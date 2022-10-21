package flower.store;

import lombok.Getter;
import lombok.Setter;



@Setter
public class Flower {
    @Getter
    protected double sepalLength;
    protected FlowerColor color;
    @Getter
    protected double price;
    @Getter
    private FlowerType flowerType;

    public String getColor() {
        return color.toString();
    }
}
