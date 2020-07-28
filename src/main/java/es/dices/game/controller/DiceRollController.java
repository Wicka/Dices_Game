package es.dices.game.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.dices.game.dto.Dice;
import es.dices.game.dto.DiceRoll;
import es.dices.game.menu.MenuOptions;
import es.dices.game.service.DiceRollServiceImp;


@RestController
@RequestMapping ("/api")
public class DiceRollController {
	
	@Autowired
	DiceRollServiceImp diceRollServiceImp;
	
	//---------------------------------------------------------------------
	//----------------------------------------------  CRUD
	//---------------------------------------------------------------------
	
	
	@GetMapping("/CRUD_rolls")
	public List<DiceRoll> showDiceRoll(){		
		return diceRollServiceImp.showDiceRoll();	
	}
	
	@GetMapping ("/CRUD_rolls/{id}")
	public DiceRoll diceRollXID(@PathVariable(name="id")Integer id) {
		return diceRollServiceImp.diceRollXID(id);
	}
	
	//GET Realizo la tirada dados en la partida
	@PostMapping("/CRUD_rolls")
	public DiceRoll saveDiceRoll(@RequestBody DiceRoll diceRoll) {
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		diceRoll.setDice1(dice1.getToss());
		diceRoll.setDice2(dice2.getToss());		
		return diceRollServiceImp.saveDiceRoll(diceRoll);	
	}
	
	
	@PutMapping("/CRUD_rolls/{id}")
	public DiceRoll updateDiceRoll (@PathVariable(name="id")Integer id, @RequestBody DiceRoll diceRoll) {
		
		DiceRoll diceRoll_selected = new DiceRoll();
		
			diceRoll_selected.setDice1(diceRoll.getDice1());
			diceRoll_selected.setDice2(diceRoll.getDice2());
			diceRoll_selected.setResult(diceRoll.getResult());
			
		DiceRoll diceRoll_updated = new DiceRoll();
		
			diceRoll_updated= diceRollServiceImp.saveDiceRoll(diceRoll_selected);
			
		return diceRoll_updated;
	}
			
	@DeleteMapping ("/CRUD_rolls/{id}")
	public String deleteDiceRoll(@PathVariable(name="id")Integer id) {
		
		diceRollServiceImp.deleteDiceRoll(id);
		return "Roll dice number : "+ id + " has been deleted";
	}
	
	
	
	
	//GET Realizo una tirada de dados
	@GetMapping("/rolldices")
	public String rollDice() {
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		return "Roll Dices : \nDice 1 : " + dice1.getToss() + " \nDice 2 : " + dice2.getToss();		
	}
	


	
	
}
