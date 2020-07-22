package es.dices.game.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="diceroll")
public class DiceRoll {
	
	
	// ---------------------------------------------------------------------------------------------------
	// ---------------------------------- ATRIBUTES / FIELDS --------------------------------------------
	// ---------------------------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
	@Column(name="idroll")
	private int id;
	
	@Column(name="idtoss")
	private int toss;
	
	@Column(name="idgame")
	private int game;
	
	@Column(name="idplayer")
	private  int player;
	
	@Column(name="dice1")
	private int dice1;
	
	@Column(name="dice2")
	private int dice2;
	
	@Column(name="result")
	private int result;

	
	
	/**
	 * @param id   			-- tbl diceroll 	(idpicture)
	 * @param idtoss		-- tbl diceroll 	(idtoss)
	 * @param idgame		-- tbl diceroll 	(idgame)
	 * @param idplayer		-- tbl diceroll 	(idplayer)
	 * @param dice1			-- tbl diceroll		(dice1)
	 * @param dice2			-- tbl diceroll		(dice2)
	 * @param result		-- tbl diceroll		(result)
	 */
	

	// -----------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------
		
	// ---------------------------------- BUILDERS ---------------------------------------------------------

	public DiceRoll() {
		
	}
	
	public DiceRoll(int id, int toss, int game, int player, int dice1, int dice2, int result) {
		super();
		this.id = id;
		this.toss = toss;
		this.game = game;
		this.player = player;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.result = result;
	}

	

	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     GETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	public int getId() {
		return id;
	}

	public int getToss() {
		return toss;
	}

	public int getGame() {
		return game;
	}

	public int getPlayer() {
		return player;
	}

	public int getDice1() {
		return dice1;
	}

	public int getDice2() {
		return dice2;
	}

	public int getResult() {
		return result;
	}

	
	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     SETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------


	public void setId(int id) {
		this.id = id;
	}

	public void setToss(int toss) {
		this.toss = toss;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public void setDice1(int dice1) {
		this.dice1 = dice1;
	}

	public void setDice2(int dice2) {
		this.dice2 = dice2;
	}

	public void setResult(int result) {
		this.result = result;
	}

	
	// ------------------------------------------ TO STRING ----------------------------------------------------------
	

	@Override
	public String toString() {
		return "DiceRoll [id=" + id + ", toss=" + toss + ", game=" + game + ", player=" + player + ", dice1=" + dice1
				+ ", dice2=" + dice2 + ", result=" + result + "]";
	}
		
	
}
