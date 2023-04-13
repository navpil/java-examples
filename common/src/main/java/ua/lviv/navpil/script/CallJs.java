package ua.lviv.navpil.script;

import jdk.nashorn.api.scripting.ScriptObjectMirror;

import javax.script.Bindings;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class CallJs {

    public static void main(String[] args) throws ScriptException, FileNotFoundException, NoSuchMethodException {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engine = sem.getEngineByName("javascript");//can also be "js" or "nashorn"

//        engine.eval("print(\"hello javascript\");");

        doWithEngine(engine, "factorial.js");
    }

    public static void doWithEngine(ScriptEngine nashorn, String scriptName) throws ScriptException, NoSuchMethodException {
        InputStream is = CallJs.class.getClassLoader().getResourceAsStream("ua/lviv/navpil/scripts/" + scriptName);
        nashorn.eval(new InputStreamReader(is));

        Object factorialResult = nashorn.eval("factorial(3);");
        showResult(factorialResult);

        Invocable n = (Invocable)nashorn;

        showResult(n.invokeFunction("helloFromJs", "Jim"));
        showResult(n.invokeFunction("showObjectInformation", new Date()));

        Object personJson = n.invokeFunction("json", "Anna");
        showResult(personJson);

        //how to invoke this method from Java?
        Bindings json = (Bindings)personJson;
        System.out.println(json.get("age"));
        showResult(json.get("carCount"));

        ScriptObjectMirror personJsObject = (ScriptObjectMirror) personJson;

        System.out.println("Calling member function " + personJsObject.callMember("carCount"));
        //
        n.invokeFunction("backReferenceJava");
    }

    public String instanceM() {
        return "I'm intance method of class " + this.getClass().getSimpleName();
    }

    public static String helloFromJava(String name) {
        return "Hello from Java, " + name;
    }

    private static void showResult(Object factorialResult) {
        if (factorialResult != null) {
            System.out.println(factorialResult.getClass());
            System.out.println(factorialResult);
        }
    }
}
