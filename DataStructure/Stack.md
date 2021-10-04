# Stack 스택
![image](https://user-images.githubusercontent.com/56028436/135752258-3b9d13bc-d72c-46ce-bccc-32f36993292a.png)

- LIFO 후입선출 ; 가장 최근에 들어온 데이터가 가장 먼저 나감
- 추상 데이터 타입
  - 객체: 0개 이상의 원소를 가지는 유한 선형 리스트(순서O)
  - 연산: create, is_full, is_empty, push, pop, peek

# 스택의 구현
배열을 이용한 스택의 구현
## 1차원 배열 stack[]
- 가장 먼저 들어온 요소 : stack[0]
- 가장 최근에 들어온 요소 : stack[top]
- 스택이 공백 상태 ➡️ top = -1

- 전역 변수로 구현
```C

```
