package org.academiadecodigo.shellmurais;

public class Grid {

    private final int GRID_SIZE = 50;

    private Square[][] grid;
    private Cursor cursor;
    private Memory memory;

    public void init() {
        memory = new Memory();
        grid = new Square[GRID_SIZE][GRID_SIZE];
        generateGrid();
        cursor = new Cursor(this);
        cursor.init();

    }

    private void generateGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j] = new Square((i+1)*10,(j+1)*10);

            }

        }

    }

    public void changeBigSquareColor(int x, int y) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (i == ((x-1)/10) && j == ((y-1)/10)) {
                    if (i-1 >= 0) { grid[i-1][j].changeColor(); }
                    if (j-1 >= 0) { grid[i][j-1].changeColor(); }
                    grid[i][j].changeColor();
                    if (i+1 <= 50) { grid[i+1][j].changeColor(); }
                    if (j+1 <= 50) { grid[i][j+1].changeColor(); }

                }

            }

        }

    }
    public void changeSquareColor(int x, int y) {
        findSquare(x,y).changeColor();

    }
    private Square findSquare(int x, int y) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (i == ((x-1)/10) && j == ((y-1)/10)) { return grid[i][j]; }

            }

        }
        return null;

    }

    public void resetSquares() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j].reset();

            }

        }

    }
    public void fillSquares() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j].fill();

            }

        }

    }
    public void changeAllSquares() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                grid[i][j].changeColor();

            }

        }

    }

    public void changeColColor(int x) {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[(x-1)/10][i].changeColor();

        }

    }
    public void changeRowColor(int y) {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][(y-1)/10].changeColor();

        }

    }
    public void changeCrossColor(int x, int y) {
        grid[(x-1)/10][(y-1)/10].changeColor();
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[(x-1)/10][i].changeColor();

        }
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][(y-1)/10].changeColor();

        }

    }

    public void resetColColor(int x) {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[(x-1)/10][i].reset();

        }

    }
    public void resetRowColor(int y) {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][(y-1)/10].reset();

        }

    }
    public void resetCrossColor(int x, int y) {
        grid[(x-1)/10][(y-1)/10].reset();
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[(x-1)/10][i].reset();

        }
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][(y-1)/10].reset();

        }

    }

    public void fillColColor(int x) {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[(x-1)/10][i].fill();

        }

    }
    public void fillRowColor(int y) {
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][(y-1)/10].fill();

        }

    }
    public void fillCrossColor(int x, int y) {
        grid[(x-1)/10][(y-1)/10].fill();
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[(x-1)/10][i].fill();

        }
        for (int i = 0; i < GRID_SIZE; i++) {
            grid[i][(y-1)/10].fill();

        }

    }

    public void symmetryX() {
        for (int i = 0; i < GRID_SIZE/2; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (grid[i][j].isColored()) {
                    grid[GRID_SIZE-(i+1)][j].fill();

                }
                if (grid[GRID_SIZE-(i+1)][j].isColored()) {
                    grid[i][j].fill();

                }

            }

        }

    }
    public void symmetryY() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE/2; j++) {
                if (grid[i][j].isColored()) {
                    grid[i][GRID_SIZE-(j+1)].fill();

                }
                if (grid[i][GRID_SIZE-(j+1)].isColored()) {
                    grid[i][j].fill();

                }

            }

        }

    }

    public void save() { memory.save(grid); }
    public void load() { grid = memory.load(grid); }

}
