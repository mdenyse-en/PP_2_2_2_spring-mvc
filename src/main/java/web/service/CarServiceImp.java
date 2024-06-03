package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImp implements CarService{
    @Override
    public List<Car> getCarsByCount(int count) {
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("BMW", "X6", 3500000));
        cars.add(new Car("Ford", "Mustand", 1560000));
        cars.add(new Car("Honda", "Accord", 2300000));
        cars.add(new Car("VW", "Tiguan", 2960000));
        cars.add(new Car("Mercedes-Benc", "AMG", 6400000));

        if (count > 0 && count < 5) {
            cars = cars.stream().limit(count).toList();
        }

        return cars;
    }
}
