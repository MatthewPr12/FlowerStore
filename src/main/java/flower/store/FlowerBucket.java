package flower.store;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow;

public class FlowerBucket {
    List<FlowerPack> flowers = new ArrayList<FlowerPack>();

    public void add(FlowerPack fp){
        flowers.add(fp);
    }

    public double getPrice() {
        double res = 0;
        for(FlowerPack i: flowers){
            res += i.getPrice();
        }
        return res;
    }
}
