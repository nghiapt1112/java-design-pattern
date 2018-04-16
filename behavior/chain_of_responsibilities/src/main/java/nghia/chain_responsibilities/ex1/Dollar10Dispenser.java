package nghia.chain_responsibilities.ex1;

public class Dollar10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void nextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            int remainder = cur.getAmount() % 10;
            System.out.println("Dispensing " + num + " 10$ note");
            if (remainder != 0) {
                System.out.println("so tien con du la: " + remainder);
                this.chain.dispense(new Currency(remainder));
            } else {
                return;
            }
        } else {
            this.chain.dispense(cur);
        }
    }

}