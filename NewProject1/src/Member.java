import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*ȸ�� Ŭ����*/
public class Member {
	private String memberCode; // ȸ�� ��ȣ
	private String memberName; // ȸ�� �̸�
	private String memberPhone; // ȸ�� ��ȭ��ȣ
	private String memberPcode; // ȸ�� �뿩��ǰ
	private String memberDate; // ȸ�� �뿩����
	private String today; // ���� ��¥
	
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
	
	public void setMemberDate(String memberDate) { // ȸ�� �뿩���� setter �޼ҵ�
		this.memberDate = memberDate;
	}
	
	//public void setToday() { // ���� ��¥ setter �޼ҵ�

	//}
	
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
	
	public String getMemberDate() { // ȸ�� �뿩���� getter �޼ҵ�
		return memberDate;
	}
	
	public String getToday() {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
		Date date = new Date();
		today = mSimpleDateFormat.format(date);
		return today;
	}
}


