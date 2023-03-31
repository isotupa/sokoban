package es.upm.pproject.items;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import es.upm.pproject.parser.Level;

public class WorldObject {
	protected int x;
	protected int y;
	protected JLabel label;
	protected int [] size= {80,80};
	protected int mx,my;
	protected Level l;
	
	public WorldObject(int x, int y, String pathSprite) throws IOException {
		this.x = x;
		this.y = y;
		BufferedImage image = ImageIO.read(new File(pathSprite));
		label=new JLabel(new ImageIcon(image));
		label.setBounds(x, y, size[0], size[1]);
		label.setVisible(true);
	}
	
	public WorldObject(int x, int y, String pathSprite, Level l) throws IOException{
		this.x = x;
		this.y = y;
		this.l = l;
		BufferedImage image = ImageIO.read(new File(pathSprite));
		label=new JLabel(new ImageIcon(image));
		label.setBounds(x, y, size[0], size[1]);
		label.setVisible(true);
	}
	
	public JLabel getLabel() {
		return label;
	}
	

}
