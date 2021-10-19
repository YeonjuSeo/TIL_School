# Signed Number Representations
## Two's Complement
⚠️범위 주의<br/>
![image](https://user-images.githubusercontent.com/56028436/137634286-b2d5f13d-469f-4611-a478-d188d25bd39b.png)

- Negating Two's Complement Numbers
  1. 모두 0➡️1, 1➡️0 한다.
  2. 1을 더한다. 
- Sign bit인 0,1로 음양 표시
- 0 표현법이 하나

### Sign/Magnitude
![image](https://user-images.githubusercontent.com/56028436/137634001-ef437f20-da08-4182-87f8-89155714ead3.png)

- 앞에 Sign bit를 추가해서 음양을 표시
- Problems
  - 0을 2가지 방법으로 표현할 수 있음 = 0이 2개
  - 하드웨어에서 다루기 어려움


### One's Complement
- Negating Two's Complement Numbers :  0➡️1, 1➡️0 한다.
- Problem
  - 0 표현법이 2가지

### Biased
Floating Point에서의 지수 표현에서 사용됨

- Add a bias (offset) to all numbers
  - 대부분의 음수: 000..0 = -2<sup>n-1</sup>
  - 0: 100..0 = 0
  - 대부분의 양수: 111..1 = 2<sup>n-1</sup>-1

### Sign Extension in MIPS
- lb(load-byte) 또는 lbu(load-byte unsigned) 사용
- I-Format 명령어(-16bit의 immediate field. 32bit로 변경될 필요 O)와 immediate operand에서 시행됨

# Adder
#### Subtraction with an Adder ; A - B = A + bit_invert(B) + 1

![image](https://user-images.githubusercontent.com/56028436/137736872-255d3160-1934-40ff-a75d-8eea7f40e7fb.png)
- Not Gate를 이용해서 !B를 계산하고 1을 입력


![image](https://user-images.githubusercontent.com/56028436/137737909-badf6f35-2b83-4e6f-af59-bd25ee684ee9.png)
- XOR gate를 이용해서 Add/Sub 계산
  - 더하기 : 0 : B 값 그대로
  - 빼기 : 1 : B 값 반대로

#### Overflow in Addition & Subtraction
- Overflow occurs when not enough bits are available to represent the result
- Operand의 정상적인 계산 결과의 부호와 `반대의 부호가 결과로` 출력된다면 오버플로우가 발생한 것이다!

*add, sub, addi는 오버플로우에 관해 runtime exception를 표시<br/>
*addu, subu, addiu는 오버플로우에 관해 runtime exception을 표시하지 않음

## Full Adder
![image](https://user-images.githubusercontent.com/56028436/137735441-de7be706-c805-4454-86f8-c3bfd0461a82.png)
![image](https://user-images.githubusercontent.com/56028436/137735483-1c5582f3-33cf-4dbd-a79e-a98892a9e0a1.png)
![image](https://user-images.githubusercontent.com/56028436/137735536-1541e4a5-a02b-4bba-9bfc-599cd97b6ba9.png)

- Sum: s<sub>i</sub> = a<sub>i</sub> XOR b<sub>i</sub> XOR c<sub>i</sub>
- Carry: c<sub>i+1</sub> = a<sub>i</sub>*b<sub>i</sub> + a<sub>i</sub>*c<sub>i</sub> + b<sub>i</sub>*c<sub>i</sub> <br/> c<sub>i+1</sub> = a<sub>i</sub>*b<sub>i</sub> + c<sub>i</sub>*(a<sub>i</sub>+b<sub>i</sub>)
- Carray Delay: 2 gate delays per one stage<br/>ex) 64 gate delays for 32-bit ripple adder

## Ripple Adder
![image](https://user-images.githubusercontent.com/56028436/137735666-f20d544b-5a3b-4799-b302-e0ef35300065.png)<br/>
String Full Adders

## Carry Lookahead Adder
![image](https://user-images.githubusercontent.com/56028436/137744732-8f2a0a67-1ec4-4c5b-9e25-1e6f7ed6dd12.png)

- Speeding Up by Define `Generate` and `Propagate`
  - Generate ; g<sub>i</sub> = a<sub>i</sub>*b<sub>i</sub>
    - a<sub>i</sub>와 b<sub>i</sub>가 모두 true이면 Adder는 항상 Carry를 생성해낸다.
  - Propagate ; p<sub>i</sub> = a<sub>i</sub> + b<sub>i</sub>
    - a<sub>i</sub> 또는 b<sub>i</sub> 중에서 하나만 true라도 Adder는 Carry 값을 생성해낼 수 있게 된다. 
  - 각각 계산하는 데 1 gate delay 소요
- Much More Logic ↔️ Faster Addition <br/>; Carry 값을 차례로 기다릴 필요 없이 a<sub>i</sub>와 b<sub>i</sub>를 동시에 대입해서 계산 가능
- `3 gate delays / 4 bit calculation`
  - a<sub>i</sub>와 a<sub>i</sub>로 p<sub>i</sub>와 g<sub>i</sub> 동시에 계산하기 ➡️ 1 gate delay
  - Carray Lookahead Unit에서 `c<sub>1</sub> - c<sub>4</sub>`  ➡️ 2 gate delay
  - 4 bit adder에는 유용하지만 여전히 16bit나 32 bit를 계산하기에는 delay가 크다.<br/>➡️Ripple/Lookahead Adder<br/>➡️Group-Lookahead Adder

## Ripple/Lookahead Adder
4 bit짜리 Carry Lookahead Adder를 Ripple 스타일로 모두 연결<br/>
![image](https://user-images.githubusercontent.com/56028436/137753239-a5c0c895-3ea0-4205-9127-b5c46b2f61fe.png)

- `2*n+1 gate delays/ 4*n bit calculation`
- Ripple Adder보다 빠르긴 하지만 여전히 delay가 크다.

## Group Carry-Lookahead Adder
![image](https://user-images.githubusercontent.com/56028436/137753819-9cab2301-3a4e-445e-aeff-0592b22842f1.png)

- Combine groups using second level
- Carry Lookahead를 4-bit의 한 그룹으로 설정 ➡️ `Super Propagate`와 `Supe rGenerate` 생성
- `5 gate delays / 16 bit calculation`
  -  a<sub>i</sub>와 a<sub>i</sub>로 p<sub>i</sub>와 g<sub>i</sub> 동시에 계산하기 ➡️ 1 gate delay
  -  p<sub>i</sub>와 g<sub>i</sub>로 P<sub>i</sub>와 G<sub>i</sub> 계산하기 ➡️ 2 gate delay
  -  P<sub>i</sub>와 G<sub>i</sub>로 C<sub>4</sub>(=c<sub>16</sub>) 계산하기 ➡️ 2 gate delay

*GateDelay 정리-16bits<br/>
|Adder|Ripple|Carry Lookahead|Ripple/Lookahead|Group Carry-Lookahead
|------|---|---|---|---|
|16bits|32|12|9|5|
|32bits|64|24|17|10|
|equation|2*n|3*(n/4)|1+2*(n/4)|5*(n/16)|

# ALU ; Arithmetic-Login Units
Combinational logic element that performs multiple functions depending on operation select bit<br/>
![image](https://user-images.githubusercontent.com/56028436/137769091-00e1466e-1c21-433e-94f6-65d6f7c06e33.png)

- Arithmetic: add, sbutract
- Logical: AND, OR

## Constructing ALU
![image](https://user-images.githubusercontent.com/56028436/137770369-5a68345f-c518-40f8-b617-2676c424a1d5.png)<br/>
⬇️ Putting it Together <br/>
![image](https://user-images.githubusercontent.com/56028436/137770480-5dd9f9c3-a120-49da-8ff5-3ec90c36d797.png)<br/>

*Overflow Detection in ALUs<br/>
c<sub>msb</sub>+1 ≠ c<sub>msb</sub> ➡️ overflow = 1

## Supporting slt Instruction
; A<B일 때 결과가 000...01 이려면 <br/>
➡️ A-B < 0 에서 좌변의 MSB가 1이면 bit<sub>31</sub>을 1로 만들고 그대로 slt의 결과로 출력<br/>

![image](https://user-images.githubusercontent.com/56028436/137772371-8b4af3da-7ab6-467f-8e3c-8a4690271e18.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/137772464-f5f9aba0-59eb-4ef3-919e-64ae0da3beb0.png)

1. A-B<0일 때 Set이 1이 될 수 있도록 설정
2. Set을 LSB의 Less로 보냄 ➡️ Operation _slt_ 작동 ➡️ Less<sub>i</sub>가 S<sub>i</sub> 값으로 튀어나옴

<br/>
![image](https://user-images.githubusercontent.com/56028436/137772949-f4a59997-8c04-438b-9399-9c05998b8ace.png)<br/>
*ALU Operation == ALU control input<br/>
*add와  subtract는 overflow 발생 가능성 O<br/>
*CarryOut = bit 31 = S<sub>31</sub>

# Multiplier Hardware - Sequential Multiplier
*Multiplier 곱하는 수 & Multiplicand 곱해지는 수<br/>
*n bit multiplicand * m bit multiplier = (n+m)bit product

- MIPS에서 곱셈 결과는 Hi 레지스터와 Lo에 저장
  - Hi - Product의 상위 32 bit ⏪ mfhi
  - Lo - Product의 하위 32 bit ⏪ mflo

## 1st Version
![image](https://user-images.githubusercontent.com/56028436/137774652-83cbe834-c1f1-4d61-aac1-6c2ef729d6b9.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/137774600-25b55855-a125-4b5d-ac58-a26efed82181.png)

- Multiplicand를 왼쪽으로 밀기
- Multiplier를 오른쪽으로 밀기
  - Multiplier의 LSB가 0이면 넘어가고 1이면 수행

- 개선점: 64-bit ALU를 사용하고 있기는 하지만 상위 32bit만 계산에 사용됨

## 2nd Version
![image](https://user-images.githubusercontent.com/56028436/137775161-2cda9395-efbe-4db4-8c53-245fad7747b8.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/137775213-c714478b-1e10-466f-a558-0637d226d8bd.png)

- Multiplicand는 가만히 있고 그 대신 Product를 오른쪽으로 밀기
  - Multiplier의 한 bit와 Multiplicand를 계산한 값을 Product의 **왼쪽**에 저장하고 오른쪽으로 한칸씩 밂
- Multiplier를 오른쪽으로 밀기

- 개선점: Multiplier와 Product(결과)를 한 레지스터 안에 저장 가능

## 3rd Version
![image](https://user-images.githubusercontent.com/56028436/137775782-d8bce298-fbc5-4923-a6a3-7b0da2c4a472.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/137775814-0d81124e-82d8-4149-ba1e-33cb33e9487c.png)

- Product를 레지스터의 **왼쪽**, Multiplier를 **오른쪽**에 저장하고 한꺼번에 오른쪽으로 밀기
  - Product에 필요한 움직임 구현 & 계산이 완료된 multiplier의 비트는 제거
   
# Division Hardware
*Divisor 나누는 수 & Dividend 나눠지는 수
- Dividend = Quotient * Divisor + Remainder
- Subtract shifted divisor from dividend when it "fits"
- 나누는 수와 나눠지는 수의 부호를 확인<br/>➡️ 서로 부호가 반대면 똑같이 만들어주기 & **나머지의 부호 = 나눠지는 수의 부호**
- MIPS에서 나눗셈 결과는 Hi와 Lo에 저장
  - Hi - 나머지
  - Lo - 몫
- Software must check for overfow, divide-by-zero 

## 1st Version
![image](https://user-images.githubusercontent.com/56028436/137891151-f89098d1-ab80-41f1-b6c1-859a2709d7de.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/137891215-47b41588-196d-4a83-b613-89b503fd1917.png)

- Divisor로 빼보기 
  - `결과(REM)<0` 이면 다시 더해서 원래 값으로 restore
  - `결과(REM)>0` 이면 QUOT를 왼쪽으로 밀고 LSB = 1로 설정
- Divisor을 오른쪽으로 밀기 

- 개선점
  - 64-bit ALU를 쓰고 있기는 하지만 계산할 때는 32-bit만 사용 (REM가 어차피 더 많은 공간을 사용하므로 DIVISOR에 큰 공간을 쓸 필요 X)
  - 먼저 빼보고 DIVISOR를 오른쪽으로 밀면 첫번째 단계에서는 절대로 몫이 1이 나올 수 없다. ∴ 순서를 바꾸면 iteration 순서 한 번 절약 가능

## 2nd Version
![image](https://user-images.githubusercontent.com/56028436/137892527-2d8edf37-24eb-45cf-87e8-f0d1f4dbaeee.png)

- Divisor 고정
- REM을 왼쪽으로 한 칸 미는 걸로 시작 ➡️ Repition을 33에서 32로 절약 
- Dividend 혹은 (Subtraction이 진행되면서는)Remainder를 담은 Register를 왼쪽으로 밀기 ➡️ 32bit ALU 사용 가능
- 결과값 = Upper Half of REM 레지스터

- 개선점: REM을 왼쪽으로 밀다보면 오른쪽에 남는 공간 생김

## 3rd Version
![image](https://user-images.githubusercontent.com/56028436/137892579-4a135c97-8ce8-4608-b3b6-b63150df1a62.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/137892654-b34cb7cb-e853-4865-956c-3e302a1b10db.png)

- REM 레지스터의 남는 오른쪽에 Quotient를 함께 넣음
  - Dividend/REM과 Quotient가 왼쪽으로 함께 이동


# Floating Point
To represent _Very large numbers, Very small numbers, Rational numbers, irrational numbers, Transcendental numbers_, Adapting scientific notation to binary <br/>
![image](https://user-images.githubusercontent.com/56028436/137894332-5c7da602-d3ae-4f9c-89e9-0258abf42ed4.png)

- Trade off between precision and range<br/>= Arithmetic is **approximate**(무한소수X) ➡️ 에러 발생을 피하기 힘듦_inevitable_!
- MIPS Floating Point Instructions
  - Basic operations: ex) add.s - single, add.d - double

## Single precision_32bits_float type
![image](https://user-images.githubusercontent.com/56028436/137894602-621c629b-983e-46ec-b1b8-652240ede3b9.png)
- Bias = 127

## Double precision_64bits_double type
![image](https://user-images.githubusercontent.com/56028436/137894653-9ec92f31-699f-45af-a751-32d6df3336cc.png)
- Bias = 1023

