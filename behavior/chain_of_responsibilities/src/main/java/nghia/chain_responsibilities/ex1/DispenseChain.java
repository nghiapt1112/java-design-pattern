package nghia.chain_responsibilities.ex1;

public interface DispenseChain {

    void nextChain(DispenseChain nextChain);

    void dispense(Currency cur);
}