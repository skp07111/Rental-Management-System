import java.util.Date;

/*ȸ�� Ŭ����*/
public class Member {
	private String memberCode; // ȸ�� ��ȣ
	private String memberName; // ȸ�� �̸�
	private String memberPhone; // ȸ�� ��ȭ��ȣ
	private String memberPcode; // ȸ�� �뿩��ǰ
	private Date memberDate; // ȸ�� �뿩����
	
	public Member() {} // ������
	
	public void setMemberCode(String memberCode) { // ȸ�� ��ȣ setter �޼ҵ�
		this.memberCode = memberCode;
	}
	
	public void setMemberName(String memberName) { // ȸ�� �̸� setter �޼ҵ�
		this.memberName = memberName;
	}
	
	public void setMemberPhone(String memberPhone) { // ȸ�� ��ȭ��ȣ setter �޼ҵ�
		this.memberPhone = memberPhone;
	}
	
	public void setMemberPcode(String memberPcode) { // ȸ�� �뿩��ǰ setter �޼ҵ�
		this.memberPcode = memberPcode;
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
	
	public String getMemberPcode() { // ȸ�� �뿩��ǰ getter �޼ҵ�
		return memberPcode;
	}
	
	public Date getMemberDate() { // ȸ�� �뿩���� getter �޼ҵ�
		return memberDate;
	}
	
	public void setRentDate() {
		Date today = new Date();
		this.memberDate = today;
	}
}


