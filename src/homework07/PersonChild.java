package homework07;

public class PersonChild extends Person{
    public PersonChild(String name, int age, int sum) {
        super(name, age, sum);
    }

    @Override
    public void buy(Product product) {
        if(getAge() <= 6){
            System.out.println("Ребёнок пока не может покупать продукты");
        } else if (getAge() > 6 || getAge() <= 17) {
            super.buy(product);
        }
    }


}
