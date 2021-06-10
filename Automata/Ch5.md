# Context-Free Language 문맥-자유 언어

<details>
<summary> a<sup>n</sup>b<sup>n</sup></summary>
<div markdown="1">       
- CFG G: S ➡ aSb, S ➡ λ <br/>
- L(G) = {<span>a<sup>n</sup></span><span>b<sup>n</sup></span> : n>=0} <br/>
- NPDA <br/> <img src="https://user-images.githubusercontent.com/56028436/121554207-ebf59e80-ca4c-11eb-9efb-8e9517db62e4.png" />
- DPDA <br/><img src="https://user-images.githubusercontent.com/56028436/121565073-14829600-ca57-11eb-88f7-5560608c239e.png" />
</div>
</details>

<details>
<summary> <span>ww<sup>R</sup></summary>
<div markdown="1">       
- CFG G: S ➡ aSa, S ➡ bSb, S ➡ λ <br/>
- L(G) = {<span>ww<sup>R</sup> : w ∈{a,b}*}
- NPDA <br/> <img src="https://user-images.githubusercontent.com/56028436/121554400-1d6e6a00-ca4d-11eb-982f-5a79a2430724.png" />
- DPDA로 만들어줄 수 없음 (위의 NPDA - pop할 대상이 없는 λ transition을 하고 있어서)

</div>
</details>
  
<details>
<summary>n<sub>a</sub>(w) = n<sub>a</sub>(w) and n<sub>a</sub>(v) >= n<sub>b</sub>(v) in any prefix v</summary>
<div markdown="1">       
- CFG G: S ➡ aSb, S ➡ SS, S ➡ λ <br/>
- L(G) = {w:n<sub>a</sub>(w) = n<sub>a</sub>(w) and n<sub>a</sub>(v) >= n<sub>b</sub>(v) in any prefix v}
</div>
</details>
  
- 임시저장소(stack)이 생김
- L=L(G)인 G가 존재 ↔ L 이 context-free language

## Context-Free Grammar
- Productions of the form: A ➡ x (x:변수와 터미널)
- Sometimes, derivation order doesn't matter
- Context-Free Grammar는 ambigous한 것 or non-ambiguous한 것
  
## Ambiguity
![image](https://user-images.githubusercontent.com/56028436/121539647-d1b5c380-ca40-11eb-853c-4f0a8fd391f0.png)
- w의 유도 과정에 따라 2개 혹은 그 이상의 derivation tree가 생성 ➡ `ambiguous`한 문법
- w가 2개 혹은 그 이상의 leftmost or rightmost derivation을 가짐 ➡ `ambiguous`한 문법
- Inherent Ambiguity 
  - unambiguous한 L: non-ambiguous한 G가 존재
  - inherently(본질적으로) ambiguous한 L: non-ambiguous한 G가 존재하지 않음 ; Some CFL have only ambiguous grammars
  - ex. a<sup>n</sup>b<sup>n</sup>c<sup>n</sup> __p.34

### Parsing 
; w ∈ L(G)인 w에 대해 일련의 생성 규칙을 발견하는 과정<br/>
; CFG로 생성되는 언어에 속하는 스트링 w를 유도하는 과정
- Parser가 result를 찾는 방식: 
  - Exhaustive Search(top-down parsing)
    - Time Complexity: k +  + ... + k<sup>2|w|</sup> ; Extremely bad!
  
*w에 따라 유도 중 nontermination에 빠지는 경우가 생길 수도 있으므로 제약을 추가할 수도 있음 p.39

## s-grammar(simple grammar)
![image](https://user-images.githubusercontent.com/56028436/121543394-d760d880-ca43-11eb-9ce5-b7df5e1beabb.png)<br/>
; Exhuastive Search를 해도 선형 시간 내 결과 탐색 가능한 CFG<br/>

- A ➡ ax (a:symbol x: string of variables), Pair(A,a)가 한 번만 나온다
- Total time for parsing string : |w|
  
➡ For general CFG, there exists a parsing algorithm that parses a string w in time |w|<sup>3</sup><br/>

*Convention for specifying grammars for Programming Language: Backus-Naur Form p.45<br/>
*s-grammar is easily/efficiently parsed by Backus-Naur Form due to keywords
