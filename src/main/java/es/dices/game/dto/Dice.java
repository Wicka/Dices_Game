package es.dices.game.dto;

public class Dice {
	
	private int toss;
	
	public Dice () {
		this.toss=(int) (Math.random() * 6)+1;;
	}

	//-------------------------------------------------------------------------------------------------------------------
	//------------------------------------------- GETTERS
	//-------------------------------------------------------------------------------------------------------------------
	
	public int getToss() {
		return toss;
	}
	
	//-------------------------------------------------------------------------------------------------------------------
	//------------------------------------------- SETTERS
	//-------------------------------------------------------------------------------------------------------------------
		
	public void setToss(int toss) {
		this.toss = toss;
	}

	//-------------------------------------------------------------------------------------------------------------------
	//------------------------------------------- TO STRING
	//-------------------------------------------------------------------------------------------------------------------
	
	
	@Override
	public String toString() {
		return "[toss=" + toss + "]";
	}
	

}
