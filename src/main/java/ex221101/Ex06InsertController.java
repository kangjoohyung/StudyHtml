package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex06InsertController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("InsertController ȣ��");//Ȯ�ο� �ּܼ���
		
		// serviceȣ��-->daoȣ��-->����� �Ϸ�Ǹ� redirect������� ��ü�˻����� �̵�
		Ex05ModelAndView mv=new Ex05ModelAndView("221101front?key=221101select", true);
		
		return mv;
	}

}
