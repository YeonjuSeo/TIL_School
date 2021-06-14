## Objectives
- Students should be able to tell the difference between binary, octal, decimal, and hexadecimal numbers.
- Students should be able to tell `how numbers can be added, subtracted, and multiplied in computers`.
- Students should be able to tell the difference between single-precision floating-point and double-precision floating-point formats.

## Unsigned Integers
1. Decimal 
  - 10 possible values: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
  - ex. 8547 = (8\*10<sup>3</sup>)+(5\*10<sup>2</sup>)+(4\*10<sup>1</sup>)+(7\*10<sup>0</sup>)
2. Binary
  - 2 possible values : 0, 1
  - ex. 1110 = (1\*2<sup>3</sup>)+(1\*2<sup>2</sup>)+(1\*2<sup>1</sup>)+(0\*2<sup>0</sup>)
3. Octal(Radix-8)
  - 8 possible values : 0, 1, 2, 3, 4, 5, 6, 7
  - ex. 7547 = (7\*8<sup>3</sup>)+(5\*8<sup>2</sup>)+(4\*8<sup>1</sup>)+(7\*8<sup>0</sup>)
4. Hexadecimal(Radix-16)
  - 16 possible values : 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F
  - ex. 8A47 = (8\*16<sup>3</sup>)+(A\*16<sup>2</sup>)+(4\*16<sup>1</sup>)+(7\*16<sup>0</sup>)

*#7 표 추가 필요<br/>
*어떠한 수든 아래와 같은 형식으로 표현이 가능하다. <br/>
![image](https://user-images.githubusercontent.com/56028436/116903688-b3a5b800-ac77-11eb-9ac1-fb87eaabf608.png)

### Binary to Octal & Hexadecimal
- Binary ➡ Octal ; 3개씩 자른 수로 2➡10 연산을 하여 나란히 쓴다.<br/>
  ![image](https://user-images.githubusercontent.com/56028436/116904197-5d854480-ac78-11eb-984b-562f22bc68a9.png)<br/>
- Binary ➡ Hexadecimal ; 4개씩 자른 수로 2➡10 연산을 하여 나란히 쓴다.<br/>
  ![image](https://user-images.githubusercontent.com/56028436/116904332-873e6b80-ac78-11eb-8689-7d9d1039dc7e.png)<br/>
  
*자릿수를 3의 배수로 맞추기 위해 앞에 0을 추가하기도 한다.

## Half Adder
: 1 bit를 더하는 것만 가능하다.<br/>
![image](https://user-images.githubusercontent.com/56028436/116904519-c371cc00-ac78-11eb-9bcb-a00dd441134d.png)

# Full Adder
*Input x = 8 bits, y = 8 bits ➡ possible combination : 2<sup>16</sup><br/><br/>
![image](https://user-images.githubusercontent.com/56028436/116905111-865a0980-ac79-11eb-8feb-42c4543dd8a1.png)
- S
  - input에서 1이 홀수면 1<br/>
    ![image](https://user-images.githubusercontent.com/56028436/116908573-0aae8b80-ac7e-11eb-9da8-3337e5409921.png)<br/>
    *Kmap의 배치가 사선으로 되어있으면 XOR
- C<sub>out</sub>
  - input에서 1이 2개 이상이면 1<br/>
    ![image](https://user-images.githubusercontent.com/56028436/116908734-3598df80-ac7e-11eb-9339-8c6b22d996ec.png)<br/>
    
*Full adder can be constructed using half-adders<br/>
*XNOR<br/>
![image](https://user-images.githubusercontent.com/56028436/117691381-cc254d80-b1f6-11eb-9029-270be4fac83d.png)
<br/>

# Ripple Carry Adder_multiple bit adder
![image](https://user-images.githubusercontent.com/56028436/116908918-6f69e600-ac7e-11eb-9ed7-b1d11b1bdc55.png)<br/>
- 3 input bits: y, x, C<sub>in</sub>
- 2 output bits: S, C<sub>out</sub>
- Total delay = (C 기준)2n, (S 기준)2n-1

## Signed Number
- Unsigned 32-bits<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117370319-2ecdcf00-af01-11eb-9806-d430fd72a215.png)<br/>
  - MSB: 가장 왼쪽의 비트
  - Magnitude: 32
  - LSB: 가장 오른쪽의 비트

![image](https://user-images.githubusercontent.com/56028436/117370461-62a8f480-af01-11eb-8cd5-1c6247f8ef20.png)
- 가장 왼쪽 비트: Sign
  - 0 ➡ 양수
  - 1 ➡ 음수
- MSB: 왼쪽에서 두 번째 비트
- Magnitude: **31**
- LSB: 가장 오른쪽의 비트

➡ `같은 비트 내에서 표현할 수 있는 범위가 Unsgined Number에 비해 작다!(다르다!)`

# 음수 표현법
1. Sign-and-Magnitude Representation: 가장 왼쪽 bit를 반대로 바꾸기 (0➡1)<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117370949-1611e900-af02-11eb-8c3b-c98cacca108a.png)
2. 1's Complement Representation: 각 비트를 다 반대로 바꾸기 (0↔1)<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117371144-5a9d8480-af02-11eb-9c25-ea214cb17e44.png)<br/>
  - K = (2<sup>비트 수=n</sup>-1)-P
3. `2's Complement Representation`: 오른쪽에서부터 최초의 1까지는 그대로 적다가 그 이후로는 비트 반대로 적기<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117371411-d0095500-af02-11eb-9f55-838f3154d30b.png)<br/>
  - K = 2<sup>비트 수=n</sup>-P

*각 표현법 별 표현 범위</br>
- Signed and Magnitude: -(2<sup>(n-1)</sup>-1)~2*(2<sup>(n-1)</sup>-1)
- 1's Complement: -(2<sup>(n-1)</sup>-1)~2*-(2<sup>(n-1)</sup>-1)
- 2's Complement: -(2<sup>(n-1)</sup>)~2*-(2<sup>(n-1)</sup>-1)<br/>
![image](https://user-images.githubusercontent.com/56028436/117371777-6b9ac580-af03-11eb-9f5d-cc8f51528e76.png)<br/>
➡ 2's Complement는 0이 한 개인 대신 음수를 하나 더 표현할 수 있다.

## Addition
- 1's Complement<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117372240-317df380-af04-11eb-81d8-8f2d2926a328.png)<br/>
  ➡ 마지막 C<sub>out</sub>이 0이면 결과 그대로, 1이면 1을 추가로 더하는 연산 필요
- `2's Complement` <br/>
  ![image](https://user-images.githubusercontent.com/56028436/117372390-65f1af80-af04-11eb-8738-fba8635f5ebc.png)<br/>
  ➡ 비트 수를 넘겨 나온 마지막 C<sub>out</sub>는 무시. 비트 수만큼만 헤아리면 된다.
  
*Subtraction 시에는 2's Complement를 이용하여 `양수 - 양수` 식을 `양수 + 음수` 식으로 생각하여 풀이한다.
![image](https://user-images.githubusercontent.com/56028436/117372722-f29c6d80-af04-11eb-9d13-8e66721437c4.png)

## Adder and Subtractor Unit
*2's Complement<br/>
![image](https://user-images.githubusercontent.com/56028436/117372912-473fe880-af05-11eb-9156-687acf8881fc.png)<br/>
- ADD ; 0 ➡ XOR gate를 지난 값은 들어온 값 그대로이다. C<sub>0</sub> = 0
- SUB ; 1 ➡ 0이 들어오면 1, 1이 들어오면 0이 결과로 나온다.(1's Complement) + C<sub>0</sub> = `1`(2's Complement)

# Arithmetic Overflow
- Unsigned number: 마지막 C<sub>out</sub>이 1이면 overflow
- Signed number: 끝에서 두 번째 C<sub>n</sub>C<sub>n-1</sub>이 01 or 10이면 overflow<br/>
  ➡![image](https://user-images.githubusercontent.com/56028436/117700566-27f4d400-b201-11eb-8af5-1a1d278e11a1.png)<br/>
  
*(주의)Arithmetic overflow를 알기 위해 CarryOut을 볼 때는 꼭! 주어진 수의 bit보다 머리 하나는 더 나와있는 데까지(CarryOut 수 = 주어진 수의 bit 수) 체크해서 가장 끝과 끝에서 두 번째를 헤아려야함!

# Performance Issue
*Critical-path delay(critical path): the longest delay<br/>
*모든 gate의 delay가 1이라고 가정한다.<br/>
*`gate delay의 계산은 gate의 수가 아닌 gate의 level을 이용한다.`<br/>
*Total delay를 계산할 때는 가장 마지막에 계산되는 값을 이용한다.
<br/>

## Ripple-Carry Adder
C와 S를 구할 때마다 매번 gate delay가 추가된다.
> C<sub>out</sub>(x,y,C<sub>in</sub>) = yC<sub>in</sub> + xC<sub>in</sub> + xy <br/>
> ➡ c<sub>i+1</sub> = x<sub>i</sub>y<sub>i</sub> + (x<sub>i</sub> + y<sub>i</sub>)c<sub>i</sub> <br/>
> ➡ c<sub>i+1</sub> = g<sub>i</sub> + p<sub>i</sub>c<sub>i</sub> (g<sub>i</sub> =x<sub>i</sub>y<sub>i</sub>, p<sub>i</sub> = x<sub>i</sub> + y<sub>i</sub>) 

![image](https://user-images.githubusercontent.com/56028436/117526989-72106680-b003-11eb-885c-5c10f0e19a43.png)<br/>
➡ Total delay = (C 기준)2n + 1, (S 기준)2n

## Carry-Lookahead Adder
S값을 계산하기 위한(gate delay 1) C를 한꺼번에 모아서(gate delay 3) 계산한다
> C<sub>out</sub>(x,y,C<sub>in</sub>) = yC<sub>in</sub> + xC<sub>in</sub> + xy <br/>
> ➡ c<sub>i+1</sub> = x<sub>i</sub>y<sub>i</sub> + (x<sub>i</sub> + y<sub>i</sub>)c<sub>i</sub> <br/>
> ➡ c<sub>i+1</sub> = g<sub>i</sub> + p<sub>i</sub>c<sub>i</sub> (g<sub>i</sub> =x<sub>i</sub>y<sub>i</sub>, p<sub>i</sub> = x<sub>i</sub> + y<sub>i</sub>) 
> ➡ c<sub>i+1</sub> = g<sub>i</sub> + p<sub>i</sub>(g<sub>i-1</sub> + p<sub>i-1</sub>c<sub>i-1</sub>) ➡ ...

![image](https://user-images.githubusercontent.com/56028436/117706944-e2d4a000-b208-11eb-8f6f-1bc819185b90.png)<br/>
➡ Total delay = (가장 마지막에 계산되는 값: Sum)4<br/>
*C에는 매번 3씩 걸린다

## A Hierarchical Carry-Lookahead Adder with Ripple-Carry
Carry-Lookahead Adder에서는 S값을 계산하기 위한 C값을 한꺼번에 모아서 계산하므로 fan-in 문제가 발생할 수 있다. 그것을 해소하기 위해 계산 과정을 **4개**의 Adder에 나누어서 이용하게 한 것이 Hierarchical Carry-Lookahead Adder이다.<br/>
![image](https://user-images.githubusercontent.com/56028436/117547542-0eba1f00-b06b-11eb-8d29-ad0c628e41d2.png)<br/>
➡ Total delay = (가장 마지막에 계산되는 값: Sum)8

# Multiplication
- Unsigned Number: 일반 곱셈과 동일 / Shifting bits
- Signed Number: **Sign extension** ; 표현하고자하는 bit수에 모자란만큼 앞에 0 or 1을 붙인다.<br/>
  ![image](https://user-images.githubusercontent.com/56028436/117710040-9a1ee600-b20c-11eb-8cd0-c424ca1187a9.png)<br/>
  
  - 양수(제일 앞의 signed bit가 0): 앞에 0 추가
  - 음수(제일 앞의 signed bit가 1): 앞에 1 추가<br/>
  *개수는 아래에서 더해지는 수 앞에 항상 하나의 0 또는 1이 붙도록<br/>
  *(주의)2's complement로 더하기 시 주어진 bit 이상의 1은 무시한다는 것 기억하고 적용하기

# Other Number Representations
## Fixed-Point Numbers
![image](https://user-images.githubusercontent.com/56028436/117548235-c6046500-b06e-11eb-8de9-dafeb36d6049.png)
## Floating-Point Numbers
; Mantisa X R<sup>Exponent</sup><br/>
*Normalized ; 소수점 앞에는 **0이 아닌 수**가 **반드시 하나** 존재해야한다.<br/>
<br/>
- Single-Precision Floating-Point Format(=32bit Format)<br/>
  ; 1Sign + 8bit(excess-127 exponent) + 23 bits of mantisa
  - Value: +-1.M*2<sup>(E-127)</sup>
  - Exponent field range: 2<sup>-126</sup>~2<sup>127</sup> (약  10<sup>-38</sup>~10<sup>38</sup>)
  - Infinity number: 2<sup>-127</sup> ➡ -00 & 2<sup>128</sup> ➡ 00
  - <details>
    <summary>Example</summary>
    <div markdown="1">
      <img src="https://user-images.githubusercontent.com/56028436/117582521-53ae8600-b13d-11eb-8fa2-734aebe6ce35.png"/>
    </div>
    </details>
- Double-Precision FLoating-Point Format(=64bit Format)<br/>
  ; 1Sign + 11bit(excess-1023 exponent) + 52 bits of mantissa
  - Value: +-1.M*2<sup>(E-1023)</sup>
  - Exponent field range: 2<sup>-1023</sup>~2<sup>1024</sup> (약  10<sup>-308</sup>~10<sup>308</sup>)
 
## BCD Representation
![image](https://user-images.githubusercontent.com/56028436/117548955-ae2ee000-b072-11eb-9eb5-d5af16964978.png) ![image](https://user-images.githubusercontent.com/56028436/117710243-dc482780-b20c-11eb-857f-1cfa068bede5.png)
<br/>
; decimal을 자릿수마다 4bit로 쪼개서 표현 ex) 24 = 0010 0100
➡ 0~9를 벗어나는 수가 나오면 *6(=0110)을 한 번 더 더한다.*

# Parity_error-checking purposes
; 1 bit 에러만 감지 가능
- Even Parity ; 1의 개수를 짝수로 유지
  - 주어진 7 bit의 수의 1의 개수가 짝수 ➡ 가장 오른쪽의 parity bit가 0
  - 주어진 7 bit의 수의 1의 개수가 홀수 ➡ 가장 오른쪽의 parity bit가 1
- Odd Parity ; 1의 개수를 홀수로 유지
  - 주어진 7 bit의 수의 1의 개수가 짝수 ➡ 가장 오른쪽의 parity bit가 1
  - 주어진 7 bit의 수의 1의 개수가 홀수 ➡ 가장 오른쪽의 parity bit가 0
<br/>
*결과예시<br/>

![image](https://user-images.githubusercontent.com/56028436/117692299-d8f67100-b1f7-11eb-9807-3435828e7172.png)<br/>
*https://www.tutorialspoint.com/what-is-a-parity-bit
