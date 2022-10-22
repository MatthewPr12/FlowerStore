package flower.store;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


class StoreTest {
    private Store store;

    @BeforeEach
    public void init() {
        store = new Store();
    }

    @Test
    void takeBestThree() {
        List<Flower> res = store.takeBestThree(123);
        double res_sum = 0;
        for(Flower i : res)res_sum+=i.getPrice();
        Assertions.assertTrue(res_sum>=0);
        Assertions.assertTrue(res_sum<=300);
        Assertions.assertEquals(res.size(), 3);
        List<Flower> dummy_bucket = store.takeBestThree(123);
        Assertions.assertEquals(dummy_bucket, res);
    }
}