package com.example.marsrover;

public class Rover {
    private int positionX;
    private int positionY;
    private char direction;
    private boolean[][] world_cells;

    private final int CELLS_HEIGHT = 10;
    private final int CELLS_WIDTH = 15;


    Rover(String initialPoint, char initialDir) {
        String coordinates[] = initialPoint.split(",");
        this.positionX = new Integer(coordinates[0]);
        this.positionY = new Integer(coordinates[1]);
        this.direction = initialDir;

        this.world_cells = new boolean[CELLS_WIDTH][CELLS_HEIGHT];
        world_cells[4][4] = true;// obstacle
    }

    public String move(String movements) {
        if (!"".equals(movements))
            for (int i = 0; i < movements.length(); i++)
                switch (movements.charAt(i)) {
                    case 'N':
                        if (this.positionY > 0)
                            this.positionY--;
                        else this.positionY = CELLS_HEIGHT - 1;
                        this.direction = 'N';
                        break;

                    case 'S':
                        if (this.positionY < CELLS_HEIGHT)
                            this.positionY++;
                        else this.positionY = 0;
                        this.direction = 'S';
                        break;
                    case 'W':
                        if (this.positionX > 0)
                            this.positionX--;
                        else this.positionX = CELLS_WIDTH - 1;
                        this.direction = 'W';
                        break;
                    case 'E':
                        if (this.positionX < CELLS_WIDTH)
                            if (!this.world_cells[this.positionX+1][this.positionY])
                                this.positionX++;
                            else throw new UnsupportedOperationException("Obstaculo!!");
                        else this.positionX = 0;
                        this.direction = 'E';
                        break;
                }
        return this.positionX + ", " + this.positionY + ", " + this.direction;
    }

}
