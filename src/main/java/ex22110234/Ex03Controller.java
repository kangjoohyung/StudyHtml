package ex22110234;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Ex03Controller {
	//�޼ҵ��̸��� ���� ���ϱ�, �μ��� request, response
	Ex06ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)throws ServletException, IOException; 
}
