import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;

public class scene extends Canvas implements MouseListener, MouseMotionListener{
	//Window and Graphics
	private JFrame window;
	private Image backbuffer;
	private Image Flash;
	private Graphics backg;
	
	//Storage for card images
	BufferedImage[] carddraw;
	
	public scene(){		
		window = new JFrame("Testing Renders");
		window.setSize(640,480);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout());
		window.add(this);
		window.setVisible(true);
		backbuffer = createImage(640,480);
		Flash = createImage(640,480);
		backg = backbuffer.getGraphics();
		addMouseListener(this);
		addMouseMotionListener(this);
		
		//Loadup card pics
		stack dummy = new stack();
		for(int i = 0; i < stack.stacksize; i++){
			String cardname = dummy.getcard(i).getcardname();
			
			try {
				
				carddraw[i] = ImageIO.read(new File("cardPics/" + cardname));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getinput(){
		return 0;
	}

	
	
	
	
	//Buncha junk ignore below
	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}