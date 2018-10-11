package Factory;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Factory.
 */
public class FactoryTest
{
    private Factory commandsManager;
    private static Logger log = Logger.getLogger(Factory.class);


    @Before
    public void setUp(){
        this.commandsManager = Factory.getInstance();
    }

    @After
    public void tearDown(){
        this.commandsManager.takeDown();
    }

    @Test
    public void assertCommands() throws Exception
    {
        log.info("TRYING 3 VALID COMMANDS:");
        Command c1 = Factory.getInstance().getCommandByClassLoader("FirstCommand");
        Assert.assertEquals(c1.getClass(), FirstCommand.class);
        log.info(c1.execute());
        Command c2 = Factory.getInstance().getCommandByClassLoader("SecondCommand");
        Assert.assertEquals(c2.getClass(), SecondCommand.class);
        log.info(c2.execute());
        Command c3 = Factory.getInstance().getCommandByClassLoader("ThirdCommand");
        Assert.assertEquals(c3.getClass(), ThirdCommand.class);
        log.info(c3.execute());
    }

    @Test(expected = Exception.class)
    public void assertCommandNotFound() throws Exception{
        log.info("TRYING A INVALID COMMAND:");
        Command cX = Factory.getInstance().getCommandByClassLoader("XXXXXXCommand");
    }

}
