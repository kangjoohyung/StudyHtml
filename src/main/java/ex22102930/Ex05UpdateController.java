package ex22102930;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex05UpdateController implements Ex02Controller {

	@Override
	public Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("UpdateController ȣ��");
		// serviceȣ��-->dao �����Ϸ� ������ �̵�
		request.setAttribute("message", "������ �Ϸ�Ǿ����ϴ�");
		
		return new Ex03ModelAndView("SelfStudy/22102930/03_updateResult.jsp"); // �������� �ٷ� �����ؼ� �����غ�
	}
}
