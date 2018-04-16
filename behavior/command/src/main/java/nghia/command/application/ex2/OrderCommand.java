package nghia.command.application.ex2;

import nghia.command.application.ex2.domain.Order;

/**
 * The Command interface.
 *
 */
public interface OrderCommand {

    /**
     * The Command Invoker calls this.
     */
    void execute(Order order);
}
