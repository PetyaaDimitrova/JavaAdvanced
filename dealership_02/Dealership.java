package dealership_02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Dealership {
    private String name;
    private int capacity;
    private Collection<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Car car) {
        if (data.size() < capacity) {
            data.add(car);
        }

    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : data
        ) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        }
        int latestYear = 0;
        List<Car> list = new ArrayList<>(data);
        Car car = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getYear() > latestYear) {
                latestYear = list.get(i).getYear();
                car = list.get(i);
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        for (Car car : data
        ) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", name));
        for (Car c : data
        ) {
            sb.append(c.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
