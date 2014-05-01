public class war{
	private int state;
	private stack field;
	private stack pdeck;
	private stack cdeck;
	
	private card pfight;
	private card cfight;
	
	public war(){
		state = 0;
		stack tempdeck = new stack();
		tempdeck.shuffle();
		boolean alter = false;
		field = new stack(0);	
		pdeck = new stack(0);
		cdeck = new stack(0);
		for(int i = 0; i < stack.stacksize; i++){
			if(alter==false){
				alter = true;
				pdeck.addcard(tempdeck.getcard(i).clone());
			}
			else{
				alter = false;
				cdeck.addcard(tempdeck.getcard(i).clone());
			}
		}
		//Splits decks up into probably equal piles
	}
	
	
	public void next(){
		//Round 1 War
		if(state==0){
			//First and second cards are the ones currently in the war
			int phase = field.addcard(pdeck.getcard(0).clone());
			field.addcard(cdeck.getcard(0).clone());
			pdeck.refactorlist(1);
			cdeck.refactorlist(1);
			if(field.getcard(phase).equals(field.getcard(phase+1))){
				state = 3;
			}
			else if(field.getcard(phase).getrank() > field.getcard(phase+1).getrank()){
				state = 1;
			}
			else{
				state = 2;
			}
			pfight = field.getcard(phase);
			cfight = field.getcard(phase+1);
		}
		else if(state==1){
			//Player won
			for(int i = 0; i < field.checksize(); i++){
				pdeck.addcard(field.getcard(i).clone());
			}
			state = 0;
		}
		else if(state==2){
			//Enemy won
			for(int i = 0; i < field.checksize(); i++){
				cdeck.addcard(field.getcard(i).clone());
			}
			state = 0;
		}
		else if(state==3){
			//I've decided due most likely to lazyness that if a player doesn't have enough for the war they lose.
			if(pdeck.checksize()>=3&&cdeck.checksize()>=3){
				field.addcard(pdeck.getcard(0).clone());
				field.addcard(pdeck.getcard(1).clone());
				field.addcard(pdeck.getcard(2).clone());
				field.addcard(cdeck.getcard(0).clone());
				field.addcard(cdeck.getcard(1).clone());
				field.addcard(cdeck.getcard(2).clone());
				//Now to add the two important cards
				int phase = field.addcard(pdeck.getcard(3).clone());
				field.addcard(cdeck.getcard(3).clone());
				if(field.getcard(phase).equals(field.getcard(phase+1))){
					state = 3;
				}
				else if(field.getcard(phase).getrank()>field.getcard(phase+1).getrank()){
					state = 1;
				}
				else{
					state = 2;
				}
				pfight = field.getcard(phase).clone();
				cfight = field.getcard(phase+1).clone();
				pdeck.refactorlist(4);
				cdeck.refactorlist(4);
			}
			else if(pdeck.checksize()<=2){
				//this lowers the current index of the stack making the checkstate method declare them the loser
				pdeck.refactorlist(pdeck.checksize());
			}
			else{
				cdeck.refactorlist(cdeck.checksize());
			}
		}
		
	}
	
	public int[] checkstate(){
		//First integer is who won the round, second is if a game winner occurs, third and fourth are the respective deck counts
		int[] abc = new int[4];
		//Round winner check
		abc[0] = state;
		
		//Game winner check
		if(pdeck.checksize()==0){
			abc[1] = 1;
		}
		else if(cdeck.checksize()==0){
			abc[1] = 2;
		}
		else{
			abc[1] = 0;
		}
		
		abc[2] = pdeck.checksize();
		abc[3] = cdeck.checksize();
		return abc;
	}
	
	public card[] getfight(){
		card[] retlist = new card[2];
		retlist[0] = pfight;
		retlist[1] = cfight;
		return retlist;
	}
	
	
}