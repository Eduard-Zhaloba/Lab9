package org.example;
public class Passenger implements Cloneable {
    private String name;
    private String seat;

    public Passenger(String name, String seat) {
        this.name = name;
        this.seat = seat;
    }

    public String getName() { return name; }
    public String getSeat() { return seat; }

    @Override
    public Passenger clone() {
        try {
            return (Passenger) super.clone();
        } catch (CloneNotSupportedException e) {
            return new Passenger(this.name, this.seat);
        }
    }

    @Override
    public String toString() {
        return name + " (" + seat + ")";
    }
}