package flower.store;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Comparator;
public class Store {
    private final List<Flower> stock = new ArrayList<>();
    private static final Random PRICE_GENERATOR = new Random();
    private static final Random COLOR_GENERATOR = new Random();
    private static final Random FLOWER_SELECTOR = new Random();
    private static final double MAX_FLOWER_PRICE = 100;
    public static final int MAX_NUM_FLOWERS = 100;
    public static final double SEPAL_LENGTH = 12;
    public static final double BUDGET = 123.123;
    public Store() {
        fillStock();
    }

    private void fillStock() {
        for (int i = 0; i < MAX_NUM_FLOWERS; ++i) {
            Flower flower = FlowerSelect.selectFlower(FLOWER_SELECTOR
                    .nextInt(FlowerSelect.getNUM_OF_FLOWER_TYPES()));
            flower.setPrice(PRICE_GENERATOR.nextDouble(MAX_FLOWER_PRICE));
            flower.setColor(FlowerColor
                    .chooseColor(COLOR_GENERATOR
                            .nextInt(FlowerSelect.getNUM_OF_FLOWER_TYPES())));
            flower.setSepalLength(SEPAL_LENGTH);
            stock.add(flower);
        }
    }

    public final List<Flower> search(double gSum) {
        double resultSum = stock.get(0).getPrice()
                + stock.get(1).getPrice()
                + stock.get(stock.size() - 1).getPrice();
        List<Flower> resultBucket = new ArrayList<>();
        resultBucket.add(stock.get(0));
        resultBucket.add(stock.get(1));
        resultBucket.add(stock.get(stock.size()-1));
        resultBucket.sort((Comparator.comparing(Flower::getPrice)));

        for (int i = 0; i < stock.size()-2; i++) {
            int aPointer = i+1;
            int bPointer = stock.size() - 1;
            while (aPointer < bPointer) {
                double currentSum = stock.get(i).getPrice()
                        + stock.get(aPointer).getPrice()
                        + stock.get(bPointer).getPrice();
                if (currentSum > gSum) {
                    bPointer -= 1;
                } else {
                    aPointer += 1;
                }

                if (Math.abs(currentSum-gSum) < Math.abs(resultSum-gSum)) {
                    resultSum = currentSum;
                    resultBucket.clear();
                    resultBucket.add(stock.get(i));
                    resultBucket.add(stock.get(aPointer));
                    resultBucket.add(stock.get(bPointer));
                }
            }
        }
        return resultBucket;
    }


    public static void main(String[] args) {
        Store myStore = new Store();
        List<Flower> res =  myStore.search(BUDGET);
        System.out.println(res);
    }


}
