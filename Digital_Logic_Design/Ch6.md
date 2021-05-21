## Objectives
- Students should be able to describe the definition of `combinational circuits` 
- Students should be able to Describe the definitions of `multiplexer` and `de-multiplexer` and how they works
- Students should be able to describe the definitions of `decoder` and `encoder` and how they operates

# Combinational Curcuit
- combining을 통해 다른 logic gate 설계 가능
- ouput은 들어온 input을 통해서`만` 결정된다. 즉, output에 이전의 state가 영향을 주지 않는다.
- 메모리를 사용하지 않는다.
- 이전의 상태는 현재 curcuit 상태에 아무런 영향을 주지 않는다. 즉, 현재의 output과 다음 circuit의 output에는 아무런 의존성이 없다.

# MUX : Multiplexer
combinational circuit이다.
## 2-to-1 Multiplexer
![image](https://user-images.githubusercontent.com/56028436/119128029-11a40f00-ba70-11eb-8d66-8a23938a347a.png)<br/>
- Data input: Maximum of 2<sup>n</sup>
- Selection input : n
- Output: 1
<br/><br/>

|s|f|
|---|---|
|0|w<sub>0</sub>|
|1|w<sub>1</sub>|

## 4-to-1 Multiplexer
![image](https://user-images.githubusercontent.com/56028436/119128615-d5bd7980-ba70-11eb-9121-faeeaba73baf.png)
![image](https://user-images.githubusercontent.com/56028436/118397045-3160bf00-b68d-11eb-888d-c1ca26a92cff.png)<br/>
*circuit 그릴 줄 알기

|s<sub>1</sub>|s<sub>0</sub>|f|
|---|---|---|
|0|0|w<sub>0</sub>|
|0|1|w<sub>1</sub>|
|1|0|w<sub>2</sub>|
|1|1|w<sub>3</sub>|

`f = !s1&!s0&w0 + !s1&s0&w1 + s1&!s0&w2 + s1&s0&w3 `
- Data input: 4(2<sup>2</sup>)
- Selection input : 2
- Output: 1
<br/><br/>

*4-to-1 multiplexer can be built using three 2-to-1 multiplexers<br/>
![image](https://user-images.githubusercontent.com/56028436/119128898-3482f300-ba71-11eb-9c1f-9f8e6b4d6ab9.png)
<br/>
*16-to-1 multiplexer can be built using five 4-to-1 multiplexers<br/>

# Sysnthesis of Logic Functions using MUX
; w<sub>0</sub>, w<sub>1</sub>, w<sub>2</sub>, w<sub>3</sub> 값을 어떻게 설정하느냐에 따라 selection bit를 이용해서 gate처럼 동작하는 MUX를 제작할 수 있다.<br/>

<details>
<summary>OR gate</summary>
<div markdown="1">       
<img src="https://user-images.githubusercontent.com/56028436/119129490-f508d680-ba71-11eb-86f3-d48690a230e3.png"/>
</div>
</details>

<details>
<summary>XOR gate</summary>
<div markdown="1">
<img src="https://user-images.githubusercontent.com/56028436/119129666-2c778300-ba72-11eb-90ca-3a536894bf7a.png"/>
</div>
</details>

<details>
<summary>더 General하게 synthesize하기</summary>
<div markdown="1">       
- XOR gate ; 4 to 1 MUX ➡ 2 to 1 MUX<br/>
  <img src="https://user-images.githubusercontent.com/56028436/119129859-6fd1f180-ba72-11eb-8779-243725c6e370.png">
  <img src="https://user-images.githubusercontent.com/56028436/119130046-a7d93480-ba72-11eb-97b6-f98ebf14b982.png"><br/>
- XOR과 XNOR<br/>
  <img src="https://user-images.githubusercontent.com/56028436/119130430-2df57b00-ba73-11eb-8cfd-db5ad7ffb2c3.png"/><br/>
- 추가<br/>
  <img src="https://user-images.githubusercontent.com/56028436/119130544-554c4800-ba73-11eb-987b-30b944a98cb9.png"/><br/>
  <img src="https://user-images.githubusercontent.com/56028436/119130578-5e3d1980-ba73-11eb-8239-e657eb3b402c.png"/>
</div>
</details>

## Shannon's Expansion Theorem_MUX로 Curcuit 생성
;f(w<sub>1</sub>, w<sub>1</sub>, ..., w<sub>n</sub>) = !w<sub>i</sub>&f<sub>!w<sub>i</sub></sub> + w<sub>i</sub>&f<sub>w<sub>i</sub></sub> <br/>
; f<sub>!w<sub>i</sub></sub> : Cofactor of f with respect to !w<sub>i</sub>(f<sub>!w<sub>i</sub></sub>)<br/>
; f<sub>!w<sub>i</sub></sub> : Cofactor of f with respect to w<sub>i</sub>(f<sub>w<sub>i</sub></sub>)<br/>
➡ 1~n 중 가장 cost가 작은 수를 선택<br/>

### DEMUX_De-Multiplexer 
![image](https://user-images.githubusercontent.com/56028436/119162939-e6ccb180-ba95-11eb-8aac-d1f08504070f.png)<br/>

- Combinational circuit + reverse operation of MUX
- Data input: 1
- Selection input : n
- Output: Maximum of 2<sup>n</sup>

|s<sub>0</sub>|y<sub>1</sub>|y<sub>0</sub>|
|---|---|---|
|0|0|D|
|1|D|0|

# Decoder
; decode encoded information <br/>
- A binary decoder ; logic curcuit with n inputs and 2<sup>n</sup> outputs
- `Enable input` is used to **disable outputs**
- Decoder Tree ; 작은 decoder로 큰 decoder를 만들 수 있다.
- <details>
  <summary>Decoder를 이용해서 Multiplexer도 만들 수 있다.</summary>
  <div markdown="1">
  <img src="https://user-images.githubusercontent.com/56028436/119169444-fc91a500-ba9c-11eb-8f3a-165372037951.png" />
  </div>
  </details>

*<details>
 <summary>Decoder Example ; ROM</summary>
 <div markdown="1">
 <img src="https://user-images.githubusercontent.com/56028436/119169724-52664d00-ba9d-11eb-8b13-08caf05be15b.png" /><br/>
   <div>Tri-State Buffer ; Enable(=Read) 값이 0이면 unknown state인 High impedance</div>
   <div>Tri-State Buffer ; Enable(=Read) 값이 1이면 input 값을 그대로 받아온다.</div>
 </div>
 </details>
 
## One-Hot Encoded
; An n-bit binary code in which `exactly one` of the bits is `set to 1` `at a time`<br/>
![image](https://user-images.githubusercontent.com/56028436/119166524-ae2ed700-ba99-11eb-8a7c-233f3287c95a.png)<br/>
|Enable|w<sub>1</sub>|w<sub>0</sub>|y<sub>0</sub>|y<sub>1</sub>|y<sub>2</sub>|y<sub>3</sub>|
|---|---|---|---|---|---|---|
|0|D|D|0|0|0|0|
|1|0|0|1|0|0|0|
|1|0|1|0|1|0|0|
|1|1|0|0|0|1|0|
|1|1|1|0|0|0|1|

<br/>
*3-to-8 Decoder

![image](https://user-images.githubusercontent.com/56028436/119168623-0cf55000-ba9c-11eb-9cfa-e7fb4906f41e.png)<br/>
- w<sub>0</sub>과 w<sub>1</sub>값은 두 decoder가 공유한다.
- 빨간색 테두리 친 부분 ➡ 1st deocder와 2nd decoder의 `Enable을 결정`<br/>
  ➡ Enable이 0인 decoder가 disabled된다.
  |w<sub>2</sub>|Enable|동작|
  |---|---|---|
  |0|1|1st decoder|
  |1|0|2nd decoder|
