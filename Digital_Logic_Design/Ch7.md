## Objectives
- Students should be able to state the definitions of **Latch** and **Flip-Flop**, respectively
- Students should be able to state the definition of **register**
- Students should be able to create **circuits for registers, counters, and a simple processor**

### Combinational Circuit
![image](https://user-images.githubusercontent.com/56028436/120361282-a1856b00-c344-11eb-804c-4c4af1a509ac.png)<br/>
: current input으로만 ouput을 결정하는 circuit

### Sequential Circuit
![image](https://user-images.githubusercontent.com/56028436/120361338-b06c1d80-c344-11eb-898b-b9bc530b8647.png)</br>
: present value 뿐만 아니라 이전의 circuit output까지 이용해서 output을 결정하는 circuit ➡ 메모리 필요
<br/> ➡ Fire alarm은 Sequential circuit을 이용하여 만들어야한다.
# Storage Elements
## Basic Latch
![image](https://user-images.githubusercontent.com/56028436/120361544-e6a99d00-c344-11eb-9ad1-4e12bd07b686.png)
  ![image](https://user-images.githubusercontent.com/56028436/120361598-f923d680-c344-11eb-8741-3f94762ccd16.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120361684-1789d200-c345-11eb-8a68-dcf09881e454.png)
<br/>
- 1 bit data 저장
- 2 개의 NOR gate
- 시작 시 initialize가 꼭 필요하다.
- Characteristic table ; `Qa값(위) = S값`

<br/>
- (S,R)이 (1,0) or (0,1) ➡ (0,0) ; previous value 유지
- (S,R)이 (1,1) ➡ (0,0) ; unknown이 된다.

## Gated SR Latch
![image](https://user-images.githubusercontent.com/56028436/120362178-be6e6e00-c345-11eb-9de4-ccfa589ad66c.png)
![image](https://user-images.githubusercontent.com/56028436/120362628-39d01f80-c346-11eb-906b-4254f23307d8.png)
![image](https://user-images.githubusercontent.com/56028436/120362196-c4644f00-c345-11eb-88c9-e6d497873222.png)
<br/>
*그림 수정 예정<br/>
![image](https://user-images.githubusercontent.com/56028436/120362668-4785a500-c346-11eb-88c2-398b7555274c.png)
<br/>
- Clk(= Enable bit)가 존재한다.

<br/>
- Clk가 0이면 S, R 값에 관계없이 이전 값 유지
- Clk가 1이면
  - (S,R)이 (0,0)이면 이전 값 유지
  - (S,R)이 (1,0) or (0,1)이면 `Q값(위) = S값`
  - (S,R)이 (1,1)이면 unknown ; `Oscillation`

<br/>
*2 AND gate와 2 NOR gate로 만든 Gated SR Latch는 4개의 NAND gate로도 만들 수 있다. ➡ 더 적은 gate수 
<br/>

![image](https://user-images.githubusercontent.com/56028436/120362846-7ef45180-c346-11eb-891e-85f723708574.png)

## Gated D Latch
![image](https://user-images.githubusercontent.com/56028436/120363128-c084fc80-c346-11eb-8360-55465d0713a9.png)
![image](https://user-images.githubusercontent.com/56028436/120363000-a2b79780-c346-11eb-818e-17b67acb4764.png)
![image](https://user-images.githubusercontent.com/56028436/120363023-a77c4b80-c346-11eb-94ac-98a1acc2e6c5.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120363395-122d8700-c347-11eb-9efe-354fb4747bc4.png)
<br/>
: S와 R (위치의)값으로 항상 반댓값만 생성되므로 `unknown state에 빠지지 않는다!` <br/>
- Level sensitive
  - Clk가 high면 delay가 있더라도 Q와 !Q가 D 변화에 따라서 변한다. `D = Q`
  - Clk가 low면 D가 변해도 Q와 !Q는 이전값을 유지한다(변하지 않는다.)

# Flip-Flops
- Clk의 값이 변경되는 `edge of a controlling Clk`에서만 Q값이 변경될 수 있다.<br/>
  ↔Latch는 high이면 Q값 변경 가능
- 한 Clock Cycle동안 Q 값이 유지된다 ➡ computing 시간 제공
- 1bit(0 or 1)만 저장 가능

*Clock Cycle: low-high 혹은 high-low를 한 번 반복<br/>
*Qm은 Clk가 high면 D를 따라 즉시 바뀐다 but Qs(= Q)는 꼭 edge에서만 변경된다.

## Master-Slave D Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120480477-09da5800-c3ea-11eb-8717-0adbbf1e4626.png)
![image](https://user-images.githubusercontent.com/56028436/120480720-53c33e00-c3ea-11eb-9cf1-bf875e071584.png) <br/>

- `negative edge(1➡0)`에서 Q 값에 D가 반영(= Q 값이 변화) <br/>
  - Clk가 1 : D값이 Qm에 반영 in Master ➡ Clk가 0 : Qm 값이 Q에 반영 in Slave

## Edge-Triggered D Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120481322-f4196280-c3ea-11eb-9a65-b48500361c0c.png)
![image](https://user-images.githubusercontent.com/56028436/120481363-01365180-c3eb-11eb-86f2-95e2ce2116e9.png) <br/>

- `positive edge(0➡1)`에서 Q 값에 D가 반영(= Q 값이 변화) <br/>
  - Clk가 0 : D값이 Qm에 반영 ➡ Clk가 1 : Qm 값이 Q에 반영

<br/><br/>
- D Latch ; Level Sensitive : Clk가 high(or low)일 때 결과가 변화
- Master-Slave & Edge-Triggered D Flip-Flop: edge에서 값 저장(변화), 한 cycle 간 유지

*Clk에서의 Not 여부로 `있으면 Master-Slave`, `없으면 Edge-Triggered`로 Graphical Symbol을 구분할 수 있다.

### Clear and Preset
![image](https://user-images.githubusercontent.com/56028436/120483600-3a6fc100-c3ed-11eb-89ca-169d3004fe53.png)
![image](https://user-images.githubusercontent.com/56028436/120483643-452a5600-c3ed-11eb-90a5-53ff00b1f914.png)
<br/>
Clk 값과 관계 없이
- Preset이 1➡0이 되면 `Q = 1`이 된다.
- Clear이 1➡0이 되면 `Q = 0`이 된다.

*Preset과 Clear 동작은 Master-Slave와 Edge-Triggered에서 동일하다.
<br/><br/>

![image](https://user-images.githubusercontent.com/56028436/120483726-596e5300-c3ed-11eb-82a7-5f145ee8096e.png)
<br/>
*Asynchronous clear: Clk 값이 결과값에 영향을 주지 않고 Preset/Clear의 값 변환에 따라 바로 Q 값이 변화된다.
*Synchronous clear: Clk 값에 맞춰 결과값이 변화한다.(= edge일 때 Clear의 값에 따라 Q가 결정.)

## T Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120484389-fb8e3b00-c3ed-11eb-9a30-a14faafe7db9.png)
![image](https://user-images.githubusercontent.com/56028436/120484410-01841c00-c3ee-11eb-978a-fb33bad45737.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120484542-27112580-c3ee-11eb-909b-45034f18acd1.png)
<br/>

; T가 `1`인 경우 Q가 그 다음 cycle에서 반대값으로 전환

## JK Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120484979-925af780-c3ee-11eb-950b-5aaa6dc31cc5.png)
![image](https://user-images.githubusercontent.com/56028436/120485001-98e96f00-c3ee-11eb-977a-849c897f18a5.png)
<br/>
; `D = J&!Q + !K&Q` <br/>
|J|K|Q(t+1)|설명|
|---|---|---|--------------|
|0|0|Q(t)| ➡ 이전 값 유지|
|0|1|0| ➡ Clear|
|1|0|1| ➡ Preset|
|1|1|!Q(t)| ➡ Qa 값이 반전됨|

# Registers
; Connected Flip-flops (= multiple Flip-flops)
