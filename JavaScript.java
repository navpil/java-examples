import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.util.List;

public class JavaScript {

    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = scriptEngineManager.getEngineFactories();

        for (ScriptEngineFactory engineFactory : engineFactories) {
            System.out.println(engineFactory.getEngineName());
        }
    }
}
