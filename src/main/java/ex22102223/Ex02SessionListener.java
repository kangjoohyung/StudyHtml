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
        System.out.println("SessionListener ������");
    }

    public void sessionCreated(HttpSessionEvent se)  { 
        System.out.println("SessionListener sessionCreated");
    }
    
    /**
     * ������ ����ɶ� ȣ��
     * 1)session.invalidate();//���Ǹ���
     * 2)session timeout�Ǿ�����(�⺻30��)
     * 
     * 3)�������� x�� Ŭ���������� ȣ����� �ʴ´�.
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
        System.out.println("SessionListener sessionDestroyed");
    }
	
}
