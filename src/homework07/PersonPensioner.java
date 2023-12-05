package homework07;

public class PersonPensioner extends Person{
    public PersonPensioner(String name, int age, int sum) {
        super(name, age, sum);
    }

    @Override
    public void buy(Product product) {
        product.setCost(0.95 * product.getCost());
        System.out.println("Скидка для пенсионеров 5%, сумма составит: " + product.getCost());
        super.buy(product);
    }
}
