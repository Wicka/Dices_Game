package es.dices.game.dto;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table (name="games")

public class Game {
	
	// ---------------------------------------------------------------------------------------------------
	// ---------------------------------- ATRIBUTES / FIELDS --------------------------------------------
	// ---------------------------------------------------------------------------------------------------

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
	@Column(name="idgame")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	
	@ManyToOne
	@JoinColumn(name="player1")	
	private Player player1;
	
	@ManyToOne
	@JoinColumn(name="roll1")	
	private DiceRoll roll_1;
	
	@ManyToOne
	@JoinColumn(name="player2")	
	private Player player2;
	
	@ManyToOne
	@JoinColumn(name="roll2")	
	private DiceRoll roll_2;
	
	@ManyToOne
	@JoinColumn(name="winner")	
	private Player winner;
	
	
	
	// -----------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------
		
	// ---------------------------------- BUILDERS ---------------------------------------------------------
		
		
	public Game() {
		
	}

	public Game(int id, Date date, Player winner, Player player1, DiceRoll roll_1, Player player2, DiceRoll roll_2) {
		super();
		this.id = id;
		this.date = date;
		this.winner = winner;
		this.player1=player1;
		this.roll_1=roll_1;
		this.player2=player2;
		this.roll_2=roll_2;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     GETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------


	

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}


	
	public Player getPlayer1() {
		return player1;
	}
	
	public DiceRoll getRoll_1() {
		return roll_1;
	}
	
	public Player getPlayer2() {
		return player2;
	}
	
	public DiceRoll getRoll_2() {
		return roll_2;
	}
	public Player getWinner() {
		return winner;
	}


	

	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     SETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------


	

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setRoll1(DiceRoll roll_1) {
		this.roll_1 = roll_1;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}


	public void setRoll2(DiceRoll roll_2) {
		this.roll_2 = roll_2;
	}
	
	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	// ------------------------------------------ TO STRING ----------------------------------------------------------


	@Override
	public String toString() {
		return "Game [Geme id=" + id + ", date=" + date + ", player1=" + player1 + ", roll1=" + roll_1 + ", player2="
				+ player2 + ", roll2=" + roll_2 + ", winner=" + winner + "]";
	}
		

	
}
