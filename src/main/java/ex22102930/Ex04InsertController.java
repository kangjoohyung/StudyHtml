package ex22102930;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04InsertController implements Ex02Controller {

	@Override
	public Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("InsertController ȣ��");//Ȯ�ο� �ּܼ���
		
		// serviceȣ��-->daoȣ��-->����� �Ϸ�Ǹ� redirect������� ��ü�˻����� �̵�
		Ex03ModelAndView mv=new Ex03ModelAndView("22102930front?key=select", true);
		
		return mv;
	}

}
