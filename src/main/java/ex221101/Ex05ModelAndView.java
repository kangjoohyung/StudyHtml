package ex221101;
/**
 * �� Controller�� ����ü���� ����� �� �̵��ؾ� �ϴ� ������ ������
 * �̵� ��Ŀ� ���� �Ӽ��� �����ϴ� ��ü
 * �� return Ÿ�� �����ϴ� ��ü
 */
public class Ex05ModelAndView {
	private String viewName; //���̸�
	private boolean isRedirect; //�̵���� ( true�̸� redirect, false�̸� forward )
	
	public Ex05ModelAndView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ex05ModelAndView(String viewName) {
		super();
		this.viewName = viewName;
	}

	public Ex05ModelAndView(boolean isRedirect) {
		super();
		this.isRedirect = isRedirect;
	}

	public Ex05ModelAndView(String viewName, boolean isRedirect) {
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
