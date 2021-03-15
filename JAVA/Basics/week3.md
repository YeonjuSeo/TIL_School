# for문
```Java
for(초기문; 조건식; 반복 후 작업){
  ..작업문..
}
```
![image](https://user-images.githubusercontent.com/56028436/111151928-773cd080-85d3-11eb-8c88-b04c27f322b6.png)
- 반복 조건이 true이거나 비어있으면 무한 반복한다.
- 초기문과 반복 후 작업은 ,로 여러 문장 나열 가능 but 가독성 하락

- for문의 예시
```Java
for(n = 1; n <=2000; n*=2) 
  System.out.print(n + ",");
} // 1,2,4,8,16,32,64,128,256,512,1024,
```
# while문
```Java
while(조건식){
  ..작업문..
}
```
![image](https://user-images.githubusercontent.com/56028436/111152309-eadedd80-85d3-11eb-8a04-1359fb4c6535.png)
- 처음부터 복조건을 통과한 후 작업문 수행

# do-while 문
```Java
do {
  ..작업문..
} while(조건식);
```
![image](https://user-images.githubusercontent.com/56028436/111152438-106be700-85d4-11eb-9b04-7bb64ec211c3.png)
- 무조건 최소 한 번 작업문 실행

--------------------------
### continue
반복문을 빠져 나가지 않으면서 다음 반복을 진행 
### break
반복문 **하나**를 완전히 빠져나갈 때 사용
  - 즉, 중첩 반복문에서 안쪽 반복문의 break 문이 실행되면 안쪽 반복문만 벗어남
