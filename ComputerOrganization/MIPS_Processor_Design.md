명령어를 메모리로부터 fetch해와서 ISA에 의해 특정된 명령어들을 실행하는 하드웨어를 설계한다.

# Steps in Processor Design - Single-Cycle Implementation
1. Analyze instruction set ; get datapath requirements _어떤 datapath 구성 요소가 디자인 되어야하는지_
2. Select datapath components and Establish clocking methodology
3. Assemble datapath that meets requirements
4. Determine control signal values for each instruction(for open or block)
5. **Assemble control logic to generate control signals** 

*Processor Implementation Styles - 1 clock cycle = 1 up&down
- Single Cycle ; 1 명령어 - 1 clock cycle
  - CPU가 한 명령어를 1 clock cycle 내에 처리
  - worst case를 기준으로 1 clock-cycle time을 설정해야함 ➡️ 속도가 가장 `느린 명령어`까지 밖에 빨라질 수 없음
- Multi-Cycle ; 1 명령어 - n clock cycle 
  - fetch/execute cycle을 여러 step으로 나눔 
  - 1 step을 1 clock cycle 내로 처리 ➡️ 빠른 명령어 - 적은 step
- Pipelined ; n 명령어를 동시에 `parallel`
  - Multi-Cycle처럼 한 명령어를 여러 step으로 나누고 1 step을 1 clock cycle 내에 처리
  - CPU가 이러한 명령어 여러 개를 **parallel하게** 처리함 - `assembly line`

### MIPS Lite
- Use MIPS to illustrate processor design
- **Limit** initial design to a subset of instructions
  - Memory access: `lw`, `sw`
  - Arithmetic/Logical: `add`,`sub`,`and`,`or`,`slt`
  - Branch/Jump: `beq`,`j`
- Add instructions as we go along

## 1. Get Datapath Requirements - Hardware Components
- Memory
  - I-Memory for instruction
  - D-Memory for data
- 32개의 Registers
  - _read_ from _rs_ field
  - _read_ from _rt_ field
  - _write_ from _rd_ or _rt_ filed
- PC_Program Counter
- Sign Extender
- Add and Subtract (register values) in ALU
- Add 4 or extended immediate to PC
  - 명령어 fetch 후 자동 PC+4
  - jumping이나 branching으로 인한 PC extending

## 2. (a) Choose Datapath Components

### Combinational Components 
`not related with memory/data storage`

  - Adder
  - ALU
  - Multiplexer
  - Sign Extender

*실제로 메모리 장치처럼 데이터를 가지고 있지는 않음!


### Storage (Components)
새로운 값은 Enable 상태에서 **clock edge일 때** 로드됨

  - Registers
  - Register File <br/>; repository for all the registers <br/>; 여러 레지스터에 접근할 수 있는 하나의 location<br/>![image](https://user-images.githubusercontent.com/56028436/138080962-ae14ecd6-0952-4c34-83da-29175669a869.png)
    - 2 Data Outputs:  RD1 = 1 ➡️ RN1, RD2 = 1 ➡️ RN2
    - RegWrite = 1 ➡️ **clock edge**동안 WD 값을 WN에 저장
  - Memory<br/>![image](https://user-images.githubusercontent.com/56028436/138080719-fa8ceb85-99df-4022-8c4f-5ae1d1b5a192.png)
    - Data Read
      - MemRead = 1 && MemWrite = 0
      - ADDR에 주소 넣어두면 access time 이후 RD에 읽은 값 로드 
    - Data Write
      - MemRead = 0 && MemWrite = 1
      - ADDR에 주소, WD에 input 넣어두면 `clock edge`에 ADDR에 WD 저장

## 2. (b) Choose Clocking Methodology
저장소에 있는 내용을 언제 읽고, 저장소에 언제 내용을 쓸 수 있는지 결정

- Typical clocking methodologies
  - `Single-Phase Edge Triggered` ; edge에서만 가능
  - Single-Phase Level Triggered ; low or high level에서만 가능
  - Multiple-Phase Level Triggered ; low and high level에서 가능

### Edge-Triggered Clocking
![image](https://user-images.githubusercontent.com/56028436/138081799-9476de4a-72e5-4214-9764-4b5cf5ce9b7d.png)

- t<sub>clock</sub> > t<sub>prop</sub> + t<sub>setup</sub>
- t<sub>clock</sub> = t<sub>prop</sub> + t<sub>setup</sub> + t<sub>slack</sub>
- 첫번째 edge에서 data가 register output에서 combinational logic으로 로드됨
- 다음 edge 전까지 t<sub>prop</sub> 동안 combinational logic이 처리를 끝냄

## 3. Assemble datapath

*MIPS Instruction Execution
1. **Fetch Instruction** from memory
2. Decode Instruction and **read register values**
3. if necessary, perform an **ALU operation**
4. If **load or store**, do memory access
5. **Write** results back to register file and increment PC by PC+4 / direct jumping / indirect jumping

### 1) Datapath for Instruction Fetch
![image](https://user-images.githubusercontent.com/56028436/138082473-08bce632-daf9-4c97-8554-2a4c343079c4.png)

- Instruction ⬅️ Memory[PC]<br/>*PC값 = 메모리에서 instruction을 가리키는 주소
- PC ⬅️ PC + 4 ; RD로 명령어 나오고(fetch 완료) PC 값 update

### 3) Datapath for R-Type Instructions
![image](https://user-images.githubusercontent.com/56028436/138082739-c7a7d787-2a0d-4ff4-943b-52d7b06cc5ac.png)<br/>

*Operation Bit ; 010 ➡️ ADD
 
