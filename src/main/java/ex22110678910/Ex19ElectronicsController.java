package ex22110678910;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


public class Ex19ElectronicsController implements Ex16Controller {
	
	private Ex14ElectronicsService elecService = new Ex14ElectronicsServiceImpl();

	@Override
	public Ex17ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 *  ��ü�˻�
	 * */
	public Ex17ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		  String pageNo = request.getParameter("pageNo");
		  if(pageNo==null || pageNo.equals("")) {
			  pageNo="1";
		  }
		
		//List<Ex09Electronics> list = elecService.selectAll();
		
		  List<Ex09Electronics> list = elecService.selectAll( Integer.parseInt(pageNo) );
		  
		request.setAttribute("list", list);//�信�� ${list}
		request.setAttribute("pageNo", pageNo); //�信�� ${pageNo}
		
		return new Ex17ModelAndView("SelfStudy/22110678910_important/06list.jsp"); //forward������� �̵�
	}
	
	
	/**
	 * ����ϱ�
	 * */
	public Ex17ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//������ enctype="multipart/form-data" �����Ǿ� �ֱ⶧���� request�ƴ� MultipartRequest�� ó���Ѵ�. - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save"); //
		int maxSize=1024*1024*100; //100M
		String encoding="UTF-8";

		MultipartRequest m = 
		 new MultipartRequest(request,saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//���۵� ������ �ޱ� 
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		Ex09Electronics elec = 
			new Ex09Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
		
		//����, ����÷�ΰ� �Ǿ��ٸ�....
		if(m.getFilesystemName("file") != null) {
			//�����̸�����
			elec.setFname(m.getFilesystemName("file"));
			
			//����ũ������ -> ������Ʈ������ ���µ�
			long size = m.getFile("file").length();
			elec.setFsize( (int)size );
		}
		
		elecService.insert(elec);

	   return new Ex17ModelAndView("22110678910front", true);//?key=elec&methodName=select �⺻���� �����ȴ�.	
	}
	
	/**
	 * �󼼺��� 
	 * */

	public Ex17ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 String modelNum = request.getParameter("modelNum");
		 boolean state = request.getParameter("flag")==null ? true : false;
		 
		String pageNo =  request.getParameter("pageNo");
		 
		 //�ι�° �μ� boolean ��ȸ�� �������θ��Ǵ��� �μ�(true�̸�, false�̸� ��������)
		Ex09Electronics electronics = elecService.selectByModelnum(modelNum, state);
		request.setAttribute("elec", electronics);
		request.setAttribute("pageNo", pageNo);
		
		return new Ex17ModelAndView("SelfStudy/22110678910_important/07read.jsp"); //forward��� 
	}
	
	
	/**
	 *  ������
	 * */
	public Ex17ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum  = request.getParameter("modelNum");
		String pageNo  = request.getParameter("pageNo");
		
		Ex09Electronics elec = elecService.selectByModelnum(modelNum, false);
		request.setAttribute("elec", elec);
		request.setAttribute("pageNo", pageNo);
		
		return new Ex17ModelAndView("elec/update.jsp");//forward���
	}
	
	/**
	 * �����Ϸ�
	 * */
	public Ex17ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   //������ ���� 5�� �ޱ�
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		String pageNo = request.getParameter("pageNo");
		
		elecService.update( new Ex09Electronics(modelNum, modelName, Integer.parseInt(price), 
				description, password) );
		
		//������ �Ϸᰡ ����....
		Ex17ModelAndView mv = new Ex17ModelAndView();
		mv.setViewName("22110678910front?key=elec&methodName=selectByModelNum&modelNum="+modelNum+"&flag=1&pageNo="+pageNo);
	    mv.setRedirect(true);
		return mv;
	}
	
	/**
	 * ����
	 * 
	 * */
	public Ex17ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//���۵Ǵ� 2���ޱ�
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		
		//÷�ε� ������ �����ϴ� ����� ������ �Ǿ����� �������� ���ϵ� �����Ѵ�. - �� ����� service�Ѵ�.
		String saveDir = request.getServletContext().getRealPath("/save");
		
		elecService.delete(modelNum, password , saveDir);
		
		return new Ex17ModelAndView("22110678910front", true);
	}
	
}//classEnd

