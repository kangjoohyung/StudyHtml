package ex2210171819;

public class Ex01Product {
	private String code="A01";
	private String name="�����";
	private int price=3500;
	private int qty=5;
	
	public Ex01Product() {
		System.out.println("Product ������");
	}
	
	public String getCode() {
		System.out.println("getCode() ȣ��");
		return code;
	}
	public String getName() {
		System.out.println("getName() ȣ��");
		return name;
	}
	public int getPrice() {
		System.out.println("getPrice() ȣ��");
		return price;
	}
	public int getQty() {
		System.out.println("getQty() ȣ��");
		return qty;
	}
	
	
}