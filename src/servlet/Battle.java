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
import model.GetCharacterListLogic;

/**
 * Servlet implementation class Battle
 */
@WebServlet("/Battle")
public class Battle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Battle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetCharacterListLogic getCharacterListLogic =
				      new GetCharacterListLogic();
		 List<Character> CharacterList = getCharacterListLogic.execute();
		 request.setAttribute("CharacterList", CharacterList);


		    RequestDispatcher dispatcher = request.getRequestDispatcher(
		            "/WEB-INF/jsp/CharacterSelect.jsp");

		       dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
