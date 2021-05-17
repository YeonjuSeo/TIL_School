package 예외처리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//기존 문자열 배열
		String [] sr = {"aaa","bbb","ccc","ddd"};
		int num1=0, num2=0;
		Scanner input = new Scanner(System.in);
		try {
			sr[100]="eeee"; //여기서 문제가 발생됐으므로 블록의 아래 내용은 실행되지 않음!
			System.out.println("정수를 입력하세요!");
			num1 = input.nextInt();
			System.out.println("정수를 입력하세요!");
			num2 = input.nextInt();
			num1=num1/num2;
			
		} catch(ArrayIndexOutOfBoundsException e) {
			//배열이므로 추가가 안돼서 맨 마지막 걸로 대체
			sr[sr.length-1]="eeee";
			//에러임을 알리고 종료
			System.out.println("인덱스 초과 에러! 확인하세요!");
		} catch(InputMismatchException e) {
			System.out.println("숫자 형태의 데이터를 넣어야합니다!");
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다!");
		} catch(Exception e){
			//위에서 알아내지 못한 원인에 대한 예외는 여기서 잡힐 수 있도록한다.
			//이것 하나만 넣으면 정확히 어떤 이유로 비정상 종료되었는지 알 수 없으므로 좋지 않다.
		}finally {
			//예외가 잡히지 않을 경우 finally에서 종료
			//예외가 잡히지 않아도 여기까지 실행되기 때문.
			//예외 유무와 관계없이 꼭 실행되고 넘어가야할 필요가 있을 때 finally 작성
			System.out.println("예외가 발생하든 안하든 공통적으로 실행");
		}
		//예외가 잡히면 여기 Main에서 종료
		//예외가 잡히지 않으면 이 문장은 출력되지 않는다.
		System.out.println("이 문장이 출력 될까요?");  
	}

}
