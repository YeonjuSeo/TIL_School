# Stack 스택
![image](https://user-images.githubusercontent.com/56028436/135752258-3b9d13bc-d72c-46ce-bccc-32f36993292a.png)

- LIFO 후입선출 ; 가장 최근에 들어온 데이터가 가장 먼저 나감
- 추상 데이터 타입
  - 객체: 0개 이상의 원소를 가지는 유한 선형 리스트(순서O)
  - 연산: create, is_full, is_empty, push, pop, peek

# 스택의 구현
배열을 이용한 스택의 구현
## 1차원 배열 stack[]
```C
#include <stdio.h>
#include <stdlib.h>
#define MAX_STACK_SIZE 100 //스택의 최대 크기

typedef int element;
typedef struct {
  element data[MAX_STACK_SIZE]; //스택으로 사용할 배열
  int top;
} StackType; //스택 1개

// 스택 초기화 함수
void init_stack(StackType* s){
  s->top = -1;
}
// 공백 상태 검출 함수
int is_empty(StackType* s){
  return (s->top == -1);
}
// 포화 상태 검출 함수
int is_full(StackType* s){
  return (s->top == (MAX_STACK_SIZE-1));
}

// 삽입 함수
void push(StackType* s, element item){
  if(is_full(s)) return; //스택이 다 찼는지 먼저 확인 //다 찼으면 삽입 불가
  return s->data[++(s->top)] = item; //top을 증가한 뒤 top 위치에 item 삽입
}
// 삭제 함수
element pop(StackType* s){
  if(is_empty(s)) exit(1); //스택에 요소가 있는지 먼저 확인 //하나도 없으면 에러
  else return s->data[(s->top)--] = item; //top에 있던거 출력한 뒤 top 감소
}
// 피크 함수
element pop(StackType* s){
  if(is_empty(s)) exit(1); //스택에 요소가 있는지 먼저 확인 //하나도 없으면 에러
  else return s->data[(s->top)] = item; //top에 있던거 출력
}

int main(){
  StackType s; //정적으로 스택 생성 
  init_stak(&s); //**스택의 주소를 함수에게 전달**
  
  push(&s, 1);
  printf("%d\n",pop(&s));
}
```
- 스택이 공백 상태 ➡️ top = -1
- 가장 먼저 들어온 요소 : stack[0]
- 가장 최근에 들어온 요소 : stack[top]


## 동적 스택
```C
#include <stdio.h>
#include <stdlib.h>

typedef int element;
typedef struct {
  element* data; //포인터로 정의 //스택으로 사용할 배열
  int capacity; //현재 스택의 크기
  int top;
} StackType;

// 스택 초기화 함수
void init_stack(StackType* s){
  s->top = -1;
  s->capacity = 1;
  s->data = (element*)malloc(s->capacity*sizeof(element));
}
// 스택 삭제(반납) 함수
void delete(StackType* s){
  free(s);
}
// (동일)공백 상태 검출 함수
int is_empty(StackType* s){
  return (s->top == -1);
}
// 포화 상태 검출 함수
int is_full(StackType* s){
  return (s->top == s->capacity -1);
}

// 삽입 함수
void push(StackType* s, element item){
  if(is_full(s)){ //스택이 다 찼는지 먼저 확인 //다 찼으면 공간 추가 할당
    c->capacity *=2;
    s->data = (element*)realloc(s->data, s->capacity*sizeof(element)); //**realloc**
  } 
  s->data[++(s->top)] = item; //top을 증가한 뒤 top 위치에 item 삽입
}
// (동일)삭제 함수
element pop(StackType* s){
  if(is_empty(s)) exit(1); //스택에 요소가 있는지 먼저 확인 //하나도 없으면 에러
  else return s->data[(s->top)--] = item; //top에 있던거 출력한 뒤 top 감소
}
// (동일)피크 함수
element pop(StackType* s){
  if(is_empty(s)) exit(1); //스택에 요소가 있는지 먼저 확인 //하나도 없으면 에러
  else return s->data[(s->top)] = item; //top에 있던거 출력
}

int main(){
  StackType *sp; //스택 포인터
  sp = (StackType*)malloc(sizeof(StackType)); //스택 생성
  init_stack(sp); //**스택 포인터 그대로 전달**
  
  StackType s;
  init_stack(&s);

  push(sp, 1);
  printf("%d\n",pop(sp));
  
  free(sp); //스택 공간 반환
}
```
- malloc(), realloc()을 호출하여 실행 시간에 메모리를 할당받아 스택으로 사용
- StackType 구조체 변수 1개를 동적을 할당받아 스택을 생성
- **s는 구조체 변수, 여기에서 sp는 구조체 변수를 가리키는 포인터**

