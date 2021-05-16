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
![image](https://user-images.githubusercontent.com/56028436/118396614-3c1a5480-b68b-11eb-9aab-289be3ac246a.png)<br/>
- Data input: Maximum of 2<sup>n</sup>
- Selection input : n
- Output: 1
<br/><br/>
- s = 1 ➡ w<sub>0</sub>
- s = 0 ➡ w<sub>1</sub>

## 4-to-1 Multiplexer
![image](https://user-images.githubusercontent.com/56028436/118397022-1726e100-b68d-11eb-8225-e3485bae5e5b.png)
![image](https://user-images.githubusercontent.com/56028436/118397045-3160bf00-b68d-11eb-888d-c1ca26a92cff.png)

`f = !s1&!s0&w0 + !s1&s0&w1 + s1&!s0&w2 + s1&s0&w3 `
- Data input: 4(2<sup>2</sup>)
- Selection input : 2
- Output: 1
<br/><br/>
*4-to-1 multiplexer can be built using 3 2-to-1 multiplexers<br/>
*16-to-1 multiplexer can be built using 5 4-to-1 multiplexers<br/>
