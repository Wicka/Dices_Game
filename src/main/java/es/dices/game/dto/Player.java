package es.dices.game.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity 
@Table (name= "players")

public class Player {
	
	// ---------------------------------------------------------------------------------------------------
	// ---------------------------------- ATRIBUTES / FIELDS --------------------------------------------
	// ---------------------------------------------------------------------------------------------------
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrementa
	@Column(name="idplayer")	
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="points")
	private int points;
	
	@Column(name="ranking")
	private int ranking;
	
	private Integer igames;
	private Integer iwingames;
	private Integer rate;

	@JsonIgnore
	@OneToMany
	@JoinColumn(name="idgame")
	private List<Game> games;
	
	

	/**
	 * @param id   		-- tbl players 	(idplayer)
	 * @param name		-- tbl players 	(name)
	 * @param date		-- tbl players (date)
	 * @param ranking	-- tbl players (ranking)
	 */
	
	
	// -----------------------------------------------------------------------------------------------------
	// -----------------------------------------------------------------------------------------------------
	
	// ---------------------------------- BUILDERS ---------------------------------------------------------
	
	
	public Player() {
		
	}

	public Player(int id, String name, Date date, int points,int ranking, int igames, int iwingames, int rate) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.ranking = ranking;
		this.igames=igames;
		this.iwingames= iwingames;
		this.rate=rate;
	}

	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     GETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public int getRanking() {
		return ranking;
	}
	
	
		
	public int getPoints() {
		return points;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idgame")
	public List<Game> getGames() {
		return games;
	}
	public int getIgames() {
		return igames;
	}
	public int getIwingames() {
		return iwingames;
	}
	public int getRate() {
		return rate;
	}
	
	// ----------------------------------------------------------------------------------------------------------------
	// --------------------------------     SETTERS     ---------------------------------------------------------------
	// ----------------------------------------------------------------------------------------------------------------

	
	


	public void setId(int id) {
		this.id = id;
	}

	

	

	public void setName(String name) {
		this.name = name;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}
	
	
	public void setPoints(int points) {
		this.points = points;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public void setIgames(int igames) {
		this.igames = igames;
	}

	public void setIwingames(int iwingames) {
		this.iwingames = iwingames;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name=" + name + ", date=" + date + ", points=" + points + ", ranking=" + ranking
				+ ", igames=" + igames + ", iwingames=" + iwingames + ", rate=" + rate + "]";
	}
	
	// ------------------------------------------ TO STRING ----------------------------------------------------------

//	@Override
//	public String toString() {
//		return "Player [Player=" + id + ", name=" + name + ", date=" + date + ", points=" + points + ", ranking=" + ranking
//				+ ", igames=" + igames + ", iwingames=" + iwingames + ", games=" + games+ ", rate=" + rate + "]";
//	}

	

	
	


}
