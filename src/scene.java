import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;

public class scene extends Canvas implements MouseListener, MouseMotionListener{
	//Window and Graphics
	private JFrame window;
	private Image backbuffer;
	private Image Flash;
	private Graphics backg;
	
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
	}
	
	public int getinput(){
		return 0;
	}

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