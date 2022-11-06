package ex22110234;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 회원관리에 관한 Controller
 */
public class Ex05UserController implements Ex03Controller {

	@Override
	public Ex06ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		
		return null;
	}
	/**
	 * 로그인
	 */
	public Ex06ModelAndView login(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UserController의 login");
		// service->dao호출
		
		//로그인 성공하면 세션에 정보 저장 
		//session은 redirect로가면됨(브라우져열려있는동안 유지되니까)
		HttpSession session=request.getSession();
		session.setAttribute("sessionMessage", "로그인된 정보입니다");
		
		return new Ex06ModelAndView("22110234/02_login.jsp",true);//redirect방식으로 이동한다.
	}
	
	/**
	 * 회원정보수정
	 */
	public Ex06ModelAndView update(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UserController의 update");
		// 서비스호출->dao
		//request저장이니까 forward이동
		request.setAttribute("message", "수정완료되었습니다");
		
		return new Ex06ModelAndView("22110234/03_update.jsp"); //forward방식으로 이동하자.
	}
	
	/**
	 * 가입하기
	 */
	
	/**
	 * 로그아웃
	 */

}
