package flower.store;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket {
    private final List<FlowerPack> flowers = new ArrayList<>();


    public void add(FlowerPack fp) {
        flowers.add(fp);
    }

    public double getPrice() {
        double res = 0;
        for (FlowerPack i: flowers) {
            res += i.getPrice();
        }
        return res;
    }
}
