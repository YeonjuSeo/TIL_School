import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	static int animalNum=0, zooNum=0, days=1, goal;
	static Random rand = new Random(); //�� static�̾������?
	//���� ��Ȳ �����ֱ�
	public static void show(����[] animals) {
		System.out.println("------------Forest---------------");
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==null) {
				System.out.print("X | ");
			}
			else {
				System.out.print(animals[i].�̸�+" | ");
			}
		}
		System.out.println();
		System.out.println("---------------------------------");
	}
	
	public static void main(String[] args) {
		
		����[] ���� = new ����[50]; //������ ���� ��
		int menu;
//		�ʱ� ���� ����
		for(int i=0;i<����.length;i++) {
			int r = rand.nextInt(4)+1;
			if(r == 1) ����[i] = new ������("�۸۰�"+i);
			if(r == 2) ����[i] = new ��("�ٹ���"+i, 10);
			if(r == 3) ����[i] = new ������("����"+i,2);
			if(r == 4) ����[i] = new ���("�ҽ�"+i);
			animalNum++;
			
			
		}
		//���� ��� �����ֱ�
		Main.show(����);
		
		//��ɲ� ����
		
		��ɲ� hunter = new ��ɲ�();
		for(days=1;days<=10;days++) {
			if(days/3==0) {
				System.out.println("������ ��Ŀ������ ���� ���Դϴ�...");
//				�������忡 �ִ� ��� ���� �ȾƼ� �� ���� ������ ���ϱ�
//				�������� ���� clear�ϱ�
			}
			else {
				hunter.makeGoal();
				while(true) {
					if(animalNum==1) {
						System.out.println("���°踦 ���� �Ѹ����� �������...");
						break;
					}
					else if(zooNum==goal) {
						System.out.println("������ ����� ��Ҿ�...");
						break;
					}
					hunter.����ϱ�(����);
					Main.show(����);
					hunter.show();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
//			��ɲ��� �Ϸ� ����
			hunter.����-=15;
//			�������� ���� ���� ����?��ŭ ���ο� ���� ä���ֱ�
		}
	}
}
// F11 ����� �� F6 �������� Ȯ������!
// ������ϴ� â�� Variables�� Breakpoints