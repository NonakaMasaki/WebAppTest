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
import model.PostCharacterLogic;

@WebServlet("/CharacterCreate")
public class CharacterCreate extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {


    GetCharacterListLogic getCharacterListLogic =
        new GetCharacterListLogic();
    List<Character> characterList = getCharacterListLogic.execute();
    request.setAttribute("characterList", characterList);


    RequestDispatcher dispatcher =
    		request.getRequestDispatcher("/WEB-INF/jsp/CharacterCreate.jsp");
    dispatcher.forward(request, response);


  }

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");

//リクエストスコープ内の確認
    System.out.println(name);


    if (name != null && name.length() != 0) {

    				//
      Character character = new Character(name,Integer.parseInt(request.getParameter("hp")),Integer.parseInt(request.getParameter("str")));
      PostCharacterLogic postCharacterLogic = new PostCharacterLogic();
      postCharacterLogic.execute(character);


    } else {

      request.setAttribute("errorMsg",
          "error");
    }


    // データベースのキャラクターリストをリクエストスコープにセットするやつ
   // GetCharacterListLogic getCharacterListLogic =
  //      new GetCharacterListLogic();
   // List<Character> CharacterList = getCharacterListLogic.execute();

   // request.setAttribute("CharacterList", CharacterList);
//

    RequestDispatcher dispatcher = request.getRequestDispatcher(
        "/");
   dispatcher.forward(request, response);
  }
}