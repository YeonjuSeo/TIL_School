# Ch4 Class & Objects
```
*point :  
- A 클래스가 B클래스를 사용하는 방법 \
             ==> 상속 or   속성으로 포함한다  or  메소드의 인자로 전달한다.
-주어진 문장 및 실행결과를 보고,  어떤 속성과 어떤 메소드가 필요한지 파악하기
-속성의 타입, 메소드의 리턴값, 인자의 타입 정하기
-상속과 다형성을 이용하여 여러가지의 객체를 동작시킬 수 있는 메소드 결정하기 :  오버로딩, 오버라이딩
-static 의 활용
-추상클래스와 인터페이스


*문제의 예:   
-A 클래스에서 정의되어야 할 속성을 모두 고르세요.
-A와  B 클래스의 관계를 볼 때  메소드 m()은 어떻게 정의되어야 할까요?  
-다음 조건대로 구현할 때 클래스 헤더를 정의하세요
-다음 문장을 코드로 나타내면?
-코드와 실행결과를 보고 메소드 동작결과 추론하기
```

![image](https://user-images.githubusercontent.com/56028436/116397624-ca0bd800-a861-11eb-9dc1-b68736e0fdd8.png)
```
1번
정답: 
public class A extends B // A is-a B
public class C extends D,F // C is-a D,F

*꼬리 질문 정답: C is-a D,F
// 자바에서는 다중 상속이 불가능하다.
```
```
2번
정답: 
public class A extends B implements IB // A is-a B implements IB
public class C extends B implements IA,IB, IC // C is-a B implements IA, IB, IC
```
<img src="https://user-images.githubusercontent.com/56028436/116398804-28858600-a863-11eb-8feb-6b9d04932d1c.png" width="300">
상속은 한 번만 가능하지만 implements는 여러 개가 가능하다!<br/>

```
3번
정답: 3개 // a(), b(), ib()
```
```
4번
정답: 5개 // b(),c(),ia(),ib(),ic()
```

![image](https://user-images.githubusercontent.com/56028436/116397320-6c778b80-a861-11eb-8a03-1e027d685db1.png)
```
1번
정답: 2.plush(실수,실수)가 실행 // result = 30.3

//좀 더 큰 개념인 '실수'로 실행된다.
```
```
2번
정답: 2. 없다.

//이미 인자가 같은 int plus(int x, int y)가 있다.
// 리턴 값으로는 메소드를 구분할 수 없다.
```

![image](https://user-images.githubusercontent.com/56028436/116399222-a47fce00-a863-11eb-83c3-61827ec0bbd0.png)
```
정답: 3) 컵라면

//생성된 건 짱구 but 관점은 엄마 ➡ 짱구의 메소드를 쓰되 엄마가 볼 수 있는 것만 쓸 수 있다!
```
*만약에 `할머니 grandma = new 짱구()`에서 `grandma.청소하기()`는 가능할까?
```
정답: 불가능!

// 할머니의 관점(클래스)에는 청소하기가 없으므로 볼 수 없다.
```
*짱구가 엄마처럼 요리하려면?
```
요리하기2(){
  super.요리하기(); 
  //or
  new 엄마().요리하기();
  
}

//할머니처럼 하려면 엄마에서 super받아온 것을 또 super해오고...
```
