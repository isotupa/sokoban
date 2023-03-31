package es.upm.pproject.items;

import java.io.IOException;

import es.upm.pproject.rules.Rules;

public class MovableObject extends WorldObject {
	final int mDistance = 80;
	
	public MovableObject(int x, int y,String pathSprite) throws IOException {
		super(x, y, pathSprite);
	}

	public boolean moveUp() {
		return Rules.getRules().moveUp(x, y);
	}
	
	public boolean moveDown() {
		return Rules.getRules().moveDown(x, y);
	}
	
	public boolean moveRight() {
		return Rules.getRules().moveRight(x, y);
	}
	
	public boolean moveLeft() {
		return Rules.getRules().moveLeft(x, y);
	}

}
