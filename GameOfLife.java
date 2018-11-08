import java.security.cert.X509Certificate;

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
        for (int[] row:grid){
            for (int i:row){
                System.out.print(i+ " ");
            }
            System.out.println();
        }

    }


    public int check_borders(int i, int size){
        if (i >= size)return i-size;
        else if (i < 0)return i+size;
        else return i;
    }

    @Override
    public void setAlive(int x, int y) {
//        String debug_x = "x:" + x; String debug_y = "x:" + x;
//        System.out.println(debug_x);
        grid[check_borders(x, X_SIZE)][check_borders(y,Y_SIZE)] = 1;


    }

    @Override
    public void setDead(int x, int y) {
        grid[check_borders(x, X_SIZE)][check_borders(y,Y_SIZE)] = 0;
    }

    @Override
    public int getLiveNeighbors(int x, int y) {
        int n = 0;
        for (int y_off = -1; y_off <= 1; y_off++) {
            for (int x_off = -1; x_off <= 1; x_off++) {

                if (grid[check_borders(x+x_off,X_SIZE)][check_borders(y+y_off,Y_SIZE)] == 1 && !(x_off == 0 && y_off==0)){
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
        for (int a = 0; a <= Y_SIZE - 1; a++) {
            for (int b = 0; b <= X_SIZE - 1; b++) {
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

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife(10,10);
        int x=0;
        int y=0;
        gol.setAlive(x-1,y-1);
        gol.setAlive(x,y-1);
        gol.setAlive(x+1,y-1);
        gol.setAlive(x-1,y);
        gol.setAlive(x+1,y);
        gol.setAlive(x-1,y+1);
        gol.setAlive(x,y+1);
        gol.setAlive(x+1,y+1);
        gol.showGrid();
        System.out.println();
        System.out.println(gol.getLiveNeighbors(x,y));
    }



}
