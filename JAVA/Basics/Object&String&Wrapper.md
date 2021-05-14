# Object 클래스
;모든 클래스의 수퍼 클래스<br/>
➡ 모든 클래스에 강제 상속<br/>
➡ 모든 객체가 공통으로 가지는 객체의 속성을 나타내는 메소드 보유<br/>

## 주요 메소드
### Object 클래스로 객체 속성 알아내기
- getClass()
  - 클래스이름.getClass().getName() : 클래스 이름 ex.Point
- hashCode() : 해시 코드 값 ex. 366712642
- toString() : ex.(Overriding하지 않을 시)Point@15db9742
  - 단순 객체 출력`println(객체)`했을 때와 결과 동일

### 객체 ➡ 문자열
; toString()
<br/>
Object 클래스에서 구현된 toString()은 객체를 문자열로 반환한다.<br/>
```Java
public String toString() {
	return getClass().getName() +"@" + Integer.toHexString(hashCode());
}
```
그 반환 내용을 원하는대로 사용하기 위해 개발자는 자신만의 toString()을 오버라이딩해야한다.<br/>
```Java
Public class Point {
	int x, y;
  public Point(){}
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
  public String toString(){
    return "Point(" + x + "," + y+")";
  }
}
```
- (Overriding하지 않았을 때) Point@15db9742
- (위와 같이 Overridng 하고 출력했을 때) Point(x좌표,y좌표)

# 객체 비교
; equals()<br/>
- == 연산자: 두 개의 레퍼런스 비교 ; **같은 객체**를 가리키고 있는지 아닌지<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117668766-38955200-b1e1-11eb-92a7-c86fe1deae08.png)<br/>
  ; a != b <br/>
  ; a == c
- boolean equals(Object obj) : 객체 **내용** 비교<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117668897-5498f380-b1e1-11eb-8ccd-2386890ad550.png)<br/>
  ; a.equals(b) == true<br/>
  ; a.equals(c) == false
  
# Wrapper 클래스
; 자바의 기본 타입을 클래스화 ➡ **기본 타입**의 값을 **객체로** 다룰 수 있게 함<br/>
```Java
//기본 타입의 값으로 Wrapper 객체 생성
Double f = Double.valueOf(3.14);

//문자열로 Wrapper 객체 생성
Double d = Double.valueOf(“3.14”);
```
- 이름이 Wrapper인 클래스를 존재하지 않음
- 생성자를 이용한 Wrapper 객체 생성(X) valueOf 이용
- Wrapper 클래스의 많은 메소드가 static 타입
*Float 객체는 double 타입의 값으로 생성 가능 `Float f = Float.valueOf((double) 3.14)`

## 활용
- parse~ ➡ 문자열을 기본 데이터 타입으로 변환<br/>
  ```Java
  boolean b = Boolean.parseBoolean("true"); 	// b = true
  double f = Double.parseDouble("3.14" ); 	// d = 3.14
  ```
- to~ ➡ 기본 타입을 문자열로 변환<br/>
  ```Java
  String s1 = Integer.toString(123); //"123"
  String s2 = Integer.toHexaString(123); //"7b"
  String s3 = Boolean.toString(true); //"true"
  ```
  
## 박싱과 언박싱
- boxing: 기본 타입의 값을 Wrapper 객체로 변환
- unboxing: Wrapper 객체에 들어 있는 기본 타입의 값을 빼내는 것

![image](https://user-images.githubusercontent.com/56028436/117672348-ba3aaf00-b1e4-11eb-9c10-70536008aa5c.png)
```Java
public class AutoBoxingUnBoxingEx {
	public static void main(String[] args) {
		int n = 10;
		Integer intObject = n; 	// auto boxing
		System.out.println(intObject); // Integer @ ~ 가 아닌 10 출력

		int m = intObject + 10; // auto unboxing
		System.out.println(m); // 10을 unboxing해서 10을 더한 뒤 변수에 담아 출력
	}
}
```
# String Class
*import 하지 않아도 쓸 수 있다.<br/>
### 생성
- String 리터럴로 String 객체 생성 ➡ 자바가상머신 내에서 생성, 관리
	- `String()`: 빈 String 객체 생성 ; `String str1 = "abcd"`
- String 클래스의 생성자를 이용하여 생성 ➡ 힙 메모리에 생성
	- `String(char[] value)`: char 배열에 있는 문자들을 String 객체로 생성 ; `String str = new String(['a','b','c','d'])`
	- `String(String original)`: 매개변수로 주어진 문자열과 동일한 String 객체 생성 ; `String str = new String("abcd")`
	- `String(StringBuffer buffer)`: 매개변수로 주어진 StringBuffer의 문자열을 String 객체로 생성 
<br/>

## 특징

*String != char[]<br/>
- String 객체는 수정 불가능(상수공간). 빼는 건 가능 but `put`, `set`같은 행동 불가.<br/>
  ```Java
  String s = new String("Hello");
  String t = s.concat("Java"); //HelloJava
  // s는 여전히 Hello(변경되지 않음)
  ```
- **String 비교 시에는 `equals()` 사용** <br/>
  * `==`는 문자열 비교에 사용하면 안됨.
- <details>
  <summary>주요 메소드</summary>
  <div markdown="1">
	
  - 문자열 비교 ; `int compareTo(String anotherString)` <br/>
    문자열이 같으면 0, anotherString보다 앞에 나오면 음수, 뒤에 나오면 양수 리턴
  - 문자열 연결
    - +연산자: 피연산자에 문자열이나 객체가 포함 ➡ **문자열로 변환하여 연결** <br/>
      ```Java
      System.out.print(2+3); //5
      System.out.print("1"+2+3+"4"); //1234
      ```
    - `String concat(String str)` ; 기존 String 객체를 변화시키지 않고 새로운 String 객체 생성&리턴 <br/>
      ```Java
      String s1 = "abcd";
      String s2 = "efgh";
      s1.concat(s2); //s1은 그대로 "abcd"
      s1 = s1.concat(s2); //s1 = "abcdefgh"
      ```
   - 문자열 내 공백 제거 ; `String trim()` <br/>
     문자열 앞 뒤 공백 문자를 제거. 문자열 중간에 있는 공백은 제거되지 않는다.
   - 문자열 내 각 문자 접근 ; `char CharAt(int index)` <br/>
     *객체처럼 단순히 index로 바로 접근할 수 없다.
   - 문자열 분리 ; `char[] split(String divider)`
   - 문자열 대치 ; `String replace(String old, String new)`
  </div>
  </details>
 
 # StringBuffer 클래스
 `StringBuffer sb = new StringBuffer("java")`<br/>
 ; 가변 크기의 문자열 저장 클래스 <br/>
 - StringBuffer 객체의 크기는 String 길이에 따라 가변적
 - String 클래스와 달리 문자열 변경 가능
