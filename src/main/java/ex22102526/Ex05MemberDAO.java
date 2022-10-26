package ex22102526;

import java.util.List;

public interface Ex05MemberDAO {
	/**
	 * ��ü�˻�
	 * select * from member order by join_date desc
	 */
	List<Ex04Member> selectAll();
	
	/**
	 * ����ϱ�
	 * insert into member(id, pwd, name, age, addr, phone, join_date) values(?,?,?,?,?,?,sysdate)
	 */
	int insert(Ex04Member member);
	
	/**
	 * id �ߺ�üũ�ϱ�
	 * @return : true�̸� �ߺ�, false�̸� �ߺ��ƴ� (������ �κ���) - select ��� 
	 * select id from member where id=?
	 */
	boolean duplicateCheckById(String id);
	
	/**
	 * �����ϱ�
	 * delete from member where id=?
	 */
	int delete(String id);
	
	/**
	 * �󼼺���
	 * select * from member where id=?
	 */
	Ex04Member selectById(String id);
	
	/**
	 * ���ǰ˻�
	 * (�˻��ʵ�� �˻��ܾ ���޹޾� �˻��ʵ忡 �˻��ܾ ������ ���ڵ带 �˻�)
	 * 
	 * ���ÿ� �ִ°� �ȵż� ���ε��� ���� �ֱ�(�������� ���� �̽�����)
	 * select * from member where ID like ?
	 * select * from member where name like ?
	 * select * from member where addr like ?
	 */
	List<Ex04Member> searchByKeyWord(String keyField, String keyWord);
}
