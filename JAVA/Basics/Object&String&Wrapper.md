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

### 객체 비교
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
