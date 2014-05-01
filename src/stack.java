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
				count++;
			}
		}
	}
	
	public stack(int o){
		//used to create war stacks
		curind = 0;
		cardlist = new card[stacksize];
	}
	
	//Adds a card to the array and returns it's position
	public int addcard(card ac){
		cardlist[curind] = ac;
		curind++;
		int retval = curind-1;
		return retval;
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
	
	public void refactorlist(int i){
		//Moves elements up in the list, 0 is the top
		int hold = curind;
		for(int k = 0; k < hold-i; k++){
			cardlist[k] = cardlist[k+i];
		}
		curind = curind - i;
	}
	
	public int checksize(){
		return curind;
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