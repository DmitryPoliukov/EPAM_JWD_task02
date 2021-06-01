package by.epamtc.poliukov.task02.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Basket {

    private final double volumeCapacity;
    private final double weightCapacity;
    private List<Ball> balls = new ArrayList<>();

    public Basket(double volumeCapacity, double weightCapacity) {
        this.volumeCapacity = volumeCapacity;
        this.weightCapacity = weightCapacity;
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

    public List<Ball> addBall(Ball ball) {
        balls.add(ball);
        return balls;
    }
}
