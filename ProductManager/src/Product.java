/*��ǰ Ŭ����*/
public class Product {
	private int product_number; // ��ǰ ��ȣ
	private String product_name; // ��ǰ �̸�
	private int product_period; // ��ǰ �뿩�Ⱓ
	private String product_status; // ��ǰ �뿩����
	private String product_date; // ��ǰ �뿩����
	
	public Product() {} // ������
	
	public void setProductNumber(int product_number) { // ��ǰ ��ȣ setter �޼ҵ�
		this.product_number = product_number;
	}
	
	public void setProductName(String product_name) { // ��ǰ �̸� setter �޼ҵ�
		this.product_name = product_name;
	}
	
	public void setProductPeriod(int product_period) { // ��ǰ �뿩�Ⱓ setter �޼ҵ�
		this.product_period = product_period;
	}
	
	public void setProductStatus(String product_status) { // ��ǰ �뿩���� setter �޼ҵ�
		this.product_status = product_status;
	}
	
	public void setProductDate(String product_date) { // ��ǰ �뿩���� setter �޼ҵ�
		this.product_date = product_date;
	}
	
	public int getProductNumber() { // ��ǰ ��ȣ getter �޼ҵ�
		return product_number;
	}
	
	public String getProductName() { // ��ǰ �̸� getter �޼ҵ�
		return product_name;
	}
	
	public int getProductPeriod() { // ��ǰ �뿩�Ⱓ getter �޼ҵ�
		return product_period;
	}
	
	public String getProductStatus() { // ��ǰ �뿩���� getter �޼ҵ�
		return product_status;
	}
	
	public String getProductDate() { // ��ǰ �뿩 ���� getter �޼ҵ�
		return product_date;
	}
}
