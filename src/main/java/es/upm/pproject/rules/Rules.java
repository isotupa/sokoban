package es.upm.pproject.rules;

public class Rules {
	private static Rules rules=null;
	private static char[][] matrix;
	//We use this int to let the items move through the matrix 
	private final int distance = 80;
	private Rules(char[][] matrix) {
		Rules.matrix=matrix;
	}
	public static Rules generateMatrix(char[][] matrix) {
		if(rules ==null) {
			rules=new Rules(matrix);
		}
		return rules;
	}
	public static Rules getRules() {
		return rules;
	}
	
	public boolean moveUp(int x, int y) {
		return matrix[x/distance][y/distance-1] != '+' && matrix[x/distance][y/distance-1] != '#';
	}
	public boolean moveDown(int x, int y) {
		return matrix[x/distance][y/distance+1] != '+' && matrix[x/distance][y/distance+1] != '#';
	}
	public boolean moveLeft(int x, int y) {
		return matrix[x/distance-1][y/distance] != '+' && matrix[x/distance-1][y/distance] != '#';
	}
	public boolean moveRight(int x, int y) {
		return matrix[x/distance+1][y/distance] != '+' && matrix[x/distance+1][y/distance] != '#';
	}
}
