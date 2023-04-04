package org.example;

import lombok.Data;

@Data
public class Car implements Comparable<Car> {
    String manufacturer;
    int horsepower;

    public Car(String manufacturer, int horsepower) {
        this.manufacturer = manufacturer;
        this.horsepower = horsepower;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getHorsepower() {
        return horsepower;
    }

    @Override
    public int compareTo(Car o) {
        return getManufacturer().compareTo(o.getManufacturer());
    }
}
