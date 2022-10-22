package flower.store;

public class FlowerSelect {
    public static int numOfFlowerTypes = 3;

    public static Flower selectFlower(int channel) {
        return switch (channel) {
            case 0 -> new Rose();
            case 1 -> new Chamomile();
            case 2 -> new Tulip();
            default -> throw new IllegalArgumentException("Flower selection failure");
        };
    }
}
