package ex22102021;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Ex05LogTest {
	Log log=LogFactory.getLog(super.getClass());

	public static void main(String[] args) {
		System.out.println("----���� ����----");
		
		Ex05LogTest t=new Ex05LogTest();
		t.test();
		
		System.out.println("----���� ��----");
	}

	public void test() {
		//�α� ��� (�� �� �ʿ����, info������ info�� �ϸ� ��)
		//log.trace("trace�� ���õ� �α�");
		//log.debug("debug�� ���õ� �α�");
		log.info("info�� ���õ� �α�");
		//log.warn("warn�� ���õ� �α�");
		//log.error("error�� ���õ� �α�");
		//log.fatal("fatal�� ���õ� �α�");
	}
}
