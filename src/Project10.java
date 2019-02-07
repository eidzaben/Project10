//This code was created by Eid Zaben and Zachary Henson for CS lab
		import java.io.File;
		import java.io.FileNotFoundException;
		import java.io.PrintWriter;


		
public class Project10 {

	public static void main(String[] args) throws FileNotFoundException {
		final int MAX = 255;
		final int ROW = 10;
		final int COL = 10;
		final int S_Width = 1;
		int[][] vImage = makeVertical(COL, ROW, S_Width);
		writeFile("vertImage.pgm", ROW, COL, MAX, vImage);
		
		int[][] hImage = makeHorizontal(COL, ROW, S_Width);
		writeFile("horizImage.pgm", ROW, COL, MAX, hImage);
		
		int[][] cImage = makeChecker(COL, ROW, S_Width);
		writeFile("checkImage.pgm", ROW, COL, MAX, cImage);
		
		int[][] dImage = makeDiagonal(COL, ROW, S_Width);
		writeFile("diagImage.pgm", ROW, COL, MAX, dImage);


	}
	
	//Make vertical 
	public static int[][] makeVertical(int height, int width, int stripeWidth) {
		int[][] image = new int[width][height];
		for (int rows = 0; rows < height; rows += stripeWidth) {
			for (int cols = 0; cols < width; cols += stripeWidth) {
				if (cols % 2 == 0) {
					image[rows][cols] = 255;
				}
				else {
					image[rows][cols] = 0;
				}
			}
		}
		return image;
	}
	
	//Make horizontal
	public static int[][] makeHorizontal(int height, int width, int stripeHeight) {
		int[][] image = new int[width][height];
		for (int cols = 0; cols < height; cols += stripeHeight) {
			for (int rows = 0; rows < width; rows += stripeHeight) {
				if (rows % 2 == 0) {
					image[rows][cols] = 255;
				}
				else {
					image[rows][cols] = 0;
				}
			}
		}
		return image;
	}
	
	//Make Checker
	public static int[][] makeChecker(int height, int width, int stripeWidth) {
		int[][] image = new int[width][height];
		for (int cols = 0; cols < height; cols += stripeWidth) {
			for (int rows = 0; rows < width; rows += stripeWidth) {
				if ((rows + cols) % 2 == 0) {
					image[rows][cols] = 255;
				}
				else {
					image[rows][cols] = 0;
				}
			}
		}
		return image;
	}
	
	//Make Diagonal
	public static int[][] makeDiagonal(int height, int width, int stripeWidth) {
		int[][] image = new int[width][height];
		for (int cols = 0; cols < height; cols += stripeWidth) {
			for (int rows = 0; rows < width; rows += stripeWidth) {
				if ((rows + cols) % 3 == 0) {
					image[rows][cols] = 255;
				}
				else {
					image[rows][cols] = 0;
				}
			}
		}
		return image;
	
	}
	
	public static void writeFile(String fileName, int ROWS, int COLS, int MAX, int[][] array) throws FileNotFoundException {
		PrintWriter iFile = new PrintWriter(new File (fileName));
		iFile.write("P2 \n");
		iFile.write(ROWS + " " + COLS + "\n");
		iFile.write(MAX + "\n") ;
		for (int rows = 0; rows < ROWS; ++rows) {
			for (int cols = 0; cols < COLS; ++cols) {
				iFile.write(array[rows][cols] + " ");
			}
		}
		iFile.close();
	}
	
	
	
}
