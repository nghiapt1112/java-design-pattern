package nghia.command;

import nghia.command.application.ex1.CreditCardStrategy;
import nghia.command.application.ex1.Item;
import nghia.command.application.ex1.PaypalStrategy;
import nghia.command.application.ex1.ShoppingCart;
import org.junit.Test;

public class ObserverApplicationTests {

    @Test
    public void testEx1() {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(new Item("1", 110));
        cart.addItem(new Item("2", 420));
        cart.addItem(new Item("3", 430));
        cart.addItem(new Item("4", 440));
        cart.addItem(new Item("5", 450));
        cart.addItem(new Item("6", 460));

        //pay by paypal
        cart.pay(new PaypalStrategy("myemail@example.com", "mypwd"));

        //pay by credit card
        cart.pay(new CreditCardStrategy("Pankaj Kumar", "1234567890123456", "786", "12/15"));
    }
}
