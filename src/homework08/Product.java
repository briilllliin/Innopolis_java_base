package homework08;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Product {

    public Product(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    private int cost;

    public static Product createProduct(String name, int cost) {
        return new Product(name, cost);
    }



    public static Product getProduct(String name, List<Product> productList) {

        Iterator<Product> iter = productList.iterator();

        while (iter.hasNext()) {
            Product product = iter.next();
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

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