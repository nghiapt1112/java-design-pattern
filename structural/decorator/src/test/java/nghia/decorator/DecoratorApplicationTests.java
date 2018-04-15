package nghia.decorator;

import nghia.decorator.application.ex1.GenericReport;
import nghia.decorator.application.ex1.SupportLinkDecorator;
import nghia.decorator.application.ex1.SupportPopupDecorator;
import nghia.decorator.application.ex2.BasicCar;
import nghia.decorator.application.ex2.Car;
import nghia.decorator.application.ex2.LuxuryCar;
import nghia.decorator.application.ex2.SportsCar;
import nghia.decorator.application.ex3.Circle;
import nghia.decorator.application.ex3.Rectangle;
import nghia.decorator.application.ex3.RedShapeDecorator;
import nghia.decorator.application.ex3.Shape;
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
