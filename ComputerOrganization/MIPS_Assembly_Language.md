# Highlevel Language ➡️ Execution file
![image](https://user-images.githubusercontent.com/56028436/136647853-3650a867-b4d5-4d8c-a7e2-a97b954b00a2.png)
<br/>
- Compiler: C program ➡️ Assembly Language(= symbolic form of what the machine understand)
- Assembler: Assembly Language ➡️ an object file(= combination of machine language instructions, data, information needed to place instructions properly in memory)
- Linker or Link Editor: Stitches all the independently assembled machine language programs ➡️ an executable file that can be run on a computer
- Loader: load the executable file into memory for execution

<br/>

- Static Library
  - 빠르다
  - 실행 파일의 일부가 됨
  - 실행 여부와 관계 없이 로딩되어있음
- Dynamic Library 
  - 프로그램 실행 전까지는 링크되지 않고 로드되지 않음
  - 오버헤드에 적절히 대처

# Languages
## Machine Language
- CPU **dependent**
- 명령어 하나 = CPU 행동 하나
- 일련의 bit로 표현됨
- CPU 수준에서는 가장 낮은 언어 단계
- 기계가 바로 이해 가능

## Assembly Language
- CPU **dependent**
- 기계어와 밀접하게 연결 ∴ Machine Architecture마다 각각의 어셈블리어와 기계어를 사용

### MIPS
![image](https://user-images.githubusercontent.com/56028436/136648478-8bf59fe3-a257-4610-a85d-c658a570036d.png) <br/>

- ✅ RISC: 심플하고 기본적인 명령어 세트를 추구 ↔️ CISC: 복잡한 명령어 세트 컴퓨터
- MIPS processor consists of
  - processing을 위한 CPU
  - traps, exceptions, virtual memory system을 조절하는 Coprocessor 0
  - floating point unit을 담당하는 Coprocessor 1

### CPU
= (central) processor <br/>
- Typical compoenets of a CPU
  - ALU(Arithmetic Logic Unit): 산수 연산 & 논리 연산 수행
  - Control Unit: 메모리에서 명령어를 추출 ➡️ 명령어 해동 ➡️ 명령어 실행 (필요시 ALU 호출)

### Registers
![image](https://user-images.githubusercontent.com/56028436/136649184-514ca165-e3c5-4484-b0a7-3927360b1b50.png) <br/>

# MIPS Instruction Set
*Assembler translates pseudo-instructions ➡️ one or more native instructions <br/>
*des, src1, reg2 : (must) register)<br/>
*src : register / 32-bit integer<br/>

## Load Instructions
![image](https://user-images.githubusercontent.com/56028436/136649359-d1fb3612-3f42-4b60-a257-a407e82592a4.png)
- ○ la _des, addr_ : Load the address of label.
- ○ li _des, const_ : Load the constant const into des.
- lw _des, addr_ : Load the word at addr into des.

## Arithmetic Operations
`<op> <des> <src1> <src2>`<br/>
*Simplicity favours regularity<br/>
- 32 registers are provided

![image](https://user-images.githubusercontent.com/56028436/136649566-ea5a1469-392b-43c7-ab33-ea7a72bbd991.png)<br/>
- add(u) _des, src1, src2_ : des gets src1 + src2
- ○ neg(u) _des, src1_ : des gets the negative of src1
- sll des, src1, src2 : des gets src1 shifted left by src2 bits
- ○ sub(u) _des, src1, src2_ : des gets src1 - src2

## Syscalls
- 프로그램 실행을 연기하고 OS로 통제권을 넘기는 명령어
- **$v0** 레지스터를 읽어서 명령 내용 확인

![image](https://user-images.githubusercontent.com/56028436/136649753-b5cd8012-95f1-47b1-9f89-269d1252cd4c.png)<br/>
- 1 print_int $a0
- 5 read_int .
- 10 exit .

### Data Movement Instructions
*hi register나 lo register를 이용한 데이터 이동에는 특별한 명령어를 사용한다.<br/>
![image](https://user-images.githubusercontent.com/56028436/136650003-06979403-1814-4415-967d-248c4152cd41.png)<br/>
- ○ move _des, src1_ : Copy the contents of src1 to des

# Instruction Examples
- Data segment : 저장소를 할당하고 전역 변수를 초기화
- Text segment : 실행하고 싶은 명령어 입력
- 기본적으로 어셈블러는 text segment에서 시작
- 프로그램 실행은 main 위치에서 시작.

1. Read 2 numbers and Sum, and then Print
```C
main:
## Get first number from user, put into $t0.
  li $v0, 5 # load syscall read_int into $v0.
  syscall # make the syscall.
  move $t0, $v0 # move the number read into $t0.
## Get second number from user, put into $t1.
  li $v0, 5 # load syscall read_int into $v0.
  syscall # make the syscall.
  move $t1, $v0 # move the number read into $t1.
# Compute the sum.
  add $t2, $t0, $t1 # Sum it up
## Print out $t2.
  move $a0, $t2 # move the number to print into $a0.
  li $v0, 1 # load syscall print_int into $v0.
  syscall # make the syscall.
# Exit the program
  li $v0, 10 # syscall code 10 is for exit.
  syscall # make the syscall.
```
2. Print Text
*null terminate = 그 자리에서 프로그램 종료<br/>
![image](https://user-images.githubusercontent.com/56028436/136651446-c3bb2911-c1f5-4595-9d96-8b31bd631af1.png)
- .ascii _str_ : String. Do not null-terminate
- .ascizz _str_ : string. Do null-terminate
- .byte _byte1...byteN_ : bytes(8-bit integers) ➡️ byte 각각 초기화 가능
- .half _half1...halfN_ : (16-bit integers)
- .space size : allocate n bytes of space in the current segment. In SPIM, only permitted in the data segment.
- .word _word1...wordN_ : words(32-bit integers)

```C
# Daniel J. Ellard -- 02/21/94
# hello.asm-- A "Hello World" program.
# Registers used:
# $v0 - syscall parameter and return value.
# $a0 - syscall parameter-- the string to print.
  .text
main:
  la $a0, hello_msg # load the addr of hello_msg into $a0.
  li $v0, 4 # 4 is the print_string syscall.
  syscall # do the syscall.
# Exit the program
  li $v0, 10 # 10 is the exit syscall.
  syscall # do the syscall.
# Data for the program:
  .data
hello_msg: .asciiz "Hello World\n"
```

#### They Are The Same
- hello_msg: .asciiz "Hello World\n"
- hello_msg: .ascii "Hello"
             .asciiz " World"
             .ascii "/n'
             .byte 0
- hello_msg: .byte 0x48 # hex for ASCII "H"
             ...
             .byte 0xA # hex for ASCII newline
             .byte 0x0 # hex for ACII NULL
             
## Register Operands

*Smaller is faster<br/>
*크기가 큰 메인 메모리에 많은 양의 데이터 저장 가능<br/>

- Arithmetic instructions use register operands
- MIPS has a 32 * 32-bit register file (0~31)
  - Use for frequently accessed data

## Memory Operands
- Main memory는 데이터 합성을 위해 사용 ex) 배열, 구조체, 동적 데이터
- To apply Arithmetic operations
  1. 메모리에서 값을 불러와 레지스터에 저장
  2. Arithmetic operation 수행 among registers
  3. 레지스터에 저장된 결과값을 메모리에 저장
- Memory is byte addressed
  - Each address identifies an 8-bit = 1 byte<br/>ex) 주소: 0x1000 -> 내용: 0x12(=4bit = 1byte)
- Words(=4bytes) are aligned in memory<br/>*Address must be a multiple of 4
- MIPS is `Big Endian`
  - MSB at Least address of a word ↔️ `Little Endian` : LSB at Least address<br/>![image](https://user-images.githubusercontent.com/56028436/136653275-b1fcc8df-0841-4eb7-9e5e-8d703d47729a.png)
