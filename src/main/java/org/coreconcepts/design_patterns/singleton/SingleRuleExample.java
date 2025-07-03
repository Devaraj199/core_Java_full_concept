package org.coreconcepts.design_patterns.singleton;

public class SingleRuleExample {
    public static void main(String[] args) {
      Logger logger1 = Logger.getInstance();
      Logger logger2= Logger.getInstance();
      Logger logger3 = Logger.getInstance();
    }
}

class Logger {
    private static Logger logger;
    private Logger() {
        System.out.println("Constructor being called");
    }

  public static Logger getInstance() {
      // single thread
//       if(logger == null){
//           logger = new Logger();
//       }

      // multi Thread
      if (logger == null) {
          synchronized (Logger.class) {
              if (logger == null) {
                logger = new Logger();
              }
          }
      }
      return logger;
  }
}
