package com.example.marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverTests {
    Rover rover;

    @Test
    public void emptyMovementsTest() {
        //arrange
        String initialPoint = "0,2";
        char initialDir = 'N';
        String movements = "";

        //act
        rover = new Rover(initialPoint, initialDir);
        String positionResult = rover.move(movements);

        //asert
        assertEquals("0, 2, N", positionResult);
    }

    @Test
    public void northMovementTest() {
        String initialPoint = "0,2";
        char initialDir = 'S';
        String movements = "N";

        rover = new Rover(initialPoint, initialDir);
        String positionResult = rover.move(movements);

        assertEquals("0, 1, N", positionResult);
    }

    @Test
    public void eastMovementTest() {
        String initialPoint = "0,2";
        char initialDir = 'S';
        String movements = "E";

        rover = new Rover(initialPoint, initialDir);
        String positionResult = rover.move(movements);

        assertEquals("1, 2, E", positionResult);
    }

    @Test
    public void movementsTest() {
        String initialPoint = "0,2";
        char initialDir = 'S';
        String movements = "ESS";

        rover = new Rover(initialPoint, initialDir);
        String positionResult = rover.move(movements);

        assertEquals("1, 4, S", positionResult);
    }

    @Test
    public void offMovementsTest() {
        String initialPoint = "0,0";
        char initialDir = 'S';
        String movements = "NW";

        rover = new Rover(initialPoint, initialDir);
        String positionResult = rover.move(movements);

        assertEquals("14, 9, W", positionResult);
    }

    @Test (expected = UnsupportedOperationException.class)
    public void obstacleTest() {
        String initialPoint = "0,0";
        char initialDir = 'S';
        String movements = "SSSSEEEE";

        rover = new Rover(initialPoint, initialDir);
        String positionResult = rover.move(movements);

        //assertEquals("4, 4, E", positionResult);
    }
}
