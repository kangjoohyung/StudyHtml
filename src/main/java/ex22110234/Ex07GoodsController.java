package ex22110234;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 상품관련 Controller
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
	 * 상품목록 가져오기
	 */
	public Ex06ModelAndView list(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController의 list");
		
		request.setAttribute("goodsList",Arrays.asList("사과","딸기","포도","바나나"));
		
		return new Ex06ModelAndView("22110234goods/04_list.jsp"); //forward이동
	}
	
	/**
	 * 상품등록
	 */
	public Ex06ModelAndView insert(HttpServletRequest request, HttpServletResponse reponse)
			throws ServletException, IOException {
		System.out.println("GoodsController의 insert 호출");
		
		Ex06ModelAndView mv=new Ex06ModelAndView();
		mv.setViewName("22110234goods/05_registerOk.jsp");
		mv.setRedirect(true); //redirect방식 전송
		
		return mv;
	}
}
