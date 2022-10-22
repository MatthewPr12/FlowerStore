package flower.store;

import lombok.Getter;
import lombok.Setter;



@Setter
public class Flower {
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter
    private double price;
    @Getter
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }

    @Override
    public String toString() {
        return "Flower{"
                + "sepalLength=" + sepalLength
                + ", color=" + color
                + ", price=" + price
                + '}';
    }
}
