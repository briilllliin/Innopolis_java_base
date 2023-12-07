package homework_3;

import java.util.Objects;

public class TV implements IDevice {


    private int diagonal;
    private String model;
    private long price;

    public TV(String model, int diagonal, int price) {
        this.model = model;
        this.diagonal = diagonal;
        this.price = price;
    }

    public int getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(int diagonal) {
        this.diagonal = diagonal;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return diagonal == tv.diagonal && price == tv.price && Objects.equals(model, tv.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diagonal, model, price);
    }


    @Override
    public String toString() {
        return "Телевизор " + model + " с диагональю: " + diagonal +
                ", цена: " + price + " руб.";
    }

    @Override
    public void turn_on() {
        System.out.println("Телевизор " + model + " включён");
    }

    @Override
    public void turn_off() {
        System.out.println("Телевизор " + model + " выключен");

    }
}
