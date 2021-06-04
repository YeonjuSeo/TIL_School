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
- Characteristic table ; `Qa값(위) = !R값`

<br/>

- (S,R): (0,0) or (1,0) or (0,1) ➡ (0,0) ; previous value 유지
- (S,R): (1,1) ➡ (0,0) ; unknown이 된다.

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

- Clk가 0이면 S, R 값에 관계없이 이전 Q 값 유지
- Clk가 1이면
  - (S,R)이 (0,0)이면 이전 Q 값 유지
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
  - Clk가 high(인 동안)면 delay가 있더라도 Q와 !Q가 D 변화에 따라서 변한다. `D = Q`
  - Clk가 low(인 동안)면 D가 변해도 Q와 !Q는 이전값을 유지한다(변하지 않는다.)

# Flip-Flops
- Clk의 값이 변경되는 `edge of a controlling Clk`에서만 Q값이 변경될 수 있다.<br/>
  ↔Latch는 high이면 Q값 변경 가능
- 한 Clock Cycle동안 Q 값이 유지된다 ➡ computing 시간 제공
- 1bit(0 or 1)만 저장 가능

*Clock Cycle: low-high 혹은 high-low를 한 번 반복<br/>

## Master-Slave D Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120480477-09da5800-c3ea-11eb-8717-0adbbf1e4626.png)
![image](https://user-images.githubusercontent.com/56028436/120480720-53c33e00-c3ea-11eb-9cf1-bf875e071584.png) <br/>
![image](https://user-images.githubusercontent.com/56028436/120742375-b96e1200-c531-11eb-8575-aa0aa0dfb5a8.png)


- `negative edge(1➡0)`에서 Q 값에 D가 반영(= Q 값이 변화) <br/>
  - Clk가 1 : D값이 Qm에 반영 in Master ➡ Clk가 0 : Qm 값이 Q에 반영 in Slave

## Edge-Triggered D Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120481322-f4196280-c3ea-11eb-9a65-b48500361c0c.png)
![image](https://user-images.githubusercontent.com/56028436/120481363-01365180-c3eb-11eb-86f2-95e2ce2116e9.png) <br/>
![image](https://user-images.githubusercontent.com/56028436/120742422-cbe84b80-c531-11eb-8730-693e8d64d2fb.png)


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
*Asynchronous clear: Clk 값이 결과값에 영향을 주지 않고 Preset/Clear의 값 변환에 따라 바로 Q 값이 변화된다.<br/>
*Synchronous clear: Clk 값에 맞춰 결과값이 변화한다.(= edge일 때 Clear의 값에 따라 Q가 결정.)

## T Flip-Flop
![image](https://user-images.githubusercontent.com/56028436/120484389-fb8e3b00-c3ed-11eb-9a30-a14faafe7db9.png)
![image](https://user-images.githubusercontent.com/56028436/120484410-01841c00-c3ee-11eb-978a-fb33bad45737.png)
<br/>
*Positive Edge signal 때만 변경 가능<br/>
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
; Connected Flip-flops (= multiple Flip-flops)<br/>

### Shift Register
![image](https://user-images.githubusercontent.com/56028436/120641270-5dae7500-c4ae-11eb-8df8-fd773a54fed2.png)
<br/>
*positive edge clock signal에서만 값 변화 가능 <br/>
- 왼쪽으로 shift = 2배
- 오른쪽으로 shift = 1/2배

*이동하려는 bit수만큼의 cycle을 기다려야 원하는만큼의 shift를 진행할 수 있다.

## Parallel-Access Shift Register
![image](https://user-images.githubusercontent.com/56028436/120641529-a6fec480-c4ae-11eb-9c0f-b7828f836845.png)
<br/>
- Load = 1 ➡ Parallel input 값이 flip-flop에 Load
  - 왼쪽의 gate는 무용지물, 오른쪽 gate를 사용
- Load = 0 ➡ 입력한 Serial input 값으로 shift 진행
  - 오른쪽 gate는 무용지물, 왼쪽 gate에 Serial input이 전달된다.

즉, control signal에 따라 serial input과 parallel input 중 다른 값을 사용<br/>
*shift를 위해 Serial input에 값을 넣을 때 음수면 1을 넣기도 한다.<br/>
*바꾸고자하는 수를 한 번에 입력할 수 있다.(parallel input)

# Counter
- asynchronous : Common Clk 사용하지 않음 ➡ Q가 다음 Q에 영향
- synchronous : Common Clk 사용
<br/>

## Asynchronous Up-Counter with T Flip-Flops
![image](https://user-images.githubusercontent.com/56028436/120642228-9864dd00-c4af-11eb-8eb7-b666b8d8bf1e.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120642548-001b2800-c4b0-11eb-8f0e-394ca1f73907.png)
<br/>
*positive edge에서 값이 바뀜<br/>
- 3개의 bit 저장 가능 = 0~7까지 헤아릴 수 있음
- [Clk = 1] Q<sub>n-1</sub> = 0 ➡ Q<sub>n</sub> 전환
- [Clk = 0] Q<sub>n-1</sub> = 1 or Q<sub>n-1</sub> 값에 변화 없음 ➡ Q<sub>n</sub> 유지

## Asynchronous Down-Counter with T Flip-Flops
![image](https://user-images.githubusercontent.com/56028436/120642638-1d4ff680-c4b0-11eb-8fd4-d9095e77858f.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120642757-41133c80-c4b0-11eb-9512-dbf6ed1d479f.png)
<br/>
- 3개의 bit 저장 가능 = 0~7까지 헤아릴 수 있음
- [Clk = 0] Q<sub>n-1</sub> = 0 or Q<sub>n-1</sub> 값에 변화 없음 ➡ Q<sub>n</sub> 유지
- [Clk = 1] Q<sub>n-1</sub> = 1 ➡ Q<sub>n</sub> 전환

## Synchronous Counter with T Flip-Flops
![image](https://user-images.githubusercontent.com/56028436/120643023-98191180-c4b0-11eb-8b3b-a72b44cb0314.png)
![image](https://user-images.githubusercontent.com/56028436/120643209-d31b4500-c4b0-11eb-85f9-9d81aa8cbaaa.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120643178-ca2a7380-c4b0-11eb-9cc8-b0661a537f23.png)
<br/>
*Timing diagram을 볼 때 delay 고려 필요<br/>
- Q<sub>0</sub> ~ Q<sub>n-1</sub>까지의 값이 모두 1이어야 Q<sub>n</sub> 값이 1로 전환


### Synchronous Counter with Enable and Clear Capability

![image](https://user-images.githubusercontent.com/56028436/120645247-29898300-c4b3-11eb-93f2-bea2f77473ac.png)
<br/>
- Clear ➡ 모든 flip-flop의 Q 값이 0으로 변환
- Enable = 0 ➡ flip-flop이 Q 값을 저장
- Enable = 1 ➡ Toggle 시작

## Synchronous Counter with D Flip-Flops
![image](https://user-images.githubusercontent.com/56028436/120645632-9866dc00-c4b3-11eb-9e44-da3c4e65c8c2.png)
<br/>
- The JK flip-flops can be used in exactly the same way as the T flip-flops
- Enable = 1 ➡ XOR gate가 Qn 값을 toggling
  - Q<sub>0</sub> ~ Q<sub>n-1</sub>까지의 값이 모두 1이어야 Q<sub>n</sub> 값이 1로 전환<br/>*Synchronous Counter with T Flip-Flops과 동일

## Counters with Parallel Load
![image](https://user-images.githubusercontent.com/56028436/120646004-0a3f2580-c4b4-11eb-99db-d69bd7d33ef3.png)
<br/>
*Load 위해 NOT gate 사용<br/>
- Load = 0 ➡ XOR gate 값이 D로 입력(앞의 Synchronous Counter with D Flip-Flops과 동일)
- Load = 1 ➡ D들이 각각의 flip-flop에 저장
- Often it is necessary to start counting with the initial count being equal to 0
- Sometimes, it is desirable to start with a different count<br/>➡ Load 필요
  - Load = 1 해서 D에 값 입력 ➡ 값 저장 ➡ Load = 0, Enable = 0으로 변경 ➡ D에 입력한 값대로 count 시작

## Modulo-6 Counter with Synchronous Reset
![image](https://user-images.githubusercontent.com/56028436/120647526-a9b0e800-c4b5-11eb-8f59-953893481255.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120648064-33f94c00-c4b6-11eb-976d-a21b300c921d.png)
<br/>
- 2의 배수인 수 외의 수를 헤아리고 싶을 때
- 0~5까지 총 6개의 수만 count
- 5에 도달하면(Q<sub>0</sub> = 1 & Q<sub>2</sub> = 1) **다음 cycle에** Q값이 모두 0으로 reset된다.

## Modulo-6 Counter with Asynchronous Reset
![image](https://user-images.githubusercontent.com/56028436/120648307-715dd980-c4b6-11eb-9780-8f4280e2fbf9.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/120648339-7a4eab00-c4b6-11eb-83d3-e9068026f7a7.png)
<br/>
- 0~5까지 총 6개의 수만 count
- 5에 도달하면(Q<sub>0</sub> = 1 & Q<sub>2</sub> = 1) **바로** Q값이 모두 0으로 reset된다.

<br/><br/>
*synchronous reset은 실질적으로 5까지, asynchronous reset은 실질적으로 4까지 헤아리고 0으로 바뀐다. <br/>
*Asynchronouos Timing diagram에서 확인할 수 있듯 한 cycle에서 2개의 값이 나타나는 것은 다른 연결 logic에 영향을 줄 수 있기 때문에<br/>
➡ `Synchronous reset is a better choice than asynchronous reset`


## Binary-Coded-Decimal (BCD) Counter
![image](https://user-images.githubusercontent.com/56028436/120648973-34dead80-c4b7-11eb-8795-26a2414f630d.png)
<br/>
- using two modulo-10 counters
- it is necessary to reset the four flip-flops after the count of `9` has been obtained `Using Load` <br/>*9 ➡ 09

## Ring Counter
![image](https://user-images.githubusercontent.com/56028436/120682401-610a2680-c4d7-11eb-8d05-f40f0d5a64e8.png)
<br/>
- 1000 ➡ 0100 ➡ 0010 ➡ 0001 ➡ 1000 ➡ …
- Q 값 중 `하나만 1`이고 나머지는 0
- Take Q output of the last stage and feed it back to the first stage

### Johnson Counter
![image](https://user-images.githubusercontent.com/56028436/120682712-bc3c1900-c4d7-11eb-945e-b40a302e8307.png)
<br/>
*Variation of Ring Counter<br/>
- 0000 ➡ 1000 ➡ 1100 ➡ 1110 ➡ 1111 ➡ 0111 ➡ 0011 ➡ 0001 ➡ 0000 ➡ ...

# Design Examples
## Bus
![image](https://user-images.githubusercontent.com/56028436/120683070-26ed5480-c4d8-11eb-97fd-cbc909e88264.png)
<br/>
- Each register is connected to a **common set of n wires**, which are used to transfer data into an out of the register
- External = 1 & 수많은 register 중 하나만 1 ➡ 해당 register에만 저장 가능(0인 것에는 불가)

![image](https://user-images.githubusercontent.com/56028436/120683188-484e4080-c4d8-11eb-9d6a-05ec9cfa0e85.png)
<br/>

- R<sub>in</sub> = 0 ➡ 이전의 Q 값이 D로 이동
- R<sub>in</sub> = 1 ➡ External Data가 D에 저장

![image](https://user-images.githubusercontent.com/56028436/120683406-8a778200-c4d8-11eb-8b22-366a570c9c84.png)

<br/>

- Load Data 
  - External Data 입력 ➡ Rx = 1 ➡ Register x에 저장
- Move Rx to Ry
  - Rx<sub>out</sub> = 1 && Ry<sub>in</sub> = 1 ➡ common wire를 이용해서 이동
- Add Rx and Ry<br/>➡ 더해서 옮기기까지 총 5 Clock Cycle 소요
  - Rx<sub>out</sub> = 1 && A<sub>in</sub> = 1 ➡ Rx 값은 Register A로
  - Ry<sub>out</sub> ➡ Ry 값은 Adder로 ➡ Adder에서 두 값 더한 뒤 Register G로 
  - G<sub>in</sub> = 1 ➡ Register G가 더한 결과 저장
  - G<sub>out</sub> = 1 && Rx<sub>in</sub> = 1 ➡ Rx에 더한 값 이동
