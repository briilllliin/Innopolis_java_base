package homework07;

import java.util.Objects;
import java.util.regex.Pattern;

public class Product {

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (getName().isEmpty() || Objects.equals(getName(), "")) {
            throw new RuntimeException("Name product can't be null");
        } else if ((!Pattern.matches("[а-яА-Я]+", getName())) || name.length() <= 2) {
            throw new RuntimeException("Uncorrected name product");
        }
        this.name = name;
    }

    private String name;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        if(getCost() <= 0){
            throw new RuntimeException("Uncorrected price");
        }
        this.cost = cost;
    }

    private double cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return cost == product.cost && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
