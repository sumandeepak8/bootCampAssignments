package com.java.bootcamp.bagballproblem;

import java.util.ArrayList;
import java.util.List;

class Bag {

    private List<Ball> balls;
    Validator validator;
    Integer maxBalls;

    Bag() {
        this.balls = new ArrayList<>();
        this.maxBalls = 12;
        this.validator = new Validator();
    }

    Bag addBall(Ball ball) {
        if (this.totalBalls() < this.maxBalls) {
//            if(validator.isValid(ball))
            this.balls.add(ball);
        }
        return this;
    }

    Integer totalBalls() {
        return this.balls.size();
    }
}
