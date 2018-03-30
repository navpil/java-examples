package ua.lviv.navpil;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Usage
 *
 *
 * put nashornwar.js into home directory, content of the file can look like this:
 *
 * function shouldAccept(person) {
 *    if (person.getAge() > 17 || person.getName() === "Dima") {
 *       return true;
 *    }
 *    return false;
 * }
 *
 * mvn jetty:run
 *
 * http://localhost:7899/acceptPerson?name=John&age=14
 * http://localhost:7899/acceptPerson?name=John&age=24
 * http://localhost:7899/acceptPerson?name=Dima&age=14
 *
 *
 * Change the nashornwar.js in the home directory and run with
 *
 * http://localhost:7899/acceptPerson?name=John&age=14&reload=true
 *
 */
@WebServlet(name = "PersonAcceptServlet", urlPatterns = "/acceptPerson")
public class PersonAcceptServlet extends HttpServlet {

    private ScriptEngine engine;

    @Override
    public void init() throws ServletException {
        loadScript();
    }

    private void loadScript() {
        engine = null;
        try {
            ScriptEngineManager sem = new ScriptEngineManager();
            engine = sem.getEngineByName("nashorn");

            InputStream is = new FileInputStream(System.getProperty("user.home") + "/nashornwar.js");
            engine.eval(new InputStreamReader(is));

        } catch (FileNotFoundException | ScriptException e) {
            //ignore
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if ("true".equals(req.getParameter("reload"))) {
            loadScript();
        }
        String name = req.getParameter("name");
        Integer age = Integer.parseInt(req.getParameter("age"), 10);

        if (shouldAccept(new Person(name, age))) {
            resp.getWriter().append("OK").flush();
        } else {
            resp.getWriter().append("Filtered out").flush();
        }

    }

    private boolean shouldAccept(Person person) {
        if (engine == null) return true;
        return jsShouldAccept(person);
    }

    private Boolean jsShouldAccept(Person person) {
        try {
            return (Boolean)((Invocable) engine).invokeFunction("shouldAccept", person);
        } catch (ScriptException | NoSuchMethodException e) {
            return false;
        }
    }

    public static class Person {

        private final String name;
        private final Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }
    }
}
