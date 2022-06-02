/*������ UI Ŭ����*/
import java.util.Scanner; // Scanner Ŭ����

public class Admin {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); // scan ��ü ����
		ProductManager pm = new ProductManager(); // pm ��ü ����
		
		/* �ý��� �ȳ�â ��� */
		while(true) {
			System.out.println("********�����ڿ� �ý����Դϴ�********");
			System.out.println("1. ��ǰ �߰�");
			System.out.println("2. ��ǰ ����");
			System.out.println("3. ��ǰ ����Ʈ ���");
			System.out.println("4. ȸ�� �߰�");
			System.out.println("5. ȸ�� ����");
			System.out.println("6. ȸ�� ����Ʈ ���");
			System.out.println("7. ��ǰ ��Ʈ");
			System.out.println("8. �뿩 ����Ʈ ���");
			System.out.println("9. �ý��� ����");
			System.out.print("������ �޴��� ���ڷ� �Է����ּ���: ");
	
			int menu = scan.nextInt(); // �޴� �Է¹ޱ�

			switch(menu) {
			/*��ǰ �߰�*/
			case 1: // ��ǰ ���� �Է¹ޱ�
				Product p = new Product();
				System.out.print("��ǰ �ڵ�: ");
				p.setProductCode(scan.next());
				String pcode = p.getProductCode();
				if (pm.isSameProduct(pcode) == false) {
					System.out.println("�̹� �����ϴ� ��ǰ �ڵ��Դϴ�.");
				}
				else {
					System.out.print("��ǰ �̸�: ");
					p.setProductName(scan.next());
					System.out.print("��ǰ ���: ");
					p.setProductStock(scan.nextInt());
					System.out.print("��ǰ ����: ");
					p.setProductAmount(scan.nextInt());
					System.out.print("��ǰ �뿩�Ⱓ: ");
					p.setProductPeriod(scan.nextInt());
					p.setProductDate(null);
					// �Է��� ��ǰ�� �迭�� �߰�
					pm.insertProduct(p); 
				}
				System.out.println("\n");
				break;
				
			/*��ǰ ����*/
			case 2:
				// ��ǰ �ڵ� �Է¹ޱ�
				System.out.print("������ ��ǰ �ڵ带 �Է����ּ���: ");
				try {
					pm.deleteProduct(scan.next());
				}
				catch (ArrayIndexOutOfBoundsException e) 
				{
					System.out.println("�ش� �ڵ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
				}
				System.out.println("\n");
				break;
			
			/*��ǰ ����Ʈ ���*/	
			case 3:
				for(int i = 0; i < pm.getPcount(); i++) { // �迭�� ó������ ������ ��ǰ ���� ���
					p = pm.productAt(i);
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount() +"\t\t�뿩�Ⱓ:" + p.getProductPeriod() + "\t\t�뿩����:" + p.getProductDate());
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
				
			/*ȸ�� �߰�*/	
			case 4: // ȸ�� ���� �Է¹ޱ�
				Member m = new Member();
				System.out.print("ȸ�� �ڵ�: ");
				m.setMemberCode(scan.next());
				String mcode = m.getMemberCode();
				if (pm.isSameMember(mcode) == false) {
					System.out.println("�̹� �����ϴ� ȸ�� �ڵ��Դϴ�.");
				}
				else {
					System.out.print("ȸ�� �̸�: ");
					m.setMemberName(scan.next());
					System.out.print("ȸ�� ��ȭ��ȣ: ");
					m.setMemberPhone(scan.next());
					m.setMemberPcode(null);
					m.setMemberDate(null);
					// �Է��� ȸ���� �迭�� �߰�
					pm.insertMember(m); 
				}
				System.out.println("\n");
				break;
				
			/*ȸ�� ����*/
			case 5:
				// ȸ�� �ڵ� �Է¹ޱ�
				System.out.print("������ ȸ�� �ڵ带 �Է����ּ���: ");
				try {
					pm.deleteMember(scan.next());
				}
				catch (ArrayIndexOutOfBoundsException e) 
				{
					System.out.println("�ش� �ڵ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
				}
				System.out.println("\n");
				break;
			
			/*ȸ�� ����Ʈ ���*/	
			case 6:
				for(int i = 0; i < pm.getMcount(); i++) { // �迭�� ó������ ������ ȸ�� ���� ���
					m = pm.memberAt(i);
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("ȸ���ڵ�:" + m.getMemberCode() + "\t\t�̸�:" + m.getMemberName() +"\t\t��ȭ��ȣ:" + m.getMemberPhone() + "\t\t�뿩��ǰ:" + m.getMemberPcode() + "\t\t�뿩����:" + m.getMemberDate());
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
		
			/*��ǰ ��Ʈ*/
			case 7:
				System.out.print("ȸ�� �ڵ带 �Է����ּ���: ");
				int midx = -1;
				midx = pm.searchMember(scan.next()); // ȸ�� �ڵ� �˻�
				if (midx == -1) 
					System.out.println("�Է��Ͻ� ȸ�� �ڵ尡 �������� �ʽ��ϴ�.");
				else {
					System.out.print("��Ʈ�� ��ǰ �ڵ带 �Է����ּ���: ");
					String code = scan.next();
					if (pm.rentalProduct(code) == false)
						 System.out.println("�Է��Ͻ� ��ǰ �ڵ�� ��ġ�ϴ� ��ǰ�� �����ϴ�."); // �Է��� ��ǰ �ڵ忡 �ش��ϴ� ��ǰ�� ���� ���
					else { // �Է��� ��ǰ �ڵ忡 �ش��ϴ� ��ǰ�� �ִ� ���
						m = pm.memberAt(midx);
						m.setMemberPcode(code); // ȸ�� m�� �ش� ��ǰ�ڵ� ����
						System.out.print(m.getToday()); // ���� ��¥ ���
						System.out.println(" �Է��Ͻ� ��ǰ�� �뿩�� �Ϸ�Ǿ����ϴ�.");
						m.setMemberDate(m.getToday()); // ���� ��¥ ��������
						int pidx = pm.searchProduct(code); 
						p = pm.productAt(pidx); // �Է��� ��ǰ �ڵ忡 �ش��ϴ� ��ǰ p
						p.setProductDate(m.getToday()); // ��ǰ p�� ���� ��¥�� �뿩���ڷ� ����
					}
				}
				System.out.println("\n");
				break;
			
			/*�뿩 ����Ʈ ���*/	
			case 8:
				for(int i = 0; i < pm.getMcount(); i++) { // �迭�� ó������ ������ ȸ�� ���� ���
					m = pm.memberAt(i);
					if (m.getMemberDate() != null) {
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						System.out.println("�뿩�� ȸ���ڵ�:" + m.getMemberCode() + "\t\t�뿩�� ��ǰ�ڵ�:" + m.getMemberPcode() + "\t\t�뿩����:" + m.getMemberDate());
					}
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
				
				
			/*�ý��� ����*/
			case 9: 
				System.out.println("�ý����� �����մϴ�.");
				break;
					
			
			/*�޴��� ���� ���ڸ� �Է��� ���*/	
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~4 �߿��� �Է����ּ���.");
				System.out.println("\n");
				break;
			}
			if (menu == 9) // while�� Ż��
					break;
		} 
		scan.close();
	}
}
