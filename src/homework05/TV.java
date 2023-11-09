package homework05;

import java.util.Objects;

public class TV implements Comparable<TV>{
    private String model;
    private int channelNumber;
    private int volume;
    private boolean isOn;

    public TV(String model, int channelNumber, int volume, boolean isOn) {
        this.model = model;
        this.channelNumber = channelNumber;
        this.volume = volume;
        this.isOn = isOn;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getChannelNumber() {
        return channelNumber;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setChannelNumber(int channelNumber) {
        this.channelNumber = channelNumber;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return " TV{" +
                "model=" + model +
                "channelNumber=" + channelNumber +
                ", volume=" + volume +
                ", isOn=" + isOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TV tv = (TV) o;
        return channelNumber == tv.channelNumber && volume == tv.volume && isOn == tv.isOn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(channelNumber, volume, isOn);
    }

    @Override
    public int compareTo(TV o) {
        return this.getChannelNumber() - o.getChannelNumber();
    }
}
