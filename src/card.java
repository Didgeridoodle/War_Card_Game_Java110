public class card{
	private int suit;
	private int rank;
	
	
	public card(int s, int r){
		suit = s;
		rank = r;
	}
	
	public int getrank(){
		return rank;
	}
	
	public String getsuit(){
		if(suit==0){
			return "clubs";
		}
		else if(suit==1){
			return "diamonds";
		}
		else if(suit==2){
			return "hearts";
		}
		else{
			return "spades";
		}
	}
	
	public card clone(){
		return new card(suit, rank);
	}
	
}