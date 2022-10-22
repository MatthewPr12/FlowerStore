package flower.store;

import lombok.Getter;

public class FlowerSelect {
    @Getter
    private static final int NUM_OF_FLOWER_TYPES = 3;

    public static Flower selectFlower(int channel) {
        return switch (channel) {
            case 0 -> new Rose();
            case 1 -> new Chamomile();
            case 2 -> new Tulip();
            default -> throw new
                    IllegalArgumentException("Flower selection failure");
        };
    }
}
