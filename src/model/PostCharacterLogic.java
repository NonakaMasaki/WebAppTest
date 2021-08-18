package model;

import dao.CharacterDAO;

public class PostCharacterLogic {

	public void execute(Character character) {

		CharacterDAO dao = new CharacterDAO();
		dao.create(character);


	}





}
