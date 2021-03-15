import java.util.Scanner;
//내 맘대로 구구단
public class Table {
	public static void main(String [] args) {
		String choice;
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("홀수단을 출력할까요 짝수단을 출력할까요?(홀수/짝수/종료)");
			choice = input.nextLine();
			if(choice.equals("종료")) break;
			if(!choice.equals("홀수") && !choice.equals("짝수")) {
				System.out.println("뭔가 실수가 있었나봐요! 다시 입력해주세요!");
				continue;
			}
			if(choice.equals("홀수")) {
				for(int i=1;i<=9;i+=2) {
					for(int j=1;j<=9;j++) {
						System.out.println(i+"*"+j+" = "+i*j);
					}
					System.out.println("\n");
				}
			}
			else {
				for(int i=2;i<=9;i+=2) {
					for(int j=1;j<=9;j++) {
						System.out.println(i+"*"+j+" = "+i*j);
					}
					System.out.println("\n");
				}
			}
		}
		
	}
}
