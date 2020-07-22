package es.dices.game.dto;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="winner")
	private int winner;
	
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

	public Game(int id, Date date, int winner) {
		super();
		this.id = id;
		this.date = date;
		this.winner = winner;
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

	public int getWinner() {
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

	public void setWinner(int winner) {
		this.winner = winner;
	}
	
	
	// ------------------------------------------ TO STRING ----------------------------------------------------------
		
	@Override
	public String toString() {
		return "Game [id=" + id + ", date=" + date + ", winner=" + winner + "]";
	}
	
}
