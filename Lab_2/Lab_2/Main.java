
class Automobile {

    private String brand;
    private String model;
    private int year;
    private double price;


    public Automobile(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Марка: " + brand + ", Модель: " + model +
                ", Рік випуску: " + year + ", Вартість: $" + price);
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {

        Automobile[] cars = new Automobile[5];


        cars[0] = new Automobile("Toyota", "Corolla", 2018, 15000);
        cars[1] = new Automobile("Honda", "Civic", 2020, 18000);
        cars[2] = new Automobile("Ford", "Focus", 2017, 13000);
        cars[3] = new Automobile("BMW", "3 Series", 2019, 25000);
        cars[4] = new Automobile("Hyundai", "Elantra", 2021, 17000);


        System.out.println("Список автомобілів:");
        for (Automobile car : cars) {
            car.displayInfo();
        }


        Automobile minPriceCar = cars[0];
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getPrice() < minPriceCar.getPrice()) {
                minPriceCar = cars[i];
            }
        }


        System.out.println("\nАвтомобіль із мінімальною вартістю:");
        minPriceCar.displayInfo();
    }
}
