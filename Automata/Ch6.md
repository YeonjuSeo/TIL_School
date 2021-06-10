## Simplification
*연습문제3<br/>
- 제한 없는 CFG ➡ 제한된 형태의 동치의 문법 => 큰 효과
- 생성 규칙의 수의 필연적 감소를 의미하지는 X
- 우리는 CFL에서 L-{λ}인 언어를 다룬다

1. Remove Nullable Variables
; λ production, Nullable Variable 제거<br/>
  
1) 모든 Nullable Variable 찾기<br/>
![image](https://user-images.githubusercontent.com/56028436/121545350-6a4e4280-ca45-11eb-86b1-fc269412654f.png)
<br/>위와 같이 바로 λ로 가거나 transition을 거쳐 λ가 되는 변수
2) Nullable Variable과 관련한 transition이 미치는 영향을 커버하는 새로운 문법을 추가 + Nullable Variable 제거

2. Remove Unit-Productions
![image](https://user-images.githubusercontent.com/56028436/121546897-a209ba00-ca46-11eb-9b8c-574176bd67dc.png)
<br/>
; A ➡ B<br/>
*A ➡ A는 즉시 제거<br/>
*dependency graph를 그려보자<br/>
1) Unit production이 될 수 있는 모든 rule 찾기
2) Unit production 삭제 + Unit production 삭제로 영향받는 부분을 **치환**으로  커버<br/>

3. Remove Useless Variables
1) terminate되지 않는 변수 삭제<br/>
  = terminal로 마무리 지어지는 변수 탐색 ➡ 그렇지 않는 변수 삭제<br/>
2) Start Variable에서 도달할 수 없는 변수 삭제
*유도 과정에서 쓰이지 않는 production rule 삭제

### Chomsky Normal Forms
![image](https://user-images.githubusercontent.com/56028436/121547892-84892000-ca47-11eb-981e-66d7d7a1f6bb.png)
![image](https://user-images.githubusercontent.com/56028436/121548410-f2cde280-ca47-11eb-8b5d-9a44e915ddde.png)
<br/>
p.67, 69<br/>
1. symbol이라고 붙은 걸 변수(T)로 바꿈
2. 2개짜리 변수를 하나의 변수(V)로 묶어가며 우변이 변수로 2개로 이루어질 수 있도록 함

*Chomsky Normal Form 변환 전 simplification이 우선되어야 함<br/>

- Chomsky Normal forms are good for parsing and proving theorms
- It is very easy to find the Chomsky normal form of any CFG<br/> = 모든 CFG는 Chomsky Normal Form으로 변형 가능

### Greibach Normal Form
![image](https://user-images.githubusercontent.com/56028436/121549067-7ee00a00-ca48-11eb-9c51-cfe9f80cd459.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/121549214-9f0fc900-ca48-11eb-8c59-0d288ae19407.png)
<br/>
*s-grammar가 (변수,symbol) 쌍이 한 번만 나오는 것이었다면 Greibach Normal Form은 그 쌍이 여러 번 나올 수 있다.<br/>

- Greibach normal forms are very good for parsing
- It is hard to find the Greibach normal form of any CFG

# CYK Algorithm ; Membership Algorithm for CFL
*Membership Algorithm: 그 문자열이 해당 grammar에 의해 유도될 수 있는 문자열인지 판단
- 대상: grammar in Chomsky Normal form

![image](https://user-images.githubusercontent.com/56028436/121551236-6e309380-ca4a-11eb-9ca4-e36e9aac8625.png)<br/>
- 최상단에 S가 속해있으면 해당 문자열은 해당 grammar에 의해 유도될 수 있다.

*Φ와 다른 변수의 결합은 무조건 Φ이다.<br/>
*변수 결합 순서 마음대로 바꾸지 말기!(왼쪽에서 읽은 변수가 왼쪽, 오른쪽에서 읽은 변수가 오른쪽)<br/>
![image](https://user-images.githubusercontent.com/56028436/121551964-0890d700-ca4b-11eb-83eb-339935fb0c08.png)
*구현 p.98~<br/>
![image](https://user-images.githubusercontent.com/56028436/121552220-3fff8380-ca4b-11eb-8961-a5e4c26a13d7.png)
