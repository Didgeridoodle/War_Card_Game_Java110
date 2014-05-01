public class card{
	private int suit = 0;
	private int rank = 0;
	
	
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
	
	public String getcardname(){
		String mess = "";
		if(rank<=10){
			mess = String.valueOf(rank);
		}
		else if(rank==11){
			mess = "jack";
		}
		else if(rank==12){
			mess = "queen";
		}
		else if(rank==13){
			mess = "king";
		}
		else{
			mess = "ace";
		}
		
		if(suit==0){
			mess += "c.jpg";
		}
		else if(suit==1){
			mess += "d.jpg";
		}
		else if(suit==2){
			mess += "h.jpg";
		}
		else{
			mess += "s.jpg";
		}
		
		return mess;
	}
	
	
	public boolean equals(card test){
		if(rank==test.getrank()){
			return true;
		}
		else{
			return false;
		}
	}
	
}