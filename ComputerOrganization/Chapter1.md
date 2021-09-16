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
 
 하나의 architecture 정의에 따라 여러 organization이 있을 수 있다.
<br/>

# Overview of Physical Implementations
*Physical Implementation of Hardware <br/>
- Integrated Circuits (ICs)
- Printed Circuit Boards (PCBs)
- Power Supplies
- Chassis
- Connectors and Cables

<br/>
*Organization of a Desktop PC<br/>

![image](https://user-images.githubusercontent.com/56028436/133563217-6eea33e1-8132-4867-bcc5-ab9e86630d1d.png)

<br/>
- `NorthBridge` is the chip or chips that connect a CPU to other components.
- `SouthBridge` is the chip that controls all of the computers I/O functions.
- `Intelligent Drive Electronics(IDE) interface` is an interface for mass storage devices.
- `Accelerated Graphics Port(AGP)` is based on PCI, but is designed for 3D graphics.
- `Peripheral Component Interconnect(PCI)` is a local bus standard.

## BIOS
- A **built-in software** & basic I/O system
- OS가 로드 되기 전 실행되어 키보드, 화면, 드라이브 등의 통제를 초기화/컨트롤 하는 코드를 가진다.
- always be available
- 읽기 전용 메모리(ROM)에 위치해서 disk failure로 인해 손상되지 않음

# Computer Systems Overview
*Instruction Sets<br/>
- R type ➡️ Arithmetic & logical operation
- I type ➡️ Loading / Storing data
- J type ➡️ Jumping in certain instructions

## Performace
- `Response Time` : 주어진 일을 끝내는 데 걸리는 시간
- `Throughput` : 일정 시간 내에 얼마나 많은 일을 수행할 수 있는지
<br/>

### Processor Implementation
<img width="468" alt="스크린샷 2021-09-16 16 02 37" src="https://user-images.githubusercontent.com/56028436/133565786-e12a2cab-3d89-48ad-9eae-50a55f814e3d.png">
<br/>
- Basic Implementation ; 한 instruction이 끝나야 다음 instruction 실행
  - Single-Cycle ; 1 clock cycle 동안 한 개의 명령 실행
  - ✅ Multicycle ; 1 개의 명령이 multiple clock cyle 내에 실행
- ✅ Pipelined Implementation
- Advanced techniques

## Memory Systems
![image](https://user-images.githubusercontent.com/56028436/133566483-2d065b45-d150-4612-9762-49ce89bb4a13.png)
<br/>
- Cache Memory ; (Fast) Processor가 자주 요청하는 데이터를 그 속에 저장했다가 메모리 요청 필요 없이 바로 해당 데이터에 접근할 수 있게 함
- Virtual Memory ; (Slow) 디스크를 활용하여 만들어진 추가 메모리 공간
- **Memory Hierarchy** : Cache Memory > Memory(주로 RAM) > Disk


# VLSI Technology Overview_CMOS Transistors
; Complementary Metal Oxide Semiconductor <br/>
*L이 작을수록 트랜지스터가 명령을 더 빠르게 처리

- Pmos <br/> ![image](https://user-images.githubusercontent.com/56028436/133567787-3fe93e4b-a62a-425a-904b-ed261ec49bee.png) <br/>
  - 한 쪽(주로 source)이 VDD에 연결
  - input으로 0V가 들어오면 High
- Nmos <br/> ![image](https://user-images.githubusercontent.com/56028436/133567841-31bd3691-540e-4237-847e-87ec59e02632.png) <br/>
  - 한 쪽(주로 source)이 GND에 연결
  - input으로 1V가 들어오면 High

<br/>
<img width="634" alt="스크린샷 2021-09-16 16 21 38" src="https://user-images.githubusercontent.com/56028436/133568214-deaff80e-695b-4e18-ad98-50e4dd4eda8d.png">
