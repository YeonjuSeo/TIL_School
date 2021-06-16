## Objectives
- Students should be able to create `Finite State Machines (FSMs)`
- Students should be able to state the differences between `Moore-type` and `Mealy-type` FSMs.

# Sequential Circuit
- Sequential circuit needs to store the state
- Clock signal is used to control the operation of a sequential circuit
  - Synchronous sequential circuit ; using Clk
  - Asynchronous sequential circuit ; not using Clk
- Synchronous sequential circuit ⬅ combinational logic + one or more flip-flops

![image](https://user-images.githubusercontent.com/56028436/122070111-a5c78300-ce30-11eb-9dab-37e022baa740.png)<br/>
> Sequential Circuit = Finite State Machines(FSMs)
- Flip-flops ; state 저장 장치
  - positive / negative edge-triggered type
- Combinational Curcuit ; current state의 output
<br/>

- Circuit에서 점선이 없음 ➡ `Moore type` : outputs depend only on the state of the circuit
  - 한 cycle 안에서 output 값이 변경되지 않는다
- Circuit에서 점선이 있음 ➡ `Mealy type` : outputs depend on both the state and the primary inputs ; 과거의 정보와 현재의 정보 ➡ output
  - 한 cycle(Clk) 안에서도 w 값이 바뀌면 output이 바뀔 수 있다.

![image](https://user-images.githubusercontent.com/56028436/122072611-b37e0800-ce32-11eb-9811-91367e4adca0.png)<br/>
*w:input & z:output <br/>
- All changes in the circuit occur on the **positive edge of a clock signal**
- input에서 1이 2개 연속되어 나옴 ➡ output = 1<br/>
⇒ 이를 인식하는 circuit ; sequence detectors

# input으로 1이 연속 2번이 나오는지 감지하는 Circuit 그리기_Moore State Model
1. State Diagram<br/>
![image](https://user-images.githubusercontent.com/56028436/122073067-17a0cc00-ce33-11eb-8f60-03dccfbc2f11.png)<br/> 
- arrow ; transition & circle ; state
- Starting state(initial) ; Reset을 가진다
  - Reset이 high면 initial로 간다.
- **State에서 output 생성**

2. State table<br/>
![image](https://user-images.githubusercontent.com/56028436/122073944-c80ed000-ce33-11eb-8425-c8f333ffdb0a.png)<br/>

3. Assign a specific valuation of variables y1 and y2 to each state
- 사용하지 않는 valuation은 don't care 값으로 지정한다 ➡ 후에 simpler한 circuit 제작
- 변수의 할당에 따라 simpler한 circuit이 만들어질 수 있으므로 변수의 할당을 다양하게 시도해봐야 한다.
- One Hot Encoding을 이용한 할당 ; state의 개수만큼 flip-flop을 사용하여 하나만 1이도록 valuation을 설계<br/>![image](https://user-images.githubusercontent.com/56028436/122083801-26d84780-ce3c-11eb-8909-8b83df1aa94e.png)<br/>
*state 개수만큼 flip-flop을 할당했으나 K-Map 계산 후 모든 logic expression에서 사용되지 않는 flip-flop은 생략 가능 


*3 different states ➡ 2 flip-flops( = 2 state variables) ; 00, 01, 10, 11<br/>
6 different states, 8 different states ➡ 3 flip-flops <br/>
16 different state ➡ 4 flip-flops

4. 어떤 flip-flop을 사용할지 결정<br/>
![image](https://user-images.githubusercontent.com/56028436/122077015-5421f700-ce36-11eb-8ea1-a2e0decb8811.png)<br/>
- 보통은 값이 그대로 들어가서 나오는 D-type flip-flops(_positiv edge) 사용
- 해당 circuit은 Moore type. (w에서 output을 계산하는 combinational circuit을 잇는 선이 있으면 Mealy type)

5. Derivation of Next-State and Output Expressionns
- The required logic expressions can be derived using K-maps & SOP
- Using Don't Cares can make the logic expressions simpler

6. Final implementation ; circuit 그리기<br/>
![image](https://user-images.githubusercontent.com/56028436/122081628-39518180-ce3a-11eb-86c7-e98f9eb11824.png)<br/>
앞선 logic expression들을 이용하여 circuit을 그린다

## Design Example_Ch7의 Bus
![image](https://user-images.githubusercontent.com/56028436/122081976-8b92a280-ce3a-11eb-8d43-57278d5b9928.png)<br/>
- The contents of a register R1 and R2 can be swapped using register R3 as a temporary storage locations
  - R2<sub>out</sub> = 1 && R3<sub>in</sub> = 1 ; R2의 내용물을 R3로 이동(**복사**)
  - R1<sub>out</sub> = 1 && R2<sub>in</sub> = 1 ; R1의 내용물을 R2로 이동
  - R3<sub>out</sub> = 1 && R1<sub>out</sub> = 1 ; R3에 있던 R2의 값을 R1으로 이동

![image](https://user-images.githubusercontent.com/56028436/122082458-ff34af80-ce3a-11eb-906d-8021f0efae1a.png)
- Functon(w) ; 시작 signal
- Common Clk를 이용하고 있으므로 **synchronous**

![image](https://user-images.githubusercontent.com/56028436/122082718-30ad7b00-ce3b-11eb-9f67-6a35ac49c6ad.png)<br/>
*state가 4개이므로 2 개의 flip-flop 사용<br/>
![image](https://user-images.githubusercontent.com/56028436/122083092-884be680-ce3b-11eb-9705-99a715a8c5bd.png)
<br/>
*공통되는 부분은 share해가며 circuit 만들기

# input으로 1이 연속 2번이 나오는지 감지하는 Circuit 그리기_Mealy State Model
![image](https://user-images.githubusercontent.com/56028436/122085394-a286c400-ce3d-11eb-8582-10d781e79f56.png)
- Mealy type : 연속된 1이 나온 **same Clk**에 output이 변화 ↔ Moore type : 다음 Clk에서 output 변화

1. State Diagram <br/>
![image](https://user-images.githubusercontent.com/56028436/122085785-07421e80-ce3e-11eb-9a88-c81a31501dee.png)
- **Transition에서 output 생성**

2. State table & 3. State Assignment<br/>
![image](https://user-images.githubusercontent.com/56028436/122086332-92bbaf80-ce3e-11eb-9444-98f5b9aeffdc.png)<br/>
*0과 1은 하나의 flip-flop에 저장 가능하므로 circuit 작성 시 한 개의 flip-flop만 그린다.

4. Derivation & 5. Circuit<br/>
![image](https://user-images.githubusercontent.com/56028436/122086462-b2eb6e80-ce3e-11eb-8417-641f61d917c0.png)<br/>
*값을 넘기기만해서 첫번째 Combinational circuit이 딱히 필요 없다.<br/>
*Timing Diagram<br/>
![image](https://user-images.githubusercontent.com/56028436/122089645-eda2d600-ce41-11eb-80b7-cfac75137dcc.png)<br/>
*t4 edge ; edge에서 w값이 1 ➡ y가 1(B state)로 && t4~t5에서 w가 1 ➡ output z도 1로
- positive edge일 때의 w 값 ➡ y 값의 state 결정 ; w가 1이면 y도 해당하는 state로 이동
- edge 이후 Clk 동안의 w 값 ➡ output z 값 결정 ; edge 후에도 1이면 output도 1로
- w값에 따라 Clk동안 z값이 변경될 수 있다 ↔ Moore type : 한 cycle동안 output z 값이 변할 일 X

## Serial Adder
- Ripple Carry Adder는 full adder 하나 당 한자리씩 연산이 가능하다.
- Using sequential circuit, we can make 32 bit serial adder with 1 full adder
- Serial Adder에서는 bit들이 각각 한 번(each clock signal)에 한 쌍씩 더해진다.

![image](https://user-images.githubusercontent.com/56028436/122223972-a0307280-ceee-11eb-9cf3-4a45ceed0ce7.png)

- A, B Register에 더할 수가 들어있고 하나씩 shift되면서 Adder FSM에 들어간다.
- C Register에도 shift되면 계산된 값이 들어온다

### Mealy-Type FSM for Serial Adder
![image](https://user-images.githubusercontent.com/56028436/122225121-bdb20c00-ceef-11eb-8e7b-c973bebcccc1.png)

- state는 carry out 값에 따라 2개가 필요.

*Mealy-type은 state에서 output을 생성하지 않는다.<br/>
![image](https://user-images.githubusercontent.com/56028436/122225333-ee924100-ceef-11eb-8eb2-3aab3aa8d2cb.png)
![image](https://user-images.githubusercontent.com/56028436/122225367-f7831280-ceef-11eb-8a12-27507ddd8b4e.png)<br/>
*K-Map을 통해서 minimum cost를 구하여 Y와 s 식 유도<br/>
![image](https://user-images.githubusercontent.com/56028436/122226115-9ad42780-cef0-11eb-8004-84845ac8338b.png)

### Moore-Type FSM for Serial Adder
![image](https://user-images.githubusercontent.com/56028436/122226231-bccdaa00-cef0-11eb-8924-4f6032672ddc.png)

- Moore-type FSM에서는 output이 state로부터 나와야하므로 2개 이상의 state가 필요

![image](https://user-images.githubusercontent.com/56028436/122226346-dc64d280-cef0-11eb-9aba-f6001956dc64.png)
![image](https://user-images.githubusercontent.com/56028436/122226454-f7cfdd80-cef0-11eb-8a9a-23423ea97977.png)
