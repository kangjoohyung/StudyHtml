package ex22110234;

import java.io.IOException;
import java.lang.reflect.Method;
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
@WebServlet(urlPatterns="/22110234front", loadOnStartup=1)
public class Ex04DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Ex03Controller> map;
	private Map<String, Class<?>> clzMap;

	@Override
	public void init() throws ServletException {
		ServletContext application=super.getServletContext();
		map=(Map<String, Ex03Controller>)application.getAttribute("map");
		clzMap=(Map<String, Class<?>>)application.getAttribute("clzMap");
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("�ǳ�"); //index.jsp���� ������ �Ǵ��� �ܼ�������� Ȯ��
		String key=request.getParameter("key");//user,board,goods
		String methodName=request.getParameter("methodName");
		
		System.out.println("key="+key+",methodName="+methodName); //�Ѿ���� �� Ȯ�ο�-�ܼ� ���
		try {
		Ex03Controller con=map.get(key);
		Class<?> clz=clzMap.get(key);
		Method method=clz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class); //Method�� reflect
		
		Ex06ModelAndView mv=(Ex06ModelAndView) method.invoke(con, request, response);
		
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//service��

}