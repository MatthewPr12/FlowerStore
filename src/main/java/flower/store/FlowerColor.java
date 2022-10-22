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

    public static FlowerColor chooseColor(int n){
        if (n % 3 == 0) {
            return RED;
        }
        else if (n % 3 == 1) {
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
