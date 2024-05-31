package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {
    @GetMapping("/cars")
    public String getCars(@RequestParam(value = "count", defaultValue = "5") int countCars, ModelMap model) {
        System.out.println(countCars);
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("BMW", "X6", 3500000));
        cars.add(new Car("Ford", "Mustand", 1560000));
        cars.add(new Car("Honda", "Accord", 2300000));
        cars.add(new Car("VW", "Tiguan", 2960000));
        cars.add(new Car("Mercedes-Benc", "AMG", 6400000));

        if (countCars > 0 && countCars < 5) {
            cars = cars.stream().limit(countCars).toList();
        }
        model.addAttribute("list", cars);
        return "cars";
    }

}
