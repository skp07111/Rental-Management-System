import java.util.Date;
/*��ǰ Ŭ����*/
public class Product {
	private String productCode; // ��ǰ ��ȣ
	private String productName; // ��ǰ �̸�
	private int productStock;  // ��ǰ ���
	private int productAmount; // ��ǰ ����
	private int productPeriod; // ��ǰ �뿩�Ⱓ
	
	public Product() {} // ������
	
	public void setProductCode(String productCode) { // ��ǰ ��ȣ setter �޼ҵ�
		this.productCode = productCode;
	}
	
	public void setProductName(String productName) { // ��ǰ �̸� setter �޼ҵ�
		this.productName = productName;
	}
	
	public void setProductStock(int productStock) { // ��ǰ ��� setter �޼ҵ�
		this.productStock = productStock;
	}
	
	public void setProductAmount(int productAmount) { // ��ǰ ���� setter �޼ҵ�
		this.productAmount = productAmount;
	}
	
	public void setProductPeriod(int productPeriod) { // ��ǰ �뿩�Ⱓ setter �޼ҵ�
		this.productPeriod = productPeriod;
	}
	
	public String getProductCode() { // ��ǰ ��ȣ getter �޼ҵ�
		return productCode;
	}
	
	public String getProductName() { // ��ǰ �̸� getter �޼ҵ�
		return productName;
	}
	
	public int getProductStock() { // ��ǰ ��� getter �޼ҵ�
		return productStock;
	}
	
	public int getProductAmount() { // ��ǰ ���� getter �޼ҵ�
		return productAmount;
	}
	
	public int getProductPeriod() { // ��ǰ �뿩�Ⱓ getter �޼ҵ�
		return productPeriod;
	}
	
	public void addStock() {
		productStock++;
	}

	public void subtractStock() {
		if (productStock > 0) {
			productStock--;
			setProductStock(productStock);
		}
	}
}


