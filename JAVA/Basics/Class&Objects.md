# OOP__Objective-Oriented Programming
*객체 = 데이터(➡고유한 특성, 변수) + 기능
![image](https://user-images.githubusercontent.com/56028436/113993881-db2f7d80-988f-11eb-994a-254ced2079da.png)

- 객체지향언어: 객체를 기반으로 프로그램을 작성하는 언어 
- **부품객체**를 먼저 만들고 **하나씩 조립**해 가는 프로그램 기법
- **물체(객체)들간의 상호 작용**으로 표현
- 메소드 작성 시, 어떤 동작에 관한 작업/논리를 `절차지향적인 순서`로 표현할 수 있음<br/>
➡ `OOAD(분석/설계) ➡ OOP(프로그래밍)`

- 객체지향 기법의 3R
  - 가독성 Readability
  - 재사용성 Reusability
  - 신뢰성 Reliability

*객체를 만들기 위해서는 Class가 필요하다.<br/>

### 객체지향 프로그램이 갖추어야 할 속성
 - 상속성 Inheritance
 - 은닉성 Information Hiding, Encapsulation
 - 다형성 Polymorphism

## 캡슐화__불필요한 건 숨기고 약속된 것만 꺼내자!
![image](https://user-images.githubusercontent.com/56028436/113539055-ca74d280-9617-11eb-9e5f-a4319fce5429.png)
- 약속되지 않은 부분 / 보여줄 필요가 없는 부분은 감싸서 숨겨버리는 것
- 객체의 필드, 메소드를 하나로 묶고, 실제 구현 내용을 감추는 것
- 외부 객체는 객체 내부 구조를 알 수 X, 객체가 노출해 제공하는 필드와 메소드만 이용 가능

*추상화: 꼭 필요한 정보만 노출하는 기법

➡ 외부 사용으로 인한 객체 손상 방지, 캡슐화된 멤버의 노출 여부 결정(public/private/protected)

### 자바의 캡슐화__클래스와 객체
- Class: 객체 모양을 선언한 틀. 메소드(멤버 함수)와 필드(멤버 변수)는 모두 클래스 내에 구현
- 객체: **클래스의 모양대로 생성된 실체(instance)**
  - 객체 내 데이터에 대한 보호, 외부 접근 제한 __ 객체 외부에서는 공개된 메소드로 비공개 멤버에 접근(직접 접근X)
  - 객체 외부에서 비공개 멤버에 직접 접근할 수 없도록 `private`

### 접근 지정자__public, private, protected, default
*패키지: 관련있는 클래스 파일(.class)를 저장하는 디렉터리 공간. 소스 성격에 따라 구분하는 것이 좋음<br/>

|멤버에 접근하는 클래스|public|private|default|protected|
|:---:|:---:|:---:|:---:|:---:|
|같은 패키지의 클래스|O|X|O|O|
|다른 패키지의 클래스|O|X|X|X|
|접근 가능 영역|모든 클래스|클래스 내|같은 패키지 내|같은 패키지와<br/> 상속 받은 서브 클래스<br/>(다른 패키지에 있어도 가능)|

*private에서<br/>
- 읽기 전용 필드 필요 ➡ getter 필요
- 외부에서 값 변경 불가하도록 ➡ setter 필요

## 상속__공통부분은 재사용!
```Java
public class 강아지 extends 동물 {}
```
*상위 객체로 갈수록 추상화, 일반화되고 하위 객체로 갈수록 상세화된다.
- 상속 대상: 상위 개체의 필드와 메소드. 생성자는 상속되지 X
- 상속 조건: A is B가 **물리적/개념적으로 타당할 때만** 상속.
- 하위 객체가 상위 개체의 속성과 메소드를 모두 사용
- `Is-A` : 새로운 클래스 A가 기존 클래스 B를 물려받았을 때, `A는 B이다!`가 성립 ➡ `Class A Is-A Class B`
- 2,3단계까지가 적당

➡ 반복된 코드를 줄임, 빠른 코드 작성 지원, 객체의 `다형성` 구현

### 자바의 상속
- 부모 클래스 = 수퍼 클래스 = 상위 클래스
- 자식 클래스 = 서브 클래스 = 하위 클래스
  - 수퍼 클래스를 재사용하고 새로운 특성 추가

## 다형성
```Java
class Car implements Playable{}
```
- 상속 계층 상의 객체의 위치에 따라 어떤 method를 호출할지 결정한다.
  - 먼저 하위 클래스에서 method를 찾고 없으면 상위 클래스로 올라가면서 탐색
- 메소드 오버로딩, 메소드 오버라이딩, `interface`를 활용한다.
- 매개변수의 다형성
  : 매개변수가 클래스 타입일 경우 해당 클래스 객체 대입이 원칙이나 자식 객체 대입도 허용<br/>
  <img src="https://user-images.githubusercontent.com/56028436/116437097-08b48900-a888-11eb-8559-bec5b854789c.png" width="500">
- 필드의 **다형성**__Upcasting
  : 같은 상속 트리 내 객체들을 하나의 **배열로** 관리
  ```Java
  class Car{
    Tire[] tires = {
      new Tire("앞 왼쪽", 6);
      new Tire("앞 오른쪽", 2);
    }
  }
  
  tires[i] = new KumhoTire("앞오른쪽",13); //배열의 원소로 접근 가능
  ```
- 강제 타입 변환__Downcasting
  : 부모 타입 ➡ 자식 타입
  - 조건: Upcasting 후 다시 Downcasting 할 때만 가능
<br/><br/>

![image](https://user-images.githubusercontent.com/56028436/116442575-9a72c500-a88d-11eb-8d34-300fdf651d34.png)

### 메소드 오버로딩
:**같은 이름, 동일한 return 타입** but **인자의 형태, 수**에 따라 optional하게 동작.<br/>
⚠리턴 타입은 오버로딩과 관련 없으므로 리턴값으로는 메소드를 구분하지 못함

```Java
// 불가능 // return 타입이 다름
int play();
void play();

// 가능 // 인자의 형태로 구분
int play(강아지 c);
int play(고양이 d);
 ```

### 메소드 오버라이딩
: 슈퍼 클래스에서 상속받은 메소드를 서브 클래스마다 각자 다르게 구현
<br/>
➡ 서로 다른 상속 트리(클래스) 연결 가능, 객체 부품화 가능, 유지보수 용이
<br/>
- 서브 클래스에 오버라이딩된 메소드가 무조건 실행되는 동적 바인딩 발생
  ![image](https://user-images.githubusercontent.com/56028436/116442167-259f8b00-a88d-11eb-896f-0cfaaf776ec3.png)
- 접근 제한을 더 강하게 오버라이딩하는 것은 불가<br/>
  : public ➡ deafult/private (불가능)
    default ➡ public(가능)
    
*동적 바인딩: 실행할 시점에 동작이 변경될 수 있음 (↔ 정적 바인딩: 컴파일 시 동작 결정)<br/>
*오버라이드 시 상위 클래스 버전의 메소드 기능이 필요하다면? super 키워드!
```Java
abstract class Report {
  void runReport() {
    // 일반적인 보고서 설정…
  }
  void printReport() {
    // 포괄적인 출력 작업 …
  }
}

class BuzzWordReport extends Report {
  void runReport() {
    super.runReport();
    buzzwordCompliance();
    printReport();
  }
  void buzzwordCompliance() { … }
}
```

## 객체와 클래스
```Java
//Circle.java
public class Circle {
  int radius; // 원의 반지름 필드
  String name; // 원의 이름 필드
  // 원의 생성자
  public Circle() { }
  // 원의 면적 계산 메소드 //Getter
  public double getArea() { 
    return 3.14*radius*radius;
  }
}

//Main.java
public class Main{
  public static void main(String[] args) {
    Circle pizza = new Circle(); // Circle class 모양의 객체 생성하고 Circle pizza에 저장
    pizza.radius = 10; // 피자의 반지름을 10으로 설정
    pizza.name = "자바피자"; // 피자의 이름 설정
    double area = pizza.getArea(); // 피자의 면적 알아내기
    System.out.println(pizza.name + "의 면적은 " + area);ㅌ
  }
}
```
- Has-a(집합 관계) : 완성품과 부품의 관계
- Use-a(사용 관계) : 객체가 다른 객체를 사용하는 관계
- Is-a(상속 관계) : 종류 객체와 구체적인 사물 객체 관계

### 클래스
멤버(=속성/state/field + 메소드/behavior/행동)들의 **설계도**
- 하나의 클래스로 여러 개의 인스턴스를 만들 수 있다.
- 구성
  - 접근 지정자/접근 제한자
  - 생성자
  - Getter & Setter: 밖에서 보이지 않는 값을 가져오거나 세팅할 때 사용
- 최상위 super class : Object Class
<br/>
*.java: 클래스를 정의한 파일<br/>
*.class: .java로 만들어지는 **바이트코드**

### 생성자
객체가 생성될 때 초기화를 위해 자동으로 한 번 호출되는 메소드(리턴타입X)

- 클래스 내에서 하나 이상 선언되어야하며 선언되지 않은 경우 기본 생성자가 자동 삽입
  - 메소드 오버로딩 가능
      ```Java
      public Circle() { // 매개 변수 없는 생성자
        radius = 1; name = ""; // radius의 초기값은 1
      }
      public Circle(int r, String n) { // 매개 변수를 가진 생성자
        radius = r; name = n;
      }
      ```
  - 클래스에 생성자가 하나라도 작성됐거나 상속된 클래스의 경우 기본 생성자가 생성되지 않는다.<br/>
    `Implicit super constructor A() is undefined. Must explicitly invoke another constructor`<br/>
    기본 생성자가 없는데 기본 생성자가 호출되는 경우`super();`에는 에러 발생
- new에 서브 클래스의 객체가 생성될 때
  - 서브 클래스의 생성자와 슈퍼 클래스의 생성자가 **모두 실행**된다.
  - 슈퍼 클래스의 생성자가 먼저 실행 ➡ 서브 클래스의 생성자 실행
  - `super(parameter)` ; 서브 클래스에서 슈퍼 클래스의 생성자 선택
    - 반드시 서브 클래스 생성자 코드의 제일 첫번째 라인에 작성

### 객체
- 클래스의 인스턴스
  - 인스턴스instance: 클래스로부터 만들어진 객체
- 메모리 공간을 갖는 구체적인 실체
- 멤버 접근: ```객체레퍼런스변수.멤버```
<br/>
- 클래스에서 선언된 동일한 속성을 가지나 객체마다 서로 다른 고유한 값으로 구분된다.

## this__객체 자신에 대한 레퍼런스
```Java
class Power { 
  public double base; 
  public int exp; 
  public double val; 
  public Power(double num, int exp) { 
    this.base = num; 
    this.exp = exp; //그냥 exp = exp이면 헷갈린다.
    this.val = 1; 
    if(exp==0) return; 
    for( ; exp>0; exp--) 
      this.val = this.val * this.base; 
  } 
  public double get_pwr() { 
    return this.val; 
  } 
}
```
- 필요한 경우
  - 객체 내부에서 인스턴스 멤버임을 명확히
  - 매개변수와 필드이름이 동일
  - 다른 메소드 호출 시 객체 자신의 레퍼런스를 전달하거나 반환

## 객체 배열
*객체의 치환은 객체 복사(X) **레퍼런스(주소) 복사(O)**
```Java
//공간 생성
동물[] 숲속 = new 동물[10];
//공간 안에 객체 넣기
for(int i=0; i<숲속.length; i++){
  숲속[i] = new 동물();
}
```
생성과 객체 삽입 둘 다 해야 객체 배열이 생성되었다고 볼 수 있다.

#### 인자 전달
- 기본 타입의 값 전달 : 값이 매개변수에 **복사**되어 전달
- 객체 전달 : 객체의 레퍼런스만 전달
- 배열 전달: 배열 레퍼런스만 전달

## 객체의 소멸 & 가비지 컬렉션
자바 가상 기계의 가비지 컬렉터가 가비지 컬렉션 시점을 전적으로 판단하여 자동으로 가비지를 수집하여 반환처리한다.<br/>
그러므로 `System.gc()`로 가비지 작동 요청을 하더라도 바로 실행되지 않고 필요하다고 판단될 때 실행된다..

### static
1. 멤버: static & non-static
  - non-static 멤버
    - 객체마다 독립적으로 별도 존재
    - 공유되지 않음
  - static 멤버
    ```
    Math m = new Math(); (X)
    int n = Math.abs(-5); (O)
    ```
    - 객체를 생성하지 않고 바로 사용 가능 ; `new~` 할 필요 X
    - 클래스 당 하나만 생성
    - 동일한 클래스의 모든 객체에 의해 공유

2. 메소드: static & non-static
  - static 메소드
    - 객체 생성 전에도 호출이 가능 <br/>➡ **non-static 멤버에 접근 불가**, 현재 객체를 가리키는**this 사용 불가**
  - non-static 메소드
    - 객체 생성 전에도 static 멤버 사용 가능<br/>
      ![image](https://user-images.githubusercontent.com/56028436/116405407-92555e00-a86a-11eb-8a07-f84e080ee21d.png)

3. 변수: static & instance
  - static 변수: 모든 객체를 통틀어 하나만 있는 변수
  - instance 변수: 객체마다 하나씩 있는 변수


## 싱글톤Singleton
```Java
public class Sky{
	private static Sky instance = null;
	private Sky() {
		System.out.println("하늘 객체를 생성");
	}
	public static Sky getInstance() {
		if(instance == null) instance = new Sky();
		else System.out.println("이미 생성되었습니다.");
		
		return instance;
	}
}
```
하나의 어플리케이션 내에서 단 하나만 생성되도록 만든 객체
- 싱글톤 만드는 방법
  1. 생성자 앞에 private 붙이기 ➡ 외부에서 new 연산자로 생성자 호출 불가
    ```Java
    Singleton obj1 = new Singleton(); //컴파일 에러
    Sky s1 = Sky.getInstance(); // getInstance로 생성 
    ```

### final
- final 클래스: 클래스 상속 불가
- final 메소드: 메소드 오버라이딩 불가
<br/>
- 상수 선언 시 사용. 

## Upcasting & Downcasting
```Java
class Person {...}
class Student extends Person {...}
  
Student s = new Student("나는 학생");
Person p = s; // 업캐스팅 // 자동 타입 변환
Student st = (Student)p; // 다운 캐스팅 // 타입 명시 필요
```
### Upcasting 
: (타입 변환) 서브 클래스 객체 ➡ 슈퍼 클래스 객체
- 변환 후 슈퍼 클래스의 멤버만 접근 가능
- 부모 타입에는 모든 자식 객체가 대입 가능
- 바로 위의 부모가 아니더라도 상속 계층의 상위면 자동 타입 변환 가능
  <img src="https://user-images.githubusercontent.com/56028436/116431797-0f8ccd00-a883-11eb-83f1-5fb25855abf5.png" width="400">

### Downcasting 
: (타입 변환) 업캐스팅 한 슈퍼 클래스 객체 ➡ 서브 클래스 타입
- 명시적 타입 변환 필요
- 부모 타입이라고 해서 모두 자식 타입으로 강제 변환할 수 있는 것은 X
  ```Java
  Parent parent = new Parent();
  Child child = (Child) parent; // 불가능
  ```

### instanceOf
레퍼런스가 가리키는 객체의 타입 식별(boolean 값 반환)
**업/다운캐스팅이 되었을 때도 비교 가능**
![image](https://user-images.githubusercontent.com/56028436/116435359-38629180-a886-11eb-98a3-afbf3d7ec36f.png)

## 추상 클래스 Abstract Class
```Java
Public abstract class Calculator {...}
```
: 실체 클래스 생성 목적이 아닌 **상속용 클래스**<br/>
; 구체적인 행위는 상속받은 클래스마다 다를 수 있으므로 완전하게 표시하기에는 불충분한 추상적 개체를 표현<br/>

- 객체 생성 불가(new 연산자 사용 불가)
- 구체적인 행위는 하위 클래스에서 **오버라이딩**시켜 완성하도록 함
- 모든 추상 클래스와 메소드는 public
- 추상 클래스 A를 상속하는 클래스 B가 **추상 클래스가 아니라면,**<br/>
  B는 A에 있더 **추상 메소드를 반드시 오버라이딩** 해야한다.
- 종류
  - 추상 메소드를 하나라도 가진 클래스
    - 추상 메소드가 존재 ➡ 반드시 abstract가 앞에 붙은 추상 클래스로 선언되어야함(필)
  - 추상 메소드가 없지만 abstract로 선언된 클래스

*추상 메소드: body는 없고 prototype만 있는 메소드
```Java
public abstract String getName();
public abstract void setName(String s);
```

## 인터페이스
![image](https://user-images.githubusercontent.com/56028436/116446573-0bb47700-a892-11eb-92ad-0cdd2df75c0f.png)
<br/>
: 인터페이스의 내용에 해당하면 연결 가능. 구현 방법은 클래스마다 다를 수 있다.<br/>
: (자바)클래스가 구현해야 할 메소드들이 선언되는 추상형
```Java
public interface SerialDriver {...}
```
- 구성요소
  - 상수
    - public만 허용
    - public static final 생략
  - 추상 메소드
    - 선언 시 public abstract 생략 가능
    - 인터페이스를 구현하는 클래스는 인터페이스의 **모든 추상 메소드를 반드시 구현**
  - default 메소드
    - 인터페이스를 구현하는 클래스에 자동 상속
    - public 접근 지정만 허용하되 선언 시 생략 가능
  - private 메소드
    - 인터페이스 내에 있는 다른 코드에 의해서만 호출 가능
    - 인터페이스 내에 메소드 코드가 작성되어야 함.
  - static 메소드
    - public private 모두 지정 가능
    - 생략하면 public<br/>
  
  *필드(멤버 변수) 선언 불가


- 인터페이스 메소드 구현 시 **public** 생략하면 오류 발생
- 다중 상속, 다른 인터페이스 상속 가능
- 구현객체에서 인터페이스로 자동 타입 변환 가능
  ![image](https://user-images.githubusercontent.com/56028436/116445972-70230680-a891-11eb-9c88-4022195d4963.png)

<br/>

![image](https://user-images.githubusercontent.com/56028436/116447064-8c737300-a892-11eb-8a4d-6383612e4749.png)

*참고자료(추상클래스와 인터페이스): https://myjamong.tistory.com/150

### 익명 객체
: 이름이 없는 객체
```Java
class A{
  //A 클래스의 필드 선언
  Parent field = new Parent(){
    int childField;
    void childMethod();
    //Parent의 메소드를 오버라이딩
    @Override
    void parentMethod() {}
  }
}
```

- 단독 생성 불가
  - 클래스 상속/인터페이스 구현해야만 생성 가능
- 내부에서 새롭게 정의된 필드와 메소드는 익명 객체 내부에서만 사용(외부 접근 불가)<br/>
  cuz 익명 객체는 부모 타입 변수에 대입 ➡ 부모 타입에 선언된 것만 사용 가능

### 중첩 클래스 & 중첩 인터페이스
- 중첩 클래스: 클래스 멤버로 선언된 클래스
 ```Java
  class ClassName{
    class NestedClassName{...}
  }
  ```
  - 분류<br/>
    ![image](https://user-images.githubusercontent.com/56028436/116447577-1ae7f480-a893-11eb-9f1c-6c6c0f0323ea.png)

- 중첩 인터페이스: 클래스 멤버로 선언된 인터페이스
  ```Java
  class ClassName{
    interface NestedInterfaceName{...}
  }
  ```
