package ex2210171819;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Ex02ForEachBean {
	private String names[]= {"����","�Կ�","����","�ο�","���"};
	
	private List<String> menus=Arrays.asList("¥��","«��","«¥��","������","�Ⱥ�ä");
	private List<Ex03BoardDTO> boardList = new ArrayList<Ex03BoardDTO>();
	private Map<String, String> map = new HashMap<String, String>();
	public Ex02ForEachBean() {
		boardList.add(new Ex03BoardDTO(1,"JSTL�н���1"));
		boardList.add(new Ex03BoardDTO(2,"JSTL�н���2"));
		boardList.add(new Ex03BoardDTO(3,"JSTL�н���3"));
		boardList.add(new Ex03BoardDTO(4,"JSTL�н���4"));
		boardList.add(new Ex03BoardDTO(5,"JSTL�н���5"));
		boardList.add(new Ex03BoardDTO(6,"JSTL�н���6"));
		boardList.add(new Ex03BoardDTO(7,"JSTL�н���7"));
		boardList.add(new Ex03BoardDTO(8,"JSTL�н���8"));
		boardList.add(new Ex03BoardDTO(9,"JSTL�н���9"));
		boardList.add(new Ex03BoardDTO(10,"JSTL�н���10"));
		boardList.add(new Ex03BoardDTO(11,"JSTL�н���11"));
		//�ݺ��� ������ ���� ���� ������ ������ ����
		map.put("kr", "���ѹα�");
		map.put("us", "�̱�");
		map.put("fr", "������");
		map.put("jp", "�Ϻ�");
		map.put("cn", "�߱�");
	} //����� ���Ŀ� �ٸ�
	public String[] getNames() { //�信�� ${�̸�.names}
		return names;
	}
	public List<String> getMenus() { //�信�� ${�̸�.menus}
		return menus;
	}
	public List<Ex03BoardDTO> getBoardList() { //�信�� ${�̸�.boardList}
		return boardList;
	}
	public Map<String, String> getMap() { //�信�� ${�̸�.map}
		return map;
	}
	
}
