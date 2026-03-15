package lld1.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Car c1 = new Car("X", 124.00, 3, 214200);
        Car c2 = new Car("Y", 180.00, 8, 90000);
        Car c3 = new Car("Z", 135.00, 4, 800200);
        Car c4 = new Car("X1", 100.00, 7, 114200);

        List<Car> carList = new ArrayList<>();
        carList.add(c1);
        carList.add(c2);
        carList.add(c3);
        carList.add(c4);

        //Here Comparable compareTo() method is called implicitly
        Collections.sort(carList);
        System.out.println(carList);

        //CarPriceComparator using seperate class
        Collections.sort(carList, new CarPriceComparator());
        System.out.println(carList);

        //CarSeatsComparator using lambdas
        Collections.sort(carList, (Car c11, Car c21) -> {
            return c11.noOfSeats - c21.noOfSeats;
        });

        System.out.println(carList);
    }
}
