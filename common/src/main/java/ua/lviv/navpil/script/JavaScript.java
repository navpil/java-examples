package ua.lviv.navpil.script;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ServiceLoader;

public class JavaScript {

    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = scriptEngineManager.getEngineFactories();

        for (ScriptEngineFactory engineFactory : engineFactories) {
            System.out.println(engineFactory.getEngineName());
            System.out.println(engineFactory.getNames());
        }

        ScriptEngine ruby = scriptEngineManager.getEngineByName("ruby");
        ruby.eval("puts 'hello world'");

//        ServiceLoader<ScriptEngineFactory> load = ServiceLoader.load(ScriptEngineFactory.class);
//        for (ScriptEngineFactory factory : load) {
//            System.out.println(factory.getEngineName());
//        }

//        java(scriptEngineManager);
//
//        ScriptEngine sisc = scriptEngineManager.getEngineByName("sisc");
//        Object eval = sisc.eval(new InputStreamReader(JavaScript.class.getClassLoader().getResourceAsStream("Script.scheme")));

    }

    private static void java(ScriptEngineManager scriptEngineManager) throws ScriptException {
        ScriptEngine java = scriptEngineManager.getEngineByName("java");
        System.out.println(java);

        String[] value = {"1", "2", "result"};
        java.getContext().setAttribute("arguments", value, ScriptContext.ENGINE_SCOPE);

        Object eval = java.eval(new InputStreamReader(JavaScript.class.getClassLoader().getResourceAsStream("Script.java")));
        System.out.println(value[2]);
    }
}
