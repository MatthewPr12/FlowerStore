package flower.store;

public enum FlowerColor {
    /**
     * Flower colors.
     */
    RED("#FF0000"),
    BLUE("#0000FF"),
    VIOLET("#8F00FF");
    private static final int NUM_OF_COLORS = 3;
    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public static FlowerColor chooseColor(int n) {
        if (n % NUM_OF_COLORS == 0) {
            return RED;
        }
        else if (n % NUM_OF_COLORS == 1) {
            return BLUE;
        }
        else {
            return VIOLET;
        }
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
