package ex221101;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex07UpdateController implements Ex03Controller {

	@Override
	public Ex05ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UpdateController ȣ��");
		// serviceȣ��-->dao �����Ϸ� ������ �̵�
		request.setAttribute("message", "������ �Ϸ�Ǿ����ϴ�");
		
		return new Ex05ModelAndView("SelfStudy/221031/03_updateResult.jsp"); // �������� �ٷ� �����ؼ� �����غ�
	}
}
