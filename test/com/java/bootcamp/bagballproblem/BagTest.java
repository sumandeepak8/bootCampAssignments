package com.java.bootcamp.bagballproblem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BagTest {

    @Test
    void shouldAddMax12BallsToBag() {
        Bag bag = new Bag();
        Ball green = new Ball("green");
        bag.addBall(green).addBall(green).addBall(green)
                .addBall(green).addBall(green).addBall(green)
                .addBall(green).addBall(green).addBall(green)
                .addBall(green).addBall(green).addBall(green)
                .addBall(green);
        assertEquals(12,bag.totalBalls());
    }
}