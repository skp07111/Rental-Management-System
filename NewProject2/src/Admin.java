/*UI Ŭ����*/
import java.util.Scanner; // Scanner Ŭ����
import java.util.Date;
import java.util.InputMismatchException;

public class Admin {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); // scan ��ü ����
		ProductManager pm = new ProductManager(); // pm ��ü ����
		
		/* �ý��� �ȳ�â ��� */
		while(true) {
			System.out.println("********��Ż ���� �ý��� �����Դϴ�********");
			System.out.println("1. �����ڿ� �ý���\t2. ���� �ý���\t3.�ý��� ����");
			System.out.print("������ �ý����� �������ּ���(���ڷ� �Է�): ");
			int system = scan.nextInt();
			if (system == 1) {
				System.out.println("\n");
				System.out.println("[�����ڿ� �ý���]");
				System.out.println("1. ��ǰ �߰�");
				System.out.println("2. ��ǰ �˻�");
				System.out.println("3. ��ǰ ����");
				System.out.println("4. ��ǰ ����Ʈ ���");
				System.out.println("5. ȸ�� �߰�");
				System.out.println("6. ȸ�� �˻�");
				System.out.println("7. ȸ�� ����");
				System.out.println("8. ȸ�� ����Ʈ ���");
				System.out.println("9. �뿩 ��� ���");
				System.out.println("10. ���� ���� Ȯ��");
				System.out.println("11. �������� ���ư���");
				System.out.print("������ �޴��� �������ּ���(���ڷ� �Է�): ");
				
				int menu = scan.nextInt(); // �޴� �Է¹ޱ�
				
				switch(menu) {
				/*��ǰ �߰�*/
				case 1: // ��ǰ ���� �Է¹ޱ�
					Product p = new Product();
					System.out.print("��ǰ �ڵ�: ");
					String pcode = scan.next();
					try {
						pm.searchProduct(pcode);
						System.out.println("�̹� �����ϴ� ��ǰ �ڵ��Դϴ�.");
					} 
					catch(MyException e) {
						p.setProductCode(pcode);
						System.out.print("��ǰ �̸�: ");
						p.setProductName(scan.next());
						System.out.print("��ǰ ����: ");
						int amount = scan.nextInt();
						p.setProductStock(amount);
						p.setProductAmount(amount);
						System.out.print("1�� �뿩��: ");
						p.setRentalFee(scan.nextInt());
						System.out.print("1�� ��ü��: ");
						p.setLateFee(scan.nextInt());
						// �Է��� ��ǰ�� �迭�� �߰�
						pm.insertProduct(p); 
					}
					System.out.println("\n");
					break;
					
				/*��ǰ �˻�*/
				case 2:
					System.out.print("�˻��� ��ǰ �ڵ带 �Է����ּ���: ");
					try {
						int idx = pm.searchProduct(scan.next());
						p = pm.productAt(idx);
						System.out.println("��ǰ�� �˻��Ǿ����ϴ�.");
						System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount());
					} 
					catch(MyException e) {
						System.err.println("�ش� �ڵ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
					}
					break;
					
				/*��ǰ ����*/
				case 3:
					// ��ǰ �ڵ� �Է¹ޱ�
					System.out.print("������ ��ǰ �ڵ带 �Է����ּ���: ");
					try {
						int idx = pm.searchProduct(scan.next());
						pm.deleteProduct(idx);
					}
					catch(MyException e) {
						System.out.println("�ش� �ڵ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
					}
					System.out.println("\n");
					break;
					
				/*��ǰ ����Ʈ ���*/	
				case 4:
					for(int i = 0; i < pm.getPcount(); i++) { // �迭�� ó������ ������ ��ǰ ���� ���
						p = pm.productAt(i);
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount());
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					break;
					
				/*ȸ�� �߰�*/	
				case 5: // ȸ�� ���� �Է¹ޱ�
					Member m = new Member();
					System.out.print("ȸ�� �ڵ�: ");
					String mcode = scan.next();
					try {
						pm.searchMember(mcode);
						System.out.println("�̹� �����ϴ� ȸ�� �ڵ��Դϴ�.");
					}
					catch(MyException e) {
						m.setMemberCode(mcode);
						System.out.print("ȸ�� �̸�: ");
						m.setMemberName(scan.next());
						System.out.print("ȸ�� ��ȭ��ȣ: ");
						m.setMemberPhone(scan.next());
						System.out.print("ȸ�� �뿩�Ⱓ: ");
						m.setMemberPeriod(scan.nextInt());
						// �Է��� ȸ���� �迭�� �߰�
						pm.insertMember(m); 
					}
					System.out.println("\n");
					break;
					
				/*ȸ�� �˻�*/
				case 6:
					System.out.print("�˻��� ȸ�� �ڵ带 �Է����ּ���: ");
					try {
						int idx = pm.searchMember(scan.next());
						m = pm.memberAt(idx);
						System.out.println("ȸ���� �˻��Ǿ����ϴ�.");
						System.out.println("ȸ���ڵ�:" + m.getMemberCode() + "\t\t�̸�:" + m.getMemberName() +"\t\t��ȭ��ȣ:" + m.getMemberPhone() + "\t\t�뿩�Ⱓ:" + m.getMemberPeriod());
						System.out.print("�뿩 ��ǰ �ڵ�: ");
						for (int j = 0; j < 3; j++) {
							System.out.print(m.getRentArray(j) + "\t");
						}
					} 
					catch(MyException e) {
						System.err.println("�ش� �ڵ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
					}
					System.out.println("\n");
					break;	
					
				/*ȸ�� ����*/
				case 7:
					// ȸ�� �ڵ� �Է¹ޱ�
					System.out.print("������ ȸ�� �ڵ带 �Է����ּ���: ");
					try {
						int idx = pm.searchMember(scan.next());
						pm.deleteMember(idx);
					}
					catch (MyException e) {
						System.out.println("�ش� �ڵ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
					}
					System.out.println("\n");
					break;

				
				/*ȸ�� ����Ʈ ���*/	
				case 8:
					for(int i = 0; i < pm.getMcount(); i++) { // �迭�� ó������ ������ ȸ�� ���� ���
						m = pm.memberAt(i);
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						System.out.println("ȸ���ڵ�:" + m.getMemberCode() + "\t\t�̸�:" + m.getMemberName() +"\t\t��ȭ��ȣ:" + m.getMemberPhone() + "\t\t�뿩����:" + m.getMemberDate());
						System.out.print("�뿩 ��ǰ �ڵ�: ");
						for (int j = 0; j < 3; j++) {
							System.out.print(m.getRentArray(j));
							if (j < 2)
								System.out.print(",");
						}
						System.out.println("");
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					break;
			
				
				/*�뿩 ����Ʈ ���*/	
				/*case 9:
					for(int i = 0; i < pm.getMcount(); i++) { // �迭�� ó������ ������ ȸ�� ���� ���
						m = pm.memberAt(i);
						if (m.getMemberDate() != null) {
							System.out.println("---------------------------------------------------------------------------------------------------------------------");
							System.out.println("�뿩�� ȸ���ڵ�:" + m.getMemberCode() + "\t\t�뿩�� ��ǰ�ڵ�:" + m.getMemberPcode() + "\t\t�뿩����:" + m.getMemberDate());
						}
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					break;*/
					
				
				/*���� ���� ���*/	
				case 10:
					System.out.print("������ ����: "+ pm.getSales());
					System.out.println("��");
					System.out.println("\n");
					break;
						
				/*�������� ���ư���*/
				case 11: 
					System.out.println("\n");
					break;
	
				/*�޴��� ���� ���ڸ� �Է��� ���*/	
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~4 �߿��� �Է����ּ���.");
					System.out.println("\n");
					break;			
				}	
			}
			else if (system == 2) {
				System.out.println("\n");
				System.out.println("[���� �ý���]");
				System.out.println("1. ��ǰ ����Ʈ ���");
				System.out.println("2. ��ǰ �뿩");
				System.out.println("3. ��ǰ �ݳ�");
				System.out.println("4. �������� ���ư���");
				System.out.print("������ �޴��� ���ڷ� �Է����ּ���: ");
		
				int menu = scan.nextInt(); // �޴� �Է¹ޱ�
				
				switch(menu) {
				/*��ǰ ����Ʈ ���*/	
				case 1:
					Product p = new Product();
					for(int i = 0; i < pm.getPcount(); i++) { // �迭�� ó������ ������ ��ǰ ���� ���
						p = pm.productAt(i);
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount());
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					break;
					
				/*��ǰ �뿩*/
				case 2:
					System.out.print("ȸ�� �ڵ带 �Է����ּ���: ");
					try {
						int midx = pm.searchMember(scan.next()); // ȸ�� �ڵ� �˻�
						for (int i = 0; i < 3; i++) {
							System.out.print("�뿩�� ��ǰ �ڵ带 �Է����ּ���: ");
							try {
								String pcode = scan.next();
								int pidx = pm.searchProduct(pcode);
								if (pm.productAt(pidx).getProductStock() == 0) System.out.println("�ش� ��ǰ�� ��� �����ϴ�.");
								else {
									pm.rentalProduct(midx, pidx, pcode);
									System.out.println("��ǰ�� �뿩�Ǿ����ϴ�.");
								}
							} 
							catch(MyException e) {
								System.err.println("�ش� �ڵ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
							}
						}
					}
					catch(MyException e) {
						System.err.println("�ش� �ڵ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
					}
					System.out.println("\n");
					break;
					
				/*��ǰ �ݳ�*/
				case 3:
					System.out.print("ȸ�� �ڵ带 �Է����ּ���: ");
					try {
						int midx, pidx;
						String pcode;
						Date today = new Date();
						midx = pm.searchMember(scan.next());
						System.out.println("ȸ������ �뿩 �Ⱓ�� "+ pm.memberAt(midx).calculate(today) + "�� �Դϴ�.");
						for (int i = 0; i < 3; i++) {
							pcode = pm.memberAt(midx).getRentArray(i);
							pidx = pm.searchProduct(pcode);
							pm.returnProduct(midx, pidx, today);
						}
						System.out.println("��ǰ�� ��� �ݳ��Ǿ����ϴ�.");
						for (int i = 0; i <3; i++) {
							pm.memberAt(midx).resetRentArray(i, null);
						}
						pm.memberAt(midx).setMemberDate(null);
					}
					catch(MyException e) {
						System.err.println("�ش� �ڵ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
					}
					System.out.println("\n");
					break;
				
				/*�������� ���ư���*/
				case 4: 
					System.out.println("\n");
					break;
				
				/*�޴��� ���� ���ڸ� �Է��� ���*/	
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~4 �߿��� �Է����ּ���.");
					System.out.println("\n");
					break;
				
				} 
			}
			else if (system == 3) {// �ý��� ����(while�� Ż��)
				System.out.println("�ý����� �����մϴ�.");
				break;
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~3 �߿��� �Է����ּ���.");
				System.out.println("\n");
			}
		}
		scan.close();
	}
}
			