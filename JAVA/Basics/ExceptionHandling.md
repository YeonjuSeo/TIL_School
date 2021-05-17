*오류(Error)
  - 컴파일 전에 알 수 있음
  - 원인: 하드웨어의 잘못된 동작/고장
  - 정상 실행 상태로 돌아갈 수 없음
  - 오류 발생 시 프로그램 종료
  
# 예외(Exception)
- 컴파일 전에 알 수 없음. 실행 중에 발생.(돌려봐야 안다.)
- 원인: 사용자의 잘못된 조작 or 개발자의 잘못된 코딩
- 예외 처리 추가 ➡ 정상 실행 상태로 복귀 가능
- 예외 발생 시 프로그램 종료
<br/><br/>
- 예시
  - **유효범위 초과한 배열의 인덱스**
  - **0으로 나누기**
  - 존재하지 않는 파일 읽기 시도, 장치 사용 불가
  - 잘못된 입력

*일반 예외(Exception)은 예외 처리 코드가 없으면 컴파일 오류가 발생하나 실행 예외(RuntimeException)은 예외 처리 코드를 생략해도 컴파일이 된다.
<br/><br/>

# 예외처리_try-throw-catch-finally 블록 구조
<details>
<summary>수업 중 실습 코드 full</summary>
<div markdown="1">
  
```Java
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

```
</div>
</details>

- Try 블록: 예외 발생 가능성이 있는 코드 작성. 이 블록 내에서 예외 상황이 발생하면 Exception 객체가 throw된다.
- Catch 블록: Exception 객체에 대한 제어가 이동해옴.
  - 모든 Catch 블록은 연관되는 Try 블록이 반드시 존재해야함
  - Catch 블록의 코드가 시랳ㅇ된 후 catch 블록 다음에 이어지는 문장을 계속 수행
- Finally 블록: 오류 발생 여부와 **관계없이 공통적으로** 수행되는 코드. 생략 가능.
<br/><br/>
- **Try 코드의 오류가 catch에서 잘 잡히면 Main코드에서 종료되나 그렇지 않으면 Finally에서 종료된다.**
- 모든 예외는 전달되는(throw) 과정이 있지만, 모든 예외가 명시적인 throw문을 필요로 하는 것은 아니다.

*모든 오류를 잡을 수 있는 최상위 클래스: Exception. 하지만 정확히 어떤 이유로 비정상 종료되었는지 알 수 없으므로 이것 하나만 사용하는 것은 X.
