import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.cert.X509Certificate;
import java.util.Scanner;

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
        GameOfLife gol = new GameOfLife(120, 120);
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Write a Number to enter the Menu:\n" +
                "1. Explosion\n" +
                "2. Birds\n" +
                "3. Mati\n" +
                "4. Leon\n" +
                "5. Blume\n" +
                "Bitte geben sie eine Nummer aus dem Menü ein: ");
        int n = reader.nextInt();
        if (n == 1) {
            gol.setAlive(20, 18);
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
            gol.setAlive(22, 19);
            Run.startgameoflife(gol);
        }
        else if (n == 2) {
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
            gol.setAlive(21, 20);
            gol.setAlive(22, 20);
            gol.setAlive(23, 20);
            gol.setAlive(24, 20);
            gol.setAlive(25, 20);

            gol.setAlive(20, 21);
            gol.setAlive(25, 21);

            gol.setAlive(25, 22);

            gol.setAlive(24, 23);
            gol.setAlive(20, 23);

            gol.setAlive(22, 24);
            //Großer Vogel
            gol.setAlive(31, 30);
            gol.setAlive(32, 30);
            gol.setAlive(33, 30);
            gol.setAlive(34, 30);
            gol.setAlive(35, 30);
            gol.setAlive(36, 30);

            gol.setAlive(30, 31);
            gol.setAlive(36, 31);

            gol.setAlive(36, 32);

            gol.setAlive(30, 33);
            gol.setAlive(35, 33);

            gol.setAlive(32, 34);
            gol.setAlive(33, 34);
            //Mittel Vogel
            gol.setAlive(21, 40);
            gol.setAlive(22, 40);
            gol.setAlive(23, 40);
            gol.setAlive(24, 40);
            gol.setAlive(25, 40);

            gol.setAlive(20, 41);
            gol.setAlive(25, 41);

            gol.setAlive(25, 42);

            gol.setAlive(24, 43);
            gol.setAlive(20, 43);

            gol.setAlive(22, 44);
            // Kleiner Vogel
            gol.setAlive(11, 50);
            gol.setAlive(12, 50);
            gol.setAlive(13, 50);
            gol.setAlive(14, 50);

            gol.setAlive(10, 51);
            gol.setAlive(14, 51);

            gol.setAlive(14, 52);

            gol.setAlive(10, 53);
            gol.setAlive(13, 53);
            Run.startgameoflife(gol);
        }
        else if (n == 3) {
            for (int i = 0; i <= X_SIZE; i++) {
                gol.setAlive(i, 0);
                gol.setAlive(0, i);
                gol.setAlive(i, i);
            }
            Run.startgameoflife(gol);
        }
        else if (n == 4) {
            for (int i = 0; i <= X_SIZE; i++) {
                gol.setAlive(i, 0);
                gol.setAlive(0, i);
                gol.setAlive(i, i);
                gol.setAlive(i++, i--);
            }

            Run.startgameoflife(gol);


        }
        // Empfohlene Feldgröße 120
        else if (n==5){
            for(int i=0; i <= X_SIZE; i++){
            for(int l=0; l <= 10000; l++){
                int random1 = (int )(Math.random() * 50 );
                int random2 = (int )(Math.random() * 50 );
                gol.setAlive(random1+(X_SIZE/4), random2+(X_SIZE/4));}


            }
            Run.startgameoflife(gol);
            reader.close();
        }

    }
    public static void startgameoflife(GameOfLife gol){
        VisualGameOfLife sb = new VisualGameOfLife(gol.grid);
        for (int i = 0; i <= 1000; i++) {
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
