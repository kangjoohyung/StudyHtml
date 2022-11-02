package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06InsertController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("InsertController 호출");//확인용 콘솔송출
		
		// service호출-->dao호출-->등록이 완료되면 redirect방식으로 전체검색으로 이동
		Ex05ModelAndView mv=new Ex05ModelAndView("221101front?key=221101select", true);
		
		return mv;
	}

}
