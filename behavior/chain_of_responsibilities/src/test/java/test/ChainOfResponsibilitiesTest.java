package test;

import nghia.chain_responsibilities.ex1.*;
import nghia.chain_responsibilities.ex2.AbstractLogger;
import nghia.chain_responsibilities.ex2.ConsoleLogger;
import nghia.chain_responsibilities.ex2.ErrorLogger;
import nghia.chain_responsibilities.ex2.FileLogger;
import org.junit.After;
import org.junit.Test;
import org.springframework.test.annotation.DirtiesContext;

@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class ChainOfResponsibilitiesTest {

    private DispenseChain c1;
    private DispenseChain c2;
    private DispenseChain c3;


    private AbstractLogger errorLogger;
    private AbstractLogger fileLogger;
    private AbstractLogger consoleLogger;

    @Test
    public void testChain() {
        prepareTest1();
        int amount = 80;
        System.out.println("Amount Entered to dispense: " + amount);
        if (amount % 10 != 0) {
            System.out.println("Amount should be in multiple of 10s.");
            return;
        }
        // process the request
        c1.dispense(new Currency(amount));

    }

    private void prepareTest1() {
        // initialize the chain

        c1 = new Dollar50Dispenser();
        c2 = new Dollar20Dispenser();
        c3 = new Dollar10Dispenser();

        // set the chain of responsibility
        c1.nextChain(c2);
        c2.nextChain(c3);
    }


    @Test
    public void testChain2() {
        prepareTest2();

        errorLogger.logMessage(AbstractLogger.INFO,
                "This is an information.");

        errorLogger.logMessage(AbstractLogger.DEBUG,
                "This is an debug level information.");

        errorLogger.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }

    private void prepareTest2() {
        errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        fileLogger = new FileLogger(AbstractLogger.DEBUG);
        consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);
    }

    @After
    public void destroy() {
        c1 = null;
        c2 = null;
        c3 = null;

        errorLogger = null;
        fileLogger = null;
        consoleLogger = null;
    }
}
