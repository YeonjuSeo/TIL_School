# Queue 큐
- FIFO 선입선출 ; 먼저 들어온 데이터가 먼저 나감
- 추상 데이터 타입
  - 객체: 0개 이상의 요소들로 구성된 선형 리스트
  - 연산: create, init, is_empty, is_full, enqueue, dequeue, peek

# 큐의 구현
## 선형큐 linear queue
- 배열을 선형으로 사용
- 응용) 작업 스케줄링

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

// 큐 초기화
void init_queue(QueueType* q){
  q->rear = -1;
  q->front = -1;
}

// 큐 전체 출력
void queue_print(QueueType* q){
  for(int i=0;i<MAX_QUEUE_SIZE; i++){
    //데이터가 없는 front or 그 뒤거나 rear가 가리키는 곳 뒷부분
    if(i <= q->front || i > q->rear) print("  | ");
    //front 뒤~rear까지 출력
    else print("%d | ",q->data[i]);
  }
  print('\n');
}

// 다 찼는지 체크
int is_full(QueueType* q){
  if(q->rear == MAX_QUEUE_SIZE -1) return 1; //배열 이용해서
  else return 0;
}

// 비었는지 체크
int is_empty (QueueType* q){
  if(q->front == q->rear) return 1;
  else return 0;
}

// 큐에 삽입
void enqueue(QueueType* q, int item){
  if(is_full(q)) return;
  q->data[++(q->rear)] = item; //rear를 늘리고 그 위치에 item 삽입
}

// 큐에서 삭제 (삭제된 item 리턴)
int dequeue(QueueType* q){
  if(is_empty(q)) return -1;
  int item = q->data[++(q->front)]; //front가 가리키는 곳은 비어있다! 그러므로 front를 먼저 늘린다.
  return item;
}

int main(void){
  int item = 0;
  QueueType q; // 큐 생성
  init_queue(&q);
}
```

## 원형큐 circular queue
![image](https://user-images.githubusercontent.com/56028436/136918452-0793108f-70cb-4066-9a04-8efcfd76f847.png)<br/>

- 큐의 전단과 후단을 관리하기 위한 2개의 변수 필요
  - front: 첫번쨰 요소 **하나 앞**의 인덱스
  - rear: 마지막 요소의 인덱스
- 공백 상태와 포화 상태를 구별하기 위하여 하나의 공간을 항상 비워둔다.
  - 공백 상태: front == rear
  - 포화 상태: front == (rear+1)% MAX_QUEUE_SIZE
- 응용: 버퍼

```C
#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typeedef struct{
  element data[MAX_QUEUE_SIZE];
  int front, rear;
} QueueType;

// 초기화
void init_queue(QueueType* q){
  q->front = q->rear = 0;
}

// 공백 상태 판정
int is_empty(QueueType* q){
  return (q->front == q->rear);
}

// 포화 상태 판정
int is_full(QueueType* q){
  return((q->rear+1)%MAX_QUEUE_SIZE == q->front);
}

// 큐 전체 출력
void queue_print(QueueType* q){
  if(!is_empty){
    int i = q->front;
    do{ //front+1, front+2, ...순으로 출력 //front는 비어있음
      i=(i+1)% MAX_QUEUE_SIZE ; //i가 큐 사이즈를 넘지 않도록
      printf("%d | ", q->data[i]);
      if(i==q->rear) break; // 마지막 원소에 다다랐으면 종료_Q. 이거 없으면?
    } while(i!=q->front); //비어있는 원래의 front로 돌아올 때까지
  }
  print("\n");
}

// 원형 큐에 삽입
void enqueue(QueueType* q, element item){
  if(is_full(q)) exit(1);
  q->rear = (q->rear +1)% MAX_QUEUE_SIZE; //최대 크기를 넘지 않도록 다음으로 확장
  q->data[q->rear] = item; //rear 위치에 item 삽입
}

// 원형 큐에서 삭제(삭제된 data 반환)
element dequeue(QueueType* q){
  if(is_empty(q)) exit(1);
  q->front (q->front +1) % MAX_QUEUE_SIZE; // 최대 크기 넘지 않도록 front 한 칸 앞으로
  return q->data[q->front];
}

int main(){
  QueueType queue;
  int element;
  
  init_queue(&queue);
  while(!is_full(&queue)){
    // element 입력받기
    enqueue(&queue, element);
  }
  while(!is_empty(&queue)){
     element = dequeue(&queue);
  }
}
```

# Deque, Dequeue 덱
; double-ended queue

- 큐의 front 와 rear에서 모두 삽입과 삭제가 가능한 큐
- 추상 데이터 타입
  - 객체: n개의 element 형으로 구성된 요소들의 순서있는 모임
  - 연산: create, init, is_empty, is_full, add_front, add_rear, delete_front, delete_rear, get_front, get_rear

# 덱의 구현
배열을 이용한 덱의 구현

```C
#include <stdio.h>
#include <stdlib.h>
#define MAX_QUEUE_SIZE 5

typedef int element;
typeedef struct{
  element data[MAX_QUEUE_SIZE];
  int front, rear'
} DequeType;

void init_deque(DequeType* q){
  q->front = q->rear = 0;
}
```

