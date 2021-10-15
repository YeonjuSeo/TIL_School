# List 리스트
`L = (item<sub>0</sub>,item<sub>1</sub>,item<sub>2</sub>,...,item<sub>n-1</sub>)` <br/>
- 항목들이 순서/위치를 가지고 차례대로 저장
- 기본 연산: 삽입, 삭제, 탐색
- 추상 데이터 타입
  - 객체: n 개의 element 형으로 구성된 순서 있는 모임
  - 연산: insert, insert_last, insert_first, delete, clear ,get_entry, get_length, is_empty, is_full, print_list

# 리스트의 구현
![image](https://user-images.githubusercontent.com/56028436/137535079-1a557f54-a2fa-41bc-b3ed-c852b4bfe7bf.png)

## 배열로 구현된 리스트 ; ArrayList
배열 ➡️ 순차적인 메모리 공간 할당 ; 리스트의 순차적 표현

- 삽입, 삭제 시 오버헤드 발생 가능성 O ∵ 기존 데이터의 이동
- 리스트 크기 고정<br/>*공간 부족 시 더 큰 배열 생성 후 기존 배열 데이터 모두 복사해야함

## 연결 리스트로 구현된 리스트 ; LinkedList
동적 메모리 할당 ➡️ 연결 리스트(LinkedList)로 구현

- 크기 제한 X
- 리스트 가운데에서 삽입과 삭제가 수월
- 항목 검색 시 배열보다 탐색 시간이 오래 걸림
