package homework07;

public class PersonAdult extends Person{
    private boolean getCredit = true;
    public PersonAdult(String name, int age, int sum) {
        super(name, age, sum);
    }

    @Override
    public void buy(Product product) {
        if((getSum() - product.getCost() <= 0) || getCredit){
            System.out.println("Данный товар можно приобрести в кредит! Сумма кредита составит: " + (product.getCost() - getSum()));
        }

      super.buy(product);
    }

}
