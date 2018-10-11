package Factory;

import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class Factory
{
    private static final String PACKAGE ="Factory.";
    private static Factory instance = null;
    private Map<String, Command> commandsMap= new HashMap<>();
    private static Logger log = Logger.getLogger(Factory.class);


    private Factory(){
    }

    public static Factory getInstance(){
        if (instance == null) instance = new Factory();
        return instance;
    }

    public Command getCommand(String command) throws Exception {
        Command c = this.commandsMap.get(command);

        if (c == null) {
            c = this.getCommandByClassLoader(command);
            this.commandsMap.put(command, c);
        }

        return c;
    }

    private Command getCommandByClassLoader(String command) throws Exception {
        Command cmd = null;
        Class theClass = null;

        try {
            theClass = Class.forName(PACKAGE + command);
            cmd = (Command)theClass.newInstance();

        } catch (ClassNotFoundException e) {
            //log.error();
            e.printStackTrace();
            throw new Exception("Command not found");
        }

        return cmd;
    }

    public void takeDown(){
        instance = null;
    }
}
