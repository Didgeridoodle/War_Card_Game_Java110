import java.util.Random;

public class stack{
	//Used for storing a stack of cards
	public static int stacksize = 52;
	private int curind;
	private card[] cardlist;
	
	public stack(){
		cardlist = new card[stacksize];
		int count = 0;
		for(int i = 0; i < 4; i++){
			for(int k = 2; k < 15; k++){
				cardlist[count] = new card(i,k);
			}
		}
	}
	
	public stack(int o){
		//used to create war stacks
		curind = 0;
		cardlist = new card[stacksize];
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
	
	public void shuffle(){
		Random rnd = new Random();
		for(int i = 0; i < cardlist.length; i++){
			int index = rnd.nextInt(51)+1;
			card hold = cardlist[index];
			cardlist[index] = cardlist[i];
			cardlist[i] = hold;
		}
	}
	
}