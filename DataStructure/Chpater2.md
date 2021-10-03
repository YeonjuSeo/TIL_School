# 순환(재구, Recursion)이란?
수행 도중에 자기 자신을 다시 호출하여 문제를 해결하는 기법<br/>
*재귀 함수 속에는 순환 호출을 멈추는 부분이 있어야함.(함수 가장 윗부분에 쓰기!)

![image](https://user-images.githubusercontent.com/56028436/135749292-1d86746e-4d5c-4aa3-af43-501501166869.png)<br/>
https://velog.io/@wonhee010/%EB%A9%94%EB%AA%A8%EB%A6%AC-%EA%B5%AC%EC%A1%B0-feat.-%EC%9E%AC%EA%B7%80-vs-%EB%B0%98%EB%B3%B5%EB%AC%B8<br/>
*힙 영역은 동적으로 커졌다 작아졌다 하며. 배열의 할당은 힙 영역에서 이루어진다.<br/>
*스택 영역에는 함수 호출과 관련된 지역 변수와 매개 변수가 저장된다.<br/><br/>

- 함수를 재귀적으로 호출할 시 스택에는 콜스택이 계속해서 쌓인다.<br/>
![image](https://user-images.githubusercontent.com/56028436/135749468-c2c738b6-f752-42d5-8d86-9fc3af593260.png)

# 순환(recursion) vs 반복(iteration)
- 순환 : 순환 호출
  - 함수 호출의 오버헤드 발생
- 반복 : for / while
  - 수행 속도가 더 빠름
  - 순화적인 문제에 대해서는 적용이 어려울 수 있음

*대부분의 순환은 반복으로 바꾸어 작성할 수 있다.

# (순환<반복) 거듭제곱 프로그램
*재귀함수를 사용해서 오히려 더 비효율적이어질 수도 있다.
- 반복적인 방법(O(n))
```C
double slow_power(double x, int n){
  int i;
  double result = 1.0;
  for(i = 0; i<n; i++){
    result = resut * x;
  }
  return result;
}
```
- 순환적인 방법(O(logn))
```C
double power(double x, int n){
  if(n==0) return 1;
  else if(n%2==0) return power(x*x, n/2);
  else return power(x*x,(n-1)/2);
}
```

# (순환<반복) Fibonacci 프로그램

순환 호출 사용 시(T(n) = T(n-1)+T(n-2)+C = O(n<sup>2</sup>))
```C
int fib(int n){
  if(n==0) return 0;
  if(n==1) return 1;
  return (fib(n-1)+fib(n-2));
}
```

- 동일한 항을 중복 계산
  - n이 커지면서 더 심해짐
- 함수 한 번 실행 시 추가 2번 호출
- 깊이가 깊을 수록 많은 호출

➡️ 반복으로 계산하는 것이 더 효율적
```C
int fib(int n){
  if(n==0) return 0;
  if(n==1) return 1;
  
  int pp = 0, p=1, result =0;
  for(int i=2;i<=n;i++){
    result = p+pp;
    pp=p;
    p=result;
  }
  return result;
}
```
