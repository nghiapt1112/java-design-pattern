package nghia.command;

import nghia.command.application.ex1.GlassHouse;
import nghia.command.application.ex1.HouseTemplate;
import nghia.command.application.ex1.WoodenHouse;
import nghia.command.application.ex2.Cricket;
import nghia.command.application.ex2.Football;
import nghia.command.application.ex2.Game;
import org.junit.Test;

public class TemplateApplicationTests {

    @Test
    public void testEx1() {
        HouseTemplate houseType = null;

        houseType = new WoodenHouse();

        //using observer method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();
        houseType.buildHouse();
    }

    @Test
    public void testEx2() {

        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
