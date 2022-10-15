package ex221015;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex02InitParamServlet extends HttpServlet {
	private String ex221015dbId, ex221015dbPwd , ex221015message, ex221015driverName;
	@Override
	public void init() throws ServletException {
       ServletContext application = super.getServletContext();
		ex221015message = application.getInitParameter("ex221015message");
		ex221015driverName = application.getInitParameter("ex221015driverName");
		
		ex221015dbId = super.getInitParameter("ex221015dbId");
		ex221015dbPwd = getInitParameter("ex221015dbPwd");
		
		System.out.println("ex221015dbId = " + ex221015dbId +" , ex221015dbPwd = " + ex221015dbPwd);
		System.out.println("ex221015message = " + ex221015message +" , ex221015driverName = " + ex221015driverName);
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//
		System.out.println("Service call ==>  ex221015dbId = " + ex221015dbId +" , ex221015dbPwd = " + ex221015dbPwd);
		System.out.println("Service call ==>  ex221015message = " + ex221015message +" , ex221015driverName = " + ex221015driverName);
	}

}




