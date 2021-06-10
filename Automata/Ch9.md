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
