package ex22110678910;

import java.sql.SQLException;
import java.util.List;


public interface Ex12ElectronicsDAO {
	 /**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<Ex09Electronics> selectAll() throws SQLException;
	  
	  /**
		  * ���ڵ� ��ü �˻�(������ó��)
		  * */
	   List<Ex09Electronics> getBoardList(int pageNo) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
	   * */
	  Ex09Electronics selectByModelNum(String modelNum) throws SQLException;
	  
	  /**
	   * ��ȸ���� �����ϴ� ���
	   * update Ex09Electronics set readnum = readnum + 1 where model_num=?
	   * */
	  int increamentByReadnum(String modelNum) throws SQLException;
	  
	  
	/**
	 * ���ڵ� ����
	 * @return : 1-���Լ��� , 0 - ���Խ���
	 * */
	  int insert(Ex09Electronics electronics) throws SQLException;
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * @return : 1-�������� , 0 - ��������
	   * */
	  int delete(String modelNum, String password) throws SQLException;
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * @return : 1-�������� , 0 - ��������
	    * */
	  int update(Ex09Electronics electronics) throws SQLException;
}
