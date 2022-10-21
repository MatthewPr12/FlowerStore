package flower.store;

public enum FlowerColor {
    /**
     * Flower colors.
     */
    RED("#FF0000"),
    BLUE("#0000FF"),
    VIOLET("#8F00FF");

    private final String stringRepresentation;

    FlowerColor(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
