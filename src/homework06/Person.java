package homework06;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private String name;
    private int sum;
    private List<Product> products = new ArrayList<>();

    public Person(String name, int sum) {
        this.name = name;
        this.sum = sum;
    }

    public void buy(Product product) {
        if (this.sum - product.getCost() >= 0) {
            products.add(product);
            buyProduct(product);
            System.out.println(name + " купил/а " + product.getName());
        } else {
            System.out.println(name + " не может себе позволить " + product.getName());
        }
    }

    public void buyProduct(Product product){
        setSum(this.sum - product.getCost());
    }

    public void listProduct() {
        for (Product product : products
        ) {
            System.out.println(product.toString());

        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void getProducts() {
        System.out.print(name + " - ");
        if(products.isEmpty()){
            System.out.println(name + " ничего не куплено :(");
        }
        for (Product product : products) {
            System.out.print(product.getName() + " ");

        }
        System.out.println();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                ", products=" + products +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sum == person.sum && Objects.equals(name, person.name) && Objects.equals(products, person.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sum, products);
    }
}
