package ex22102930;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex07DeleteController implements Ex02Controller {

	@Override
	public Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("DeleteController호출");
		// service->dao호출해서 삭제완료된 후 이동
		//이번엔 forward방식으로, 메인화면으로 이동시켜봄
		Ex03ModelAndView mv=new Ex03ModelAndView();
		mv.setViewName("SelfStudy/22102930/01_index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
