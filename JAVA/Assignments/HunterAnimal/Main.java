package HunterAnimal;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	static int animalNum=20, zooNum=0, days=1;
	static Random rand = new Random();
	static boolean didAnimalWin = false;
	static ��ɲ� hunter = ��ɲ�.getInstance();
	
	public static int guessWinner() {
		System.out.println("���ڰ� �ǰ���� ��ɲ��� ��� ����...�������� ��ɲ��� �ѾƳ� �� �������?");
		System.out.println("����: 0, ����: 1");
		return input.nextInt();
	}
	
	//���� ��Ȳ �����ֱ�
	public static void show(����[] animals) {
		boolean isForest=true;
		if(animals.length!=20) isForest = false;
		
		if(isForest==true) System.out.println("--------------------------------------Forest-----------------------------------------");
		else System.out.println("--------------------------------------Zoo-----------------------------------------");
		
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==null) {
				System.out.print("X | ");
			}
			else {
				if(isForest==true) System.out.print(animals[i].�̸�+" | ");
				else System.out.print(animals[i].�̸�+"[HP:"+animals[i].getHP()+"] | ");
			}
			if((i+1)%10==0) System.out.println();
		}
		System.out.println("-------------------------------------------------------------------------------------");
	}
	
	public static void makeDelay(int n) {
		for(int i=0;i<n;i++) {
			if(n!=1) System.out.print(".  ");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	public static void makeResult(int decision) {
		if(didAnimalWin==true) System.out.println("�������� �¸�!!");
		else System.out.println("��ɲ��� �¸�!!");
		if(decision == 0 && !didAnimalWin) {
			System.out.println("���� ����! ����� �� ������~");
		}
		else if(decision == 1 && didAnimalWin) {
			System.out.println("���� ����! ���� ������~");
		}
		else {
			System.out.println("���� ���� ����! ���� ���� ����?");
		}
	}
	
	public static void tryEscape() {
		for(int i=0;i<zooNum;i++) {
			���� target = hunter.��������[i];
			makeDelay(1);
			if(hunter.��������[i].����ġ��(target.�̸�)==true) {
				System.out.println(target.�̸�+"��(��) �����ƽ��ϴ�!");
				target=null;
				target=hunter.��������[zooNum-1];
				hunter.��������[zooNum-1]=null;
				zooNum--;
			} 
		}
	}
	
	public static void main(String[] args) {
		int decision;
		����[] ���� = new ����[20];
		
//		�ʱ� ���� ����
		for(int i=0;i<����.length;i++) {
			int r = rand.nextInt(4)+1;
			if(r == 1) ����[i] = new ������("�۸۰�"+i);
			if(r == 2) ����[i] = new ��("�ٹ���"+i);
			if(r == 3) ����[i] = new ������("����"+i);
			if(r == 4) ����[i] = new ���("�ҽ�"+i);
		}
		//���� ��� �����ֱ�
		show(����);
			
//		���� ����
		decision=guessWinner();
		
		for(days=1;days<=5;days++) {
			if(didAnimalWin==true) break;
			System.out.println("["+days+"��° ��]");
			
//			��ɲ��� �� ���� ��
			if(days%3==0) {
				System.out.println("������ ��Ŀ������ ���� ���Դϴ�...");
				show(hunter.��������);
				hunter.makeMoney();
			}
			else {
				hunter.makeGoal();
				int goal = hunter.getGoal();
				while(true) {
					if(didAnimalWin==true) break;
					if(hunter.getHunts()==goal || hunter.getShots()==5) {
						if(hunter.getHunts()==goal) System.out.println("������ ����� ��Ҿ�...[wallet : $"+hunter.getWallet()+']');
						else System.out.println("������ �� ���� �ƴϳ�...[wallet : $"+hunter.getWallet()+']');
						makeDelay(3);
						
//						���̵Ǹ� �������� Ż�� �õ�
						if(didAnimalWin==false) {
							int comp=zooNum;
							tryEscape();
							if(comp==zooNum) System.out.println("���� �㿣 �ƹ��� Ż������ �ʾҽ��ϴ�...");
							makeDelay(3);
							break;
						}
					}
					
//					����ϴ� ��
					else {
						hunter.����ϱ�(����);
						show(hunter.��������);
						makeDelay(1);
					}
					
				}
			}
		}
		makeResult(decision);
	}
}
// F11 ����� �� F6 �������� Ȯ������!
// ������ϴ� â�� Variables�� Breakpoints