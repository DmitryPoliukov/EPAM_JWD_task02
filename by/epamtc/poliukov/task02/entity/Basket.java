package by.epamtc.poliukov.task02.entity;

import by.epamtc.poliukov.task02.exception.OverVolumeCapacityException;
import by.epamtc.poliukov.task02.exception.OverWeightCapacityException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Basket implements Serializable {
    private static final long serialVersionUID = 1L;
    private double volumeCapacity;
    private double weightCapacity;
    private List<Ball> balls = new ArrayList<>();
    private double totalWeightBalls;


    public Basket(double volumeCapacity, double weightCapacity) {
        this.volumeCapacity = volumeCapacity;
        this.weightCapacity = weightCapacity;
    }

    public Basket() {
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

    public Iterator<Ball> getBallsIterator() {
        return balls.iterator();
    }

    public double calculateTotalWeightBalls() {
        totalWeightBalls = 0;
        for(Ball ball: balls) {
            totalWeightBalls += ball.getWeight();
        }
        return totalWeightBalls;
    }

    public void addBall(Ball ball) throws OverVolumeCapacityException, OverWeightCapacityException {
        if(!isNull(ball)) {
            if(balls.size() == volumeCapacity) {
                throw new OverVolumeCapacityException("Unable to add ball, maximum volume capacity will be exceeded");
            }
            if(weightCapacity < calculateTotalWeightBalls() + ball.getWeight()) {
                throw new OverWeightCapacityException("Unable to add ball, maximum weight capacity will be exceeded");
            }
            balls.add(ball);
        }
    }

    public boolean removeBall(Ball removedBall) {
        for(Ball ball: balls) {
            if(ball.equals(removedBall)) {
                balls.remove(ball);
                return true;
            }
        }
        return false;
    }

    private boolean isNull(Object o) {
        return o == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return basket.volumeCapacity == volumeCapacity &&
                basket.weightCapacity == weightCapacity &&
                basket.calculateTotalWeightBalls() == calculateTotalWeightBalls() &&
                basket.balls.equals(balls);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;
        result = prime * result + (balls == null? 0 : balls.hashCode());
        result = prime * result + Double.hashCode(volumeCapacity);
        result = prime * result + Double.hashCode(weightCapacity);
        result = prime * result + Double.hashCode(calculateTotalWeightBalls());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append(" [volumeCapacity=");
        builder.append(volumeCapacity);
        builder.append(", weightCapacity=");
        builder.append(weightCapacity);
        builder.append(", balls=");
        builder.append(balls);
        builder.append(", totalWeightBalls=");
        builder.append(calculateTotalWeightBalls());
        builder.append("]");
        return builder.toString();
    }
}
