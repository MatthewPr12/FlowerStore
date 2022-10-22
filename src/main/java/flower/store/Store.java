package flower.store;

import java.util.*;

public class Store {
    private final List<Flower> stock = new ArrayList<>();
    private final static Random PRICE_GENERATOR = new Random();
    private final static Random COLOR_GENERATOR = new Random();
    private final static Random FLOWER_SELECTOR = new Random();

    public Store(){
        fillStock();
    }

    private void fillStock() {
        int maxNumOfFlowers = 100;
        double standardSepal = 12;
        for (int i = 0; i < maxNumOfFlowers; ++i) {
            Flower flower = FlowerSelect.selectFlower(FLOWER_SELECTOR
                    .nextInt(FlowerSelect.numOfFlowerTypes));
            int maxPrice = 100;
            flower.setPrice(PRICE_GENERATOR.nextInt(maxPrice));
            flower.setColor(FlowerColor
                    .chooseColor(COLOR_GENERATOR.nextInt(FlowerSelect.numOfFlowerTypes)));
            flower.setSepalLength(standardSepal);
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
        double myBudget = 123.123;
        Store myStore = new Store();
        List<Flower> res =  myStore.search(myBudget);
        System.out.println(res);
    }


}
