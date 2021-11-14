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

## Control Hazards ; beq
```
attempt to make decision before condition is evaluated
```
- 값을 비교하고 브랜치 타겟을 결정할 수 있는 **하드웨어를 2번째(ID)에 삽입** <br/>➡️ 2번째 clock cycle만에 브랜치 실행 가능

‼️ 하지만 여전히 다음 명령어에서 결과 load는 불가능함 ‼️

> 해결방법
> - Stall ; 비교 결과값을 사용할 수 있을 때까지 1 clock cycle 기다리기 (hardware unit 추가 하지 않았으면 2 cycle 기다려야함)
> - Predict ; 결과를 예측해서 행동한 뒤 fetching하기(예측이 틀렸을 경우 되돌린다)
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

- [다시이해하기]Add hardware to feed back ALU and MEM(blue) results to both ALU inputs

