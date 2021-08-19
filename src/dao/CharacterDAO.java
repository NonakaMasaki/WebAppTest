package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Character;

public class CharacterDAO {
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/test";
	private final String DB_USER ="sa";
	private final String DB_PASS ="";


	public List<Character>findAll(){
		List<Character>characterList = new ArrayList<>();

		try(Connection conn= DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql =

					"SELECT * FROM CHARACTER";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();

			while(rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				int hp = rs.getInt("HP");
				int str = rs.getInt("STR");
				//
				Character character = new Character(id,name,hp,str);
				characterList.add(character);
			}


		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return characterList;
		}


	public boolean create(Character character) {

		try(Connection conn= DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql =
					//
					"INSERT INTO CHARACTER(NAME,HP,STR) VALUES(?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1,character.getName());
			pStmt.setInt(2,character.getHp());
			pStmt.setInt(3,character.getStr());

			int result = pStmt.executeUpdate();
			if(result !=1) {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return false;}

	return true;

}


	public void delete(int id) {
		try(Connection conn= DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//リクエストスコープ内の確認
		  //  System.out.println(id);
			String sql =
					"DELETE FROM CHARACTER WHERE ID=VALUES(?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setInt(1,id);

			int result = pStmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();

}


	}}

