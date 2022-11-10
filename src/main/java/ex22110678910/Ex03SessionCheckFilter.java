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
 * UserSession üũ�� ����
 * ��� key : elec
 * 
 */
//@WebFilter("/front")
public class Ex03SessionCheckFilter implements Filter {
	public void destroy() {}

    public Ex03SessionCheckFilter() {
    	System.out.println("SessionCheckFilter ������...");
    }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("SessionCheck....");
		//����ó�� -> �������θ� üũ�Ѵ�.
		String key = request.getParameter("key");
		if(key==null || key.equals("22110678910elec")) {//�̰��� �����ϴ� key �ֱ�-Dispatcher������ �Էµ� �״��
			
			//������ ����ڸ� �ض�...
			HttpServletRequest req = (HttpServletRequest)request;
			HttpSession session = req.getSession();
			if(session.getAttribute("loginUser") ==null) {
				req.setAttribute("errorMsg", "�α����ϰ� �̿����ּ���.^^");
				req.getRequestDispatcher("SelfStudy/22110678910_important/05error.jsp").forward(request, response);
				return ;//�Լ��� ����������
			}
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}









