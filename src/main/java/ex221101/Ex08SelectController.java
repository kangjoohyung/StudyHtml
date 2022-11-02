package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex08SelectController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("SelectController 호출");
		// service호출 --> dao호출해서 --> 검색결과를 영속성에 저장하고 결과뷰로 이동한다.
		
		request.setAttribute("message", "전체검색 결과입니다");//${message} 뷰 사용
		
		Ex05ModelAndView mv=new Ex05ModelAndView("SelfStudy/221031/02_selectResult.jsp");//
		return mv;
	}

}
