package ex22102930;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex07DeleteController implements Ex02Controller {

	@Override
	public Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("DeleteControllerȣ��");
		// service->daoȣ���ؼ� �����Ϸ�� �� �̵�
		//�̹��� forward�������, ����ȭ������ �̵����Ѻ�
		Ex03ModelAndView mv=new Ex03ModelAndView();
		mv.setViewName("SelfStudy/22102930/01_index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
