package ex22102223;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class Ex02SessionListener implements HttpSessionListener {

    public Ex02SessionListener() {
        System.out.println("SessionListener 생성자");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("SessionListener sessionCreated");
    }
    
    /**
     * 세션이 종료될때 호출
     * 1)session.invalidate();//세션만료
     * 2)session timeout되었을때(기본30분)
     * 
     * 3)브라우져의 x를 클릭했을때는 호출되지 않는다.
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("SessionListener sessionDestroyed");
    }
	
}
