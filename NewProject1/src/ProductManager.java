/*��ǰ ���� Ŭ����*/
public class ProductManager {
	private final static int MAX_SIZE1 = 100;
	private final static int MAX_SIZE2 = 50;
	
	//private int sales; // ���� �����
	//private int totalsales; // �� �����(���� �����)
	//private int rentalfee; // 1�� �뿩��
	//private int latefee; // 1�� ��ü��

	private Product[] plist; // ��ǰ�� �����ϴ� �迭 plist
	private int pcount; // ��ǰ ����
	private Member[] mlist; // ȸ���� �����ϴ� �迭 mlist
	private int mcount; // ȸ�� ��
		
	public ProductManager() { // ������
		plist = new Product[MAX_SIZE1];
		mlist = new Member[MAX_SIZE2];
		pcount = 0;
		mcount = 0;
	}
	
	public Product productAt(int i) {
		return plist[i];
	}
	
	public Member memberAt(int i) {
		return mlist[i];
	}
	
	public int getPcount() {
		return pcount;
	}
	
	public int getMcount() {
		return mcount;
	}
	
	/*��ǰ�ڵ� ������ Ȯ���ϴ� �Լ�*/
	public boolean isSameProduct(String productCode) {
		int index = -1;
		index = searchProduct(productCode);
		if (index == -1)
			return true;
		else return false;
	}
	
	/*ȸ���ڵ� ������ Ȯ���ϴ� �Լ�*/
	public boolean isSameMember(String memberCode) {
		int index = -1;
		index = searchMember(memberCode);
		if (index == -1)
			return true;
		else return false;
	}
	
	/*��ǰ �߰� �Լ�*/
	public void insertProduct(Product p) {
		plist[pcount++] = p;
	}
	
	/*��ǰ �˻� �Լ�*/
	public int searchProduct(String productCode) {
		int sidx = -1; // �˻��� ��ǰ�� �ε���
		
		for (int i = 0; i < pcount; i++) {
			if(plist[i].getProductCode().equals(productCode)) {
				sidx = i;
			}
		} 
		return sidx;
	}
	
	/*��ǰ ���� �Լ�*/
	public void deleteProduct(String productCode) {
		int didx = searchProduct(productCode); // ������ ��ǰ�� �ε���
	
		for (int i = didx; i < pcount; i++) { // �迭���� �ش� ��ǰ ��ġ���� ��ǰ���� ������ ��ĭ�� ����
			plist[i] = plist[i+1]; 
		}
		pcount--; // ��ǰ ���� - 1
	}	

	/*��ǰ ��Ʈ �Լ�*/
	public boolean rentalProduct(String productCode) {
		int ridx = -1;
		ridx = searchProduct(productCode);
		if (ridx != -1) {
			int pstock = plist[ridx].getProductStock();
			pstock--;
			if(pstock >= 0) {
				plist[ridx].setProductStock(pstock);
				return true; // ��ǰ �ڵ尡 �˻��ǰ� ��� 0 �̻��̸� true
			}
			else return false; // ��� �����̸� false
		}
		else return false; // ��ǰ �ڵ尡 �˻����� ������ false
	}
	
	/*ȸ�� �߰� �Լ�*/
	public void insertMember(Member m) {
		mlist[mcount++] = m;
	}
	
	/*ȸ�� �˻� �Լ�*/
	public int searchMember(String memberCode) {
		int sidx = -1; // �˻��� ȸ���� �ε���
		
		for (int i = 0; i < mcount; i++) {
			if(mlist[i].getMemberCode().equals(memberCode)) {
				sidx = i;
			}
		} 
		return sidx;
	}
	
	/*ȸ�� ���� �Լ�*/
	public void deleteMember(String memberCode) {
		int didx = searchMember(memberCode); // ������ ȸ���� �ε���
	
		for (int i = didx; i < mcount; i++) { // �迭���� �ش� ȸ�� ��ġ���� ȸ������ ������ ��ĭ�� ����
			mlist[i] = mlist[i+1]; 
		}
		mcount--; // ȸ�� �� - 1
	}	
}