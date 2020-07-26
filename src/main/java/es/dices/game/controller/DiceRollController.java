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
	
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------  CALL TO METHODS
	//--------------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------------

		
		
		//---------------------------------------------------------------------
		//----------------------------------------------  GET METHODS (VIEWS)
		//---------------------------------------------------------------------	
	
	@GetMapping("/rolls/menu")
	public String menu() {
		return MenuOptions.DiceRoll();
	}
	
	@GetMapping("/rolls")
	public List<DiceRoll> showDiceRoll(){		
		return diceRollServiceImp.showDiceRoll();	
	}
	
	@GetMapping ("/rolls/{id}")
	public DiceRoll diceRollXID(@PathVariable(name="idroll")Integer id) {
		return diceRollServiceImp.diceRollXID(id);
	}
	
			
		//----------------------------------------------------------------------
		//--------------------------------------------  POST METHOD  (NEW ROLL)
		//----------------------------------------------------------------------

	@GetMapping("/rolldice")
	public int rollDice() {
		Dice dice = new Dice();
		return dice.getToss();
	}
	
	@PostMapping("/rolls")
	public DiceRoll saveDiceRoll(@RequestBody DiceRoll diceRoll) {
		return diceRollServiceImp.saveDiceRoll(diceRoll);	
	}
	

	//----------------------------------------------------------------------
	//--------------------------------------------  PUT METHOD  (NEW ROLL)
	//----------------------------------------------------------------------

	@PutMapping("/rolls/{id}")
	public DiceRoll updateDiceRoll (@PathVariable(name="idroll")Integer id, @RequestBody DiceRoll diceRoll) {
		
		DiceRoll diceRoll_selected = new DiceRoll();
		
			diceRoll_selected.setDice1(diceRoll.getDice1());
			diceRoll_selected.setDice2(diceRoll.getDice2());
			diceRoll_selected.setResult(diceRoll.getResult());
			
		DiceRoll diceRoll_updated = new DiceRoll();
		
			diceRoll_updated= diceRollServiceImp.saveDiceRoll(diceRoll_selected);
			
		return diceRoll_updated;
	}
	
	//-------------------------------------------------------------------
	//------------------------------------  DELETE METHOD   (DELETE ROLL)
	//----------------------CASCADE IN BBDD ------------------------------
	//--------------------------------------------------------------------

	@DeleteMapping ("/rolls/{id}")
	public void deleteDiceRoll(@PathVariable(name="idroll")Integer id) {
		
		diceRollServiceImp.deleteDiceRoll(id);
	}
	
}
