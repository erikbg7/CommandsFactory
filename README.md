# CommandsFactory
Pattern Theory Exercise (Factory)

The main objective is to understand Factory pattern and develop a little program with Factory and Singleton that creates different Commands.


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
FactoryPattern: Factory + Singleton (cache) + Command + LOG4J
      Command c = Factory.getInstance().getCommand("C1"); // Classloader (C1)
      c.execute();

      c = Factory.getInstance().getCommand("C1");  // Cache (C1)
      c.execute();
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

