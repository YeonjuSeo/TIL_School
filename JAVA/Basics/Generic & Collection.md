# 제네릭 Generic
*제네릭 프로그래밍`Generic Programming` : 일반적인 코드를 작성하고 이 코드를 다양한 타입의 객체에 대하여 재사용하는 프로그래밍 기법
- 컴파일 단계에서 타입 체크 ➡ 잘못된 타입 사용될 수 있는 문제 제거 가능

## 제네릭 타입
```Java
public class Box<T>{...}
public class Product<T,M>{...}
-------
Box <String> box = new Box<String>();
Product <Tv,String> product = new Product<>(); //java7 이후
Product <Tv,String> product2 = new Product<Tv,String>();
```
; 타입을 파라미터로 가지는 클래스와 인터페이스
- 선언 시 래스 또는 인터페이스 이름 뒤에 <타입 파라미터>를 붙임

## 제네릭 메소드
`public <타입파라미터,...> 리턴타입 메소드명(매개변수,...){...}`
`public <T> Box <T> boxing(T t){...}`
; 매개변수 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드

- 호출하는 방법
  - 명시적으로 구체적 타입 지정 ex.`Box <Integer> box = <Integer>boxing(100);`
  - 매개값을 보고 구체적 타입을 추정 ex.`Box<Integer> box = boxing(100);`

- 메소드의 인자 or 리턴 타입에 상속(클래스)/구현 관계(인터페이스)를 이용해서 타입 제한을 둘 수 있다.<br/>
  `public <T extends 상위타입> 리턴타입 메소드(매개변수, ...){...}`
  - 같은 상속 트리에 있거나 인터페이스로 연결된 경우만 타입 파라미터를 대체하여 지정할 수 있다.
    ```Java
    public Box<T extends 동물>{...}
    ------------
    Box<동물>box1 = new Box();
    Box<강아지>box2 = new Box();
    
    Box<자동차>box3 = new Box(); //불가!
    ```
    
### 와일드 카드
; ? ; 매개변수(인자)에서 허용
- `제네릭타입<?>` : Unbounded Wildcards (제한없음)
  ; 타입 파라미터를 대치하는 구체적인 타입으로 `모든 클래스나 인터페이스` 타입 가능
- `제네릭타입<? extends 상위타입>` : Upper Bounded Wildcards (상위클래스 제한)
  ; 타입 파라미터를 대치하는 구체적인 타입으로 `상위 타입이나 그 상위 타입의 하위 타입만` 타입 가능
- `제네릭타입<? super 상위타입>` : Lower Bounded Wildcards (하위 클래스 제한)
  ; 타입 파라미터를 대치하는 구체적인 타입으로 `상위 타입이나 그 상위 타입의 상위 타입만` 타입 가능
  

## 제네릭 타입의 상속과 구현
- 제네릭 타입을 부모 클래스로 사용
  - 타입 파라미터를 자식 클래스에도 기술<br/>
    `public class ChildProduct<T,M> extends Product<T,M>{...}`
  - 타입 파라미터 추가 가능
    `public class ChildProduct<T,M,C> extends Product<T,M>{...}`
- 제네릭 인터페이스 구현
  - 제네릭 인터페이스를 구현한 클래스도 제네릭 타입
