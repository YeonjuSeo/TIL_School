```Java
//예제 2-9
public class Operator {
	public static void main(String [] args) {
		short a = 0x0011; // 0000 0000 0001 0001
		short b = 0x1110; // 0001 0001 0001 0000
		System.out.println("비트 연산 결과");
		System.out.printf("%04x\n",(a&b));
		System.out.printf("%04x\n",(a|b));
		System.out.printf("%04x\n",(a^b));
		System.out.printf("%04x\n",(short)(~a));
		
		byte c = 20; // 0x14, 0001 0100
		byte d = -8; // 1000 0000 0000 0000 0000 0000 0000 1000
		System.out.println("시프트 연산 결과");
		System.out.println(c <<2); 
		System.out.println(c >>2); // 0 삽입
		System.out.println(d >>2); // 1 삽입, 0xfe -> -2
		System.out.println(d<<2); 
		System.out.println(Integer.toBinaryString(d<<2));
		System.out.printf("%x\n",d>>>2); // 0 삽입
		System.out.println(Integer.toBinaryString(d>>>2));
	}
}
```

### 질문 사항
Q. 음수를 가지고 시프트 연산을 할 때 부호를 유지하기 위해 1을 삽입한다는 내용이 잘 이해가 가지 않습니다. 앞자리가 1이면 음수라는 뜻인건가요?<br/>
A. 이진수를 표현할 때 가장 앞부분의 0들은 생략하기도 하며 음수를 표현할 때 사용하는 보수 개념을 안다면 더 이해하기 쉬울 것.

*보수 개념 참고: https://m.blog.naver.com/beaqon/221253413701
