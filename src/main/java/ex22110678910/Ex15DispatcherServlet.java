package ex22110678910;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ��� ����� ��û�� ó���� ������ Controller�� ����
 */
@WebServlet(urlPatterns = "/front" , loadOnStartup = 1)
public class Ex15DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Ex16Controller> map;
	private Map<String, Class<?>> clzMap;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = super.getServletContext();
		map = (Map<String, Ex16Controller>)application.getAttribute("map");
		clzMap = (Map<String, Class<?>>)application.getAttribute("clzMap");
	}
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String key = request.getParameter("key"); //
		String methodName = request.getParameter("methodName");
		
		if(key==null || key.equals("")) {//elec�� ���̽Ἥ ���ǻ� �̷��� ������
			key="elec";
		}
		
		if(methodName==null || methodName.equals("")) {//select�� ���̽Ἥ ���ǻ� �̷��� ������
			methodName="select";//
		}
		
		System.out.println("key = " + key +" , methodName = " + methodName);//�ܼ�Ȯ�ο�
		try {
			Ex16Controller con = map.get(key);
			Class<?> clz = clzMap.get(key);
			Method method = 
					   clz.getMethod(methodName, HttpServletRequest.class , HttpServletResponse.class);
			
			    Ex17ModelAndView mv = (Ex17ModelAndView)method.invoke(con, request, response);
			
			/////////////////////////////////////////////////////////
			if(mv.isRedirect()) {
				response.sendRedirect( mv.getViewName() );
			}else {
				request.getRequestDispatcher(mv.getViewName()).forward(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getCause().getMessage());
			request.getRequestDispatcher("error/error.jsp").forward(request, response);
		}
		
	}//service��

}






