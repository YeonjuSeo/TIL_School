# Pipelining
A way of speeding up execution of instructions
```
Key idea: Overlap execution of multiple instructions
```
- 여러 명령어가 동시에 수행될 수 있어서 속도가 빨라진다.
  - 이러한 행동은 단계가 레지스터로 분리되어있어서 가능하다.
  - 최대 N배 빨라질 수 있다. (N: number of stages) 
- Pipelinine를 적용하면 throughput은 커지지만 latency는 그대로이다.
  - 결과물은 200ps마다 이용가능한 상태가 되긴하지만 하나의 연산에는 여전히 1ns가 든다.
- Limitations
  - 연산이 stage 크기로 나뉠 수 있어야만 한다.
  - Pipeline register가 오버헤드를 더한다.
  - 명령어가 서로서로를 방해할 수 있다. _Hazards_
    - 다른 명령어끼리 하드웨어의 동일한 부분을 동일한 clock cycle 동안 가져다 써야하는 경우
    - 최악의 경우 실행을 멈춰야할 수도 있다 _stall_

> What happens if we break execution into multiple cycles, but keep the extra hardware?

```
In the best case, we can start executing a new instruction on each
clock cycle – this is pipelining
```

## Pipelining a Digital System
```
Key idea: break a big computation up into pieces
```
![image](https://user-images.githubusercontent.com/56028436/141671473-cb0a8a43-7c23-41e5-9ca2-9db44fddbb51.png)

- Separate each piece with a **pipeline register** <br/>➡️ It's faster for repeated computation
  - pipeline ❌ ➡️ 1 operation / 1ns
  - pipeline ⭕️ ➡️ 1 operation / 200ps (쪼갰으니까)

![image](https://user-images.githubusercontent.com/56028436/141671932-dd5e3e14-7f99-46a0-b851-b00e92cf20a4.png)

- Pipelining 단계
  1. IF - Instruction Fetch
  2. ID - Instruction Decode
  3. EX - Execute / Address Calculation
  4. MEM - Memory Access (read / write)
  5. WB - Write Back (results into register file)


# Pipeline Hazards
Where one instruction **cannot immediately** follow another

- 모든 Hazards는 기다리는 것만으로도 해결할 수는 있다.

## Structural Hazards
```
attempt to use same resource twice
하나의 하드웨어에 2 명령어
```
![image](https://user-images.githubusercontent.com/56028436/141672126-4fe1233f-6c95-4e42-9c48-379148f0dcb0.png)

> 해결방법
> - Stall ; 2번째 접근을 1 clock cycle 늦춘다.
> 또는
> - Harvard Architecture ; 명령어와 데이터로 메모리를 분리한다.(실제로도 캐시 분리를 하고 있음)

## Control Hazards = Branch Hazards ; beq
```
attempt to make decision before condition is evaluated
```

![image](https://user-images.githubusercontent.com/56028436/142715797-2d0737c2-0063-43cf-9ac7-b73715113bfa.png)

- 값을 비교하고 브랜치 타겟을 결정할 수 있는 **하드웨어를 2번째(ID)에 삽입** <br/>➡️ 2번째 clock cycle만에 브랜치 실행 가능

### 1-Bit Predictor: Shortcoming
가장 최근의 결과 하나를 저장

![image](https://user-images.githubusercontent.com/56028436/142716426-06fbcdd7-7917-4fe1-96f2-8d02495cee24.png)<br/>
_Inner loop branch에서 두 번 예측을 실패한 경우_

- (?) inner loop의 가장 최근 iteration에서 branch를 하는 mispredict 발생<br/>➡️ 다음 inner loop의 첫번째 iteration에서는 branch를 하지 않게 될 것이다?

### 2-Bit Predictor
가장 최근에 발생한 2 결과를 저장<br/>

![image](https://user-images.githubusercontent.com/56028436/142716588-43fc7780-e6e9-4bdd-8a0b-ba0636d8b847.png)

- (?)2번 잘못 예측하면 상태를 바꾼다.


‼️ 하지만 여전히 다음 명령어에서 결과 load는 불가능함 ‼️

> 해결방법
> - Stall ; 비교 결과값을 사용할 수 있을 때까지 1 clock cycle 기다리기 (hardware unit 추가 하지 않았으면 2 cycle 기다려야함)
> - Predict(Branch Taken) ; 결과를 예측해서 행동한 뒤 fetching하기(예측이 틀렸을 경우 되돌린다)
> - Delayed branch ; 항상 실행되는 명령어를 다음 명령어로 두기



### Stall
![image](https://user-images.githubusercontent.com/56028436/141672327-fa52637d-9499-40e5-8749-a7a477036ba4.png)

- beq가 ID일 때 결과 값을 load 해올 수는 없다.

### Correct Prediction
![image](https://user-images.githubusercontent.com/56028436/141672357-299928b2-ea15-480f-98ba-a3f2608d9071.png)

- 예측 결과가 맞으면 그대로 해나가고 틀렸으면 undo한다.<br/>➡️ 예측이 틀렸을 때만 Performance Penalty ⭕️
- 이전까지의 예측 결과를 활용해서 predictor의 성능을 높이면 평균적으로 실행 가능한 명령어의 수가 1을 향해 가까워진다.
  - 맞을 확률이 50%만 되어도 ; Expected one Instruction at this time = (맞을 확률 * 맞았을 때 실행시킬 수 있는 명령어의 수)0.5*1 + (틀릴 확률 * 틀렸을 대 실행시킬 수 있는 명령어의 수)0.5*0 = 0.5개의 명령어를 평균적으로 실행시킬 수 있다.

### Delayed Branch
![image](https://user-images.githubusercontent.com/56028436/141673026-32a53e88-ec45-427b-91dd-7383edde5dc8.png)

- 컴파일러가 명령어를 delay slot으로 재정렬한다.
- 재정렬이 안될 때는 nop을 넣는다.(~50%)

*This is how original MIPS worked

## Data Hazards
```
attempt to use data before it is ready
When data is used before it is stored
```
![image](https://user-images.githubusercontent.com/56028436/141673880-c34ebabd-0c5b-4435-8ab4-e9211e0d63e8.png)


> 해결 방법 
> - Stall ; 결과를 사용할 수 있을 때까지 기다리기 - 2 clock cycle
> - Forwarding ; datapath 내에서 데이터를 사용할 수 있게 하기
> - Reordering instructions ; hazards를 피하도록 컴파일러 사용하기

### Stall
![image](https://user-images.githubusercontent.com/56028436/141673909-f73af133-586b-4471-a729-6a4b1974e200.png)

- `add-sub`일 때나 `lw-sub`일 때나 2 clock cycle 기다려야함

### Forwarding
```
Key idea: connect new value directly to next stage
```

- `add - sub`
![image](https://user-images.githubusercontent.com/56028436/141673939-793ec79e-5b17-4d45-8b61-71b9f97a8458.png)<br/>

  - $s0를 읽긴하지만 무시하고 new value of s0를 받아들인다.

- `lw - sub`
![image](https://user-images.githubusercontent.com/56028436/141673979-fd4ec4a1-45eb-44e0-9317-a5a9dc37118a.png)<br/ >

* $s0가 rs라 EX의 위쪽으로

  - data가 MEM 이후부터 사용 가능하므로 그때까지는 기다린다.(1 clock cycle stall)

### Reordering Instructions
![image](https://user-images.githubusercontent.com/56028436/141674212-66deb930-cc5c-4d21-a374-edd744748769.png)

- Forwarding 사용 ; MEM 지마녀 lw의 $t2 값 사용 가능
- 1 clock cycle이 필요하므로 `sw $t2, 0($t1)`과 `sw $t0, 4($t1)` 자리 교체

# Piepelining in MIPS
![image](https://user-images.githubusercontent.com/56028436/141674383-56bf5ced-9ba2-41ba-a78c-9bda6954f34d.png)

- Memory operations only in lw, sw instructions (simplifies EX)
- Memory operands aligned in memory (simplifies MEM)

## Control
- Control Unit을 ID stage에 위치시킨다.
- Pass control signals to following stages
  - control signal을 pipeline register가 저장해뒀다가 필요한 건 restore해서 쓰고 안 쓰인 건 다음 pipeline register로 넘김

![image](https://user-images.githubusercontent.com/56028436/141674394-550a8e6a-404d-45af-919b-22ddce04469c.png)

*적절한 control signal을 저장해가며 사용하므로 stage마다 control signal이 다를 수 있다.

## Data Hazards
> 해결방법: Forwarding

```
Key idea : Connect data internally before it's stored
```
![image](https://user-images.githubusercontent.com/56028436/141674525-568b3f7d-b6a4-4464-9a3b-7068d306f999.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/141674596-ae9b3b44-6413-420c-894f-93b4f7b545c3.png)

- Add hardware to feed back ALU and MEM(blue) results to both ALU inputs

### To tackle data hazards, how can we detect EX Hazard and MEM Hazard? ; Controlling Forwarding
Need to test when register numbers match in _rs_, _rt_, and _rd_ fields stored in pipeline registers

![image](https://user-images.githubusercontent.com/56028436/142714683-6df966fa-f35a-4eef-919e-265b4facc7e9.png)

#### "EX" hazard
저장 전에 접근하려는 경우<br/>
ex)`add $s0, $t1, $t2` ➡️ `sub $t4, $s0, $t2`

- EX/MEM : test whether instruction writes register file and examine _rd_ register ; _rd_파일 점검 후에 레지스터에 작성
- ID/EX : test whether instruction reads _rs_ or _rt_ register and matches _rd_ register in EX/MEM ; rs 혹은 rt 레지스터의 값이 EX/MEM 에서의 rd값과 매치되는지

> 감지 방법: Forwarding Unit for EX Hazard

<br/> 저장 전에 접근하는 경우 방지

- rs의 경우 ; ForwardA = 10<sub>(2)</sub>
```
if(EX/MEM.RegWrite  // 쓰기 모드
&& (EX/MEM.RegisterRd !=0) // edge case
&& (EX/MEM.RegisterRd == ID/EX.RegisterRs)){ // 이전 명령어의 계산 결과가 first source register로 들어가는 경우
  ForwardA = 2
}
```

- rt의 경우 ; ForwardB = 10<sub>(2)</sub>
```
if(EX/MEM.RegWrite // 쓰기 모드
&& (EX/MEM.RegisterRd != 0) // edge case
&& (EX/MEM.RegisterRd == ID/EX.REgisterRt)){ // 이전 명령어의 계산 결과가 second source register로 들어가는 경우
  ForwardB = 2
}
```

##### register의 내용이 한 번 이상 바뀌는 경우에는?
➡️ Forward **most recent result** in MEM stage(= right after the EX stage)
```
add $1, $1, $2;
add $1, $1, $3;
add $1, $1, $4;
```
*I2 - I3 에서 EX hazard 발생



#### "MEM" hazard
- MEM/WB : test whether instruction writes register file and examine _rd(rt)_ register ; rd 파일 점검 후에 레지스터에 작성
- ID/EX : test whether instruction reads _rs_ or _rt_ register and matches _rd(rt)_ register in MEM/WB

> 감지 방법: Forwarding Unit for Mem Hazard

- rs의 경우 ; ForwardA = 01<sub>(2)</sub>
```
if(MEM/WB.RegWrite
&& (MEM/WB.RegisterRd !=0)
&& (MEM/WB.RegisterRd == ID/EX.RegisterRs)){
  ForwardA = 1
}
```

- rt의 경우 ; ForwardB = 01<sub>(2)</sub>
```
if(MEM/WB.RegWrite
&& (MEM/WB.RegisterRd !=0)
&& (MEM/WB.RegisterRd == ID/EX.RegisterRt)){
  ForwardB = 1
}
```

#### Branch Hazards = Control Hazards
> 해결 방법: data Forwarding

- If a comparison register is a destination of **preceding ALU instructio**n or **2<sup>nd</sup> preceding load instruction**


![image](https://user-images.githubusercontent.com/56028436/142715893-4fd34bc1-033b-46f5-ace5-6f7b892054a0.png)

  - 1CC 필요

*lw가 add보다 아래에 있었다면(두 명령어의 순서가 바뀌면)<br/>
lw와 beq 사이에는 1CC가 아닌 2CC가 필요하다.

- If a comparison register is a destination of **immediately preceding load instruction**


![image](https://user-images.githubusercontent.com/56028436/142716029-0803e19e-b736-4466-89a3-656a03283023.png)

  - 2CC 필요


##### Dynamic Branch Prediction
1. Branch history table(=Branch prediction buffer)를 확인
- recent branch instruction address로 인덱싱 되어있음
- 해당 명령어를 branch 했는지(taken) 하지 않았는지(not taken)을 기록해둠

2. 그에 따라 과거의 결과가 동일하게 branch 결과의 명령어 or branch하지 않고 넘어간 다음 명령어 중 하나로 fetching함
3. 틀렸다면 실행되던 pipeline 명령어를 날리고 prediction도 반전시킴

### Stall
![image](https://user-images.githubusercontent.com/56028436/142714999-ff555d7f-6cbb-481f-b8cf-f6df3e283e2a.png)<br/>

- I1 - I2 ; data forwarding을 해도 1CC stall 필요 ➡️ hazard detectoin unit 필요
- 이 때 Control Signal Unit(= ForwardingA) = 10<sub>(2)</sub>

#### Hazard Detection Unit

```
// lw case - how hazard detection unit detects the stall case
if(ID/EX.MemRead
&& ((ID/Ex.RegisterRt == IF/ID.RegisterRs) || (ID/EX/RegisterRt == IF/EX.RegisterRt))
```

- MUX가 ID 단계에 있는 명령어의 control signal을 날려버림(명령어 squash)
  - 뒤에는 "no-op(nop)"이 진행된다.
- IF/ID 단계에서는 stall 된 명령어를 다음 clock cycle까지 가지고 있는다.
- PC는 다음 clock cycle에서 이전의 명령어를 불러올 때까지 current value를 가지고 있는다.
  - 그러므로 stall 할 때 PC는 업데이트되면 안됨(stall된 명령어가 실행될 때 이미 PC에는 PC+4가 저장되어있기 때문). 1CC 지나고 나서 update 가능
    - Handler는 EPC-4로 가야 실행하다 오류난 곳으로 돌아가는 것!

# Exceptions & Interrupts
: Unexpected events requiring change in flow of control

- Exceptions: CPU 내부에서 발생<br/>ex) undefined opcode, overflow, syscall, ...
- Interrupt: 외부 I/O controller에서 발생

## Handling Exceptions
- In MIPS, exceptions managed by a System Control Coprocessor(CP0)

1. offending(or interrupt) 된 명령어를 PC에 저장 (MIPS에서는 EPC)
2. Indication of the problem을 저장 (MIPS에서는 Casue register에)
- 0: undefined opcode
- 1: overflow
3. 8000 00180에 있는 handler로 이동 (general하게 exception 해결 가능)
원인에 따라 이동되는 handler 주소가 다름
4. Handler에서 원인을 읽고
- 관련된 handler로 이동
- 필요한 action 결정
- If restartable(=Pipeline can flush the instruction)?<br/> corrective action 후 Handler가 EPC를 이용해서 원위치로(Refetch 후 처음부터 시작)
- 불가능 하다면? 프로그램 종료 후 EPC를 이용해서 Report

## Exceptions in a Pipeline
; Another form of **control hazard**<br/>
; Consider overflow on add in EX stage ; add $1, $2, $1<br/>

![image](https://user-images.githubusercontent.com/56028436/142718431-b9679607-8a28-4bdc-b1ef-129e48ba6c04.png)

- $1 손상 방지
- 이전 명령어 완수
- _add_와 다음 명령어를 flush
- 원인과 EPC 레지스터 값 설정
- handler에 주도권 이전

<br/>
- Example ; Exception on add

![image](https://user-images.githubusercontent.com/56028436/142718584-9ac43261-55b0-4f17-8a6b-466195ae70fa.png)


1. add를 포함한 subsequent insturctions flush
2. 적절한 handler 위치로 이동

![image](https://user-images.githubusercontent.com/56028436/142718513-34b8eccc-fb08-4c59-b7af-f19c17a5f409.png)<br/>

- IF : handler의 첫번째
- ID: lw flush
- EX: slt flush
- MEM : add flush

## Multiple Exceptions
- 한꺼번에 multiple exceptions가 발생할 수 있음
- "Precise" exception: 가장 쉬운 접근법은 earliest instruction의 exception부터 처리하는 것이다.(이후 명령어를 flush해가면서...)
- Imprecise exception
  1. Stop pipeline & Save state
  2. Handler 작동 ⬅️ 오류가 난 위치, 완수할 명령어와 flush할 명령어 구분


# Performance
- Response time: task를 수행하는 데 걸린 시간 ; 작을수록 좋음
- Throughput: 단위 시간 당 할 수 있는 총 일의 양 ; 클수록 좋음

------
- Performance = 1/Execution Time 
  - X is n time faster than Y<br/>![image](https://user-images.githubusercontent.com/56028436/142718796-2a9d3d58-f9d3-4339-ab1a-d291a4b09ac8.png)
- Elapsed time ; Total response time 
  - system performance를 결정지음

## CPU Clocking
; Operation of digital hardware governed by a constant rate clock.<br/>
![image](https://user-images.githubusercontent.com/56028436/142718883-5e9509f2-485d-4900-a30b-0c2a2eb5edbd.png)

- Clock period ; duration of a clock cycle
- Clock frequence (rate) = 1/ClockPeriod ; cycles per second
  - 높으면 주어진 시간 내에 더 많은 일을 처리할 수 있음을 의미

## CPU time = user CPU time + system CPU time
![image](https://user-images.githubusercontent.com/56028436/142719077-9297bc44-500f-4cc5-b32b-357f69e55ef6.png)<br/>
![image](https://user-images.githubusercontent.com/56028436/142719203-776c27fd-0cb5-4b38-b04f-88de89533492.png)

- 주어진 일을 처리하는 데 걸리는 시간
- Performance는 clock cycle의 수를 줄이거나, clock rate(frequency)를 늘림으로 향상된다.
- 다른 프로그램은 CPU와 시스템 성능에 의해 다르게 영향을 받는다.
- I/O times, other job's share는 제외
- 성능은 알고리즘, 프로그래밍 언어, 컴파일러, ISA에 의해 달라진다.

![image](https://user-images.githubusercontent.com/56028436/142719123-00f68bbe-824c-4a20-9ba5-3a2766e1606f.png)

- 명령어수는 프로그램에 따라 다르다.(프로그램, ISA, compiler에 의해 결정)
  - If different instruction classes take different numbers of cycles<br/>![image](https://user-images.githubusercontent.com/56028436/142719171-5c88a7de-49e3-4c2c-85d9-4cf0d111bd68.png)
  - Weighted average CPI<br/>![image](https://user-images.githubusercontent.com/56028436/142719187-51cb615f-c666-4dbc-be11-0c0172b07229.png)

- 평균 Cycle Per Instruction은 CPU 하드웨어에 의해 결정
  - 다른 명령어는 다른 CPI를 갖는다.
