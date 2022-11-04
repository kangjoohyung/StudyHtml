package ex22110234;
/**
 * �� Controller�� ����ü���� ����� �� �̵��ؾ� �ϴ� ������ ������
 * �̵� ��Ŀ� ���� �Ӽ��� �����ϴ� ��ü
 * �� return Ÿ�� �����ϴ� ��ü
 */
public class Ex06ModelAndView {
	private String viewName; //���̸�
	private boolean isRedirect; //�̵���� ( true�̸� redirect, false�̸� forward )
	
	public Ex06ModelAndView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ex06ModelAndView(String viewName) {
		super();
		this.viewName = viewName;
	}

	public Ex06ModelAndView(boolean isRedirect) {
		super();
		this.isRedirect = isRedirect;
	}

	public Ex06ModelAndView(String viewName, boolean isRedirect) {
		super();
		this.viewName = viewName;
		this.isRedirect = isRedirect;
	}
	
	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	
	
}
