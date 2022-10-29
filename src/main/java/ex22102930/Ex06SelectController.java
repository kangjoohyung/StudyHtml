package ex22102930;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06SelectController implements Ex02Controller {

	@Override
	public Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("SelectController 호출");
		// service호출 --> dao호출해서 --> 검색결과를 영속성에 저장하고 결과뷰로 이동한다.
		
		request.setAttribute("message", "전체검색 결과입니다");//${message} 뷰 사용
		
		Ex03ModelAndView mv=new Ex03ModelAndView("selectResult.jsp");//
		return mv;
	}

}
