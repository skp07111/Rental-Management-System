import java.util.Date;
/*��ǰ Ŭ����*/
public class Product {
	private String productCode; // ��ǰ ��ȣ
	private String productName; // ��ǰ �̸�
	private int productStock;  // ��ǰ ���
	private int productAmount; // ��ǰ ����
	private int rentalFee; // 1�� �뿩��
	private int lateFee; // 1�� ��ü��
	
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
	
	public void setRentalFee (int rentalFee) { // 1�� �뿩�� setter �޼ҵ�
		this.rentalFee = rentalFee;
	}
	
	public void setLateFee (int lateFee) { // 1�� ��ü�� setter �޼ҵ�
		this.lateFee = lateFee;
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
	
	public int getRentalFee() { // 1�� �뿩�� getter �޼ҵ�
		return rentalFee;
	}
	
	public int getLateFee() { // 1�� ��ü�� getter �޼ҵ�
		return lateFee;
	}
	
	public void addStock() { // ��ǰ ��� + 1
		productStock++;
	}

	public void subtractStock() { // ��ǰ ��� - 1
		if (productStock > 0) {
			productStock--;
			setProductStock(productStock);
		}
	}
}


