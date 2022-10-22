package ex22102223;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Ex01AppListener implements ServletContextListener{

	public Ex01AppListener() {
		System.out.println("AppListener ������ ȣ��");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Applistener contextDestroyed");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Applistener contextInitialized");
		//�� ���� �����ڵ带 ��� �������� ����� �� �ֵ��� �̸� map�����Ѵ�
		Map<String, String> map=new HashMap<String, String>();
		map.put("kr", "���ѹα�");
		map.put("fr", "������");
		map.put("cn", "�߱�");
		map.put("us", "�̱�");
		map.put("jp", "�Ϻ�");
		
		//����� map�� ���� Ŭ���������� ����� �� �ֱ� ������ ServletContext������ �����ؾ��Ѵ�.
		ServletContext application=sce.getServletContext();
		application.setAttribute("nationMap", map);//��� �俵������ ${applicationScope.nationMap}���� ��� ����
	}
	
}
