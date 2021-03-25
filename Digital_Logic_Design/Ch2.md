## Objectives
- Students should be able to `Make the truth table for various gate operations(NAND, NOR, NOT, AND, OR)`
- Students should be able to `Distinguish between analysis and synthesis`
- Students should be able to `Draw the Venn diagram for various gate operations`
- Students should be able to `Tell the difference between Sum-of-Product and Product-of-Sums`

## Switch
> 트랜지스터는 **스위치**다
- `x = 0` = `Open State` = `Disconnected`
- `x = 1` = `Close State` = `Connected` 
<br/>

![image](https://user-images.githubusercontent.com/56028436/112152351-8d770c00-8c25-11eb-991c-e292abceac6d.png)
<br/>The three basic logic operations introduced can be used to implement logic functions of **any complexity**

### AND
|x<sub>1</sub>|x<sub>2</sub>|L|
|---|---|---|
|1|1|1|
|1|0|0|
|0|1|0|
|0|0|0|
- L(x<sub>1</sub>,x<sub>2</sub>) = x<sub>1</sub>x<sub>2</sub>
- 기본적으로 **직렬** 연결(Serial Switch)

### OR
|x<sub>1</sub>|x<sub>2</sub>|L|
|---|---|---|
|1|1|1|
|1|0|1|
|0|1|1|
|0|0|0|
- L(x<sub>1</sub>,x<sub>2</sub>) = x<sub>1</sub>+x<sub>2</sub>
- 기본적으로 **병렬** 연결(Parallel Switch)

![image](https://user-images.githubusercontent.com/56028436/112151517-a6cb8880-8c24-11eb-8de1-48e2736c3032.png)<br/>
L(x<sub>1</sub>,x<sub>2</sub>,x<sub>3</sub>,x<sub>4</sub>) = (x<sub>1</sub>+x<sub>2</sub>)(x<sub>3</sub>+x<sub>4</sub>)<br/>
*AND가 OR보다 먼저 계산되므로 의미를 제대로 전달하기 위해서는 bracket을 잘 써야합니다.
*연산 순서: Bracket - NOT - AND - OR

### NOT
- Inverting Circuit
- L(x) = !x = x' = ~x = NOT x

# Analysis 분석
Truth table을 이용하여 (여러) 회로가 어떻게/원하는대로 동작하는지 확인 using Timing diagram(슬라이드 19 확인)
*같은 결과를 더 적은 수의 gate로 낼 수 있다면 더 좋은 circuit이다.

## Boolean Algebra
➡ We can reduce the logic expression using boolean algebra
<br/>➡ We can make curcuit simpler and lowering cost
<br/>`Students should be able to prove logic equations using Boolean Algebra`
<br/>Venn diagram can be used to prove logic equations and provide more intuitive understanding. 

<details>
<summary>Axioms</summary>
  *보통 수식이 아닌 **and와 or**의 관점에서 생각하자
<div markdown="1">       
1a: 0 0 = 0 <br/>
1b: 1 + 1 = 1 <br/>
2a: 1 1 = 1 <br/>
2b: 0 + 0 = 0 <br/>
3a: 0 1 = 1 0 = 0 <br/>
3b: 1 + 0 = 0 + 1 = 1 <br/>
4a: if x = 0, then !x = 1 <br/>
4b: if x = 1, then !x = 0 <br/>
</div>
</details>

<details>
<summary>Theorms</summary>
  *보통 수식이 아닌 **and와 or**의 관점에서 생각하자
<div markdown="1">       
5a: x 0 = 0 <br/>
5b: x + 1 = 1 <br/>
6a: x 1 = x <br/>
6b: x + 0  = x <br/>
7a: x x = x <br/>
7b: x + x = x <br/>
8a: x !x = 0 <br/>
8b: x + !x = 1 <br/>
9 : !x' = x <br/>
</div>
</details>

<details>
<summary>Properties</summary>
  *보통 수식이 아닌 **and와 or**의 관점에서 생각하자
<div markdown="1">       
10a: x y = y x <br/>
10b: x + y = y + x <br/>
11a: x ( y z ) = ( x y ) z <br/>
11b: x + ( y + z ) = ( x + y ) + z <br/>
** 12a: x ( y + z ) = x y + x z <br/>
** 12b: x + ( y z ) = ( x + y )( x + z ) <br/>
** 13a: x + x y = x <br/>
** 13b: x ( y + x ) = x <br/>
14a: x y + x !y = x <br/>
14b: ( x + y )( x + !y ) = x <br/>
15a: !( x y ) = !x + !y <br/>
15b: !( x + y ) = !x !y <br/>
16a: x + !x y = x + y <br/>
16b: x ( !x + y ) = x y <br/>
17a: x y + y z + !x z = x y + !x z <br/>
17b: ( x + y )( y + z )( !x + z ) = ( x + y )( !x + z ) <br/>
</div>
</details>

### Principle of Duality
1. Interchanging 0 and 1
2. Interchanging AND or OR
3. Keeping the form of variables as such also **holds true**
```
The person is in a room or not in a room: TRUE (1) // Entire statement is True
The person is in a room and not in a room: FALSE (0) // Dual // Entire statement is True
```

## Notation
- AND gate : xy = x ^ y
- OR gate : x + y = x V y
- NOT gate : !x = x' = ~x

# Terminology
```
- Sum of products(SOP) : x y + x z + y z
- Product of Sums(POS) : ( x + y )( x + z )( y + z )
```

# Synthesis 합성
Truth Table만을 가지고 curcuit을 만듦(Boolean Algebra로 식을 간단하게 만드는 과정까지 모두 포함됨)

 # Min-Terms
 ![image](https://user-images.githubusercontent.com/56028436/112159855-ed24e580-8c2c-11eb-8ce7-7368e5980bb6.png)
 ![image](https://user-images.githubusercontent.com/56028436/112159589-afc05800-8c2c-11eb-8c6a-47ba8a7d2d0e.png)
- **Sum-of-Products(SOP) Form** : 
- f가 **1**인 것을 이용
- Maxterm의 정반대
- 회로 마지막이 OR로 연결되어 있음

# Max-Terms
![image](https://user-images.githubusercontent.com/56028436/112159804-e1d1ba00-8c2c-11eb-8b0b-9dbb59c21a19.png)
![image](https://user-images.githubusercontent.com/56028436/112159673-c23a9180-8c2c-11eb-9d72-182a24390e38.png)
- **Product-of-Sums(POS) Form** : 
- f가 **0**인 것을 이용
- minterm의 정반대
- 회로 마지막이 AND로 연결되어 있음

# NAND
![image](https://user-images.githubusercontent.com/56028436/112160328-658ba680-8c2d-11eb-87f3-f2909fcafd0a.png)
<br/>Opposite of AND gate
<br/>*Using NAND, NOR gates, we can make simipler electronic circuits than the AND and OR functions

### Using only NAND gates to implement a Sum-of-Products
![image](https://user-images.githubusercontent.com/56028436/112160580-a683bb00-8c2d-11eb-83fe-0779caefde39.png)
![image](https://user-images.githubusercontent.com/56028436/112160740-cfa44b80-8c2d-11eb-970b-91345afd81cb.png)

# NOR
![image](https://user-images.githubusercontent.com/56028436/112160398-76d4b300-8c2d-11eb-9aff-7e3719476f6e.png)
<br/>Opposite of OR gate

### Using only NOR gates to implement a Product-of-Sums
![image](https://user-images.githubusercontent.com/56028436/112160689-c1eec600-8c2d-11eb-904d-c8849cbde2a7.png)
![image](https://user-images.githubusercontent.com/56028436/112160770-d8951d00-8c2d-11eb-8fab-6e69a0a696bf.png)
