package ex22110234;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ǰ���� Controller
 *
 */
public class Ex07GoodsController implements Ex03Controller {

	@Override
	public Ex06ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��ǰ��� ��������
	 */
	public Ex06ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController�� list");
		
		request.setAttribute("goodsList",Arrays.asList("���","����","����","�ٳ���"));
		
		return new Ex06ModelAndView("22110234goods/04_list.jsp"); //forward�̵�
	}
	
	/**
	 * ��ǰ���
	 */
	public Ex06ModelAndView insert(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController�� insert ȣ��");
		
		Ex06ModelAndView mv=new Ex06ModelAndView();
		mv.setViewName("22110234goods/05_registerOk.jsp");
		mv.setRedirect(true); //redirect��� ����
		
		return mv;
	}
}
