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
 * 모든 사용자 요청을 처리할 진입점 Controller의 역할
 */
@WebServlet(urlPatterns = "/22110678910front" , loadOnStartup = 1)
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
		
		if(key==null || key.equals("")) {//elec를 많이써서 편의상 이렇게 빼놓음
			key="elec";
		}
		
		if(methodName==null || methodName.equals("")) {//select를 많이써서 편의상 이렇게 뺴놓음
			methodName="select";//
		}
		
		System.out.println("key = " + key +" , methodName = " + methodName);//콘솔확인용
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
			request.getRequestDispatcher("SelfStudy/22110678910_important/05error.jsp").forward(request, response);
		}
		
	}//service끝

}







