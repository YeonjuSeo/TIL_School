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
  - a<sub>i</sub>와 a<sub>i</sub>f
