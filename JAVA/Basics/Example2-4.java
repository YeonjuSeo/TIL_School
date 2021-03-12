import java.util.Scanner;

public class Input_test {
	public static void main(String [] args) {
    //학번, 나이, 이름을 "빈칸으로 구분하여" 입력받고 다시 출력하기
		//학번(문자열) 나이(정수) 이름(문자열)
		Scanner input = new Scanner(System.in);
		String 학번;
		int 나이;
		String name;
		
		System.out.print("학번: ");
		학번=input.next();
		System.out.print("나이: ");
		나이=input.nextInt();
		System.out.print("이름:");
		name = input.next();
		
		System.out.println("안녕하세요! 저는 "+학번+" 학번 "+나이+"살 "+name);
		System.out.println("이라고 합니다! 반갑습니다!");
    
    
    
    //학번, 나이, 이름을 "엔터로 구분하여" 입력받고 다시 출력하기
    //학번(문자열) // 엔터! 나이(정수) // 엔터! 이름(문자열) 엔터!
		Scanner input = new Scanner(System.in);
		
		String 학번;
		int 나이;
		String name;
		
		System.out.println("학번: ");
		학번 = input.nextLine(); //학번(문자열) 까지 들어감
		System.out.println("나이: ");
		나이 = input.nextInt(); // 엔터와 나이(정수) 까지 들어감
		
		String temp = input.nextLine(); //엔터 먹어가기
		
		System.out.println("이름: ");
		//버퍼에 남아있는 엔터가 문자열이라 문자열 입력 이전에 이름에 엔터가 들어간다.
		name = input.nextLine(); //temp가 없다면 문자열 전의 엔터만 들어감
		
		System.out.println("안녕하세요! 저는 "+학번+" 학번 "+나이+"살 ");
		System.out.println("이름은"+name+"이라고 합니다! 반갑습니다!");
	}
}
