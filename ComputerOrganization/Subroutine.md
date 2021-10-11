# Subroutine
= procedure = function = method<br/>
; Logical division of the code that may be regarded as a **self-contained operation** <br/>

# Procedure Calling
1. (Caller) Place parameters in registers - 파라미터는 caller에서 쓰던 것
2. (Caller) Transfer control to procedure<br/>
`jal ProcedureLabel`
- Address of **following** instruction put in $ra
- Jumps to target address
3. (Callee) Acquire storage for procedure
4. (Callee) Perform procedure's operations
5. (Callee) Place result in register for caller
6. (Callee) Return to place of call of Caller<br/>
  `jr $ra`
- Copiees $ra to program counter (호출됐던 곳 바로 다음으로 이동)
- Can also be used for computed jumps ex.case/switch statements

*$a0 ~ a3 : arguments<br/>
*$v0 ~ v1 : result values<br/>
*$t0 ~ t9 : temporaries - Can be overwritten by callee<br/>
*$s0 ~ s7 : saved - Must be saved/restored by callee

## Jal Instruction
![image](https://user-images.githubusercontent.com/56028436/136736002-9ddfc470-a9a4-42a9-9707-600d75fda717.png)
![image](https://user-images.githubusercontent.com/56028436/136736209-f8fecd41-162d-4498-bc3c-02c4f6008bbb.png)<br/>

```
jal sub
# $ra <- PC+4 ; jal 실행 전, nop(jal 다음 instruction)을 가리키고 있음
# $ra <- address 8 bytes away from the jal ; jal 실행 후, $ra에 4값이 증가해서 그 다음 instruction을 가리킴
# PC <- sub ; label "sub"의 주소가 program counter로
# load the PC with the subroutine entry point
```
➡️ So now $ra holds the address of the **second instruction after the jal insruction**

## Jr Instruction
; Returns control to the caller ; PC ⬅️ $ra
- Copies the contents of $ra into the PC
- The instruction is followed by a branch delay slot_`nop` instrucion
- subroutine이 실행되는 내내 Return address가 $ra에 살아있을 필요는 없다.
  - **값을 stack에 안전하게 넣었다가 필요할 때 복구만 잘 시키면 문제없음**

# Example -6 Sum
```
main:
  li $s0, 0x06 # load 6 into Register S0
  li $s1, 0x10 # load 16 into Register S1
  move $a0, $s0 # use argument 1 in Register a0
  move $a1, $s1 # use argument 2 in Register a1
  jal sum_it # call subroutine sum_it
  nop # branch delay slot

# Get the result
  move $s3, $v0 # get the result from Register v0

# Print the sum
  move $a0, $s3 # place the result into Register a0
  li $v0, 1 # load syscall print_int into $v0.
  syscall # make the syscall.

# exit the program
  li $v0, 10 # syscall code 10 is for exit.
  syscall # make the syscall.
# end of sum_example.asm

  .data
sum_it:
  add $t1, $a0, $a1 # sum it up
  move $v0, $t1 # place the result
  jr $ra # return
  nop # branch delay slot
```

# Chain of Subroutine Calls
*subroutine이 중첩된 경우, $ra에는 하나의 주소만 담겨있을 수 있다.<br/>
![image](https://user-images.githubusercontent.com/56028436/136738666-75e34105-9e67-45cd-bd39-d9047d0e2b79.png)<br/>

➡️ **Stack에 return address를 넣어뒀다가 caller로 돌아갈 때 stack에서 pop해서 return address를 얻자!**<br/>
≒ Need to chang eregisters in subroutine ➡️ Push the contents onto stack<br/><br/>

![image](https://user-images.githubusercontent.com/56028436/136742856-ec557ef4-46ae-4e14-8eb6-e2d93cd0d075.png)<br/>
- subroutine이 S register를 변경할 예정이라면 stack에 첫번째로 그 값을 넣어뒀다가 caller로 돌아가기 전에 원래대로 돌려놓아야 한다.<br/>![image](https://user-images.githubusercontent.com/56028436/136744019-d6761554-1185-49e4-b072-9c3de908b3a0.png)

*Stack<br/>
![image](https://user-images.githubusercontent.com/56028436/136738859-2dc15315-ea3f-40c2-bb7f-0188f8df9f8f.png)
<br/>
- LIFO(Last-In, First-Out)
- 메모리주소가 큰 부분부터 저장되기 시작함
  - Push: sp = sp **-4** <br/> 
```
subi $sp, $sp, 4
sw $넣을값이든레지스터, 0($sp)
```
  - POP : sp = sp **+4** ➡️ <br/>
```
lw $뺄값을넣을레지스터, 0($sp)
addi $sp, $sp, 4
```
- stack pointer(= $sp = $29)를 사용해서 stack의 top을 가리킴

# Leaf Procedure
![image](https://user-images.githubusercontent.com/56028436/136741417-93433709-9ab3-4ce1-a6eb-70fd37a99064.png)<br/>
*In example below, we need to save $s0 on stack<br/>
```C
// C //f-$s0, g,h,i,j in $a0, ..., $a3
int leaf_example (int g, h, i, j)
{ int f;
f = (g + h) - (i + j);
return f;
}

// Compiled MIPS Code
leaf_example:
  addi $sp, $sp, -4
  sw $s0, 0($sp)        # Save $s0 on stack
  add $t0, $a0, $a1
  add $t1, $a2, $a3
  sub $s0, $t0, $t1
  add $v0, $s0, $zero   # Save the result in $v0
  lw $s0, 0($sp)
  addi $sp, $sp, 4      # Restore $s0 value before leave
  jr $ra                # Return to $ra
```

# Non-Leaf Procedure
; subroutine을 부르고 그 속에서 또 subroutine을 부름 ; `재귀함수` <br/>

```C
// C 
int fact (int n)
{
if (n < 1) return f;
else return n * fact(n - 1);
}

// Compiled MIPS Code // n in $a0, result in $v0
fact:
  addi $sp, $sp, -8 # adjust stack for 2 items
  sw $ra, 4($sp) # save return address at 4($sp)
  sw $a0, 0($sp) # save argument at 0($sp)
  
  slti $t0, $a0, 1 # test for n < 1
  beq $t0, $zero, L1
  addi $v0, $zero, 1 # if so, result is 1 # n이 0이면 1 리턴
  
  addi $sp, $sp, 8 # pop 2 items from stack
  jr $ra # and return

L1: addi $a0, $a0, -1 # else decrement n
  jal fact # recursive call # n 깎고 fact 함수 계속해서 호출
  
  lw $a0, 0($sp) # restore original n
  lw $ra, 4($sp) # and return address # 다음 L1 호출을 위해 매개변수 값과 sp 값 회복
  
  addi $sp, $sp, 8 # pop 2 items from stack
  mul $v0, $a0, $v0 # multiply to get result # 곱셈 부분 리턴
  jr $ra # and return
```

# Memory Layout
![image](https://user-images.githubusercontent.com/56028436/136745924-003143ce-3228-4793-8c42-619fe44a7cb5.png)<br/>

- Stack< : automatic storage<br/>
![image](https://user-images.githubusercontent.com/56028436/136745120-92fe9c62-b217-4b23-b082-218f5383ca50.png)
  - function 속 local variable 저장
  - local data is allocated by callee ex) C automatic variables
  - 보라색 네모 한 칸 ; Procedure frame = activation record
- Dynamic Data : heap
  - ex) `malloc` in C, `new` in Java
- Static Data : global variables
  - ex) static variables in C, constant arrays and strings
- Text : program code
  - ex) MIPS assembly instructions

# Branch Addressing
![image](https://user-images.githubusercontent.com/56028436/136752235-26f5f183-0542-43b6-abfe-5fec73529635.png)
<br/>
![image](https://user-images.githubusercontent.com/56028436/136751541-ce21ee0c-65d2-4c29-bda7-03f6e741a4ca.png)<br/>

- I type - constant or address = offset
- PC relative addressing
  - Target address = PC + offset * 4
  - PC already incremented by 4 by this time 

# Jump Addressing
![image](https://user-images.githubusercontent.com/56028436/136751684-583c5472-5000-4eb0-8815-611e1f069ae9.png)<br/>

- J format
- Jump(_j_ & _jal_) targets could be _anywhere in text segment_
- (Pseudo)Direct Jump addressing
  - Target address = PC<sub>31...28</sub> : (address*4)
- Branch addressing보다 더 멀리 이동 가능<br/>➡️ branch target이 너무 멀리(16비트 이상) 있으면 assembler가 알아서 코드를 direct addr로 바꾼다.

*Addressing Mode Summary<br/>
![image](https://user-images.githubusercontent.com/56028436/136752455-7f48aa6c-89ae-4f88-97fd-52e8933fe5b4.png)
<br/><br/>

*Assembler Pseudo Instructions
- 대부분 assembler 명령어는 기계어에 1:1로 매칭된다.
- Pseudo instructions는 assembler's imagination 조각이다. (꼭 1:1로 매칭되지X)<br/>![image](https://user-images.githubusercontent.com/56028436/136752675-240e9278-0ff0-4c1f-971d-3c473df76558.png)

