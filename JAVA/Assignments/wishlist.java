import java.util.Scanner;

public class List {
	public static void main(String [] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		String name, temp;
		long price, sum=0;
		System.out.println("몇 개를 입력할까요?");
		n = scanner.nextInt();
		
		for(int i=0;i<n;i++) {
			temp=scanner.nextLine();
			System.out.print((i+1)+"번째 품목: ");
			name = scanner.nextLine();
			System.out.print((i+1)+"번째 품목의 가격: ");
			price = scanner.nextInt();
			sum+=price;
		}
		System.out.println("총 필요한 금액 : "+sum + "원입니다.");
	}
}
