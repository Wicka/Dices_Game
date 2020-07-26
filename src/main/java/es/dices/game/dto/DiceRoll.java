package es.dices.game.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="diceroll")
public class DiceRoll {
	
	
	// ---------------------------------------------------------------------------------------------------
	// ---------------------------------- ATRIBUTES / FIELDS --------------------------------------------
	// ---------------------------------------------------------------------------------------------------

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
	@Column(name="idroll")
	private int idroll;
	
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idgame")	
	private Game game;
	
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idplayer")
	private  Player player;
	
	@Column(name="dice1")
	private int dice1;
	
	@Column(name="dice2")
	private int dice2;
	
	@Column(name="result")
	private int result;

	
	
	/**
	 * @param id   			-- tbl diceroll 	(idroll)
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
	
	public DiceRoll(int idroll, int toss, Game game, Player player, int dice1, int dice2, int result) {
		super();
		this.idroll = idroll;
		this.game = game;
		this.player = player;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.result = result;
	}

	

	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     GETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	public int getIdRoll() {
		return idroll;
	}

	

	public Game getGame() {
		return game;
	}

	public Player getPlayer() {
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


	public void setIdRoll(int idroll) {
		this.idroll = idroll;
	}

	

	public void setGame(Game game) {
		this.game = game;
	}

	public void setPlayer(Player player) {
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
		return "DiceRoll [idroll=" + idroll + ",  game=" + game + ", player=" + player + ", dice1=" + dice1
				+ ", dice2=" + dice2 + ", result=" + result + "]";
	}
		
	
}
