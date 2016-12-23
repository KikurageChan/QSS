package servlet;

import java.io.IOException;
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
import com.kikurage.util.KikurageTime;
import model.Posting;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	KikurageTextHtml kth = KikurageTextHtml.getInstance();
	KikurageTime kt = new KikurageTime();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute("LOGINUSER");
		if(loginUser == null){
			response.sendRedirect("/qss/Login");
		}else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text;
		//qss.jspのテキストエリアのリクエストパラメータを取得します。
		request.setCharacterEncoding("UTF-8");
		text = request.getParameter("textarea");
		//index.jspのsettingフォームからColorとSizeとSaveのリクエストパラメータ取得します。
		String color = request.getParameter("color");
		String size = request.getParameter("size");
		String save = request.getParameter("save");
		
		
		//アプリケーションスコープからPostingモデルを取得します。
		ServletContext app = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<Posting> plist = (List<Posting>)app.getAttribute("PLIST");
		//textが空っぽではない時にifの中を実行します。
		if(!kth.isEmpty(text)){
			//コマンドにマッチするかチェックします。
			if(text.matches("clear-\\d*-0817")){
				int a = kth.comClearIndex(text)-1;
				//消去したい番号がリストサイズより大きい場合にはエラーメッセージを返します。
				if(a >= plist.size() || a < 0 || plist.size() == 0){
					request.setAttribute("ERRORMSG","何も入力されていません!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
					dispatcher.forward(request, response);
				}else{//指定の番号のリスト要素を消去します。
					plist.remove(a);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
					dispatcher.forward(request, response);
				}
				//コマンドにマッチするかチェックします
			}else if(kth.comClearAll(text)){
				//リストのサイズが0だった場合エラーメッセージを返します。
				if(plist.size() == 0){
					request.setAttribute("ERRORMSG","何も入力されていません!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
					dispatcher.forward(request, response);
				}else{//リストすべての要素を消去します。
					plist.clear();
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
					dispatcher.forward(request, response);
				}
			}else{
				//セッションスコープに保存されているLOGINUSERを取得します。
				HttpSession session = request.getSession();
				User loginUser = (User)session.getAttribute("LOGINUSER");
				//色情報やサイズ情報をセットします。
				loginUser.setColor(color);
				loginUser.setSize(size);
				loginUser.setSave(save);
				session.setAttribute("LOGINUSER",loginUser);
				Posting p = new Posting(loginUser.getName(),kth.htmlAll(text),kt.getnow(),loginUser.getColor(),loginUser.getSize(),loginUser.getSave());
				plist.add(0,p);
				//もしplistのPostingインスタンスの数が100以上だった場合古いものから消去していきます。
				int psize = plist.size();
				int plast = psize - 1;
				if(psize > 100){
					for(int i=plast;i>=0;i--){
						if(plist.get(i).getSave().equals("FALSE")){
							plist.remove(i);
							psize--;
							break;
						}
						if(i == 0){
							plist.remove(plast);
							psize--;
						}
					}
				}
				//アプリケーションスコープの保存をします。
				app.setAttribute("PLIST",plist);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			request.setAttribute("ERRORMSG","何も入力されていません!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/qss.jsp");
			dispatcher.forward(request, response);
		}
	}
}

