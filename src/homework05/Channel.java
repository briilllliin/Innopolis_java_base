package homework05;

import java.util.List;
import java.util.Objects;

public class Channel {
    private String name;
    private int number;
    private List<TVProgram> tvProgram;


    public Channel(String name, int number, List<TVProgram> tvProgram) {
        this.name = name;
        this.number = number;
        this.tvProgram = tvProgram;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void getTvProgram() {
        for (TVProgram program: tvProgram) {
            System.out.println(program.getName());
        }
    }


    @Override
    public String toString() {
        return "Channel{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", tvProgram=" + tvProgram +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Channel channel = (Channel) o;
        return number == channel.number && Objects.equals(name, channel.name) && Objects.equals(tvProgram, channel.tvProgram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, tvProgram);
    }
}
