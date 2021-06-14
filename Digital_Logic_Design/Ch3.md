## Objectives
- Students should be able to `Create AND, OR, NOT, NAND, and NOR gates using PMOS, NOMS, and CMOS, respectively`
- Students should be able to tell the differences between pull-up and pull-down networks
- Students should be able to tell the differences between positive and negative logic systems

### Binary Number
Electric Signal을 Binary로 판단할 때는 아래와 같은 3가지 상태가 있다.
1. 1 / True / High
2. Undefine
3. 0 / False / Low

# Positive vs. Negative Logic System
- Positive Logic System의 3가지 상태
1. 1 / True / High
2. Undefine
3. 0 / False / Low
- Negative System은 Positive System에서 0과 1이 바뀐 것이다.

## Transistor 트랜지스터
> Considering the transistor as a simple switch
<br/>![image](https://user-images.githubusercontent.com/56028436/112167021-7dfebf80-8c33-11eb-9d5e-8163f5d3e045.png)

- The most popular type of transistor : MOSFET
  - (NMOS) Negative-channel Metal-Oxide Semiconductor
  - (PMOS) Positive-channel Metal-Oxide Semiconductor
  - (CMOS) Complementary Metal-Oxide Semiconductor

# NMOS Transistor
![image](https://user-images.githubusercontent.com/56028436/112167187-9a9af780-8c33-11eb-8cc1-14845d564f91.png)
```
- Gate(VG)에 1( =high voltage )을 주면 gate가 connected( =Close state ) // 누르면 연결된다
- Gate(VG)에 0( =low voltage )을 주면 gate가 disconnected( =Open state ) // 버튼에서 손 떼면 연결X
```
- Pull-Down Network(NMOS)로만 동작한다.
  ➡ 연결되면 V<sub>D</sub>가 **0으로 내려간다.**
*PMOS와 정반대로 동작한다

## NOT gate with NMOS
![image](https://user-images.githubusercontent.com/56028436/112168894-0b8edf00-8c35-11eb-9a8b-81ae5a69bd8b.png)
## NAND gate with NMOS
![image](https://user-images.githubusercontent.com/56028436/112169048-2f522500-8c35-11eb-850b-6f1154ab49ea.png)
- 직렬로 연결
<br/>*둘 다 연결되어 있지 않으면 V<sub>f</sub>는 5V 유지
## NOR gate with NMOS
![image](https://user-images.githubusercontent.com/56028436/112169507-98d23380-8c35-11eb-970d-c32579d504d6.png)
- 병렬로 연결 
<br/>*하나라도 연결되면 V<sub>f</sub>는 0V로 떨어진다
## AND gate with NMOS
![image](https://user-images.githubusercontent.com/56028436/112169567-a7b8e600-8c35-11eb-92a7-58f961b3e77b.png)
<br/>*NAND에 NOT을 하면 AND
## OR gate with NMOS
![image](https://user-images.githubusercontent.com/56028436/112169728-cd45ef80-8c35-11eb-9028-72159f8d972d.png)
<br/>*NOR에 NOT을 하면 AND

# PMOS Transistor
![image](https://user-images.githubusercontent.com/56028436/112167675-f9f90780-8c33-11eb-87c7-0754727dcd1c.png)
```
- Gate(VG)에 1( =high voltage )을 주면 gate가 disconnected( =Open state ) // 누르면 꺼진다
- Gate(VG)에 0( =low voltage )을 주면 gate가 connected( =Close state ) // 안누르면 켜진다
```
- Pull-Up Network(PUN)로만 동작한다.
  ➡ 연결되면 V<sub>D</sub>가 **1(ex.5V)로 올라간다.**
- NMOS와 위의 동그라미(NOT__반대)를 가지고 구분한다.
*NMOS와 정반대로 동작한다.

## NOT gate with PMOS
![image](https://user-images.githubusercontent.com/56028436/112169910-f5cde980-8c35-11eb-81a8-f4919ab363ca.png)
## NAND gate with PMOS
![image](https://user-images.githubusercontent.com/56028436/112169985-0716f600-8c36-11eb-9a4d-2dfcb8c6a69a.png)
- 병렬로 연결
*하나라도 0이면 pull up 되어서 V<sub>f</sub>는 1
## NOR gate with PMOS
![image](https://user-images.githubusercontent.com/56028436/112170018-10a05e00-8c36-11eb-8d9c-2fee3cc3cd97.png)
- 직렬로 연결 
*하나라도 연결되지 못하면 V<sub>f</sub>는 0V로 떨어진다

# CMOS
![image](https://user-images.githubusercontent.com/56028436/112170666-945a4a80-8c36-11eb-9f76-93ad1c071d17.png)
- The most popular approach using NMOS and PMOS together
- CMOS를 사용하는 이유: Low static power consumption
  NMOS와 PMOS는 둘 중에 하나를 쓰면 하나를 꺼야하므로(정반대로 동작하도록 설계) 전력 소비를 줄일 수 있음
- 드 모르간의 법칙을 이용하여 PDN이 있으면 PUN을 만들 수 있고, PUN이 있으면 PDN을 만들 수 있다.

## NOT gate with CMOS
![image](https://user-images.githubusercontent.com/56028436/112170961-d1bed800-8c36-11eb-9b7d-eef65a6d110c.png)
## NAND gate with CMOS
![image](https://user-images.githubusercontent.com/56028436/112172178-d3d56680-8c37-11eb-8609-405dac6face9.png)
<br/>*PUN은 병렬 PDN은 직렬
<br/>*PUN은 NOT을 붙이지 않은 상태로 주어진다.
## NOR gate with CMOS
![image](https://user-images.githubusercontent.com/56028436/112172465-15661180-8c38-11eb-970d-6c24439020f9.png)
<br/>*PUN은 직렬 PDN은 병렬
## Exclusive-OR gate(XOR)
![image](https://user-images.githubusercontent.com/56028436/112173440-e9975b80-8c38-11eb-80da-4937df156926.png)
<br/>1인 input이 홀수 개 있으면 결과가 1이 된다.
<br/>*AND와 NOT / OR과 NOT / NAND / NOR / AND, OR, NOT, NAND, NOR 의 조합으로는 모든 curcuit을 표현할 수 있다.
