package homework05;

import java.util.Objects;

public class TVProgram {

    private String name;
    private double rating;
    private long numberOfViewers;

    public TVProgram(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getNumberOfViewers() {
        return numberOfViewers;
    }

    public void setNumberOfViewers(long numberOfViewers) {
        this.numberOfViewers = numberOfViewers;
    }

    @Override
    public String toString() {
        return "TVProgram{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", numberOfViewers=" + numberOfViewers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TVProgram tvProgram = (TVProgram) o;
        return Double.compare(rating, tvProgram.rating) == 0 && numberOfViewers == tvProgram.numberOfViewers && Objects.equals(name, tvProgram.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rating, numberOfViewers);
    }
}
