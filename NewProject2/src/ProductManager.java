import java.util.Date;
/*��ǰ ���� Ŭ����*/
public class ProductManager {
	private final static int MAX_SIZE1 = 100;
	private final static int MAX_SIZE2 = 50;
	
	private int sales; // ���� �����
	private int totalsales; // �� �����(���� �����)
	private int rentalfee; // 1�� �뿩��
	private int latefee; // 1�� ��ü��

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
	
	/*��ǰ ��Ʈ �Լ�*/
	public void rentalProduct(String productCode, Member m, Product p) {
		p.subtractStock();
		m.setRentArray(productCode);
		m.setRentDate();
		m.setMemberDate(m.getMemberDate());
	}
	
	/*��¥ ��� �Լ�*/
	/*public long calculate(String memberCode) {
		int index = -1;
		index = searchMember(memberCode);
		if (index != -1 || mlist[index].getMemberDate() != null) {
			Date rentDate = mlist[index].getMemberDate();
			Date returnDate = new Date();
			long rentSec = returnDate.getTime() - rentDate.getTime();
			long rentDays = rentSec / (24*60*60);
			return rentDays;
		}
		else return 0;
	}*/

}