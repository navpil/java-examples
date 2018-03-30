package ua.lviv.navpil.script;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class CallEs6 {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        String[] opts = new String[] {"--language=es6"};

        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine(opts);

        engine.eval("let a = 3; print(a);");

        engine.eval("const multiple = (x) => x * 2;print(multiple(3));");
        //generator functions are not supported;
//        engine.eval("function* indexGenerator() {var index = 0; while (true) {yield index++;}}");
        //default values don't work
//        engine.eval("function showMessage(from, text = \"hello\") {return from + ':' + text;}");
        //power operator won't work
//        engine.eval("2 ** 3");
        //nashorn dislikes function declarations started with let keyword
        CallJs.doWithEngine(engine, "factorial.es6");



    }

}
