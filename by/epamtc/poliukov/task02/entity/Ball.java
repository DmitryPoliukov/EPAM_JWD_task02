package by.epamtc.poliukov.task02.entity;

import java.io.Serializable;

/**
 * The Class Ball is entity class describing the ball.
 *
 * @author Dmitry Poliukov
 */

public class Ball implements Serializable {

    private Color color;
    private double weight;

    public Ball(Color color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public Ball(){}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return (weight == ball.weight) &&
                (color == ball.color);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (color == null ? 0: color.hashCode());
        result = prime * result + Double.hashCode(weight);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append(" [Color = ");
        builder.append(color);
        builder.append(",weight = ");
        builder.append(weight);
        builder.append("]");
        return builder.toString();
    }
}
