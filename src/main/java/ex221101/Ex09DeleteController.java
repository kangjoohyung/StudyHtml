package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex09DeleteController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("DeleteControllerȣ��");
		// service->daoȣ���ؼ� �����Ϸ�� �� �̵�
		//�̹��� forward�������, ����ȭ������ �̵����Ѻ�
		Ex05ModelAndView mv=new Ex05ModelAndView();
		mv.setViewName("SelfStudy/221031/01_index.jsp");
		mv.setRedirect(true);
		
		return mv;
	}

}
