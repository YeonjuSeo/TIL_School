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
*각 Register 안에는 32bit의 정보가 저장

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

➡️ MIPS `R-format` Instructions
![image](https://user-images.githubusercontent.com/56028436/136667846-8d41d559-d5d6-45f2-9190-67da434054e6.png)<br/>
- op: operation code (opcode)
- rs: src1 register number
- rt: src2 register number
- rd: des register number
- shamt: shift amount
- funct: function code (extends opcode)


ex) add $t0, $s1, $s2<br/>
![image](https://user-images.githubusercontent.com/56028436/136667916-783ae56e-6fd0-47d6-ba31-415c9d30998a.png)

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

```C
//C
f = (g+h) - (i+j);
-f, ..., j in $s0, ..., $s4

//Compiled MIPS code
add $t0, $s1, $s2 # $t0 = g+h
add $t1, $s3, $s4 # $t1 = i+j
sub $s0, $t0, $t1 # $s0 = $t0-$t1
```

- Arithmetic instructions use register operands
- MIPS has a 32 * 32-bit register file (0~31)
  - Use for frequently accessed data

## Memory Operands
```C
//C
A[12] = h + A[8];
- h in $s2, base address of A in $s3

//Compiled MIPS code
lw $t0, 32($s3) # load word
add $t0, $s2, $t0
sw $t0, 48($s3) # store word
```

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

***배열 요소에 접근 : $배열 + 4*i**  
```C
//C
while (save[i]==k) i+1

//Compiled MIPS code
Loop: sll $t1, $s3, 2
      add $t1, $t1, $s6 # $s6 + 4*i
      lw $t0, 0($t1)
      bne $t0, $s5, Exit
      addi $s3, $s3, 1
      j Loop Exit: …
```

*Register vs Memory

- access 속도: Register > Memory
- 실행해야하는 명령어 수 : Memory > Register<br/>Operating on a memory data requires loads and stores
- Compilers는 가능한 한 변수 사용을 위해 register를 사용해야한다.<br/>자주 쓰지 않는 변수들만 메모리에 할당해야함

## Immediate Operands
*Make the common case fase : Immediaate operand는 load하는 명령어를 쓰지 않는다.

- 상수 값을 명령어에다 바로 쓴다.
- 상수값을 빼는 명령어는 없다. ➡️ 음수 값을 더하는 방식<br/>ex)`addi $s2, $s1, -1`

## The Constant Zero 0
- MIPS register 0($zero)는 상수 0이며 덮어쓰기가 불가능
- common operation에 유용하다.<br/>ex) 레지스터 간의 이동 : (Not native)`move $t2, $s1` ➡️ (Native)`add $t2, $s1, $zero`


### Signed Integers
*Unsigned Integers: 0 ~ 2<sup>32</sup>-1 (2<sup>32</sup>개)

- 2s Complement: -2<sup>n-1</sup> ~ 2<sup>n-1</sup> -1
  - Bit 31 is sign bit
  - -(-2<sup>n-1</sup>) can't be represented
  - 0 또는 양수는 unsigned일 때나 2s Complement가 적용됐을 때나 똑같이 표기된다.
- Signed Negation
  - x + !x = -1 = 11111...<sub>2</sub>
  - 2s Complement and add 1
- Sign Extension
  - Replicate the sign bit to the left

*Hexadecimal: 4 bits per hex digit

## Logical Operations
word에서 bit 그룹을 추출하거나 집어넣는 데 유용<br/>
![image](https://user-images.githubusercontent.com/56028436/136667977-bb7b085c-d44c-4e64-a847-0f02877e4c23.png)<br/>

### Shift Operations_shamt
![image](https://user-images.githubusercontent.com/56028436/136668007-b95cf9bc-db78-4edd-b76f-9032f3abf2a5.png)<br/>*MIPS R-format Instruction<br/>
- _sll_ by i bits multiplies by 2<sup>i</sup>
- _srl_ by i bits divides by 2<sup>i</sup> (unsigned only) 

### And Operations
Useful to mask bits in a word ; 선택한 비트를 제외하고 나머지를 모두 0으로 만들기<br/>
![image](https://user-images.githubusercontent.com/56028436/136668489-22852cba-2f29-4762-bbee-a988339e27d1.png)<br/>

### OR Operations
Useful to include bits in a word ; 나머지는 그대로 두고 일부에 1을 추가<br/>
![image](https://user-images.githubusercontent.com/56028436/136668517-41fdd66a-a246-4ec6-9af1-8183dce1e6c2.png)<br/>

### NOT Operations
Useful to invert bits in a word ; Negation<br/>
*MIPS has NOR 3-operaand instruction ; `a NOR b == NOT(a OR b)` ; `a NOR 0 == NOT a` <br/>
![image](https://user-images.githubusercontent.com/56028436/136668545-e9b15885-bdf4-408e-b130-e9014689421c.png)

word에서 bit 그룹을 추출하거나 집어넣는 데 유용<br/>

## Conditional Operations
: Branch to a labeled instruction if a condition is true<br/>
*Otherwise, continues sequentially<br/>
![image](https://user-images.githubusercontent.com/56028436/136724909-c559743b-e3ff-42f2-a632-4d166e82885b.png)

- b _lab_ : Unconditional branch to _lab_
- beq _src1, src2, lab_ : Branch to _lab_ if `src1 == src2`
- bne _src1, src2, lab_ : Branch to _lab_ if `src1 != src2`
- ○ bgt(u) _src1, src2, lab_ : Branch to _lab_ if `src1 > src2` 
- ○ blt(u) _src1, src2, lab_ : Branch to _lab_ if `src < src2`

## Comparison Instructions
![image](https://user-images.githubusercontent.com/56028436/136728507-e011ffb6-bee1-468d-96c5-706a2ffcfc22.png)
- seq _des, src1, src2_ : if `src1 = src2`, `des = 1`; else `des = 0`
- slt(u) _des, src1, src2_ : if `src1 < src2` , `des = 1`; else `des = 0`
- slti _rt, rs, constant_ : if `rs < constant`, `rt = 1`; else `rt = 0`

➡️ **Combination with beq, bne** <br/>
*대소를 가리는 것은 동일 여부를 가리는 것보다 실행 속도가 느림 ∴ beq, bne로 치환
```
slt $t0, $s1, $s2 # if $s1 < $s2
bne $t0, $zero, L 
```
↔️ `bgt $s2, $s1, L` <br/>
↔️ `blt $s1, $s2, L` <br/>
