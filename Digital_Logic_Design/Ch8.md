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
- Circuit에서 점선이 있음 ➡ `Mealy type` : outputs depend on both the state and the primary inputs ; 과거의 정보와 현재의 정보 ➡ output

![image](https://user-images.githubusercontent.com/56028436/122072611-b37e0800-ce32-11eb-9811-91367e4adca0.png)<br/>
*w:input & z:output <br/>
- All changes in the circuit occur on the **positive edge of a clock signal**
- input에서 1이 2개 연속되어 나옴 ➡ output = 1<br/>
⇒ 이를 인식하는 circuit ; sequence detectors

## State Diagram
![image](https://user-images.githubusercontent.com/56028436/122073067-17a0cc00-ce33-11eb-8f60-03dccfbc2f11.png)
<br/> *arrow ; transition & circle ; state
- Starting state(initial) ; Reset을 가진다
  - Reset이 high면 initial로 간다.

- For creating circuit, we draw state table<br/>
![image](https://user-images.githubusercontent.com/56028436/122073944-c80ed000-ce33-11eb-8425-c8f333ffdb0a.png)
- To produce the desired truth table, we assign a specific valuation of variables y1 and y2 to each state
  - 사용하지 않는 valuation은 don't care 값으로 지정한다 ➡ 후에 simpler한 circuit 제작
- 어떤 flip-flop을 사용할지도 결정해야하는데 보통은 값이 그대로 들어가서 나오는 D-type flip-flops(_positiv edge) 사용<br/>
![image](https://user-images.githubusercontent.com/56028436/122077015-5421f700-ce36-11eb-8ea1-a2e0decb8811.png)
  - 해당 circuit은 Moore type. (w에서 output을 계산하는 combinational circuit을 잇는 선이 있으면 Mealy type)

*3 different states ➡ 2 flip-flops( = 2 state variables) ; 00, 01, 10, 11<br/>
6 different states, 8 different states ➡ 3 flip-flops <br/>
16 different state ➡ 4 flip-flops

## Derivation of Next-State and Output Expressionns
- The required logic expressions can be derived using K-maps & SOP
- Using Don't Cares can make the logic expressions simpler
