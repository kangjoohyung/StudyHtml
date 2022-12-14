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
 * 모든 사용자 요청을 처리할 진입점 Controller의 역할
 * 사전초기화하는것이 좋음 : loadOnStartup=1 (서버올라갈때 미리 만들수있도록) 설정추가
 */
@WebServlet(urlPatterns="/221101front", loadOnStartup=1)
public class Ex04DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Ex03Controller> map;

	@Override
	public void init() throws ServletException {
		ServletContext application=super.getServletContext();
		map=(Map<String, Ex03Controller>)application.getAttribute("map");
	}



	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("되나"); //index.jsp에서 연결이 되는지 콘솔출력으로 확인
		String key=request.getParameter("key");
		System.out.println("key="+key); //넘어오는 키값 확인용-콘솔 출력
		Ex03Controller con=map.get(key);
		/*
		//if문으로 각각의 기능 설정
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
		//호출
		Ex05ModelAndView mv=con.handleRequest(request, response);
		if(mv.isRedirect()) {
			response.sendRedirect(mv.getViewName());
		}else {
			request.getRequestDispatcher(mv.getViewName()).forward(request, response);
		}
	}//service끝

}
