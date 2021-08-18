package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Character;
import model.CharacterDeleteLogic;
import model.GetCharacterListLogic;

/**
 * Servlet implementation class CharacterList
 */
@WebServlet("/CharacterList")
public class CharacterList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException, IOException {

		 GetCharacterListLogic getCharacterListLogic =
		       new GetCharacterListLogic();
		  List<Character> CharacterList = getCharacterListLogic.execute();

		 request.setAttribute("CharacterList", CharacterList);

		    RequestDispatcher dispatcher = request.getRequestDispatcher(
		            "/WEB-INF/jsp/CharacterList.jsp");

		       dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int id = Integer.parseInt(request.getParameter("id"));

		//リクエストスコープ内の確認
	    System.out.println(id);


		CharacterDeleteLogic CharacterDelete = new CharacterDeleteLogic();
		CharacterDelete.delete(id);




		 GetCharacterListLogic getCharacterListLogic =
		       new GetCharacterListLogic();
		  List<Character> CharacterList = getCharacterListLogic.execute();

		 request.setAttribute("CharacterList", CharacterList);

		    RequestDispatcher dispatcher = request.getRequestDispatcher(
		            "/WEB-INF/jsp/CharacterList.jsp");

		       dispatcher.forward(request, response);





	}

}
