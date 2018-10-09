package Factory;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Factory.
 */
public class FactoryTest
{
    private Factory commandsManager;
    private Command c1;
    private Command c2;
    private Command c3;

    @Before
    public void setUp(){
        this.commandsManager = Factory.getInstance();
        c1 = Factory.getInstance().getCommand("C1");
        c2 = Factory.getInstance().getCommand("C2");
        c3 = Factory.getInstance().getCommand("C3");
    }

    @After
    public void tearDown(){
        this.commandsManager.takeDown();
    }

    @Test
    public void assertCommands()
    {
        System.out.println("Probando la comanda 1:");
        c1.execute();

        System.out.println("Probando la comanda 2:");
        c2.execute();

        System.out.println("Probando la comanda 3:");
        c3.execute();
    }
}
