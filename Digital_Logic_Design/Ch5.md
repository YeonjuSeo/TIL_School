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
    ![image](https://user-images.githubusercontent.com/56028436/116908734-3598df80-ac7e-11eb-9339-8c6b22d996ec.png)
*Full adder can be constructed using half-adders

# Riplle Carry Adder_multiple bit adder
![image](https://user-images.githubusercontent.com/56028436/116908918-6f69e600-ac7e-11eb-9ed7-b1d11b1bdc55.png)<br/>
- 3 input bits: y, x, C<sub>in</sub>
- 2 output bits: S, C<sub>out</sub>
