package flower.store;


public class FlowerPack {
    private final Flower flower;
    private final int quantity;
    public FlowerPack(Flower fl, int qua) {
        this.flower = fl;
        this.quantity = qua;
    }

    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
