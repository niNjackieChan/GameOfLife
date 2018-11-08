
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

@SuppressWarnings("serial")
class CanvasInt extends Canvas {
	private int grid[][];

	public CanvasInt(int[][] grid_) {
		this.grid = grid_;
	}

	/**
	 * @param grid_
	 *            the grid to set
	 */
	public void setGrid(int[][] grid_) {
		this.grid = grid_;
	}

	/**
	 * update : wird bei repaint() aufgerufen
	 */
	public void update(Graphics g) {
		// Berechne die Breite und Höhe der Felder
		Rectangle frameBounds = getBounds();
		int width = frameBounds.width - 1;
		int height = frameBounds.height - 1;
		double xSize = (double) width / grid.length;
		double ySize = (double) height / grid[0].length;
		for (int xPos = 0; xPos < grid.length; xPos++) {
			for (int yPos = 0; yPos < grid[0].length; yPos++) {
				if (grid[xPos][yPos] == 1) {
					g.setColor(Color.YELLOW);
				} else {
					g.setColor(Color.BLACK);
				}
				g.fillRect((int) (xSize * xPos), (int) (ySize * (grid[0].length - 1 - yPos)), (int) xSize + 1,
						(int) ySize + 1);
			}
		}
	}

	/**
	 * paint wird beim ersten Mal aufgerufen => initialisierung
	 */
	public void paint(Graphics g) {
		update(g);
	}
}

// --- end of GoLCanvas ----------

@SuppressWarnings("serial")
public class VisualGameOfLife extends Frame {
	private CanvasInt gol;

	public VisualGameOfLife(int[][] grid_) {
		super("Game of Life");
		// Groesse des Feldes anpassen aber mit min 300x300
		int xMax = grid_.length;
		int yMax = grid_[0].length;
		int xFrame = xMax * 15;
		int yFrame = yMax * 15;
		if (xFrame < 300) {
			xFrame = 300;
		}
		if (yFrame < 300) {
			yFrame = 300;
		}
		setSize(xFrame, yFrame);
		gol = new CanvasInt(grid_);
		add(gol, BorderLayout.CENTER);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		setVisible(true);
	}

	/**
	 * 
	 * Methode zum Neuzeichen des Gitters
	 *
	 * @param grid_
	 *            Referenz auf aktuelles Feld
	 */
	public void refresh(int[][] grid_) {
		gol.setGrid(grid_);
		gol.repaint();
	}

	public static void main(String[] args) {
		// Konstanten wie in der Game of Life Klasse
		int X_SIZE = 100;
		int Y_SIZE = 100;
		int ALIVE = 1; // Bitte hier die Konstanten der GameofLIfe Klasse
		// verwenden
		int DEAD = 0; // Bitte hier die Konstanten der GameofLIfe Klasse
		// verwenden
		int[][] grid = new int[X_SIZE][Y_SIZE];
		int last = X_SIZE;
		// Anwendung der visuellen Darstellung
		// hier bitte eine Instnaz ihrer Klasse verwenden
		VisualGameOfLife sb = new VisualGameOfLife(grid);
		if (X_SIZE > Y_SIZE) {
			last = Y_SIZE;
		}
		grid[0][0] = ALIVE;
		//grid[1][0] = ALIVE;
		grid[last - 1][0] = ALIVE;
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = 1; i < last; i++) {
			grid[i][i] = ALIVE;
			grid[i - 1][i - 1] = DEAD;
			grid[last - i - 1][i] = ALIVE;
			grid[last - i][i - 1] = DEAD;
			try {
				Thread.sleep(300); // 300ms Pause
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sb.refresh(grid);
		}
	}
}