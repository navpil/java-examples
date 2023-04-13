package ua.lviv.navpil.script;

import jdk.nashorn.api.scripting.NashornScriptEngineFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.InputStreamReader;

public class CallJavaFX {

    public static void main(String[] args) throws ScriptException {

        String[] opts = new String[] {"-fx"};

        NashornScriptEngineFactory factory = new NashornScriptEngineFactory();
        ScriptEngine engine = factory.getScriptEngine(opts);

        engine.eval(new InputStreamReader(CallJavaFX.class.getClassLoader().getResourceAsStream("ua/lviv/navpil/scripts/fxscript.js")));
    }
}
