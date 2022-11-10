package ex22110678910;
/**
 * �� Controller�� ����ü���� ����� �� �̵��ؾ��ϴ� ������ ������
 * �̵���Ŀ� ���� �Ӽ��� �����ϴ� ��ü
 * 
 * */
public class Ex17ModelAndView {
   private String viewName;//���̸�
   private boolean isRedirect;//�̵����(true�̸� redirect���, false�̸� forward���)
 
   public Ex17ModelAndView() {}
   public Ex17ModelAndView(String viewName) {
	   this.viewName = viewName;
   }
   public Ex17ModelAndView(String viewName, boolean isRedirect) {
	this(viewName);
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
