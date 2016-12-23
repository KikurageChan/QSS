package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kikurage.util.KikurageTextHtml;

import model.LoginLogic;
import model.Posting;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("LOGINUSER");
		if(loginUser == null){
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("/qss/Main");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		KikurageTextHtml kth = KikurageTextHtml.getInstance();

		//index.jspのフォームから名前とパスのリクエストパラメータ取得します。
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String thema = request.getParameter("thema");

		if(kth.nameCheck(name)){	
			//特殊木耳文字を通常に戻します。
			name = kth.toKikurage(name);
			//以下は正確な名前だった場合の処理です。
			User user = new User(name,pass,thema);
			LoginLogic logic = new LoginLogic();
			//パスワードをチェックします。
			if(logic.ismember(user)){
				HttpSession session = request.getSession();
				session.setAttribute("LOGINUSER",user);
				ServletContext app = this.getServletContext();
				@SuppressWarnings("unchecked")
				List<Posting> plist = (List<Posting>)app.getAttribute("PLIST");
				//PLISTというアプリケーションスコープを作成しています。
				if(plist == null){
					plist = new ArrayList<Posting>();
					app.setAttribute("PLIST",plist);
				}
				response.sendRedirect("/qss/Main");
			}
			else{
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/failure.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/failure.jsp");
			dispatcher.forward(request, response);
		}
	}


}
