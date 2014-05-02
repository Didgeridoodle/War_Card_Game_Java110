//Arrays will be used because I really dislike arraylists


class mainframe{
	
	public static void main(String[] args){
		scene render = new scene();
		war game = new war();
		
		boolean activegame = true;
		boolean done = false;
		int[] cmds = new int[6];
		cmds[0] = 0;
		//cmds 0 determines what screen is rendered
		//cmds 1 is player deck size
		//cmds 2 is computer deck size
		//cmds 3 is player card index
		//cmds 4 is computer card index
		//cmds 5 is if someone won the round and who, 0 none, 1 player, 2 computer, 3 WAR
		while(done==false){
			//Delay prevents Flashing madness
			try {
			    Thread.sleep(100);
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			
			
			//Drawing Agent
			render.drawstuff(cmds);
			
			
			//Input Checker
			if(render.checkinput()==true){
				int[] clkholder = render.getinput();
				if(clkholder[1]>=400&&clkholder[1]<=440){
					if(clkholder[0]>=20&&clkholder[0]<=60){
						if(activegame==true){
							game.next();
							int[] hold = game.checkstate();
							cmds[5] = hold[0];
							cmds[0] = hold[1];
							cmds[1] = hold[2];
							cmds[2] = hold[3];
							//todo cmds 3 and 4 for card index
						}
						else{
							game = new war();
							activegame = true;
						}
					}
					else if(clkholder[0]>=80&&clkholder[0]<=130){
						//Exits program, exit button
						done = true;
						render.kill();
					}
					else{
						//Useless, bug testing maybe
						System.out.println("Clicked nothing.");
					}
				}
			}
			
		}
	}
}