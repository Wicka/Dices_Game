package es.dices.game.dto;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@JoinColumn(name="player2")	
	private Player player2;
	
	@ManyToOne
	@JoinColumn(name="winner")	
	private Player winner;
	
	/**
	 * @param id   		-- tbl games 	(idgame)
	 * @param date		-- tbl games 	(date)
	 * @param winner	-- tbl games 	(winner)
	 */
	
	
	// -----------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------
		
	// ---------------------------------- BUILDERS ---------------------------------------------------------
		
		
	public Game() {
		
	}

	public Game(int id, Date date, Player winner, Player player1, Player player2) {
		super();
		this.id = id;
		this.date = date;
		this.winner = winner;
		this.player1=player1;
		this.player2=player2;
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

	public Player getWinner() {
		return winner;
	}
	
	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
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

	public void setWinner(Player winner) {
		this.winner = winner;
	}
	
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	
	// ------------------------------------------ TO STRING ----------------------------------------------------------
	
	@Override
	public String toString() {
		return "Game [id=" + id + ", date=" + date + ", player1=" + player1 + ", player2=" + player2 + ", winner="
				+ winner + "]";
	}

	
		

	
}
