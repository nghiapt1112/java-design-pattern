package nghia.command;

import nghia.command.application.ex1.BinaryObserver;
import nghia.command.application.ex1.HexaObserver;
import nghia.command.application.ex1.OctalObserver;
import nghia.command.application.ex1.Subject;
import org.junit.Test;

public class ObserverApplicationTests {

    @Test
    public void testEx1() {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
