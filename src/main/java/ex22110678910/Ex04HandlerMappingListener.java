package ex22110678910;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 서버가 시작될때 각 Conroller의 구현객체를 미리 생성해서 Map에 저장한후
 * ServletContext영역에 map을 저장한다.
 *
 */
@WebListener
public class Ex04HandlerMappingListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { }

	
    public void contextInitialized(ServletContextEvent e)  { 
    	
    	
    	//생성해야하는 객체들의 정보를 가지고있는 ~.properties파일을 로딩!
    	ServletContext application = e.getServletContext();
    	String fileName = application.getInitParameter("fileName");
    	System.out.println("fileName = " + fileName);
    	//System.out.println("application="+application);
    	
    	ResourceBundle rb =
    			ResourceBundle.getBundle(fileName); //actionMapping.properties 로딩
        
    	
    	/*
    	 *  String의 문자열을 Controller라는 객체로 생성해야한다.
    	 *   :Class<?>는 어떤객체가 가지고 있는 필드, 생성자 ,메소드의 정보를 동적으로 가져올수 있도록
    	 *    도와주는 객체이다. - reflection개념
    	 *   : reflection개념은 동적으로 즉, 실행도중에 필요한 객체를 적절하게 생성하고 그 객체가
    	 *     가지고 잇는 생성자나 메소드를 동적으로 호출 할수 있도록 도와주는 개념을 Reflection이라한다.
    	 *     자바에서 이러한 개념을 적용해 놓은 API가 Class<?> 이다. 
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
	    		map.put(key, con);//객체
	    		clzMap.put(key, className);//프로퍼티 주소
	    		
	    		System.out.println(key +" handl= " + con);//객체화
	    		System.out.println("className="+className);//클래스네임(actionMapping에서따옴)
	    	}
	    	
	    	//현재 프로젝트의 모든 영역에서 map을 사용할수 있도록 ServletContext영역에 저정한다.
	    	application.setAttribute("map", map);
	    	application.setAttribute("clzMap", clzMap);
	    	application.setAttribute("path",  application.getContextPath() ); //${path}
	    	
    	}catch (Exception ex) {
			ex.printStackTrace();
		}
    	
    	
    	
    }//methodEnd
	
}//classEnd










