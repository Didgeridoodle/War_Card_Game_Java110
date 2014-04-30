public class stack{
	//Used for storing a stack of cards
	private int curind;
	private card[] cardlist;
	
	public stack(){
		cardlist = new card[52];
		int count = 0;
		for(int i = 0; i < 4; i++){
			for(int k = 1; k < 14; k++){
				cardlist[count] = new card(i,k);
			}
		}
	}
	
	public stack(int o){
		//used to create war stacks
		curind = 0;
		cardlist = new card[52];
	}
	
	public void addcard(card ac){
		cardlist[curind] = ac;
		curind += 1;
	}
	
	private stack(card[] cli){
		cardlist = cli;
	}
	
	public stack clone(){
		stack retstack = new stack(cardlist);
		return retstack;
	}
	
	public card getcard(int i){
		return cardlist[i];
	}
	
}