package nghia.command.ex1;

import nghia.command.application.ex2.*;
import nghia.command.application.ex2.commands.*;
import nghia.command.application.ex2.receivers.*;
import nghia.command.application.ex2.domain.*;

import org.junit.Test;

import java.math.BigDecimal;

public class TestCommandPattern {
    // These would live elsewhere in a proper command dictionary in real life...
    private static String ORDERBOOK_SELL_COMMAND = "orderbook-sell";
    private static String ORDERBOOK_BUY_COMMAND = "orderbook-buy";
    private static String ORDERBOOK_CANCEL_COMMAND = "orderbook-cancel";

    private static String REGULATE_SELL_COMMAND = "regulate-sell";
    private static String REGULATE_BUY_COMMAND = "regulate-buy";


    /**
     * TODO change test to actually assert something!
     */
    @Test
    public void testCommandPattern() {
        // System starts up....

        // Create the Receivers
        final OrderBook orderBook = new OrderBook();
        final RegulatorySystem regulatorySystem = new RegulatorySystem();

        // Create some order book commands
        final OrderCommand removeFromOrderBook = new OrderBookCancelCommand(orderBook);
        final OrderCommand addBuyToOrderBook = new OrderBookBuyCommand(orderBook);
        final OrderCommand addSellToOrderBook = new OrderBookSellCommand(orderBook);

        // Create some reulatory system commands
        final OrderCommand regulateBuyOrder = new RegulateBuyOrderCommand(regulatorySystem);
        final OrderCommand regulateSellOrder = new RegulateSellOrderCommand(regulatorySystem);

        // Create and parameterise the invoker for the Order Book
        final CommandInvoker commandInvoker = new CommandInvoker();
        commandInvoker.setCommand(ORDERBOOK_BUY_COMMAND, addBuyToOrderBook);
        commandInvoker.setCommand(ORDERBOOK_CANCEL_COMMAND, removeFromOrderBook);
        commandInvoker.setCommand(ORDERBOOK_SELL_COMMAND, addSellToOrderBook);

        // System up and initialised. Wait for orders to come in off exchange...

        // Process order book first
        final Order buyOrder = new Order(123, new BigDecimal("100"), new BigDecimal("1.45"));
        final Order sellOrder = new Order(999, new BigDecimal("200"), new BigDecimal("2.45"));
        final Order cancelOrder = new Order(777, new BigDecimal("300"), new BigDecimal("3.45"));

        commandInvoker.onNewOrderCommand(ORDERBOOK_BUY_COMMAND, buyOrder);
        commandInvoker.onNewOrderCommand(ORDERBOOK_SELL_COMMAND, sellOrder);
        commandInvoker.onNewOrderCommand(ORDERBOOK_CANCEL_COMMAND, cancelOrder);

        // Now set the SAME Command Invoker to use the Regulatory system to regulate the buy/sell orders
        // i.e. we parameterise it with the reg system
        commandInvoker.setCommand(REGULATE_BUY_COMMAND, regulateBuyOrder);
        commandInvoker.setCommand(REGULATE_SELL_COMMAND, regulateSellOrder);

        commandInvoker.onNewOrderCommand(REGULATE_BUY_COMMAND, buyOrder);
        commandInvoker.onNewOrderCommand(REGULATE_SELL_COMMAND, sellOrder);
        // there is no regulate for a cancel order; who cares right?

    }
}
