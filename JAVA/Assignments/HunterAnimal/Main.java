import java.util.Random;
import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	static int animalNum=0, zooNum=0, days=1, goal;
	static Random rand = new Random(); //왜 static이어야하지?
	//동물 현황 보여주기
	public static void show(동물[] animals) {
		System.out.println("------------Forest---------------");
		for(int i=0;i<animals.length;i++) {
			if(animals[i]==null) {
				System.out.print("X | ");
			}
			else {
				System.out.print(animals[i].이름+" | ");
			}
		}
		System.out.println();
		System.out.println("---------------------------------");
	}
	
	public static void main(String[] args) {
		
		동물[] 숲속 = new 동물[50]; //공간만 만든 것
		int menu;
//		초기 숲속 세팅
		for(int i=0;i<숲속.length;i++) {
			int r = rand.nextInt(4)+1;
			if(r == 1) 숲속[i] = new 강아지("멍멍개"+i);
			if(r == 2) 숲속[i] = new 뱀("꾸물뱀"+i, 10);
			if(r == 3) 숲속[i] = new 독수리("수리"+i,2);
			if(r == 4) 숲속[i] = new 상어("죠스"+i);
			animalNum++;
			
			
		}
		//생성 결과 보여주기
		Main.show(숲속);
		
		//사냥꾼 생성
		
		사냥꾼 hunter = new 사냥꾼();
		for(days=1;days<=10;days++) {
			if(days/3==0) {
				System.out.println("오늘은 서커스단이 오는 날입니다...");
//				동물농장에 있는 모든 동물 팔아서 그 가격 지갑에 더하기
//				동물농장 내용 clear하기
			}
			else {
				hunter.makeGoal();
				while(true) {
					if(animalNum==1) {
						System.out.println("생태계를 위해 한마리는 살려두자...");
						break;
					}
					else if(zooNum==goal) {
						System.out.println("오늘은 충분히 잡았어...");
						break;
					}
					hunter.사냥하기(숲속);
					Main.show(숲속);
					hunter.show();
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
//			사냥꾼의 하루 지출
			hunter.지갑-=15;
//			빠져나간 동물 수의 절반?만큼 새로운 동물 채워넣기
		}
	}
}
// F11 디버그 후 F6 눌러가며 확인하자!
// 띄워야하는 창은 Variables와 Breakpoints