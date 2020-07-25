package es.dices.game.service;

public class MenuOptions {	
	
	
	// ------------------------------------------------------------
	// ------------------------MENU CONTROLLERS
	
	
	public static String Games() {		
		
		return "GET \n"+
				"---     /games...............(Show all games) \n" + 
				"---     /games/{id}..........(Show game by Id) \n" +
				"POST \n"+
				"---     /games...............(Create a new Game) \n" +
				"PUT \n"+
				"---     /games/result........(Update field winner) \n" +
				"DELETE \n"+
				"---     /games/{id}..........(Delete game by ID) \n";
		
	}
	
	public static String players() {	
		
		return "GET \n"+
				"---     /players.............(Show all players) \n" + 
				"---     /players/{id}........(Show player by Id) \n" +
				"POST \n"+
				"---     /players.............(Create a new player) \n" +
				"PUT \n"+
				"---     /players/result......(Update fields player Name and Ranking) \n" +
				"DELETE \n"+
				"---     /players/{id}........(Delete player by ID) \n";
	}


}
