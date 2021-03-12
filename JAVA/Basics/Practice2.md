```Java
//수업 중 실습

import java.util.Scanner;
//학번, 나이, 이름을 "빈칸으로 구분하여" 입력받고 다시 출력하기
public class Input_test {
	public static void main(String [] args) {
		String 학번, 이름;
		int 나이;
		float happyScore;
		boolean isCorrect=true;
		Scanner input = new Scanner(System.in);
		while(true) {
			String temp = "aaaa";
			
			System.out.println("학번: "); //문자열
			학번 = input.nextLine();
			System.out.println("나이: "); //엔터 문자열
			나이 = input.nextInt();
			
			if(input.hasNextLine()) {
				temp = input.nextLine(); //엔터
				System.out.println("temp1: "+ temp +"길이: "+ temp.length());
			}
			
			System.out.println("이름: ");
			이름 = input.nextLine(); //문자열
			System.out.println("오늘 기분은 어떠세요?(10점만점): ");
			happyScore = input.nextFloat(); //엔터 실수
			
			if(input.hasNextLine()) {
				temp = input.nextLine(); //엔터
				System.out.println("temp2: "+ temp+"길이: "+temp.length());
			}
			
			System.out.println("입력 정보를 확인하세요.");
			System.out.println("----------------------");
			System.out.println("이름: "+이름);
			System.out.println("나이: "+나이);
			System.out.println("학번: "+학번);
			System.out.println("오늘 기분이 얼마나 좋나요?: "+happyScore);
			System.out.println("\n입력한 정보가 모두 맞나요?");
			isCorrect = input.nextBoolean(); //불리언
			
			if(input.hasNextLine()) {
				temp = input.nextLine();
				System.out.println("temp3: "+ temp+"길이: "+temp.length()); //엔터
			}
			
			if(isCorrect == true) {
				break;
			}
		}
	}
}
```

### 질문 사항
Q. temp에는 \n이 들어간다고 생각했으나 temp와 그 temp.length()를 출력해보면 각각 빈칸과 0이 나온다. <br/>'\n'를 변수에 입력하고 동일하게 출력해보면 그대로 줄바꿈과 길이 1이 출력되는데 temp는 그렇지 않은 이유는 무엇일까?
<br/>A. length()는 널문자(\0) 전까지의 캐릭터를 헤아린다. 또한 단순히 '\n'을 입력한 것과 문자열 입력의 종료 시그널로서의 엔터는 다른 것이기 때문이다. 
