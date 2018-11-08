public class GameOfLife implements IGameOfLife {
    int[][] grid;
    public static int X_SIZE;
    public static int Y_SIZE;
    
    
    public GameOfLife(int x_size, int y_size){
        X_SIZE = x_size;
        Y_SIZE = y_size;
        grid = new int[X_SIZE][Y_SIZE];
    }
    

    @Override
    public void init() {


    }

    @Override
    public void showGrid() {
        for (int a =Y_SIZE - 1 ; a >= 0; a--) {
            System.out.println();
            for (int b = 0; b < X_SIZE - 1; b++) {
                if (grid[b][a] == 1) {
                    System.out.print("[*]");
                } else {
                    System.out.print("[o]");
                }
            }
        }

    }

    @Override
    public void setAlive(int x, int y) {
        if (x > X_SIZE) {
            x -= X_SIZE;
        }
        if (x < 0) {
            x = X_SIZE;
        }
        if (y > Y_SIZE) {
            y -= Y_SIZE;
        }
        if (y < 0) {
            y = Y_SIZE;
        }
        grid[x][y] = 1;
    }

    @Override
    public void setDead(int x, int y) {
        grid[x][y] = 0;
    }

    @Override
    public int getLiveNeighbors(int x, int y) {
        int n = 0;
        for (int a = (y-1 % Y_SIZE + Y_SIZE) % Y_SIZE; a <= (y+1 % Y_SIZE + Y_SIZE) % Y_SIZE; a++) {
            for (int b =(x-1 % X_SIZE + X_SIZE) % X_SIZE; b <= (x+1 % X_SIZE + X_SIZE) % X_SIZE; b++) {

                if (grid[b][a] == 1 && (b != x || a!= y)){
                    n++;
                }

            }
        }
        return n;
    }

    @Override
    public void runGeneration() {
        int[][]newGrid = new int[X_SIZE][Y_SIZE] ;
        int n = 0;
        for (int a = 0; a < Y_SIZE - 1; a++) {
            for (int b = 0; b < X_SIZE - 1; b++) {
                n = this.getLiveNeighbors(b, a);
                if (grid[b][a] == 1) {
                    if (n < 2 || n > 3) {
                        newGrid[b][a] = 0;
                    }
                    if (n == 2 || n == 3) {
                        newGrid[b][a] = 1;
                    }
                }
                if (grid[b][a] == 0 && n == 3) {
                    newGrid[b][a] = 1;

                }
            }
        }
        grid = newGrid;
    }

    @Override
    public void runGenerations(int howMany) {
        for (int i = 0; i < howMany; i++) {
            runGeneration();
        }

    }

    @Override
    public int[][] getGrid() {
        return grid;
    }

}
