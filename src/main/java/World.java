import java.io.File;

import javax.swing.JFrame;

import es.upm.pproject.exceptions.IllegalFileFormatException;
import es.upm.pproject.parser.Level;
import es.upm.pproject.parser.Parse;
import es.upm.pproject.rules.Rules;

public class World {
	
	private static Level l=null;
	private JFrame frame;
	
	public World(String pathFile){
		try {
			l = Parse.parseTxt(new File(pathFile));
			Rules.generateMatrix(l.getMatrix());
		} catch (IllegalFileFormatException e) {
			e.printStackTrace();
		}
		
		frame= new JFrame();
		frame.setSize(l.getnRows()*80, l.getnColumns()*80+35);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		//try-catch block doesn't belong here, it is only for testing purpose. It should be in "generateMap" method.
		generateMap(l,frame);
		frame.setVisible(true);
		
	}
	//generate the world using object level.
	private void generateMap(Level l,JFrame frame) {
		l.generateLevel(frame);
	}
	
    public static void main(String[] args) {
    	new World("res/test1");
    }
    
    public static Level getLevel(){
    	return l;
    }
    
}
