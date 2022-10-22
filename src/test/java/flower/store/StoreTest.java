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
    void search() {
        double buyerBudget = 123.123;
        List<Flower> res = store.search(buyerBudget);
        double resSum = 0;
        for (Flower i : res) {
            resSum += i.getPrice();
        }
        int sumNotNeg = 0;
        int allFlowersLessHundred = 300;
        Assertions.assertTrue(resSum >= sumNotNeg);
        Assertions.assertTrue(resSum <= allFlowersLessHundred);
        Assertions.assertEquals(res.size(), 3);
        List<Flower> dummyBucket = store.search(buyerBudget);
        Assertions.assertEquals(dummyBucket, res);
    }
}