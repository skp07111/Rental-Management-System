/*�����ڿ� UI Ŭ����*/
import java.util.Scanner; // Scanner Ŭ����

public class Admin {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); // scan ��ü ����
		ProductManager pm = new ProductManager(); // pm ��ü ����
		
		int pnumber; 		// ��ǰ ��ȣ
		String pname; 		// ��ǰ �̸�
		int pperiod;		// ��ǰ �뿩�Ⱓ
		String pstatus;		// ��ǰ �뿩����
		String pdate; 		// ��ǰ �뿩����
		int mnumber; 		// ȸ�� ��ȣ
		String mname;		// ȸ�� �̸�
		String mphone; 		// ȸ�� ��ȭ��ȣ
		String mstatus;		// ȸ�� �뿩����
		String mdate; 		// ȸ�� ����
		
		/* �ý��� �ȳ�â ��� */
		while(true) {
			System.out.println("********�����ڿ� �ý����Դϴ�********");
			System.out.println("1. ��ǰ �߰�");
			System.out.println("2. ��ǰ ����");
			System.out.println("3. ��ǰ ����");
			System.out.println("4. ��ǰ �˻�");
			System.out.println("5. ��ǰ ����Ʈ ���");
			System.out.println("6. ȸ�� �߰�");
			System.out.println("7. ȸ�� ����");
			System.out.println("8. ȸ�� ����");
			System.out.println("9. ȸ�� �˻�");
			System.out.println("10. ȸ�� ����Ʈ ���");
			System.out.println("11. �ý��� ����");
			System.out.print("������ �޴��� ���ڷ� �Է����ּ���: ");
	
			int menu = scan.nextInt(); // �޴� �Է¹ޱ�
			int count = 0; // �˻� ��ǰ �� ȸ�� ������ count ���ִ� ����
			
			switch(menu) {
			/*��ǰ �߰�*/
			case 1: // ��ǰ ���� �Է¹ޱ�
				System.out.print("��ǰ ��ȣ: "); 
				pnumber = scan.nextInt();
				System.out.print("��ǰ �̸�: ");
				pname = scan.next();
				System.out.print("��ǰ �뿩�Ⱓ: ");
				pperiod = scan.nextInt();
				System.out.print("��ǰ �뿩����: ");
				pstatus = scan.next();
				System.out.print("��ǰ �뿩����: ");
				pdate = scan.next();
				// �Է��� ��ǰ�� �迭 plist�� �߰�
				pm.insertProduct(pnumber, pname, pperiod, pstatus, pdate); 
				System.out.println("\n");
				break;
				
			/*��ǰ ����*/
			case 2:
				// ��ǰ ��ȣ �Է¹ޱ�
				System.out.print("������ ��ǰ ��ȣ�� �Է����ּ���: ");
				pnumber = scan.nextInt();
				// ��ǰ �˻�
				for (int i = 0; i < pm.pidx; i++) {
					if(pm.plist[i].getProductNumber() == pnumber) { // �˻��� ��ǰ�� �ִ� ���,
						// �ش� ��ǰ ����	
						pm.deleteProduct(pnumber);		
						count++; // count != 0
					}
				}
				if(count == 0) { // �˻��� ��ǰ�� ���� ���, �ش� �޽��� ���
					System.out.print("�ش� ��ȣ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
				}
				System.out.println("\n");
				break;
				
			/*��ǰ ����*/
			case 3: 
				// ��ǰ ��ȣ �Է¹ޱ�
				System.out.print("������ ��ǰ ��ȣ�� �Է����ּ���: ");	
				pnumber = scan.nextInt();
				// ��ǰ �˻�
				for (int i = 0; i < pm.pidx; i++) {
					if(pm.plist[i].getProductNumber() == pnumber) { // �˻��� ��ǰ�� �ִ� ���,
						// ������ ��ǰ ���� �Է¹ޱ�
						System.out.print("������ ��ǰ �̸�: ");
						pname = scan.next();
						System.out.print("������ ��ǰ �뿩�Ⱓ: ");
						pperiod = scan.nextInt();						
						System.out.print("������ ��ǰ �뿩����: ");
						pstatus = scan.next();						
						System.out.print("������ ��ǰ �뿩����: ");
						pdate = scan.next();
						// �Է¹��� ������ �ش� ��ǰ ���� ����
						pm.editProduct(pnumber, pname, pperiod, pstatus, pdate);
						count++; // count != 0
					}
				}
				if(count == 0) { // �˻��� ��ǰ�� ���� ���, �ش� �޽��� ���
					System.out.print("�ش� ��ȣ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
				}
				System.out.println("\n");
				break;
			
			/*��ǰ �˻�*/
			case 4: 
				// ��ǰ ��ȣ �Է¹ޱ�
				System.out.print("�˻��� ��ǰ ��ȣ�� �Է����ּ���: ");
				pnumber = scan.nextInt();
				// ��ǰ �˻�
				for (int i = 0;i < pm.pidx; i++) {
					if(pm.plist[i].getProductNumber() == pnumber) { // �˻��� ��ǰ�� �ִ� ���, �ش� ��ǰ ���� ���
						System.out.println("��ȣ:" + pm.plist[i].getProductNumber() + "\t\t�̸�:" + pm.plist[i].getProductName() +"\t\t�뿩�Ⱓ:" + pm.plist[i].getProductPeriod() + "\t\t�뿩����:" + pm.plist[i].getProductStatus() + "\t\t�뿩����:" + pm.plist[i].getProductDate());
						count++; // count != 0
					}
				}
				if(count == 0) { // �˻��� ��ǰ�� ���� ���, �ش� �޽��� ���
					System.out.print("�ش� ��ȣ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
				}
				System.out.println("\n");
				break;
			
			/*��ǰ ����Ʈ ���*/	
			case 5:
				for(int i = 0; i < pm.pidx; i++) { // �迭 plist�� ó������ ������ ��ǰ ���� ���
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("��ȣ:" + pm.plist[i].getProductNumber() + "\t\t�̸�:" + pm.plist[i].getProductName() +"\t\t�뿩�Ⱓ:" + pm.plist[i].getProductPeriod() + "\t\t�뿩����:" + pm.plist[i].getProductStatus() + "\t\t�뿩����:" + pm.plist[i].getProductDate());
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
			
			/*ȸ�� �߰�*/
			case 6: // ȸ�� ���� �Է¹ޱ�
				System.out.print("ȸ�� ��ȣ: ");
				mnumber = scan.nextInt();
				System.out.print("ȸ�� �̸�: ");
				mname = scan.next();
				System.out.print("ȸ�� ��ȭ��ȣ: ");
				mphone = scan.next();
				System.out.print("ȸ�� �뿩����: ");
				mstatus = scan.next();
				System.out.print("ȸ�� �뿩����: ");
				mdate = scan.next();
				// �Է��� ȸ���� �迭 mlist�� �߰�
				pm.insertMember(mnumber, mname, mphone, mstatus, mdate);
				System.out.println("\n");
				break;
				
			/*ȸ�� ����*/
			case 7: 
				// ȸ�� ��ȣ �Է¹ޱ�
				System.out.print("������ ȸ�� ��ȣ�� �Է����ּ���: ");
				mnumber = scan.nextInt();
				// ȸ�� �˻�
				for (int i = 0; i < pm.midx; i++) {
					if(pm.mlist[i].getMemberNumber() == mnumber) { // �˻��� ȸ���� �ִ� ���,
						// �ش� ȸ�� ����
						pm.deleteMember(mnumber);			
						count++; // count != 0
					}
				}
				if(count == 0) { // �˻��� ȸ���� ���� ���, �ش� �޽��� ���
					System.out.print("�ش� ��ȣ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
				}
				System.out.println("\n");
				break;
			
			/*ȸ�� ����*/
			case 8: 
				// ȸ�� ��ȣ �Է¹ޱ�
				System.out.print("������ ȸ�� ��ȣ�� �Է����ּ���: ");	
				mnumber = scan.nextInt();
				// ȸ�� �˻�
				for (int i = 0; i < pm.midx; i++) {
					if(pm.mlist[i].getMemberNumber() == mnumber) { // �˻��� ȸ���� �ִ� ���,
						// ������ ȸ�� ���� �Է¹ޱ�
						System.out.print("������ ȸ�� �̸�: ");
						mname = scan.next();
						System.out.print("������ ȸ�� ��ȭ��ȣ: ");
						mphone = scan.next();
						System.out.print("������ ȸ�� �뿩����: ");
						mstatus = scan.next();		
						System.out.print("������ ȸ�� �뿩����: ");
						mdate = scan.next();
						// �Է¹��� ������ �ش� ȸ�� ���� ����
						pm.editMember(mnumber, mname, mphone, mstatus, mdate);
						count++; // count != 0
					}
				}
				if(count == 0) { // �˻��� ȸ���� ���� ���, �ش� �޽��� ���
					System.out.print("�ش� ��ȣ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
				}
				System.out.println("\n");
				break;
		
			/*ȸ�� �˻�*/
			case 9: 
				// ȸ�� ��ȣ �Է¹ޱ�
				System.out.print("�˻��� ȸ�� ��ȣ�� �Է����ּ���: ");
				mnumber = scan.nextInt();
				// ȸ�� �˻�
				for (int i = 0;i < pm.midx; i++) {
					if(pm.mlist[i].getMemberNumber() == mnumber) { // �˻��� ȸ���� �ִ� ���, �ش� ȸ�� ���� ���
						System.out.println("��ȣ:" + pm.mlist[i].getMemberNumber() + "\t\t�̸�:" + pm.mlist[i].getMemberName() +"\t\t��ȭ��ȣ:" + pm.mlist[i].getMemberPhone() + "\t\t�뿩����:" + pm.mlist[i].getMemberStatus() + "\t\t�뿩����:" + pm.mlist[i].getMemberDate());
						count++; // count != 0
					}
				}
				if(count == 0) { // �˻��� ȸ���� ���� ���, �ش� �޽��� ���
					System.out.print("�ش� ��ȣ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
				}
				System.out.println("\n");
				break;
			
			/*ȸ�� ����Ʈ ���*/	
			case 10: 
				for(int i = 0; i < pm.midx; i++) { // �迭 mlist�� ó������ ������ ȸ�� ���� ���
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("��ȣ:" + pm.mlist[i].getMemberNumber() + "\t\t�̸�:" + pm.mlist[i].getMemberName() +"\t\t��ȭ��ȣ:" + pm.mlist[i].getMemberPhone() + "\t\t�뿩����:" + pm.mlist[i].getMemberStatus() + "\t\t�뿩����:" + pm.mlist[i].getMemberDate());
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;
			
			/*�ý��� ����*/
			case 11: 
				System.out.println("�ý����� �����մϴ�.");
				break;
			
			/*�޴��� ���� ���ڸ� �Է��� ���*/	
			default: // �ش� �޽��� ���
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~11 �߿��� �Է����ּ���.");
				System.out.println("\n");
				break;
			}
			// while�� Ż��
			if (menu == 11)
				break;
		} 
		scan.close();
	}	
}
