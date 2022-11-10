package ex22110678910;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * UserSession 체크용 필터
 * 사용 key : elec
 * 
 */
//@WebFilter("/front")
public class Ex03SessionCheckFilter implements Filter {
	public void destroy() {}

    public Ex03SessionCheckFilter() {
    	System.out.println("SessionCheckFilter 생성됨...");
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SessionCheck....");
		//사전처리 -> 인증여부를 체크한다.
		String key = request.getParameter("key");
		if(key==null || key.equals("22110678910elec")) {//이곳에 진입하는 key 넣기-Dispatcher서블릿에 입력된 그대로
			
			//인증된 사용자만 해라...
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			if(session.getAttribute("loginUser") ==null) {
				req.setAttribute("errorMsg", "로그인하고 이용해주세요.^^");
				req.getRequestDispatcher("SelfStudy/22110678910_important/05error.jsp").forward(request, response);
				return ;//함수를 빠져나가라
			}
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}









