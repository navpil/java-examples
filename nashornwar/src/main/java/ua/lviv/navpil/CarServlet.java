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
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Usage:
 *
 * mvn jetty:run
 *
 * http://localhost:7899/car.html
 *
 * Enter invalid year (1879), click Send Car and alert will show you a warning
 *
 * Because it's GET, just do
 *
 * http://localhost:7899/car?year=1879
 *
 * Server uses the same validation
 */
@WebServlet(name = "CarServlet", urlPatterns = "/car")
public class CarServlet extends HttpServlet {

    private ScriptEngine engine;

    @Override
    public void init() throws ServletException {
        engine = null;
        try {
            ScriptEngineManager sem = new ScriptEngineManager();
            engine = sem.getEngineByName("nashorn");
//            InputStream is = CarServlet.class.getClassLoader().getResourceAsStream("validation.js");
            //Not to copy files around, just get an access from the servlet context. Classloader won't work
            InputStream is = getServletContext().getResourceAsStream("/validation.js");
            engine.eval(new InputStreamReader(is));
        } catch (ScriptException e) {
            throw new ServletException(e);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String year = req.getParameter("year");
        try {
            if ((Boolean) ((Invocable)engine).invokeFunction("validateCarYear", year)) {
                resp.getWriter().append("Saved car").flush();
            } else {
                resp.getWriter().append("Car year is wrong").flush();
            }
        } catch (ScriptException | NoSuchMethodException e) {
            throw new ServletException(e);
        }
    }
}
