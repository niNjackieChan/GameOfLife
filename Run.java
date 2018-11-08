import java.security.cert.X509Certificate;

public class Run extends GameOfLife{

    public Run(int x_size, int y_size){
        super(x_size, y_size);
    }



    public static void main(String[] args) {
        // Konstanten wie in der Game of Life Klasse
        int ALIVE = 1; // Bitte hier die Konstanten der GameofLIfe Klasse
        // verwenden
        int DEAD = 0; // Bitte hier die Konstanten der GameofLIfe Klasse
        // verwenden
        // Anwendung der visuellen Darstellung
        GameOfLife gol = new GameOfLife(50, 50);

        //Big Explosion
        /*gol.setAlive(20, 18);
        gol.setAlive(21, 18);
        gol.setAlive(22, 18);
        gol.setAlive(18, 18);
        gol.setAlive(17, 18);
        gol.setAlive(16, 18);

        gol.setAlive(20, 20);
        gol.setAlive(21, 20);
        gol.setAlive(22, 20);
        gol.setAlive(18, 20);
        gol.setAlive(17, 20);
        gol.setAlive(16, 20);


        gol.setAlive(16, 19);
        gol.setAlive(22, 19);*/

        // Kleiner Vogel
        gol.setAlive(11, 10);
        gol.setAlive(12, 10);
        gol.setAlive(13, 10);
        gol.setAlive(14, 10);

        gol.setAlive(10, 11);
        gol.setAlive(14, 11);

        gol.setAlive(14, 12);

        gol.setAlive(10, 13);
        gol.setAlive(13, 13);

        //Mittel Vogel
        gol.setAlive(11, 20);
        gol.setAlive(12, 20);
        gol.setAlive(13, 20);
        gol.setAlive(14, 20);
        gol.setAlive(15, 20);

        gol.setAlive(10, 21);
        gol.setAlive(15, 21);

        gol.setAlive(15, 22);

        gol.setAlive(14, 23);
        gol.setAlive(10, 23);

        gol.setAlive(12, 24);
        // hier bitte eine Instnaz ihrer Klasse verwenden

        VisualGameOfLife sb = new VisualGameOfLife(gol.grid);
        for (int i = 0; i <= 10000; i++) {
            gol.runGeneration();
            try {
                Thread.sleep(100); // 300ms Pause
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sb.refresh(gol.grid);
        }


    }
}
