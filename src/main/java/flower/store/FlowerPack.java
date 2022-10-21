package flower.store;


public class FlowerPack {
    final private Flower flower;
    final private int quantity;
    public FlowerPack(Flower fl, int qua){
        this.flower = fl;
        this.quantity = qua;
    }

    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
