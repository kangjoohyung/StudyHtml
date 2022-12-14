package ex221016;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/logout") //다른 옵션이 없을때 url-pattern이 기본속성이다.
@WebServlet(urlPatterns="/logout",loadOnStartup=1)
public class Ex09LogoutServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("logoutServlet........");
		//모든 세션의 정보 삭제
		HttpSession session = req.getSession();
		session.invalidate();
		
		PrintWriter out=resp.getWriter();
		out.println("<script>");
		out.println("top.location.href='index.jsp';");
		out.println("</script>");
		
	}
	
}










