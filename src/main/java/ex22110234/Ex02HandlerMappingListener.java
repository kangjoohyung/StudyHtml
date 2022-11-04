package ex22110234;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * ������ ���۵ɶ� �� Controller�� ������ü���̸� �����ؼ� Map�� ������ �� 
 * ServletContext������ map�� �����Ѵ�.
 */
@WebListener
public class Ex02HandlerMappingListener implements ServletContextListener {

 
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // �����ؾ��ϴ� ��ü���������� ������ �ִ� ~.properties ������ �ε�
    	ResourceBundle rb= //actionMapping.properties
    			ResourceBundle.getBundle("actionMapping");
    	/*
    	 * String�� ���ڿ��� Controller��� ��ü�� �����ؾ��Ѵ�. 
    	 * :Class<?>�� � ��ü�� ������ �ִ� �ʵ�, ������, �޼ҵ��� ������ �������� ������ �� �ֵ��� 
    	 * �����ִ� ��ü�̴�. - reflection����
    	 * 
    	 * :reflection������ �������� ��, ���൵�߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü�� ������
    	 * �ִ� �����ڳ� �޼ҵ带 �������� ȣ���� �� �ֵ��� �����ִ� ������ Reflection�̶� �Ѵ�.
    	 * �ڹٿ��� �̷��� ������ ������ ���� API�� Class<?>�̴�.
    	 */
	    try {
	    	Map<String, Ex03Controller> map=new HashMap<String, Ex03Controller>();
	    	Map<String, Class<?>> clzMap=new HashMap<String, Class<?>>();
	    	for(String key:rb.keySet()) {
	    		String value=rb.getString(key);
	    		
	    		Class<?> className=Class.forName(value);
	    		Ex03Controller con=(Ex03Controller)className.getDeclaredConstructor().newInstance();
	    		
	    		map.put(key, con);
	    		clzMap.put(key, className);
	    		
	    		System.out.println(key+"="+con);
	    		System.out.println("className="+className);
	    	}//for����
	    	
	    	//���� ������Ʈ�� ��� �������� map�� ����� �� �ֵ��� ServletContext������ �����Ѵ�.
	    	ServletContext application=sce.getServletContext();
	    	application.setAttribute("map", map);
	    	application.setAttribute("clzMap", clzMap);
	    	application.setAttribute("path", application.getContextPath()); //${path}
	    	
	    }catch (Exception ex) {
	    	ex.printStackTrace();
	    }
    }//contextInitialized ��
	
}
