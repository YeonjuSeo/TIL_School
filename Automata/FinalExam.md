# Context-Free Language 문맥-자유 언어
![image](https://user-images.githubusercontent.com/56028436/121584535-81ecf180-ca6c-11eb-9378-1fc2f0a7ad78.png)

<details>
<summary> a<sup>n</sup>b<sup>n</sup></summary>
<div markdown="1">       
- CFG G: S ➡ aSb, S ➡ λ <br/>
- L(G) = {<span>a<sup>n</sup></span><span>b<sup>n</sup></span> : n>=0} <br/>
- NPDA <br/> <img src="https://user-images.githubusercontent.com/56028436/121554207-ebf59e80-ca4c-11eb-9efb-8e9517db62e4.png" />
- DPDA <br/><img src="https://user-images.githubusercontent.com/56028436/121565073-14829600-ca57-11eb-88f7-5560608c239e.png" />
- Turing Machine <br/><img src="https://user-images.githubusercontent.com/56028436/121590917-dd6ead80-ca73-11eb-8b3b-a26437da7a2f.png" />

</div>
</details>

<details>
<summary> <span>ww<sup>R</sup></summary>
<div markdown="1">       
- CFG G: S ➡ aSa, S ➡ bSb, S ➡ λ <br/>
- L(G) = {<span>ww<sup>R</sup> : w ∈{a,b}*}
- NPDA <br/> <img src="https://user-images.githubusercontent.com/56028436/121554400-1d6e6a00-ca4d-11eb-982f-5a79a2430724.png" />
- DPDA로 만들어줄 수 없음 (위의 NPDA - pop할 대상이 없는 λ transition을 하고 있어서)

</div>
</details>
  
<details>
<summary>n<sub>a</sub>(w) = n<sub>a</sub>(w) and n<sub>a</sub>(v) >= n<sub>b</sub>(v) in any prefix v</summary>
<div markdown="1">       
- CFG G: S ➡ aSb, S ➡ SS, S ➡ λ <br/>
- L(G) = {w:n<sub>a</sub>(w) = n<sub>a</sub>(w) and n<sub>a</sub>(v) >= n<sub>b</sub>(v) in any prefix v}
</div>
</details>
  
- 임시저장소(stack)이 생김
- L=L(G)인 G가 존재 ↔ L 이 context-free language

## Context-Free Grammar
- Productions of the form: A ➡ x (x:변수와 터미널)
- Sometimes, derivation order doesn't matter
- Context-Free Grammar는 ambigous한 것 or non-ambiguous한 것
  
## Ambiguity
![image](https://user-images.githubusercontent.com/56028436/121539647-d1b5c380-ca40-11eb-853c-4f0a8fd391f0.png)
- w의 유도 과정에 따라 2개 혹은 그 이상의 derivation tree가 생성 ➡ `ambiguous`한 문법
- w가 2개 혹은 그 이상의 leftmost or rightmost derivation을 가짐 ➡ `ambiguous`한 문법
- Inherent Ambiguity 
  - unambiguous한 L: non-ambiguous한 G가 존재
  - inherently(본질적으로) ambiguous한 L: non-ambiguous한 G가 존재하지 않음 ; Some CFL have only ambiguous grammars
  - ex. a<sup>n</sup>b<sup>n</sup>c<sup>n</sup> __p.34

### Parsing 
; w ∈ L(G)인 w에 대해 일련의 생성 규칙을 발견하는 과정<br/>
; CFG로 생성되는 언어에 속하는 스트링 w를 유도하는 과정
- Parser가 result를 찾는 방식: 
  - Exhaustive Search(top-down parsing)
    - Time Complexity: k +  + ... + k<sup>2|w|</sup> ; Extremely bad!
  
*w에 따라 유도 중 nontermination에 빠지는 경우가 생길 수도 있으므로 제약을 추가할 수도 있음 p.39

## s-grammar(simple grammar)
![image](https://user-images.githubusercontent.com/56028436/121543394-d760d880-ca43-11eb-9ce5-b7df5e1beabb.png)<br/>
; Exhuastive Search를 해도 선형 시간 내 결과 탐색 가능한 CFG<br/>

- A ➡ ax (a:symbol x: string of variables), Pair(A,a)가 한 번만 나온다
- Total time for parsing string : |w|
  
➡ For general CFG, there exists a parsing algorithm that parses a string w in time |w|<sup>3</sup><br/>

*Convention for specifying grammars for Programming Language: Backus-Naur Form p.45<br/>
*s-grammar is easily/efficiently parsed by Backus-Naur Form due to keywords
  
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
![image](https://user-images.githubusercontent.com/56028436/121547892-84892000-ca47-11eb-981e-66d7d7a1f6bb.png)<br/>우변이 변수 2개 or symbol 1개<br/>
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
  
# Pushdown Automata
; CFG를 통해 만들어진 CFL을 인식하는 오토마타<br/>
- The States<br/>
![image](https://user-images.githubusercontent.com/56028436/121553210-0c712900-ca4c-11eb-861f-cfcab9e8fee5.png)
- pop을 하지 않고 push만<br/>![image](https://user-images.githubusercontent.com/56028436/121553388-30cd0580-ca4c-11eb-8ea9-db0289cb0ad7.png)
- push를 하지 않고 pop만<br/>![image](https://user-images.githubusercontent.com/56028436/121553422-375b7d00-ca4c-11eb-979a-c469e58dd020.png)
- pop도 push도 하지 않음<br/>![image](https://user-images.githubusercontent.com/56028436/121553446-3c203100-ca4c-11eb-8cc3-cc745e57e892.png)

## NPDA ; Non-Deterministic Pushdown Automata
- multi choice 가능 (갈 곳이 여러 곳 가능)
- λ transition 가능
- transition이 없을 수도 있음
- Pushing strings ; push하지 않거나, symbol만 push하거나, 문자열을 push할 수 있다.<br/>![image](https://user-images.githubusercontent.com/56028436/121556445-d84b3780-ca4e-11eb-98ce-4c4605a18ddc.png)
- String Accept 조건
  - 모든 input이 소진
  - last state가 final state
  - stack의 내용물은 신경쓰지 **않는다**
- Context-Free Language(Grammars) = Languages Accepted by NPDAs<br/>
*증명: Converting CFGs ↔ NPDAs p.171~, p.177~
- In general, in Grammar: (q<sub>0</sub>Aq<sub>f</sub>)=*>w ↔ w is accepted by the NPDA
- By construction of Grammar: (q<sub>i</sub>Aq<sub>j</sub>)=*>w ↔ in the NPDA going from q<sub>i</sub> to q<sub>j</sub>, the stack doesn't change below A and A is removed from stack.

*해당 transition의 사항을 모두 완수하지 못하면(읽을 게 없다거나, pop할 게 없다거나)그 자리에서 멈춘다.(해당 transition 시행 불가)<br/>
➡ 해당 input read도 못해서 input이 덜 소진될 수 있다.<br/>
*문자열을 push할 때 stack에는 문자열의 뒤부터 들어간다<br/>![image](https://user-images.githubusercontent.com/56028436/121556544-f0bb5200-ca4e-11eb-9dbf-752412523108.png)
<br/>
*{abba ∈ a와 b로 이뤄진 대칭 문자열} 예시 p.130<br/>
*{abbaab ∈ 문자열의 절반이 개수는 동일하되 symbol은 반대로 대칭} 예시 p.151

### Formal Definition of NPDA
![image](https://user-images.githubusercontent.com/56028436/121557309-9d95cf00-ca4f-11eb-83e6-37dcefd13d91.png)
<br/>
Instantaneous Description<br/>
![image](https://user-images.githubusercontent.com/56028436/121560214-43e2d400-ca52-11eb-93b5-599da1e88f89.png)
<br/>

*Instantaneous Description<br/>
![image](https://user-images.githubusercontent.com/56028436/121559810-e64e8780-ca51-11eb-87c5-34b48d8e8ff5.png)

## DPDA ; Deterministic PUshdown Automata
- δ(q,λ,b) is not empty <br/> = λ transition 가능 but pop할 대상이 꼭 있어야함
- 모든 symbol에 대한 transition이 정해져 있을 필요는 없음(; DFA와 다른 점)
- δ(q,a,b) contains at most one <br/> 
= 같은 state에서 λ과 함께 같은 symbol을 pop하는 transition이 있으면 안됨<br/>
= 같은 state에서 그 문자를 pop하는 다른 문자는 없다<br/>
= 동일한 상황에서 갈 곳이 한 군데 or 없어야함(선택의 여지가 2개 이상 X)
<br/>![image](https://user-images.githubusercontent.com/56028436/121564421-6545bf00-ca56-11eb-8987-905259ae280f.png)
<br/>*2가지 이상의 다른 '단경로'로 동일한 stack 상황을 만들 수 있는 multi choice이므로 두번째도 불가
- A language is deterministic context-free language is some DPDA accepts it

<br/>
`NPDAs have more power than DPDAs`
- The language L = {a<sup>n</sup>b<sup>n</sup>}∪{a<sup>n</sup>b<sup>2n</sup>} is not deterministic context-free language
  - The language {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is not context-free<br/>
    ➡ The language L∪{a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is not context-free
    
### Grammars for DCFL
; DCFL은 backtracking이 없으므로(multi choice가 없으므로) 더 efficient parsing 가능
- s-grammar
- LL Grammar
  - input scanned left ➡ right
  - Leftmost derivation
  - 스캔 여러개 가능 ➡ 선택이 더 분명해짐
- LR Grammar ; 더 general한 deterministic grammar

➡ NPDA가 인식하는 언어군이 더 크지만 DFCL는 더 efficient하게 파싱될 수 있으므로 가치가 있다.(; Programming Language 설계에서 중요)

# Pumping Lemma
For **Infinite** context-free language(;generates an infinite number of different strings),<br/>
there exists an integer **m(= production rule 개수 X 우변에 나온 것 중 가장 긴 것의 길이)**<br/>
such that for any string w∈L, |w|≥m <br/>
we can write w = uvxyz with lengths |vxy|≤m and |vy|≥1 <br/>
and it must be uv<sup>i</sup>xy<sup>i</sup>z∈L, for all i≥0 <br/>

➡ Proof: (p.216)The language L = {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is not context-free language <br/>
➡ Proof: (p.237)The language L = {ww:w ∈{a,b}} is not context-free language <br/>
➡ Proof: (p.244)The language L = {a<sup>n!</sup>:n≥0} is not context-free language <br/>

*Examples<br/>
- Context Free Language ; {a<sup>n</sup>b<sup>n</sup> : n≥0}, {<span>ww<sup>R</sup> : w ∈{a,b}*}
- Non-Context Free Language ; {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>:n≥0}, {ww:w ∈{a,b}}, {a<sup>n!</sup>:n≥0}
  
# Closure Properties
![image](https://user-images.githubusercontent.com/56028436/121571569-2b78b680-ca5e-11eb-93dc-b8448045fc7a.png)
<br/>
- Context-Free Languages are closed under (L1-G1-S1, L2-G2-S2)
  - Union `L1∪L2` ; S ➡ S1|S2
  - Conctenation `L1L2`; S ➡ S1S2
  - Star-operation `L1*` ; S ➡ S1S|λ
  - Regular Intersection ; intersection of a CFL and Regular language
- Context-Free Languages are **not** closed under 
  - intersection `L1∩L2`
  - complement `!L1`
  
# Decidable Properties of CFL
1. string w∈L(G)가 존재 ➡ CFL L의 member이다
2. CFL의 Parsers ; Exhaustive seaarch parser, CYK parsing algorithm
3. L(G)=Φ ➡ CFL G는 empty language 
  - useless variables 삭제 ➡ Start variable이 useless해졌는지 확인
4. L(G)가 infinite ➡ CFG G는 inifinite한 language L을 생성
  - simplification 후 dependency graph 그리기 ➡ **loop가 있으면 infinite**
  
# The Standard Turing Machine
- Yes/No 외의 결과 출력 가능
- 우리가 현재 사용하는 디지털 컴퓨터의 추상 모델 ; 튜링 머신이 해결하지 못하는 문제는 현재 컴퓨터로도 해결 불가
- **Infinite tape in both directions**_**Tape is the input/output file**
  - infinite한 길이 && no boundary
  - head ➡ tape의 symbol을 읽거나 tape에 symbol을 쓰고 왼쪽 or 오른쪽으로 움직인다. ; Read-Write head
    - Head starts at the leftmost position of the input string
- **deterministic**
  - 한 symbol을 읽고 갈 수 있는 곳은 하나(multi choice 불가)
  - 아무것도 읽지 않고 쓰거나 이동하기 불가(λ 문자열은 논의에서 예외. blank 읽을 수 있음)
  - 모든 symbol에 대한 transition이 정해져있을 필요 X(= No transition OK) <br/> = input string symbol에 대해 이동하지 않을 수도 있다.
- final states have no outgoing transtions = final에서 다른 곳으로 이동 불가 <br/> = final에는 incoming만 ok
- In a final state, the machine halts ➡ `Accept Input`
  - non-final state에서 멈춤 or infinite loop에 진입(never halts) ➡ `Reject Input`
- A Turing Machine is described with a binary string of 0's and 1's <br/> ➡ `The set of Turing machines forms a languages`(Each string of the language is the binary encoding of a Turing Machine)

*Turing Machine for the language {a<sup>n</sup>b<sup>n</sup>}<br/>
![image](https://user-images.githubusercontent.com/56028436/121591047-02632080-ca74-11eb-8c6f-bad0f6cdc601.png)
<br/>
위의 machine을 변형하여 language {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>}에 대한 Turing Machine도 제작 가능<br/>
➡ ![image](https://user-images.githubusercontent.com/56028436/121591289-4524f880-ca74-11eb-9db0-d2ced9817130.png)

## Formal Definition for Turing Machines
![image](https://user-images.githubusercontent.com/56028436/121591379-64bc2100-ca74-11eb-8019-95e3370a312f.png)
<br/>![image](https://user-images.githubusercontent.com/56028436/121591424-70a7e300-ca74-11eb-96a7-b1e7510b02f7.png)
<br/>*Configuration ; ('나'를 제외하고 왼쪽에 남은 거)'나'('나'를 제외하고 오른쪽에 남은 거)
<br/>

- Transition Function<br/>![image](https://user-images.githubusercontent.com/56028436/121591600-a77df900-ca74-11eb-8cf2-42ca9a11c152.png)<br/>
δ(시작 state, 읽을 symbol) = (도착 state, 쓸 내용, 이동방향)
- The Accepted Language<br/>![image](https://user-images.githubusercontent.com/56028436/121591975-19564280-ca75-11eb-8962-1bfe89d1a156.png)
<br/>좌우의 tape 내용에 상관없이 final state에 도달하기만 하면 된다.

### Turing Machines as Transducers
ex. (p.314) Turing machine for f(x,y) = x+y<br/>
ex. (p.317) Turing machine for f(x)=2x <br/>
ex. (p.320) Turing machine for x,y 비교
- A function f is computable if there is a Turing Machine M such that <br/> `q0 w ├* qf f(w)`
  - header가 맨 왼쪽에서 시작해서 맨 왼쪽으로 끝남
  - f(w) ; 결과물

*We prefer unary representation: easier to manipulate  with Turing machines
*(p.325)block diagram과 pseudocode로 combining TM for Complicated Tasks 가능

## Turing's Thesis
- Turing Machine은 digital computer와 same power를 가진다. (formal한 증명 방법은 없으나 정황 O)
- There exists an algorithms 
- Church-Turing Thesis ↔ There exists a Turing Machine that executes the algorithm.
  - (Church's Thesis) All models of computation are equivalnet
  - (Turing's Thesis) A computation is mechanical ↔ it can be performed by a Turing Machine

# Variations of the Standard Model
*The variations form different Turing Machine ; Classes<br/>
`Each Class has the same power with the Standard Model` ↔ Accept the same languages(꼭 같은 수의 단계를 거칠 필요 X)<br/>
`Same power doesn't imply same speed`.

- (p.340)Turing Machines with Stay-Option ; head의 이동 방향 : Left, Right, Stay(그 자리에 그대로)
- (p.346)Semi-Infinite Tape Machine ; 반(오른쪽)만 무한인 tape
- (p.353)The Off-Line Machine ; Input file tape와 read-write용 tape이 구부<br/>![image](https://user-images.githubusercontent.com/56028436/121597622-e5cae680-ca7b-11eb-91a0-42fcf9ba4273.png)
- (p.358)Multitape Turing Machines ; 모든 tape이 read-write tape<br/>![image](https://user-images.githubusercontent.com/56028436/121597890-2d517280-ca7c-11eb-831e-b0d01fd6ba23.png)
- MultiDimensional Turing Machines ; (2차원)이동방향 : L,R,U,D
- NonDeterministic Turing Machines ; 같은 symbol 읽고 갈 수 있는 곳 여러 곳 ok

*NonDeterministic Machine의 Polynomial Time = NP-Time, Deterministic Machine의 Polynomial Time = P-Time이라고 했을 때 <br/>
P-Time안에 해결이 가능한 문제는 NP-Time 안에 해결이 가능하다.<br/>
but NP-Time 안에 해결이 가능한 문제가 P-Time 안에 해결이 될지는 증명되지 않았음(아닐 것이라 예상)

# Countable vs Uncountable
*Infinite sets are either Countable or Uncountable<br/>
- Countable Set ; There is one to one correspondence between elements of the set and positive integers.
  - (p.378)The set of rational numbers is countable
  - (p.383)The set of all string {a,b,c}+ is countable
  - There is an enumeration procedure for a set ➡ the set is countable<br/>
  - **The set of all Turing Machines is countable**
- Uncoutable Set ; not countable한 set
  - (p.391)The set of real numbers is uncountable
  - (p.392)The powerset 2<sup>S</sup> of S is countable.

```
A language is a subset of S 
➡ The powerset of S contains all langues
➡ Language : uncountable
```
➡ Language : uncountable && Turing machines : countable<br/>
➡ There are infinitely many more languages than Turing Machines
➡ There are some languages not accepted by Turing Machines. These languages cannot be described by algorithms.

*Countable__Enumeration Procedure for S; Turing machine that generates all strings of S one by one, Each string is generated in finite time
*Uncountable__Diagonal Argument ; n까지 같은 게 있어도 n+1번째가 다르도록

### Linear Bounded Automata
; Turing machine과 같으나 read-write가 가능한 tape 구역이 제한되어있다.<br/>
![image](https://user-images.githubusercontent.com/56028436/121605097-bf5e7880-ca86-11eb-984c-86562959148c.png)<br/>

- We define LBA's as **Nondeterministic**
  - Nondeterministic LBA가 Deterministic LBA와 same power를 가지는 지는 모름
- 우리가 알 수 있는 모든 문제는 LBA로 해결 가능
  - ex) L={a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>}, L={a<sup>n</sup>}
- LBA's have more power than NPDA's and less power than TUring Machines
  
# Recursively Enumerable Language
> A language is recursively enumerable if some Turing machine accepts it
*끝나야지 accept/reject 결론이 나오는데 loop에 빠지면 결론을 주지 못함(recursively enumerable)

# Recursive Language
> A language is recursive if some Turing machine accepts it and **halts on any input string**
> A language is recursive if there is a membership algorithm for it

loop의 경우를 제외했음 ➡ 결론이 난다.<br/>

![image](https://user-images.githubusercontent.com/56028436/121606769-bcb15280-ca89-11eb-8670-0df1dac152aa.png)
<br/>
- There is a specific language which is not recursively enumerable <br/>
Turing machine이 인식하지 못하는 언어가 존재한다.
- There is a specific language which is recursively enumerable but not recursive

### Unrestricted Grammars
![image](https://user-images.githubusercontent.com/56028436/121606855-e10d2f00-ca89-11eb-9494-63c502dc988b.png)
<br/>
- A language L is **recursively enumerable** ↔ L is generated by an **unrestricted grammar**

## Context-Sensitive Grammar
![image](https://user-images.githubusercontent.com/56028436/121606960-19147200-ca8a-11eb-92df-e0ae351febc9.png)
<br/>
; Unrestricted grammar에서 제약 추가<br/>
- (p.408)The language {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is context-sensitive
- (p.410)L={w|#a=#b=#c a와 b와 c의 개수가 같음} is context-sensitive

# Chomsky Hierarchy
![image](https://user-images.githubusercontent.com/56028436/121607088-655fb200-ca8a-11eb-9033-0aaadb88f1fb.png)
