/*ȸ�� Ŭ����*/
public class Member {
	private int member_number; // ȸ�� ��ȣ
	private String member_name; // ȸ�� �̸�
	private String member_phone; // ȸ�� ��ȭ��ȣ
	private String member_status; // ȸ�� �뿩����
	private String member_date; // ȸ�� �뿩����
	
	public Member() {} // ������

	public void setMemberNumber(int member_number) { // ȸ�� ��ȣ setter �޼ҵ�
		this.member_number = member_number;
	}
	
	public void setMemberName(String member_name) { // ȸ�� �̸� setter �޼ҵ�
		this.member_name = member_name;
	}
	
	public void setMemberPhone(String member_phone) { // ȸ�� ��ȭ��ȣ setter �޼ҵ�
		this.member_phone = member_phone;
	}
	
	public void setMemberStatus(String member_status) { // ȸ�� �뿩���� setter �޼ҵ�
		this.member_status = member_status;
	}
	
	public void setMemberDate(String member_date) { // ȸ�� �뿩���� setter �޼ҵ�
		this.member_date = member_date;
	}
	
	public int getMemberNumber() { // ȸ�� ��ȣ getter �޼ҵ�
		return member_number;
	}
	
	public String getMemberName() { // ȸ�� �̸� getter �޼ҵ�
		return member_name;
	}
	
	public String getMemberPhone() { // ȸ�� ��ȭ��ȣ getter �޼ҵ�
		return member_phone;
	}
	
	public String getMemberStatus() { // ȸ�� �뿩���� getter �޼ҵ�
		return member_status;
	}
	
	public String getMemberDate() { // ȸ�� �뿩���� getter �޼ҵ�
		return member_date;
	}
}
