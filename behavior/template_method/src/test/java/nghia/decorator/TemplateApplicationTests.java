package nghia.decorator;

import nghia.template.application.ex1.GlassHouse;
import nghia.template.application.ex1.HouseTemplate;
import nghia.template.application.ex1.WoodenHouse;
import org.junit.Test;

public class TemplateApplicationTests {

    @Test
    public void testEx1() {
        HouseTemplate houseType = null;

        houseType = new WoodenHouse();

        //using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }
}
