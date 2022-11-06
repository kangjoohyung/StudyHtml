package ex22110234;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 게시판에 관련된 Controller
 *
 */
public class Ex08BoardController implements Ex03Controller {

	@Override
	public Ex06ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 게시물 검색
	 */
	public Ex06ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("BoardController의 list");
		
		request.setAttribute("message", "검색결과입니다");
		return new Ex06ModelAndView("22110234/06_list.jsp");
	}
	
	/**
	 * 상세보기
	 */
	public Ex06ModelAndView read(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("BoardController의 read");
		
		return new Ex06ModelAndView("22110234/07read.jsp", true);
	}
}
