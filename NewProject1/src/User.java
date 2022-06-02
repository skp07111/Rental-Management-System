/*����� UI Ŭ����*/
import java.util.Scanner; // Scanner Ŭ����


public class User {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in); // scan ��ü ����
		ProductManager pm = new ProductManager(); // pm ��ü ����
		Product p = new Product();
		Member m = new Member();

		
		/* �ý��� �ȳ�â ��� */
		while(true) {
			System.out.println("********���� �ý����Դϴ�********");
			System.out.println("1. ��ǰ ����Ʈ ���");
			System.out.println("2. ��ǰ ��Ʈ");
			System.out.println("3. �ý��� ����");
			System.out.print("������ �޴��� ���ڷ� �Է����ּ���: ");
	
			int menu = scan.nextInt(); // �޴� �Է¹ޱ�
			
			switch(menu) {
			/*��ǰ ����Ʈ ���*/	
			case 1:
				for(int i = 0; i < pm.getPcount(); i++) { // �迭�� ó������ ������ ��ǰ ���� ���
					p = pm.productAt(i);
					System.out.println("---------------------------------------------------------------------------------------------------------------------");
					System.out.println("��ȣ:" + p.getProductCode() + "\t\t�̸�:" + p.getProductName() +"\t\t���:" + p.getProductStock() + " / " + p.getProductAmount() +"\t\t�뿩�Ⱓ:" + p.getProductPeriod() + "\t\t�뿩����:" + p.getProductDate());
				}
				System.out.println("---------------------------------------------------------------------------------------------------------------------");
				System.out.println("\n");
				break;

			/*��ǰ ��Ʈ*/
			case 2:
				System.out.print("ȸ�� ��ȣ�� �Է����ּ���: ");
				int midx = -1;
				midx = pm.searchMember(scan.next());
				if (midx == -1) 
					System.out.println("�Է��Ͻ� ȸ�� ��ȣ�� �������� �ʽ��ϴ�.");
				else {
					System.out.print("��Ʈ�� ��ǰ ��ȣ�� �Է����ּ���: ");
					String pcode = scan.next();
					if (pm.rentalProduct(pcode) == false) 
						 System.out.println("�Է��Ͻ� ��ǰ ��ȣ�� ��ġ�ϴ� ��ǰ�� �����ϴ�.");
					else {
						m = pm.memberAt(midx);
						m.setMemberPcode(pcode);
						System.out.print(m.getToday());
						System.out.println(" �Է��Ͻ� ��ǰ�� �뿩�� �Ϸ�Ǿ����ϴ�.");
						m.setMemberDate(m.getToday());
						int pidx = pm.searchProduct(pcode);
						p = pm.productAt(pidx);
						p.setProductDate(m.getToday());
					}
				}
				System.out.println("\n");
				break;
			
			/*�ý��� ����*/
			case 3: 
				System.out.println("�ý����� �����մϴ�.");
				break;
				
			
			/*�޴��� ���� ���ڸ� �Է��� ���*/	
			default:
				System.out.println("�߸� �Է��ϼ̽��ϴ�. ���� 1~4 �߿��� �Է����ּ���.");
				System.out.println("\n");
				break;
			}
			if (menu == 3) // while�� Ż��
				break;
		} 
		scan.close();
	}	
}
