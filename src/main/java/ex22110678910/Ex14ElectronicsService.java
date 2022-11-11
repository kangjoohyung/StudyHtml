package ex22110678910;

import java.sql.SQLException;
import java.util.List;


public interface Ex14ElectronicsService{
	/**
	 * Ex09ElectronicsDAOImpl의 모든레코드 검색하는 메소드 호출
	 * */
    List<Ex09Electronics> selectAll() throws SQLException;
    
    /**
	 * paging처리
	 * */
    List<Ex09Electronics> selectAll(int pageNo) throws SQLException;
	  
	  /**
	   * Ex09ElectronicsDAOImpl의 레코드 삽입하는 메소드 호출
	   * */
	  void insert(Ex09Electronics electronics) throws SQLException;
	 
	  
	  /**
	   * Ex09ElectronicsDAOImpl의 모델번호에 해당하는 레코드 검색하는 메소드 호출
	   * @param : boolean flag - 조회수 증가 여부를 판별하는 매개변수임(true이면 조회수증가 / false이면 조회수 증가 안함)
	   * */
	  Ex09Electronics selectByModelnum(String modelNum, boolean flag)
			throws SQLException;
		 
		 
	 /**
	   * Ex09ElectronicsDAOImpl의 모델번호에 해당하는 레코드 삭제 메소드 호출
	   * */
	    void delete(String modelNum, String password, String saveDir) throws SQLException;
	  
	  
	  /**
	   * Ex09ElectronicsDAOImpl의 모델번호에 해당하는 레코드 수정  메소드 호출
	   * */
	   void update(Ex09Electronics electronics) throws SQLException;
	  
}
