# Pushdown Automata
; CFG를 통해 만들어진 CFL을 인식하는 오토마타<br/>
- The States<br/>
![image](https://user-images.githubusercontent.com/56028436/121553210-0c712900-ca4c-11eb-861f-cfcab9e8fee5.png)
- pop을 하지 않고 push만<br/>![image](https://user-images.githubusercontent.com/56028436/121553388-30cd0580-ca4c-11eb-8ea9-db0289cb0ad7.png)
- push를 하지 않고 pop만<br/>![image](https://user-images.githubusercontent.com/56028436/121553422-375b7d00-ca4c-11eb-979a-c469e58dd020.png)
- pop도 push도 하지 않음<br/>![image](https://user-images.githubusercontent.com/56028436/121553446-3c203100-ca4c-11eb-8cc3-cc745e57e892.png)

## NPDA ; Non-Deterministic Pushdown Automata
- multi choice 가능 (갈 곳이 여러 곳 가능)
- λ transition 가능
- transition이 없을 수도 있음
- Pushing strings ; push하지 않거나, symbol만 push하거나, 문자열을 push할 수 있다.<br/>![image](https://user-images.githubusercontent.com/56028436/121556445-d84b3780-ca4e-11eb-98ce-4c4605a18ddc.png)
- String Accept 조건
  - 모든 input이 소진
  - last state가 final state
  - stack의 내용물은 신경쓰지 **않는다**
- Context-Free Language(Grammars) = Languages Accepted by NPDAs<br/>
*증명: Converting CFGs ↔ NPDAs p.171~, p.177~
- In general, in Grammar: (q<sub>0</sub>Aq<sub>f</sub>)=*>w ↔ w is accepted by the NPDA
- By construction of Grammar: (q<sub>i</sub>Aq<sub>j</sub>)=*>w ↔ in the NPDA going from q<sub>i</sub> to q<sub>j</sub>, the stack doesn't change below A and A is removed from stack.

*해당 transition의 사항을 모두 완수하지 못하면(읽을 게 없다거나, pop할 게 없다거나)그 자리에서 멈춘다.(해당 transition 시행 불가)<br/>
➡ 해당 input read도 못해서 input이 덜 소진될 수 있다.<br/>
*문자열을 push할 때 stack에는 문자열의 뒤부터 들어간다<br/>![image](https://user-images.githubusercontent.com/56028436/121556544-f0bb5200-ca4e-11eb-9dbf-752412523108.png)
<br/>
*{abba ∈ a와 b로 이뤄진 대칭 문자열} 예시 p.130<br/>
*{abbaab ∈ 문자열의 절반이 개수는 동일하되 symbol은 반대로 대칭} 예시 p.151

### Formal Definition of NPDA
![image](https://user-images.githubusercontent.com/56028436/121557309-9d95cf00-ca4f-11eb-83e6-37dcefd13d91.png)
<br/>
Instantaneous Description<br/>
![image](https://user-images.githubusercontent.com/56028436/121560214-43e2d400-ca52-11eb-93b5-599da1e88f89.png)
<br/>

*Instantaneous Description<br/>
![image](https://user-images.githubusercontent.com/56028436/121559810-e64e8780-ca51-11eb-87c5-34b48d8e8ff5.png)

## DPDA ; Deterministic PUshdown Automata
- δ(q,λ,b) is not empty <br/> = λ transition 가능 but pop할 대상이 꼭 있어야함
- 모든 symbol에 대한 transition이 정해져 있을 필요는 없음(; DFA와 다른 점)
- δ(q,a,b) contains at most one <br/> 
= 같은 state에서 λ과 함께 같은 symbol을 pop하는 transition이 있으면 안됨<br/>
= 같은 state에서 그 문자를 pop하는 다른 문자는 없다<br/>
= 동일한 상황에서 갈 곳이 한 군데 or 없어야함(선택의 여지가 2개 이상 X)
<br/>![image](https://user-images.githubusercontent.com/56028436/121564421-6545bf00-ca56-11eb-8987-905259ae280f.png)
<br/>*2가지 이상의 다른 '단경로'로 동일한 stack 상황을 만들 수 있는 multi choice이므로 두번째도 불가
- A language is deterministic context-free language is some DPDA accepts it

<br/>
`NPDAs have more power than DPDAs`
- The language L = {a<sup>n</sup>b<sup>n</sup>}∪{a<sup>n</sup>b<sup>2n</sup>} is not deterministic context-free language
  - The language {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is not context-free<br/>
    ➡ The language L∪{a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is not context-free
    
### Grammars for DCFL
; DCFL은 backtracking이 없으므로(multi choice가 없으므로) 더 efficient parsing 가능
- s-grammar
- LL Grammar
  - input scanned left ➡ right
  - Leftmost derivation
  - 스캔 여러개 가능 ➡ 선택이 더 분명해짐
- LR Grammar ; 더 general한 deterministic grammar

➡ NPDA가 인식하는 언어군이 더 크지만 DFCL는 더 efficient하게 파싱될 수 있으므로 가치가 있다.(; Programming Language 설계에서 중요)

