package ex22110678910;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Ex18UserController implements Ex16Controller {
	
	private Ex13UserService userService = new Ex13UserServiceImpl();

	@Override
	public Ex17ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �α��� ���
	 * */
	public Ex17ModelAndView login(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    
		 //�ΰ��� ���۵Ǵ� ���� �޴´�.
		String userId =request.getParameter("userId");
		String pwd =request.getParameter("pwd");
		
		//���� ȣ�� 
		Ex08UserDTO dbDTO = userService.loginCheck( new Ex08UserDTO(userId, pwd) );
		
		//�α��μ����ϸ� ���ǿ� ������ ���� - ${loginUser} / ${loginName}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", dbDTO);
		session.setAttribute("loginName", dbDTO.getName());

		//index.jsp�̵� - redirect���
		
		return new Ex17ModelAndView("SelfStudy/22110678910_important/01index.jsp", true);
	}

	/**
	 * �α׾ƿ�
	 * */
	public Ex17ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//��� ������������ �����Ѵ�.
		request.getSession().invalidate();
		
		return new Ex17ModelAndView("SelfStudy/22110678910_important/01index.jsp", true);
		
		
	}
	
}






