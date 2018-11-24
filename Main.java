import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		EZ.initialize(20*32, 20*32);
		EZ.setBackgroundColor(new Color(0, 0,0)); 
		
		Map map = new Map();
		
		Life lives = new Life();
		
		FileReader fileReader = new FileReader("level.txt");
		Scanner fs = new Scanner(fileReader);

		int width = fs.nextInt();
		int height = fs.nextInt();
		String inputText = fs.nextLine();
		
		Point[][] myPoints = new Point[width][height];
		int i = 0;
		for(int row = 0; row < height; row++){
			
			inputText = fs.nextLine();
			
			for (int column = 0; column < width; column++){
				
				char ch = inputText.charAt(column);
		
					if ((row == 1) && (column == 1)) {
					}else if (ch == 'R') {
						myPoints[column][row] = new Point(column, row);
					}
			}	
		}
		fs.close();
		
		Ghost g1 = new Ghost(17*32, 32);
		Ghost g2 = new Ghost(64, 8*32);
		Ghost g3 = new Ghost(32, 18*32);
		
		
		int playerState = 0;
		
		Player myPlayer = new Player();

		while (playerState == 0) {

			g1.moveDown();
			g2.moveRight();
			g3.moveRight();
			
			// Steer the Player
			myPlayer.ControlIt();
			EZ.refreshScreen();
		}
	}
		
	
}
