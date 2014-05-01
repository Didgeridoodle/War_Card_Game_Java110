public class war{
	private int state;
	private stack field;
	private stack pdeck;
	private stack cdeck;
	
	
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
				pdeck.addcard(tempdeck.getcard(i));
			}
			else{
				alter = false;
				cdeck.addcard(tempdeck.getcard(i));
			}
		}
		//Splits decks up into probably equal piles
	}
	
	public int getstate(){
		return 0;
	}
	
	public void next(){
		//Round 1 War
		if(state==0){
			//First and second cards are the ones currently in the war
			field.addcard(pdeck.getcard(0));
			field.addcard(cdeck.getcard(0));
			if(field.getcard(0).equals(field.getcard(1))){
				state = 3;
			}
			else if(field.getcard(0).getrank() > field.getcard(1).getrank()){
				
			}
			else{
				
			}
		}
		
	}
	
}