package ex22110678910;

import java.sql.SQLException;
import java.util.List;


public interface Ex14ElectronicsService{
	/**
	 * Ex09ElectronicsDAOImpl�� ��緹�ڵ� �˻��ϴ� �޼ҵ� ȣ��
	 * */
    List<Ex09Electronics> selectAll() throws SQLException;
    
    /**
	 * pagingó��
	 * */
    List<Ex09Electronics> selectAll(int pageNo) throws SQLException;
	  
	  /**
	   * Ex09ElectronicsDAOImpl�� ���ڵ� �����ϴ� �޼ҵ� ȣ��
	   * */
	  void insert(Ex09Electronics electronics) throws SQLException;
	 
	  
	  /**
	   * Ex09ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻��ϴ� �޼ҵ� ȣ��
	   * @param : boolean flag - ��ȸ�� ���� ���θ� �Ǻ��ϴ� �Ű�������(true�̸� ��ȸ������ / false�̸� ��ȸ�� ���� ����)
	   * */
	  Ex09Electronics selectByModelnum(String modelNum, boolean flag)
			throws SQLException;
		 
		 
	 /**
	   * Ex09ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ���� �޼ҵ� ȣ��
	   * */
	    void delete(String modelNum, String password, String saveDir) throws SQLException;
	  
	  
	  /**
	   * Ex09ElectronicsDAOImpl�� �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����  �޼ҵ� ȣ��
	   * */
	   void update(Ex09Electronics electronics) throws SQLException;
	  
}
