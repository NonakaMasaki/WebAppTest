package model;

import java.util.List;

import dao.CharacterDAO;

public class GetCharacterListLogic {
	public List<Character>execute(){
		CharacterDAO dao = new CharacterDAO();
		List<Character>CharacterList = dao.findAll();
		return CharacterList ;

	}





}
