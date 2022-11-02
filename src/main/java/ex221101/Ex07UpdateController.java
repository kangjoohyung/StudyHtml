package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex07UpdateController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UpdateController 호출");
		// service호출-->dao 수정완료 결과뷰로 이동
		request.setAttribute("message", "수정이 완료되었습니다");
		
		return new Ex05ModelAndView("SelfStudy/221031/03_updateResult.jsp"); // 변수없이 바로 생성해서 리턴해봄
	}
}
