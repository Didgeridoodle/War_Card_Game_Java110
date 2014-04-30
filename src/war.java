public class war{
	private stack pdeck;
	private stack cdeck;
	
	
	public war(){
		stack tempdeck = new stack();
		tempdeck.shuffle();
		boolean alter = false;
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
	
}