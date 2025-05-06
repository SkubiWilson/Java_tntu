// Клас "Автомобіль"
class Automobile {
    // Поля
    private String brand;
    private String model;
    private int year;
    private double price;

    // Конструктор
    public Automobile(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Метод для виведення інформації
    public void displayInfo() {
        System.out.println("Марка: " + brand + ", Модель: " + model +
                ", Рік випуску: " + year + ", Вартість: $" + price);
    }

    // Геттери для доступу до вартості
    public double getPrice() {
        return price;
    }
}

// Головний клас із методом main
public class Main {
    public static void main(String[] args) {
        // Створення масиву автомобілів
        Automobile[] cars = new Automobile[5];

        // Заповнення масиву об'єктами
        cars[0] = new Automobile("Toyota", "Corolla", 2018, 15000);
        cars[1] = new Automobile("Honda", "Civic", 2020, 18000);
        cars[2] = new Automobile("Ford", "Focus", 2017, 13000);
        cars[3] = new Automobile("BMW", "3 Series", 2019, 25000);
        cars[4] = new Automobile("Hyundai", "Elantra", 2021, 17000);

        // Виведення інформації про всі автомобілі
        System.out.println("Список автомобілів:");
        for (Automobile car : cars) {
            car.displayInfo();
        }

        // Знаходження автомобіля з мінімальною вартістю
        Automobile minPriceCar = cars[0];
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getPrice() < minPriceCar.getPrice()) {
                minPriceCar = cars[i];
            }
        }

        // Виведення автомобіля з мінімальною вартістю
        System.out.println("\nАвтомобіль із мінімальною вартістю:");
        minPriceCar.displayInfo();
    }
}
