package ex22102930;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06SelectController implements Ex02Controller {

	@Override
	public Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("SelectController ȣ��");
		// serviceȣ�� --> daoȣ���ؼ� --> �˻������ ���Ӽ��� �����ϰ� ������ �̵��Ѵ�.
		
		request.setAttribute("message", "��ü�˻� ����Դϴ�");//${message} �� ���
		
		Ex03ModelAndView mv=new Ex03ModelAndView("selectResult.jsp");//
		return mv;
	}

}
