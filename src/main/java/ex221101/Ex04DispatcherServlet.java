package ex221101;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��� ����� ��û�� ó���� ������ Controller�� ����
 * �����ʱ�ȭ�ϴ°��� ���� : loadOnStartup=1 (�����ö󰥶� �̸� ������ֵ���) �����߰�
 */
@WebServlet(urlPatterns="/front", loadOnStartup=1)
public class Ex04DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Controller> map;

	@Override
	public void init() throws ServletException {
		ServletContext application=super.getServletContext();
		map=(Map<String, Controller>)application.getAttribute("map");
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("�ǳ�"); //index.jsp���� ������ �Ǵ��� �ܼ�������� Ȯ��
		String key=request.getParameter("key");
		System.out.println("key="+key); //�Ѿ���� Ű�� Ȯ�ο�-�ܼ� ���
		Controller con=map.get(key);
		/*
		//if������ ������ ��� ����
		if(key.equals("select")) {
			con=new SelectController();
		}else if(key.equals("update")) {
			con=new UpdateController();
		}else if(key.equals("delete")) {
			con=new DeleteController();
		}else if(key.equals("insert")) {
			con=new InsertController();
		}*/
		//////////////////////////////
		//ȣ��
		Ex05ModelAndView mv=con.handleRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}//service��

}