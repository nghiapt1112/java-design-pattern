package nghia.command;

import nghia.command.application.ex1.GenericReport;
import nghia.command.application.ex1.SupportLinkDecorator;
import nghia.command.application.ex1.SupportPopupDecorator;
import nghia.command.application.ex2.BasicCar;
import nghia.command.application.ex2.Car;
import nghia.command.application.ex2.LuxuryCar;
import nghia.command.application.ex2.SportsCar;
import nghia.command.application.ex3.Circle;
import nghia.command.application.ex3.Rectangle;
import nghia.command.application.ex3.RedShapeDecorator;
import nghia.command.application.ex3.Shape;
import org.junit.Test;

public class DecoratorApplicationTests {

    @Test
    public void testEx1() {
        //ClientPopupDecorator popupDecoratored = new ClientPopupDecorator(new ClientLinkDecorator(new ClientReport()));
        //System.out.println(popupDecoratored.getFirstColumnData());

        SupportPopupDecorator supportPopupDecoratored = new SupportPopupDecorator(new SupportLinkDecorator(new GenericReport()));
        System.out.println(supportPopupDecoratored.getFirstColumnData());
    }

    @Test
    public void testEx2() {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");

        Car sportsLuxuryCar = new LuxuryCar(new SportsCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }

    @Test
    public void testEx3() {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

    }
}
