package flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class StoreTest {
    private Store store;
    private static final double MAX_FLOWER_PRICE = 100;
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
        Assertions.assertTrue(resSum <= MAX_FLOWER_PRICE * 3);
        Assertions.assertEquals(res.size(), 3);
        List<Flower> dummyBucket = store.search(Store.BUDGET);
        Assertions.assertEquals(dummyBucket, res);
    }
}