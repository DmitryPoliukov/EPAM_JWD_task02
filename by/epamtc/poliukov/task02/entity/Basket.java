package by.epamtc.poliukov.task02.entity;

import by.epamtc.poliukov.task02.exception.OverVolumeCapacityException;
import by.epamtc.poliukov.task02.exception.OverWeightCapacityException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Basket implements Serializable {

    private double volumeCapacity;
    private double weightCapacity;
    private List<Ball> balls = new ArrayList<>();
    private double totalWeightBalls = 0;

    public Basket(double volumeCapacity, double weightCapacity) {
        this.volumeCapacity = volumeCapacity;
        this.weightCapacity = weightCapacity;
    }

    public Basket() {
    }

    public double getTotalWeightBalls() {
        return totalWeightBalls;
    }

    public void setTotalWeightBalls(double totalWeightBalls) {
        this.totalWeightBalls = totalWeightBalls;
    }

    public double getVolumeCapacity() {
        return volumeCapacity;
    }

    public double getWeightCapacity() {
        return weightCapacity;
    }

    public List<Ball> getBallsReadOnly() {
        return Collections.unmodifiableList(balls) ;
    }

    public List<Ball> addBall(Ball ball) throws OverVolumeCapacityException, OverWeightCapacityException {
        if(balls.size() == volumeCapacity) {
            throw new OverVolumeCapacityException("Unable to add ball, maximum volume capacity will be exceeded");
        }
        if(weightCapacity < totalWeightBalls + ball.getWeight()) {
            throw new OverWeightCapacityException("Unable to add ball, maximum weight capacity will be exceeded");
        }
        balls.add(ball);
        totalWeightBalls += ball.getWeight();
        return balls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return basket.volumeCapacity == volumeCapacity &&
                basket.weightCapacity == weightCapacity &&
                basket.totalWeightBalls == totalWeightBalls &&
                basket.balls.equals(balls);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;
        result = prime * result + balls.hashCode();
        result = prime * result + Double.hashCode(volumeCapacity);
        result = prime * result + Double.hashCode(weightCapacity);
        result = prime * result + Double.hashCode(totalWeightBalls);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Basket {volumeCapacity=");
        builder.append(volumeCapacity);
        builder.append(", weightCapacity=");
        builder.append(weightCapacity);
        builder.append(", balls=");
        builder.append(balls);
        builder.append(", totalWeightBalls=");
        builder.append(totalWeightBalls);
        builder.append("}");
        return builder.toString();
    }
}
