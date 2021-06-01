package by.epamtc.poliukov.task02.entity;

import java.io.Serializable;
import java.util.Objects;

public class Ball implements Serializable {

    private Color color;
    private double weight;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Ball(Color color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Ball(){}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return weight == ball.weight &&
                color == ball.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, weight);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "color=" + color +
                ", weight=" + weight +
                '}';
    }
}
