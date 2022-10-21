package flower.store;

import java.util.concurrent.Flow;

public class FlowerPack {
    private Flower flower;
    private int quantity;
    public FlowerPack(Flower fl, int qua){
        this.flower = fl;
        this.quantity = qua;
    }

    public double getPrice() {
        return flower.price * quantity;
    }
}
