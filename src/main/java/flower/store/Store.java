package flower.store;

import java.util.*;

public class Store {
    private final List<Flower> stock = new ArrayList<>();
    private static final Random PRICE_GENERATOR = new Random();
    private static final Random COLOR_GENERATOR = new Random();
    private static final Random FLOWER_SELECTOR = new Random();

    public Store(){
        fillStock();
    }

    private void fillStock() {
        for(int i=0; i<100; ++i){
            Flower flower = FlowerSelect.selectFlower(FLOWER_SELECTOR.nextInt(FlowerSelect.numOfFlowerTypes));
            int maxPrice = 100;
            flower.setPrice(PRICE_GENERATOR.nextInt(maxPrice));
            flower.setColor(FlowerColor.chooseColor(COLOR_GENERATOR.nextInt(FlowerSelect.numOfFlowerTypes)));
            flower.setSepalLength(12);
            stock.add(flower);
        }
    }

    public final List<Flower> takeBestThree(int gSum) {
        double result_sum = stock.get(0).getPrice() + stock.get(1).getPrice() + stock.get(stock.size() - 1).getPrice();
        List<Flower> result_bucket = new ArrayList<>();
        result_bucket.add(stock.get(0));
        result_bucket.add(stock.get(1));
        result_bucket.add(stock.get(stock.size()-1));
        result_bucket.sort((Comparator.comparing(o -> o.getPrice())));

        for(int i=0; i<stock.size()-2; i++){
            int a_pointer = i+1;
            int b_pointer = stock.size() - 1;
            while( a_pointer<b_pointer){
                double current_sum = stock.get(i).getPrice() + stock.get(a_pointer).getPrice()
                        + stock.get(b_pointer).getPrice();
                if (current_sum > gSum){
                    b_pointer -= 1;
                } else{
                    a_pointer += 1;
                }

                if(Math.abs(current_sum-gSum)<Math.abs(result_sum-gSum)){
                    result_sum = current_sum;
                    result_bucket.clear();
                    result_bucket.add(stock.get(i));
                    result_bucket.add(stock.get(a_pointer));
                    result_bucket.add(stock.get(b_pointer));
                }
            }
        }
        return result_bucket;
    }


    public static void main(String[] args) {
        Store my_store = new Store();
        List<Flower> res =  my_store.takeBestThree(123);
        System.out.println(res);
    }


}
