# Signed Number Representations
## Two's Complement
⚠️범위 주의<br/>
![image](https://user-images.githubusercontent.com/56028436/137634286-b2d5f13d-469f-4611-a478-d188d25bd39b.png)

- Negating Two's Complement Numbers
  1. 모두 0➡️1, 1➡️0 한다.
  2. 1을 더한다. 
- Sign bit인 0,1로 음양 표시
- 0 표현법이 하나

### Sign/Magnitude
![image](https://user-images.githubusercontent.com/56028436/137634001-ef437f20-da08-4182-87f8-89155714ead3.png)

- 앞에 Sign bit를 추가해서 음양을 표시
- Problems
  - 0을 2가지 방법으로 표현할 수 있음 = 0이 2개
  - 하드웨어에서 다루기 어려움


### One's Complement
- Negating Two's Complement Numbers :  0➡️1, 1➡️0 한다.
- Problem
  - 0 표현법이 2가지

### Biased
Floating Point에서의 지수 표현에서 사용됨

- Add a bias (offset) to all numbers
  - 대부분의 음수: 000..0 = -2<sup>n-1</sup>
  - 0: 100..0 = 0
  - 대부분의 양수: 111..1 = 2<sup>n-1</sup>-1

### Sign Extension in MIPS
- lb(load-byte) 또는 lbu(load-byte unsigned) 사용
- I-Format 명령어(-16bit의 immediate field. 32bit로 변경될 필요 O)와 immediate operand에서 시행됨

# Adder
