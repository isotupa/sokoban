package es.upm.pproject.parser;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import es.upm.pproject.items.Box;
import es.upm.pproject.items.Goal;
import es.upm.pproject.items.Wall;
import es.upm.pproject.items.Warehouseman;

public class Level {

	private int nRows, nColumns;
	private String lvlTitle;

	private char[][] matrix;

	public Level(int nRows, int nColumns) {
		this.nRows = nRows;
		this.nColumns = nColumns;

		matrix = new char[this.nRows][this.nColumns];
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public void set(int x, int y, char value) {
		matrix[x][y] = value;
	}

	public char get(int x, int y) {
		return matrix[x][y];
	}

	public String getLvlTitle() {
		return lvlTitle;
	}

	public void setLvlTitle(String lvlTitle) {
		this.lvlTitle = lvlTitle;
	}

	public String toString() {
		String res = "";

		for(int i = 0; i < nColumns; i++) {
			for(int j = 0; j < nRows; j++) {
				res += get(j,i);
			}
			res += "\n";
		}

		return res;
	}
	public void generateLevel(JFrame frame) {
		JLabel label=null;
		for(int i = 0; i < nColumns; i++) {
			for(int j = 0; j < nRows; j++) {
				char character = matrix[i][j];
				try {
					switch(character) {
					case '+':
						label = new Wall(i*80,j*80,"sprites/items/wall.jpg").getLabel();
						break;
					case '.':
						break;
					case '*':
						label = new Goal(i*80,j*80,"sprites/items/orb.gif").getLabel();
						break;
					case '#':
						Box box = new Box(i*80,j*80,"sprites/items/box.jpg");
						label = box.getLabel();
						break;
					case 'W':
						Warehouseman player =new Warehouseman(i*80, j*80, "sprites/character/s.png");
						label=player.getLabel();
						frame.addKeyListener(player);
						break;
					default:
						break;
					}
					frame.add(label);

				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}

		}

	}
	
	public int getnRows() {
		return nRows;
	}

	public int getnColumns() {
		return nColumns;
	}
}
