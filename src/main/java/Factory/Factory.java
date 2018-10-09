package Factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class Factory
{

    private static Factory instance = null;
    private Map<String, Command> commandsMap= new HashMap<>();

    private Factory(){
        commandsMap.put("C1", new FirstCommand());
        commandsMap.put("C2", new SecondCommand());
        commandsMap.put(("C3"), new ThirdCommand());

    }

    public static Factory getInstance(){
        if (instance == null) instance = new Factory();
        return instance;
    }

    public Command getCommand(String command){
        return commandsMap.get(command);
    }

    public void takeDown(){
        instance = null;
    }
}
