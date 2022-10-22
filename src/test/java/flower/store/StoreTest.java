package flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class StoreTest {
    private Store store;
    private static final int BUCKET_SIZE = 3;
    private static final double MAX_FLOWER_PRICE = 300;
    private static final double NON_NEG = 0;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    void search() {
        List<Flower> res = store.search(Store.BUDGET);
        double resSum = 0;
        for (Flower i : res) {
            resSum += i.getPrice();
        }
        Assertions.assertTrue(resSum >= NON_NEG);
        Assertions.assertTrue(resSum <= MAX_FLOWER_PRICE);
        Assertions.assertEquals(res.size(), BUCKET_SIZE);
        List<Flower> dummyBucket = store.search(Store.BUDGET);
        Assertions.assertEquals(dummyBucket, res);
    }
}