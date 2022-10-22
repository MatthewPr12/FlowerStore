package flower.store;

import lombok.Getter;

public class FlowerSelect {
    @Getter
    private static final int NUM_OF_FLOWER_TYPES = 3;

    public static Flower selectFlower(int channel) {
        switch (channel) {
            case 0:
                return new Rose();
            case 1:
                return new Chamomile();
            case 2:
                return new Tulip();
            default:
                throw new IllegalArgumentException("Wrong picked flower");
        }
    }
}
