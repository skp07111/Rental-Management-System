/*��Ż ���� Ŭ����*/
public class ProductManager {
	private int sales; // ���� �����
	private int totalsales; // �� �����(���� �����)
	public int rentalfee; // 1�� �뿩��
	public int latefee; // 1�� ��ü��

	public Product[] plist; // ��ǰ�� �����ϴ� �迭 plist
	public Member[] mlist; // ȸ���� �����ϴ� �迭 mlist
	public int pidx; // ��ǰ index
	public int midx; // ȸ�� index
	
	public ProductManager() { // ������
		plist = new Product[4];
		mlist = new Member[4];
		pidx = 0;
		midx = 0;
	}
	
	/*��ǰ �߰� �Լ�*/
	public void insertProduct(int product_number, String product_name, int product_period, String product_status, String product_date) {
		Product p = new Product(); // ��ü p ����
		// p�� ��ǰ ���� �Է�
		p.setProductNumber(product_number);
		p.setProductName(product_name);
		p.setProductPeriod(product_period);
		p.setProductStatus(product_status);
		p.setProductDate(product_date);
		// p�� �迭 plist�� �߰�
		plist[pidx++] = p;
	}
	
	/*��ǰ ���� �Լ�*/
	public void deleteProduct(int product_number) {
		for (int i = 0; i < pidx; i++) {
			if(plist[i].getProductNumber() == product_number) { // ��ǰ ��ȣ�� �ش��ϴ� ��ǰ�� ������,
				for ( ; i < pidx; i++) {
					plist[i] = plist[i+1]; // �迭 plist���� �ش� ��ǰ ��ġ���� ��ǰ���� ������ ��ĭ�� ����
				}
				pidx--; // ��ǰ �ε��� - 1
			}
		}
	}
	
	/*��ǰ ���� �Լ�*/
	public void editProduct(int product_number, String product_name, int product_period, String product_status, String product_date) {
		for (int i = 0; i < pidx; i++) {
			if(plist[i].getProductNumber() == product_number) { // ��ǰ ��ȣ�� �ش��ϴ� ��ǰ�� ������,
				// ��ǰ ���� �����ϱ�
				plist[i].setProductName(product_name);
				plist[i].setProductPeriod(product_period);
				plist[i].setProductStatus(product_status);
				plist[i].setProductDate(product_date);
			}
		}
	}
	
	/*ȸ�� �߰� �Լ�*/
	public void insertMember(int member_number, String member_name, String member_phone, String member_status, String member_date) {
		Member m = new Member(); // ��ü m ����
		// m�� ȸ�� ���� �Է�
		m.setMemberNumber(member_number);
		m.setMemberName(member_name);
		m.setMemberPhone(member_phone);
		m.setMemberStatus(member_status);
		m.setMemberDate(member_date);
		// m�� �迭 mlist�� �߰�
		mlist[midx++] = m;
	}
	
	/*ȸ�� ���� �Լ�*/
	public void deleteMember(int member_number) { 
		for (int i = 0; i < midx; i++) {
			if(mlist[i].getMemberNumber() == member_number) { // ȸ�� ��ȣ�� �ش��ϴ� ȸ���� ������,
				for ( ; i < midx; i++) {
					mlist[i] = mlist[i+1]; // �迭 mlist���� �ش� ȸ�� ��ġ���� ȸ������ ������ ��ĭ�� ����
				}
				midx--; // ȸ�� �ε��� - 1
			}
		}
	}
	
	/*ȸ�� ���� �Լ�*/
	public void editMember(int member_number, String member_name, String member_phone, String member_status, String member_date) {
		for (int i = 0; i < midx; i++) {
			if(mlist[i].getMemberNumber() == member_number) {  // ȸ�� ��ȣ�� �ش��ϴ� ȸ���� ������,
				// ȸ�� ���� �����ϱ�
				mlist[i].setMemberName(member_name);
				mlist[i].setMemberPhone(member_phone);
				mlist[i].setMemberStatus(member_status);
				mlist[i].setMemberDate(member_date);
			}
		}
	}
}
