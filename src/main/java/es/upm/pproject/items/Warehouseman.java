package es.upm.pproject.items;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



public class Warehouseman extends MovableObject implements KeyListener {

	BufferedImage imageS;
	BufferedImage imageA;
	BufferedImage imageD;
	BufferedImage imageW;
	final int mDistance=80;
	
	public Warehouseman(int x, int y,String pathSprite) throws IOException {
		super(x, y,pathSprite);
		imageS = ImageIO.read(new File("sprites/character/s.png"));
		imageA = ImageIO.read(new File("sprites/character/a.png"));
		imageD = ImageIO.read(new File("sprites/character/d.png"));
		imageW = ImageIO.read(new File("sprites/character/w.png"));
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='a') {
			if(moveLeft()) {
				x=x-mDistance;
				label.setBounds(x, y, size[0], size[1]);
			}
			label.setIcon(new ImageIcon(imageA));
		}
		if(e.getKeyChar()=='w') {
			if (moveUp()) {
				y=y-mDistance;
				label.setBounds(x, y,size[0], size[1]);
			}
			label.setIcon(new ImageIcon(imageW));
		}
		if(e.getKeyChar()=='d') {
			if (moveRight()) {
				x=x+mDistance;
				label.setBounds(x, y, size[0], size[1]);
			}
			label.setIcon(new ImageIcon(imageD));
		}
		if(e.getKeyChar()=='s') {
			if (moveDown()) {
				y=y+mDistance;
				label.setBounds(x, y, size[0], size[1]);
			}
			label.setIcon(new ImageIcon(imageS));
		}
	}
}
