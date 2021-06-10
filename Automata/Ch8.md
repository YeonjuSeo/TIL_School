# Pumping Lemma
For **Infinite** context-free language(;generates an infinite number of different strings),<br/>
there exists an integer **m(= production rule 개수 X 우변에 나온 것 중 가장 긴 것의 길이)**<br/>
such that for any string w∈L, |w|≥m <br/>
we can write w = uvxyz with lengths |vxy|≤m and |vy|≥1 <br/>
and it must be uv<sup>i</sup>xy<sup>i</sup>z∈L, for all i≥0 <br/>

➡ Proof: (p.216)The language L = {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>} is not context-free language <br/>
➡ Proof: (p.237)The language L = {ww:w ∈{a,b}} is not context-free language <br/>
➡ Proof: (p.244)The language L = {a<sup>n!</sup>:n≥0} is not context-free language <br/>

*Examples<br/>
- Context Free Language ; {a<sup>n</sup>b<sup>n</sup> : n≥0}, {<span>ww<sup>R</sup> : w ∈{a,b}*}
- Non-Context Free Language ; {a<sup>n</sup>b<sup>n</sup>c<sup>n</sup>:n≥0}, {ww:w ∈{a,b}}, {a<sup>n!</sup>:n≥0}
  
# Closure Properties
![image](https://user-images.githubusercontent.com/56028436/121571569-2b78b680-ca5e-11eb-93dc-b8448045fc7a.png)
<br/>
- Context-Free Languages are closed under (L1-G1-S1, L2-G2-S2)
  - Union `L1∪L2` ; S ➡ S1|S2
  - Conctenation `L1L2`; S ➡ S1S2
  - Star-operation `L1*` ; S ➡ S1S|λ
  - Regular Intersection ; intersection of a CFL and Regular language
- Context-Free Languages are **not** closed under 
  - intersection `L1∩L2`
  - complement `!L1`
  
# Decidable Properties of CFL
1. string w∈L(G)가 존재 ➡ CFL L의 member이다
2. CFL의 Parsers ; Exhaustive seaarch parser, CYK parsing algorithm
3. L(G)=Φ ➡ CFL G는 empty language 
  - useless variables 삭제 ➡ Start variable이 useless해졌는지 확인
4. L(G)가 infinite ➡ CFG G는 inifinite한 language L을 생성
  - simplification 후 dependency graph 그리기 ➡ **loop가 있으면 infinite**
