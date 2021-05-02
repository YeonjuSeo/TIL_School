package HunterAnimal;
import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	static int animalNum=20, zooNum=0, days=1;
	static Random rand = new Random();
	static boolean didAnimalWin = false;
	static 사냥꾼 hunter = 사냥꾼.getInstance();
	
	public static int guessWinner() {
		System.out.println("부자가 되고싶은 사냥꾼이 사는 숲속...동물들은 사냥꾼을 쫓아낼 수 있을까요?");
		System.out.println("실패: 0, 성공: 1");
		return input.nextInt();
	}
	
	//동물 현황 보여주기
	public static void show(동물[] animals) {
		boolean isForest=true;
		if(animals.length!=20) isForest = false;
		
		if(isForest==true) System.out.println("--------------------------------------Forest-----------------------------------------");
		else System.out.println("--------------------------------------Zoo-----------------------------------------");
		
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==null) {
				System.out.print("X | ");
			}
			else {
				if(isForest==true) System.out.print(animals[i].이름+" | ");
				else System.out.print(animals[i].이름+"[HP:"+animals[i].getHP()+"] | ");
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
		if(didAnimalWin==true) System.out.println("동물들의 승리!!");
		else System.out.println("사냥꾼의 승리!!");
		if(decision == 0 && !didAnimalWin) {
			System.out.println("예상 적중! 가재는 게 편이죠~");
		}
		else if(decision == 1 && didAnimalWin) {
			System.out.println("예상 적중! 숲은 소중해~");
		}
		else {
			System.out.println("예상 적중 실패! 다음 숲은 어떨까요?");
		}
	}
	
	public static void tryEscape() {
		for(int i=0;i<zooNum;i++) {
			동물 target = hunter.동물농장[i];
			makeDelay(1);
			if(hunter.동물농장[i].도망치기(target.이름)==true) {
				System.out.println(target.이름+"이(가) 도망쳤습니다!");
				target=null;
				target=hunter.동물농장[zooNum-1];
				hunter.동물농장[zooNum-1]=null;
				zooNum--;
			} 
		}
	}
	
	public static void main(String[] args) {
		int decision;
		동물[] 숲속 = new 동물[20];
		
//		초기 숲속 세팅
		for(int i=0;i<숲속.length;i++) {
			int r = rand.nextInt(4)+1;
			if(r == 1) 숲속[i] = new 강아지("멍멍개"+i);
			if(r == 2) 숲속[i] = new 뱀("꾸물뱀"+i);
			if(r == 3) 숲속[i] = new 독수리("수리"+i);
			if(r == 4) 숲속[i] = new 상어("죠스"+i);
		}
		//생성 결과 보여주기
		show(숲속);
			
//		게임 시작
		decision=guessWinner();
		
		for(days=1;days<=5;days++) {
			if(didAnimalWin==true) break;
			System.out.println("["+days+"번째 날]");
			
//			사냥꾼이 돈 버는 날
			if(days%3==0) {
				System.out.println("오늘은 서커스단이 오는 날입니다...");
				show(hunter.동물농장);
				hunter.makeMoney();
			}
			else {
				hunter.makeGoal();
				int goal = hunter.getGoal();
				while(true) {
					if(didAnimalWin==true) break;
					if(hunter.getHunts()==goal || hunter.getShots()==5) {
						if(hunter.getHunts()==goal) System.out.println("오늘은 충분히 잡았어...[wallet : $"+hunter.getWallet()+']');
						else System.out.println("오늘은 영 날이 아니네...[wallet : $"+hunter.getWallet()+']');
						makeDelay(3);
						
//						밤이되면 동물들의 탈출 시도
						if(didAnimalWin==false) {
							int comp=zooNum;
							tryEscape();
							if(comp==zooNum) System.out.println("오늘 밤엔 아무도 탈출하지 않았습니다...");
							makeDelay(3);
							break;
						}
					}
					
//					사냥하는 날
					else {
						hunter.사냥하기(숲속);
						show(hunter.동물농장);
						makeDelay(1);
					}
					
				}
			}
		}
		makeResult(decision);
	}
}
// F11 디버그 후 F6 눌러가며 확인하자!
// 띄워야하는 창은 Variables와 Breakpoints