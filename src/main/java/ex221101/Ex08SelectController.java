package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex08SelectController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("SelectController ȣ��");
		// serviceȣ�� --> daoȣ���ؼ� --> �˻������ ���Ӽ��� �����ϰ� ������ �̵��Ѵ�.
		
		request.setAttribute("message", "��ü�˻� ����Դϴ�");//${message} �� ���
		
		Ex05ModelAndView mv=new Ex05ModelAndView("SelfStudy/221031/02_selectResult.jsp");//
		return mv;
	}

}
