package ex22110678910;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * ������ ���۵ɶ� �� Conroller�� ������ü�� �̸� �����ؼ� Map�� ��������
 * ServletContext������ map�� �����Ѵ�.
 *
 */
@WebListener
public class Ex04HandlerMappingListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { }

	
    public void contextInitialized(ServletContextEvent e)  { 
    	
    	
    	//�����ؾ��ϴ� ��ü���� ������ �������ִ� ~.properties������ �ε�!
    	ServletContext application = e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	System.out.println("fileName = " + fileName);
    	//System.out.println("application="+application);
    	
    	ResourceBundle rb =
    			ResourceBundle.getBundle(fileName); //actionMapping.properties �ε�
        
    	
    	/*
    	 *  String�� ���ڿ��� Controller��� ��ü�� �����ؾ��Ѵ�.
    	 *   :Class<?>�� ���ü�� ������ �ִ� �ʵ�, ������ ,�޼ҵ��� ������ �������� �����ü� �ֵ���
    	 *    �����ִ� ��ü�̴�. - reflection����
    	 *   : reflection������ �������� ��, ���൵�߿� �ʿ��� ��ü�� �����ϰ� �����ϰ� �� ��ü��
    	 *     ������ �մ� �����ڳ� �޼ҵ带 �������� ȣ�� �Ҽ� �ֵ��� �����ִ� ������ Reflection�̶��Ѵ�.
    	 *     �ڹٿ��� �̷��� ������ ������ ���� API�� Class<?> �̴�. 
    	 * */
    	try {
    		
    		Map<String, Ex16Controller> map = new HashMap<String, Ex16Controller>();
    		Map<String, Class<?> > clzMap = new HashMap<String, Class<?>>();
    		
	    	for( String key :  rb.keySet() ){
	    		String value = rb.getString(key);
	    		Class<?> className = Class.forName(value);
	    		System.out.println("54");
	    		Ex16Controller con = (Ex16Controller)className.getDeclaredConstructor().newInstance();
	    		System.out.println("56");
	    		map.put(key, con);//��ü
	    		clzMap.put(key, className);//������Ƽ �ּ�
	    		
	    		System.out.println(key +" handl= " + con);//��üȭ
	    		System.out.println("className="+className);//Ŭ��������(actionMapping��������)
	    	}
	    	
	    	//���� ������Ʈ�� ��� �������� map�� ����Ҽ� �ֵ��� ServletContext������ �����Ѵ�.
	    	application.setAttribute("map", map);
	    	application.setAttribute("clzMap", clzMap);
	    	application.setAttribute("path",  application.getContextPath() ); //${path}
	    	
    	}catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    	
    	
    }//methodEnd
	
}//classEnd










