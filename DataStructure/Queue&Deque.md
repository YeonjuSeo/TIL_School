# Queue 큐
- FIFO 선입선출 ; 먼저 들어온 데이터가 먼저 나감
- 추상 데이터 타입
  - 객체: 0개 이상의 요소들로 구성된 선형 리스트
  - 연산: create, init, is_empty, is_full, enqueue, dequeue, peek

# 큐의 구현
## 선형큐 linear queue
- 배열을 선형으로 사용

![image](https://user-images.githubusercontent.com/56028436/135968545-5efc00d1-f8b5-413a-8212-0d72b3769d5f.png)
- front: 첫번째 데이터의 **앞** index
- rear: 마지막 데이터의 index

```C
#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typedef struct{
  int front;
  int rear;
  element data[MAX_QUEUE_SIZE];
} QueueType;
```
