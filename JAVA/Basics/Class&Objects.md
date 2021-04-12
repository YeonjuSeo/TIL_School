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
*동적 바인딩: 실행할 시점에 동작이 변경될 수 있음 (↔ 정적 바인딩: 컴파일 시 동작 결정)

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

## 상속__공통부분은 재사용!
```Java
public class 강아지 extends 동물 {}
```
*상위 객체로 갈수록 추상화, 일반화되고 하위 객체로 갈수록 상세화된다.
- 상속 대상: 상위 개체의 필드와 메소드. 생성자는 상속되지 X
- 상속 조건: A is B가 **물리적/개념적으로 타당할 때만** 상속.
- 하위 객체가 상위 개체의 속성과 메소드를 모두 사용
- `Is-A` : 새로운 클래스 A가 기존 클래스 B를 물려받았을 때, `A는 B이다!`가 성립 ➡ `Class A Is-A Class B`

➡ 반복된 코드를 줄임, 유지 보수의 편리성 증가, 객체의 `다형성` 구현

### 자바의 상속
- 부모 클래스 = 수퍼 클래스 = 상위 클래스
- 자식 클래스 = 서브 클래스 = 하위 클래스
  - 수퍼 클래스를 재사용하고 새로운 특성 추가

## 다형성__관점
```Java
class Car implements Playable{}
```
- 같은 타입이지만 동작의 실행 결과가 다양한 객체를 대입할 수 있는 성질
- 같은 이름의 기능을 하는 요소를 여러 개 만드는 것
<br/>

- 같은 이름의 메소드가 클래스나 객체에 따라 다르게 동작하도록 구현
- `interface`를 활용한다.
<br/>
- 메소드 오버로딩: **같은 이름, 동일한 return 타입** but **인자의 형태, 수**에 따라 optional하게 동작하도록

```Java
// 불가능 // return 타입이 다름
int play();
void play();

// 가능 // 인자의 형태로 구분
int play(강아지 c);
int play(고양이 d);
 ```

- 메소드 오버라이딩: 슈퍼 클래스에서 상속받은 메소드를 서브 클래스마다 각자 다르게 구현

➡ 서로 다른 상속 트리(클래스) 연결 가능, 객체 부품화 가능, 유지보수 용이

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
    System.out.println(pizza.name + "의 면적은 " + area);
  }
}
```

### 클래스
멤버(=속성/state/field + 메소드/behavoir/행동)들의 **설계도**
- 하나의 클래스로 여러 개의 인스턴스를 만들 수 있다.
- 구성
  - 접근 지정자/접근 제한자: public, private, protected, default(아무것도 쓰지 않음)
  - 생성자: 객체가 생성될 때 초기화를 위해 자동으로 한 번 호출되는 메소드(리턴타입X)
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
    - 클래스에 생성자가 하나라도 작성됐거나 상속된 클래스의 경우 기본 생성자가 생성되지 않는다.
  - Getter & Setter: 밖에서 보이지 않는 값을 가져오거나 세팅할 때 사용
<br/>
*.java: 클래스를 정의한 파일
*.class: .java로 만들어지는 **바이트코드**

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
