package ex221029;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Ex02Controller {
	//�޼ҵ��̸��� ���� ���ϱ�, �μ��� request, response
	Ex03ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)throws ServletException, IOException; 
}
