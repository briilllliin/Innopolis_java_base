package homework07;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class DiscountProduct extends Product {


    private int discount;
    private Date date;//дата до которой скидка действует

    public DiscountProduct(String name, double cost, int discount) {
        super(name, cost);
        this.discount = discount;
        date = new Date(123, new Random(System.currentTimeMillis()).nextInt(11) + 8, new Random(System.currentTimeMillis()).nextInt(30) + 25);

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DiscountProduct(String name, double cost) {
        super(name, cost);
    }


    public void setDiscount(int discount) {
        if (getDiscount() <= 0) {
            throw new RuntimeException("Uncorrected discount");
        }
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public boolean checkDiscount(Date date) {
        if (date.before(this.date)) {
            setCost(getCost() - (((double) getDiscount() / 100) * getCost()));
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

    @Override
    public String toString() {
        return "DiscountProduct{" +
                "discount=" + discount +
                '}';
    }
}
