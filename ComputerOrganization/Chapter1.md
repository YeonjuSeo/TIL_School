# Overview
- **Both** hardware and software affect program performance
  - software
    - Algorithm ➡️ number of source-level statements, I/O operation
    - Language, Compiler, Architecture ➡️ number of machine instructions
  - hardware
    - Processor, Memory ➡️ how fast instructions are executed
    - I/O system <br/>*I/O 시스템은 hardware와 OS(low-level software)에 모두 속한다!

# Computer Systems Overview
## Computer System Organization ; 5 Classic Components
1. Control in Processor ; 처리 명령
2. Datapath in Processor ; control에 따라서 실제로 data가 이동하는 통로
3. Memory ; 전원이 켜져이쓴 동안 프로그램과 데이터가 머묾(주로 RAM)
4. Input in Devices ; ex.키보드, 마우스, 스캐너, 디스크
5. Output in Devices ; ex.디스플레이 화면, 프린터, 디스크

## Computer System Operation
> Executing Programs - the "fetch/execute" cycle
- 각 줄을 가리키는 주소를 주고 명령어를 받아오는 `fetch`
- Control&Datapath에서 machine language를 실행하는 `execute`

위의 과정을 하나의 명령어마다 한 cycle씩 반복한다.

## Abstractions
- Language can be a abstraction layer in software <br/>ex.High-Level Language ↔️ Assembly Language ↔️ Machine Language
- In Software, we can also have system software abstractions <br/>ex.Operating system ↔️ Libraries

### **Instruction Set Architecture(ISA)** 
; Interface between hardware and low-level software

- Also called `architecture`
- Includes instructions, registers, memory access, I/O, key operations for executing computer system, ...
- Advantage : **different implementations** of the same architectur ; 발전 가능성⬆️
- Disadvantage : sometimes prevents using new innovations ; 유연성⬇️

<br/>
 *Architecture vs. Organization
 - Architecture ; `정의` of Registers, Memory model, Data types, Instructions
 - Organization ; `실구현` ; microarchitecture
