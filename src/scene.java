import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.imageio.ImageIO;


public class scene extends Canvas implements MouseListener, MouseMotionListener{
	//Window and Graphics
	private JFrame window;
	private Image backbuffer;
	private Image Flash;
	private Graphics backg;
	
	//Mouse Tracking
	private int xp;
	private int yp;
	private boolean clicked;
	
	//Storage for card images
	private BufferedImage[] carddraw;
	
	public scene(){		
		xp = 0;
		yp = 0;
		clicked = false;
		window = new JFrame("War Card Game");
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
		carddraw = new BufferedImage[stack.stacksize];
		for(int i = 0; i < stack.stacksize; i++){
			String cardname = "";
			card test = new card();
			
			try{
				test = dummy.getcard(i);
				cardname = test.getcardname();
			}catch(NullPointerException e){
				e.printStackTrace();
			}
			
			try{
				File toload = new File(getClass().getResource("cardPics/"+cardname).toURI());
				carddraw[i] = ImageIO.read(toload);
			}catch(IOException | URISyntaxException e){
				System.out.println("Images are missing!!!");
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkinput(){
		boolean hold = clicked;
		clicked = false;
		return hold;
	}
	
	public int[] getinput(){
		int[] abc = new int[2];
		abc[0] = xp;
		abc[1] = yp;
		return abc;
	}

	public void drawstuff(int[] args){ 
		//Drawing method
		//Decide which GUI to render
		if(args[0]==0){
			drawDefaultGUI();
			//Process continues inside here
			drawDeckSize(args[1], args[2]);
			backg.drawImage(carddraw[0], 50, 80, 150, 200, null);
			backg.drawImage(carddraw[0], 440, 80, 150, 200, null);
		}
		else{
			String mess = "";
			if(args[0]==2){
				mess = "Player WINS!!!";
			}
			else{
				mess = "Computer WINS!!!";
			}
			drawEndGame(mess);
		}
		repaint();
	}
	
	private void drawDeckSize(int pd, int cd){
		//Draw backdrops
		backg.setColor(Color.BLUE);
		backg.fillRect(60, 30, 100, 45);
		backg.fillRect(480, 30, 100, 45);
		//draw counts
		backg.setColor(Color.PINK);
		backg.drawString("Player:", 65, 45);
		backg.drawString(pd + " Cards in deck", 65, 55);
		backg.drawString("Player:", 485, 45);
		backg.drawString(pd + " Cards in deck", 485, 55);
		
	}
	
	private void drawDefaultGUI(){
		//draws GUI
		//I like to do my GUI by hand, more fun
		//Playing Field
		backg.setColor(Color.GREEN);
		backg.fillRect(0, 0, 640, 390);
		//Super Ugly Thing
		backg.setColor(Color.CYAN);
		backg.fillRect(0,390,640,90);		
		//Buttons
		backg.setColor(Color.RED);
		backg.fillRect(10, 400, 50, 40);
		backg.fillRect(80, 400, 50, 40);
		backg.setColor(Color.BLACK);
		backg.drawString("Next", 20, 425);
		backg.drawString("Exit", 95, 425);
	}
	
	private void drawEndGame(String mess){
		//draws GUI
		//I like to do my GUI by hand, more fun
		//White Out
		backg.setColor(Color.WHITE);
		backg.fillRect(0, 0, 640, 480);
		//Button
		backg.setColor(Color.RED);
		backg.fillRect(210, 200, 220, 80);
		backg.fillRect(10, 400, 50, 40);
		backg.fillRect(80, 400, 50, 40);
		backg.setColor(Color.BLACK);
		backg.drawString(mess, 20, 200);
		backg.drawString("Would you like to start a new game?", 225, 235);
		backg.drawString("Yes", 20, 425);
		backg.drawString("No", 95, 425);


	}
	
	
	//I really don't remember what the update and paint things do
	//I made these for my 3d rendering practice at the beginning of the semester
	public void update(Graphics g){	
		g.drawImage(backbuffer, 0, 0, this);
	}
	
	public void paint(Graphics g) {
		update(g);
	}
	
	
	public void kill(){
		window.dispose();
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
		clicked = true;
		xp = arg0.getX();
		yp = arg0.getY();
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