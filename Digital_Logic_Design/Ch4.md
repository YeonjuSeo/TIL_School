## Objectives
- Students should be able to `Find the minimum cost expression using Karnaugh maps, cubical representation, or tabular method`
</br>

### Repeated Concepts
✅ Min-terms ↔ Sum-of-Products ↔ 1 ↔ Complements of Maxterm</br>
✅ Max-terms ↔ Product of Sums ↔ 0 ↔ Complements of minterm</br>
</br>

# Karnaugh Map (K-Map)
- It allows us to recognition of **minterms** that can be **combined** using property 14a( = xy + x!y = x)
  - minterm이므로 기본적으로 SOP 형태로 작성
- 행과 열의 제목이 되는 값이 한 개씩 변겨되는 형태로 작성한다.(가장 끝과 첫번째에도 해당되도록)
![image](https://user-images.githubusercontent.com/56028436/113504353-8bd90c80-9572-11eb-8374-4d0590138cba.png)
- K-Map은 `Circularly connected with each other`
- Minimum cost를 만들기 위해서는 한 번에 최대한 많은 1을 묶어야한다.
- **Groups must contain 1, 2, 4, 8, or in general 2<sup>n</sup> cells**
</br>

### SOP vs POS
1. SOP ; minterms
- SOP form으로 1인 값을 가지고 결과를 작성한다.
- `x= 1 !x = 0`
2. POS ; Maxterms ; Complements of SOP
- POS form으로 0인 값을 가지고 결과를 작성한다.
- ❗`x= 0 !x = 1`

➡ **매번** SOP와 POS를 구해서 더 작은 값을 찾아 사용해야한다.
</br></br>

## Literal
Each appearance of a variable, either uncomplemented or complemented, is called a literal
- f(x<sub>1</sub>, x<sub>2</sub>, ... , x<sub>n</sub>) has `2n` possible literals

![image](https://user-images.githubusercontent.com/56028436/113504481-5123a400-9573-11eb-8d4d-61de98295666.png)
<br/>In this case, f(x<sub>1</sub>, x<sub>2</sub>, x<sub>3</sub>, x<sub>4</sub>) has 
- 10 possible literals
- 7 literals
</br>

## Implicant
A product term that indicates the input valuation(s) for which a given funtion is equal to 1 is called an implicant of the function
![image](https://user-images.githubusercontent.com/56028436/113504568-e757ca00-9573-11eb-8194-4cb4cf5f780e.png)

- An implicant is called a prime implicant if it canno tbe combined into another impplicant tha thas `fewer` literals
![image](https://user-images.githubusercontent.com/56028436/113504577-ede64180-9573-11eb-8ea4-afc32f7d9481.png)
</br>

## Cover
**A collection of implicants** that account for all valuations for which a given function is equal to `1` is called a cover of that function
![image](https://user-images.githubusercontent.com/56028436/113504628-474e7080-9574-11eb-8e6f-8d1693204e7e.png)
> The cover consisting of prime implicatns leads to the lowest-cost implementation
</br>

## Cost
The cost of a logic circuit = the number of gatest + the total number of inputs to all gates in the circuit
- **Primary inputs (the input variables) are available in both true and complemented forms at zero cost**
![image](https://user-images.githubusercontent.com/56028436/113504742-0145dc80-9575-11eb-9a89-8267aad7b6f4.png)
<br/>*NAND, NOR, AND, OR, NOT 모두 하나의 gate로 헤아린다.
</br>

## Incompletely Specified Functions - `Don't care` 
A function having `don't care condition(s)` is said 'incompletely specified'
- `Don't care` 값은 K-Map 연산 시 일부 혹은 전체를 0으로 둬도 1로 둬도 상관없다. 

# Multiple-Output Circuits
Multiple-output circuit에서 minimum cost 구하기 위해서는
- 단순 minimum cost expression으로
- common implicant를 최대한 활용
➡ multiple-output circuit에서는 단순히 minimum cost expression으로 구했을 때 보다 common implicant를 활용했을 때 더 적은 cost로 circuit을 만들 수 있다. 
*common implicant가 많다고해서 꼭 lower cost인 것은 아니다.

## Fan-In & Fan-Out
- Fan-In : 한 gate에서 받을 수 있는 최대 input의 수
- Fan-Out : 한 gate의 output과 연결가능한 다른 gate의 수

# Multi-Level Systhesis Techniques
To solve the `fan-in` problem, we need to apply these techniques
<br/>

### Factoring
<details><summary>The distributive property allows us to factor the expression</summary><div markdown="1">12a: x ( y + z ) = x y + x z <br/>12b: x + ( y z ) = ( x + y )( x + z ) <br/></div></details>

### Functional Decomposition
1. K-Map에서 패턴을 찾는다.
2. 0인 부분까지 1로 가정해서 묶는 두(or more) 함수를 만든다.
3. 두 함수의 `교집합` ➡ 실제로 1인 부분만 cover한다.
4. 이것의 **역**을 통해 나머지 1인 부분을 cover한다.

### Multi-Level NAND Circuit
![image](https://user-images.githubusercontent.com/56028436/114310417-ae949380-9b25-11eb-8b43-19b53aae65f2.png)
![image](https://user-images.githubusercontent.com/56028436/114310514-e3a0e600-9b25-11eb-8658-fc760dbf5114.png)

### Multi-Level NOR Circuit
![image](https://user-images.githubusercontent.com/56028436/114310532-f4515c00-9b25-11eb-88e8-80d4169aa0ac.png)
![image](https://user-images.githubusercontent.com/56028436/114310541-00d5b480-9b26-11eb-8273-111383a9d507.png)
  

