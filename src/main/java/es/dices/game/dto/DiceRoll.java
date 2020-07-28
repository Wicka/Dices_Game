package es.dices.game.dto;



import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
//@IdClass(DiceRollPk.class)

@Table (name="diceroll")

//public class DiceRoll {
//public class DiceRoll implements Serializable{	
public class DiceRoll {
	// ---------------------------------------------------------------------------------------------------
	// ---------------------------------- ATRIBUTES / FIELDS --------------------------------------------
	// ---------------------------------------------------------------------------------------------------

	//@EmbeddedId
	//private DiceRollPK idpkroll;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
	@Column(name="idroll")
	private int idRoll;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "idgame")
	private List<Game> games;
	
	@JsonIgnore
	@OneToMany
	@JoinColumn(name = "idplayer")
	private List<Player> players;
	
	
	@Column(name="dice1")
	private int dice1; 
	
	@Column(name="dice2")
	private int dice2;
	
	@Column(name="result") 
	private int result;
	
	private int player;
	private int game;
	
	

	
	
	
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
	
	public DiceRoll(int idRoll, int toss, int dice1, int dice2, int result, int player, int game) {
		super();
		this.idRoll = idRoll;
		this.dice1 = dice1;
		this.dice2 = dice2;
		this.result = result;
		this.game=game;
		this.player=player;
	
	
	}

	

	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     GETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	
	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	public int getGame() {
		return game;
	}

	public void setGame(int game) {
		this.game = game;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	

	public int getIdRoll() {
		return idRoll;
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

	public List<Game> getGames() {
		return games;
	}

	
	
	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     SETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------


	public void setIdRoll(int idRoll) {
		this.idRoll = idRoll;
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

	
	public void setGames(List<Game> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "DiceRoll [idRoll=" + idRoll + ", games=" + games + ", players=" + players + ", dice1=" + dice1
				+ ", dice2=" + dice2 + ", result=" + result + ", player=" + player + ", game=" + game + "]";
	}

	
	
	// ------------------------------------------ TO STRING ----------------------------------------------------------
	



		
	
}
