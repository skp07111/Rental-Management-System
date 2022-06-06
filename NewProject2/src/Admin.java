/*������ UI Ŭ����*/
import java.util.Scanner; // Scanner Ŭ����

public class Admin {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); // scan ��ü ����
		ProductManager pm = new ProductManager(); // pm ��ü ����
		
		/* �ý��� �ȳ�â ��� */
		while(true) {
			try {
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
				System.out.println("10. �������� ���ư���");
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
						System.out.print("��ǰ �뿩�Ⱓ: ");
						p.setProductPeriod(scan.nextInt());
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
						System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount() +"\t\t�뿩�Ⱓ:" + p.getProductPeriod());
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
						System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount() +"\t\t�뿩�Ⱓ:" + p.getProductPeriod());
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
						pm.searchProduct(mcode);
						System.out.println("�̹� �����ϴ� ȸ�� �ڵ��Դϴ�.");
					}
					catch(MyException e) {
						m.setMemberCode(mcode);
						System.out.print("ȸ�� �̸�: ");
						m.setMemberName(scan.next());
						System.out.print("ȸ�� ��ȭ��ȣ: ");
						m.setMemberPhone(scan.next());
						m.setMemberDate(null);
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
						System.out.print("ȸ���ڵ�:" + m.getMemberCode() + "\t\t�̸�:" + m.getMemberName() +"\t\t��ȭ��ȣ:" + m.getMemberPhone() + "\t\t�뿩����:" + m.getMemberDate() + "\t\t�뿩��ǰ�ڵ�:");
						for (int j = 0; j < 3; j++) {
							System.out.print("\t" + m.getRentArray(j));
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
						System.out.print("ȸ���ڵ�:" + m.getMemberCode() + "\t\t�̸�:" + m.getMemberName() +"\t\t��ȭ��ȣ:" + m.getMemberPhone() + "\t\t�뿩����:" + m.getMemberDate() + "\t\t�뿩��ǰ�ڵ�:");
						for (int j = 0; j < 3; j++) {
							System.out.print("\t"+ m.getRentArray(j));
						}
						System.out.println("");
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					break;
			
				
				/*�뿩 ����Ʈ ���*/	
				/*case 8:
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
				
				/*��¥ ���*/
				/*case 9:
					System.out.println("ȸ�� �ڵ带 �Է��ϼ���");
					System.out.println("ȸ������ �뿩 �Ⱓ�� "+ pm.calculate(scan.next()) + "�� �Դϴ�.");*/
					
					
				/*�ý��� ����*/
				case 10: 
					System.out.println("�ý����� �����մϴ�.");
					break;
						
				
				/*�޴��� ���� ���ڸ� �Է��� ���*/	
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~4 �߿��� �Է����ּ���.");
					System.out.println("\n");
					break;			
				}	
				if (menu == 10) // while�� Ż��
						break;
			}
			else if (system == 2) {
				System.out.println("\n");
				System.out.println("[���� �ý���]");
				System.out.println("1. ��ǰ ����Ʈ ���");
				System.out.println("2. ��ǰ �뿩");
				System.out.println("3. ��ǰ �ݳ�");
				System.out.println("4. �ý��� ����");
				System.out.print("������ �޴��� ���ڷ� �Է����ּ���: ");
		
				int menu = scan.nextInt(); // �޴� �Է¹ޱ�
				
				switch(menu) {
				/*��ǰ ����Ʈ ���*/	
				case 1:
					Product p = new Product();
					for(int i = 0; i < pm.getPcount(); i++) { // �迭�� ó������ ������ ��ǰ ���� ���
						p = pm.productAt(i);
						System.out.println("---------------------------------------------------------------------------------------------------------------------");
						System.out.println("�ڵ�:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount() +"\t\t�뿩�Ⱓ:" + p.getProductPeriod());
					}
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("\n");
					break;
					
					/*��ǰ ��Ʈ*/
					case 2:
						System.out.print("ȸ�� �ڵ带 �Է����ּ���: ");
						try {
							Member m = new Member();
							int midx = pm.searchMember(scan.next()); // ȸ�� �ڵ� �˻�
							m = pm.memberAt(midx);
							System.out.print("�뿩�� ��ǰ �ڵ带 �Է����ּ���: ");
							String pcode = scan.next();
							try {
									int pidx = pm.searchProduct(pcode);
									p = pm.productAt(pidx);
									if (p.getProductStock() == 0) System.out.println("�ش� ��ǰ�� ��� �����ϴ�.");
									else {
										pm.rentalProduct(pcode, m, p);
										System.out.println("��ǰ�� �뿩�Ǿ����ϴ�.");
									}
								} 
							catch(MyException e) {
								System.err.println("�ش� �ڵ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
							}
						}
						catch(MyException e) {
							System.err.println("�ش� �ڵ�� ��ġ�ϴ� ȸ���� �����ϴ�.");
						}
						System.out.println("\n");
						break;
						
						/*System.out.print("ȸ�� �ڵ带 �Է����ּ���: ");
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
								m.setRentDate(); // ���� ��¥ ����
								System.out.print(m.getMemberDate()); // ���� ��¥ ���
								System.out.println(" �Է��Ͻ� ��ǰ�� �뿩�� �Ϸ�Ǿ����ϴ�.");
								m.setMemberDate(m.getMemberDate()); // ���� ��¥ ��������
								int pidx = pm.searchProduct(code); 
								p = pm.productAt(pidx); // �Է��� ��ǰ �ڵ忡 �ش��ϴ� ��ǰ p
								p.setProductDate(m.getMemberDate()); // ��ǰ p�� ���� ��¥�� �뿩���ڷ� ����
							}
						}
						System.out.println("\n");
						break;*/
						
					
				/*�ý��� ����*/
				/*case 3: 
					System.out.println("�ý����� �����մϴ�.");
					break;*/
					
				
				/*�޴��� ���� ���ڸ� �Է��� ���*/	
				default:
					System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~4 �߿��� �Է����ּ���.");
					System.out.println("\n");
					break;
				
				} 
			}
			else if (system == 3) // �ý��� ����(while�� Ż��)
				break;
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~3 �߿��� �Է����ּ���.");
				System.out.println("\n");
			}
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("�ִ� �Է� ������ �ʰ��� �� �����ϴ�");
			}
		}
		scan.close();
	}
}
			