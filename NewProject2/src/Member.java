import java.util.Date;

/*ȸ�� Ŭ����*/
public class Member {
	private String memberCode; // ȸ�� ��ȣ
	private String memberName; // ȸ�� �̸�
	private String memberPhone; // ȸ�� ��ȭ��ȣ
	private int memberPeriod; // �뿩 �Ⱓ
	private Date memberDate; // ȸ�� �뿩����
	private String[] rentArray; // �뿩 ��ǰ ����Ʈ
	private int rcount;
	
	public Member() { // ������
		rentArray = new String[3];
		rcount = 0;
	} 
	
	public void setMemberCode(String memberCode) { // ȸ�� ��ȣ setter �޼ҵ�
		this.memberCode = memberCode;
	}
	
	public void setMemberName(String memberName) { // ȸ�� �̸� setter �޼ҵ�
		this.memberName = memberName;
	}
	
	public void setMemberPhone(String memberPhone) { // ȸ�� ��ȭ��ȣ setter �޼ҵ�
		this.memberPhone = memberPhone;
	}
	
	public void setMemberPeriod(int memberPeriod) { // ȸ�� �뿩�Ⱓ setter �޼ҵ�
		this.memberPeriod = memberPeriod;
	}
	
	public void setMemberDate(Date memberDate) { // ȸ�� �뿩���� setter �޼ҵ�
		this.memberDate = memberDate;
	}
	
	public String getMemberCode() { // ȸ�� ��ȣ getter �޼ҵ�
		return memberCode;
	}
	
	public String getMemberName() { // ȸ�� �̸� getter �޼ҵ�
		return memberName;
	}
	
	public String getMemberPhone() { // ȸ�� ��ȭ��ȣ getter �޼ҵ�
		return memberPhone;
	}
	
	public int getMemberPeriod() { // ȸ�� �뿩�Ⱓ getter �޼ҵ�
		return memberPeriod;
	}
	
	public Date getMemberDate() { // ȸ�� �뿩���� getter �޼ҵ�
		return memberDate;
	}
	
	public void addRentArray(String productCode) { // �뿩 ��ǰ�ڵ� ����Ʈ�� �߰�
		if (rcount < 3) {
			rentArray[rcount] = productCode;
			this.rcount = rcount + 1;
		}
	}
	
	public void resetRentArray(int i, String reset) { // �뿩 ��ǰ �ڵ� getter �޼ҵ�
		rentArray[i] = reset;
	}
	
	public String getRentArray(int i) { // �뿩 ��ǰ �ڵ� getter �޼ҵ�
		return rentArray[i];
	}
	
	/*��¥ ��� �Լ�*/
	public int calculate(Date returnDate) {
		Date rentDate = getMemberDate();
		long rentSec = returnDate.getTime() - rentDate.getTime(); // �ݳ��� - �뿩��
		int rentDays = (int) rentSec / (24*60*60); // ���� �뿩 �Ⱓ(����: ��)
		return rentDays;
	}
	
	public void setRentDate() { // ���� ��¥ getter �޼ҵ�
		Date today = new Date();
		this.memberDate = today;
	}
}


