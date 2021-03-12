//예제 2-14
import java.util.Scanner;

public class Comparison {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String grade;
		
		System.out.println("접수를 입력하세요(0~120): ");
		int score = input.nextInt();
		switch(score/10) {
		case 12:
		case 11:
		case 10:
			grade="A+";
			break;
		case 9:
			grade="A";
			break;
		case 8:
			grade ="B";
			break;
		case 7:
			grade="C";
			break;
		case 6:
			grade="D";
			break;
		default:
			grade="F";
		}
		System.out.println("학점은 "+grade+"입니다.");
	}
}
