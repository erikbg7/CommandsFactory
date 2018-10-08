package Factory;

/**
 * Hello world!
 *
 */
public class Factory
{

    private static Factory instance = null;

    private Factory(){}

    public static Factory getInstance(){
        if (instance == null) instance = new Factory();
        return instance;
    }

    public Command getCommand(String command){

        return null;
    }

}
