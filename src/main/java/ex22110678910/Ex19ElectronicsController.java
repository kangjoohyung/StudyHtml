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
	 *  전체검색
	 * */
	public Ex17ModelAndView select(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		  String pageNo = request.getParameter("pageNo");
		  if(pageNo==null || pageNo.equals("")) {
			  pageNo="1";
		  }
		
		//List<Ex09Electronics> list = elecService.selectAll();
		
		  List<Ex09Electronics> list = elecService.selectAll( Integer.parseInt(pageNo) );
		  
		request.setAttribute("list", list);//뷰에서 ${list}
		request.setAttribute("pageNo", pageNo); //뷰에서 ${pageNo}
		
		return new Ex17ModelAndView("SelfStudy/22110678910_important/06list.jsp"); //forward방식으로 이동
	}
	
	
	/**
	 * 등록하기
	 * */
	public Ex17ModelAndView insert(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//폼에서 enctype="multipart/form-data" 설정되어 있기때문에 request아닌 MultipartRequest로 처리한다. - cos.jar
		String saveDir = request.getServletContext().getRealPath("/save"); //
		int maxSize=1024*1024*100; //100M
		String encoding="UTF-8";

		MultipartRequest m = 
		 new MultipartRequest(request,saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		//전송된 데이터 받기 
		String modelNum = m.getParameter("model_num");
		String modelName = m.getParameter("model_name");
		String price = m.getParameter("price");
		String description = m.getParameter("description");
		String password = m.getParameter("password");
		
		Ex09Electronics elec = 
			new Ex09Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
		
		//만약, 파일첨부가 되었다면....
		if(m.getFilesystemName("file") != null) {
			//파일이름저장
			elec.setFname(m.getFilesystemName("file"));
			
			//파일크기저장 -> 프로젝트에서는 빼는듯
			long size = m.getFile("file").length();
			elec.setFsize( (int)size );
		}
		
		elecService.insert(elec);

	   return new Ex17ModelAndView("22110678910front", true);//?key=elec&methodName=select 기본으로 설정된다.	
	}
	
	/**
	 * 상세보기 
	 * */

	public Ex17ModelAndView selectByModelNum(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 String modelNum = request.getParameter("modelNum");
		 boolean state = request.getParameter("flag")==null ? true : false;
		 
		String pageNo =  request.getParameter("pageNo");
		 
		 //두번째 인수 boolean 조회수 증가여부를판단할 인수(true이면, false이면 증가안함)
		Ex09Electronics electronics = elecService.selectByModelnum(modelNum, state);
		request.setAttribute("elec", electronics);
		request.setAttribute("pageNo", pageNo);
		
		return new Ex17ModelAndView("SelfStudy/22110678910_important/07read.jsp"); //forward방식 
	}
	
	
	/**
	 *  수정폼
	 * */
	public Ex17ModelAndView updateForm(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String modelNum  = request.getParameter("modelNum");
		String pageNo  = request.getParameter("pageNo");
		
		Ex09Electronics elec = elecService.selectByModelnum(modelNum, false);
		request.setAttribute("elec", elec);
		request.setAttribute("pageNo", pageNo);
		
		return new Ex17ModelAndView("elec/update.jsp");//forward방식
	}
	
	/**
	 * 수정완료
	 * */
	public Ex17ModelAndView update(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	   //수정할 정보 5개 받기
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("modelName");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		String pageNo = request.getParameter("pageNo");
		
		elecService.update( new Ex09Electronics(modelNum, modelName, Integer.parseInt(price), 
				description, password) );
		
		//수정이 완료가 된후....
		Ex17ModelAndView mv = new Ex17ModelAndView();
		mv.setViewName("22110678910front?key=elec&methodName=selectByModelNum&modelNum="+modelNum+"&flag=1&pageNo="+pageNo);
	    mv.setRedirect(true);
		return mv;
	}
	
	/**
	 * 삭제
	 * 
	 * */
	public Ex17ModelAndView delete(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//전송되는 2개받기
		String modelNum = request.getParameter("modelNum");
		String password = request.getParameter("password");
		
		//첨부된 파일을 삭제하는 경우라면 삭제가 되었을때 폴더에서 파일도 삭제한다. - 이 기능을 service한다.
		String saveDir = request.getServletContext().getRealPath("/save");
		
		elecService.delete(modelNum, password , saveDir);
		
		return new Ex17ModelAndView("22110678910front", true);
	}
	
}//classEnd

