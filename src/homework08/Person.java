package homework08;

import java.util.ArrayList;
import java.util.Iterator;
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

    public String buy(Product product) {
        String answer;
        if (this.sum - product.getCost() >= 0) {
            products.add(product);
            buyProduct(product);
            answer = name + " купил/а " + product.getName();
        } else {
            answer = name + " не может себе позволить " + product.getName();

        }
        return answer;
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

    public List<String> getProducts() {
        List<String> answer = new ArrayList<>();
        answer.add(name + ": ");
        if(products.isEmpty()){
            answer.add(name + " ничего не куплено :(");
        }
        for (Product product : products) {
            answer.add( product.getName() + " ");

        }
        answer.add(" ");
        return answer;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static Person createPerson(String name, int sum) {
        return new Person(name, sum);
    }

    public static Person getPerson(String name, List<Person> personList) {

        Iterator<Person> iter = personList.iterator();

        while (iter.hasNext()) {
            Person person = iter.next();
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
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