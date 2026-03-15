package lld1.lambdas;

public class Car implements Comparable<Car> {
    String name;
    double speed;
    int noOfSeats;
    int price;

    Car(String name, double speed, int noOfSeats, int price) {
        this.name = name;
        this.speed = speed;
        this.noOfSeats = noOfSeats;
        this.price = price;
    }

    @Override
    public int compareTo(Car car) {
//        if(this.speed < car.speed) {
//            return -343;
//        } else if (this.speed > car.speed) {
//            return 32;
//        }
//        return 0;

        return (int) (this.speed - car.speed);
    }

    @Override
    public String toString() {
        return "[ Name : " + this.name + " Speed : " + this.speed + " Seats : " + this.noOfSeats + " Price : " + this.price + " ]" ;
    }
}
