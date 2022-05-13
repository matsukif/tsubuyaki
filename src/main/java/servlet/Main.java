package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
// import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Mutter;
import model.User;
import model.PostMutterLogic;
import model.GetMutterLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		/*
 		// つぶやきリストをアプリケーションスコープから取得
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		*/
		
 		//つぶやきをmutter tableから取得しリクエストスコープに保存
 		GetMutterLogic getMutterLogic = new GetMutterLogic();
 		List<Mutter> mutterList = (List<Mutter>) getMutterLogic.excute();
 		request.setAttribute("mutterList",mutterList);
 		
 		/*
		//取得できなあった場合は、つぶやきリストを新規作成してアプリケーションに保存
		if(mutterList == null) {
			mutterList = new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		*/
 		
		
		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		if(loginUser == null) {
			//ログインしていない場合はリダイレクト
			response.sendRedirect("/tsubuyaki/");
		} else {
			//ログイン済みの場合フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		/* //アプリケーションスコープからmutterListを取得る。
		ServletContext application = this.getServletContext();
		List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
		*/
		
		//追加するテキストの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
						
		//テキストが空白の場合はメイン画面へ戻す
		if(text == null || text.length() == 0) {
			request.setAttribute("errorMsg","つぶやきが設定されていません");
		
		} else { //テキストに値がある場合
		
			//名前をセッションスコープから取得
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
		
			//追加するつぶやきクラスを作成
			Mutter mutter = new Mutter(loginUser.getName(),text);
			
			//つぶやきをMutter tableへ登録する
			PostMutterLogic postMutterLogic = new PostMutterLogic();
			postMutterLogic.excute(mutter);

			/*
			//MutterListをアプリケーソンスコープへ保存
			application.setAttribute("mutterList",mutterList);
			*/
		}
		
		//つぶやきリストをリクエストスコープへ追加
		GetMutterLogic getMutterLogic =  new GetMutterLogic();
		request.setAttribute("mutterList", getMutterLogic.excute());
		
	
		//メイン画面へフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
