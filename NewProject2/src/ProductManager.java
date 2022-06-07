import java.util.Date;
/*��ǰ ���� Ŭ����*/
public class ProductManager {
	private final static int MAX_SIZE1 = 100;
	private final static int MAX_SIZE2 = 50;

	private Product[] plist; // ��ǰ�� �����ϴ� �迭 plist
	private int pcount; // ��ǰ ����
	private Member[] mlist; // ȸ���� �����ϴ� �迭 mlist
	private int mcount; // ȸ�� ��
	private int sales; // ���� �����
		
	public ProductManager() { // ������
		plist = new Product[MAX_SIZE1];
		mlist = new Member[MAX_SIZE2];
		pcount = 0;
		mcount = 0;
	}
	
	public Product productAt(int i) { // plist[i]�� �����ϴ� �Լ�
		return plist[i];
	}
	
	public int getPcount() { // pcount�� �����ϴ� �Լ�
		return pcount;
	}
	
	/*��ǰ �߰� �Լ�*/
	public void insertProduct(Product p) {
		plist[pcount++] = p;
	}
	
	/*��ǰ �˻� �Լ�*/
	public int searchProduct(String productCode) throws MyException {
		int pidx = -1; // �˻��� ��ǰ�� �ε���
		for (int i = 0; i < pcount; i++) {
			if (plist[i].getProductCode().equals(productCode)) 
				pidx = i;
		} 
		if (pidx == -1) throw new MyException();
		return pidx;
	} 
	
	/*��ǰ ���� �Լ�*/
	public void deleteProduct(int index) {
		for (int i = index; i < pcount; i++) { // �迭���� �ش� ��ǰ ��ġ���� ��ǰ���� ������ ��ĭ�� ����
			plist[i] = plist[i+1];
		}
		pcount--; // ��ǰ ���� - 1
	}
	
	public Member memberAt(int i) { // mlist[i]�� �����ϴ� �Լ�
		return mlist[i];
	}
	
	public int getMcount() { // mcount�� �����ϴ� �Լ�
		return mcount;
	}
	
	/*ȸ�� �߰� �Լ�*/
	public void insertMember(Member m) {
		mlist[mcount++] = m;
	}
	
	/*ȸ�� �˻� �Լ�*/
	public int searchMember(String memberCode) throws MyException {
		int midx = -1; // �˻��� ȸ���� �ε���
		for (int i = 0; i < mcount; i++) {
				if (mlist[i].getMemberCode().equals(memberCode)) 
					midx = i;
		} 
		if (midx == -1) throw new MyException();
		return midx;
	}
	
	/*ȸ�� ���� �Լ�*/
	public void deleteMember(int index) {
		for (int i = index; i < mcount; i++) { // �迭���� �ش� ȸ�� ��ġ���� ȸ������ ������ ��ĭ�� ����
			mlist[i] = mlist[i+1]; 
		}
		mcount--; // ȸ�� �� - 1
	}
	
	/*��ǰ �뿩 �Լ�*/
	public void rentalProduct(int midx, int pidx, String productCode) {
		plist[pidx].subtractStock();
		mlist[midx].addRentArray(productCode);
		mlist[midx].setRentDate();
	}	
	
	/*��ǰ �ݳ� �Լ�*/
	public void returnProduct(int midx, int pidx, Date today) {
		plist[pidx].addStock();
		int period = mlist[midx].calculate(today) - mlist[midx].getMemberPeriod(); // ���� �뿩 �Ⱓ - ������ �뿩 �Ⱓ
		int fee, totalFee = 0;
		if (period > 0) {
			for (int j = 0; j < 3; j++) {
				fee = mlist[midx].getMemberPeriod() * plist[pidx].getRentalFee() + period * plist[pidx].getLateFee();
				totalFee = totalFee + fee;
			} 
			setSales(totalFee);
		}
		else {
			for (int j = 0; j < 3; j++) {
				fee = mlist[midx].calculate(today) * plist[pidx].getRentalFee();
				totalFee = totalFee + fee;
			}
			setSales(totalFee);
		}
	}
	
	public void setSales(int sales) { // ���� setter �޼ҵ�
		this.sales = sales;
	}
	
	public int getSales() { // ���� getter �޼ҵ�
		return sales;
	}
	
	
}
