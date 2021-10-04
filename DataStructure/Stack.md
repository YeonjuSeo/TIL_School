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
- free(스택)을 하면 data가 가리키던 배열이 사라진 것! StackType 구조체 자체는 그대로 있다.

# 응용: 괄호 검사
- 괄호의 종료: 대괄호, 중괄호, 소괄호
- 조건
  - 왼쪽 괄호의 개수 = 오른쪽 괄호의 개수
  - 같은 괄호에서 왼쪽 괄호는 오른쪽 괄호보다 먼저 나와야함
  - 괄호 사이에는 포함 관계만 존재

- 구현
```C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STACK_SIZE 100
typedef char element; // 입력할 데이터 타입 : character

/...스택 구현 코드.../

int check_matching(const char* input){
  StackType s;
  char letter, open_letter;
  int n = strlen(in); //n = 문자열의 길이
  init_stack(&s); //스택 초기화
  
  for(int i =0; i<n;i++){
    letter = input[i];
    switch(letter){
      case '(': case'[': case'{':
        push(&s,letter); //여는 괄호면 stack에 push
        break;
      case ')': case']': case'}':
        if(is_empty(&s)) return 0;
        else{
          open_letter = pop(&s);
          if((open_letter =='(' && letter !=')') || 
             (open_letter =='[' && letter !=']') ||
             (open_letter =='{' && letter !='}')) {
                 return 0; //괄호의 짝이 맞지 않으므로 오류
             }
             break;
        }
    }
  }
  if(!is_empty(&s)) return 0; //스택에 남은 괄호가 있으면 오류
  return 1;
}

int main(){
  char* p = "{A[(i+1)]=0;}" //샘플 데이터
  
  if(check_matching(p)==1) printf("%s 괄호 검사 성공\n",p);
  else printf("%s 괄호 검사 성공\n",p);
}

```

# 응용: 수식의 계산_후위표기식

*후위 표기식
  - 연산의 우선순위를 나타내기 위해 괄호가 필요 없음
    - 괄호를 기다릴 필요 없이 식을 읽어가며 바로 계산
  - 연산자의 우선순위 고려할 필요X(식 자체에 우선 순위 자체가 표현)

```C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STACK_SIZE 100
typedef int element; //사용할 데이터 타입 : int
/..스택 구현 코드../

int eval(char exp[]){ //입력값은 char[]
  int op1, op2, value;
  int len=strlen(exp);
  char letter;
  StackType s;
  init_stack(&s);
  
  for(int i=0;i<len;i++){
    letter = exp[i];
    if(ch!='+' && ch!='-' && ch!='*' && ch!='/'){ //입력이 피연산자(0~9)라면 //숫자로 변형해서 push
      value = ch ='0';
      push(&s,value);
    }
    else { 
      op2=pop(&s); //연산자이면 피연산자를 스택에서 제거
      op1=pop(&s);
      switch(letter){ //연산을 수행하고 스택에 저장
        case '+': push(&s, op1+op2); break;
        case '-': push(&s, op1-op2); break;
        case '*': push(&s, op1*op2); break;
        case '/': push(&s, op1/op2); break;
      }
    }
  }
  return pop(&s); //마지막에 남은 최종 계산 결과 반환
}

int main(){
  int result;
  result= eval("82/3-32*+ \n") //후위 표기식으로 주어지는 예제
}

```
- **피연산자면 스택에 저장**
- 연산자이면 필요한 수만큼의 피연산자를 스택에서 꺼내 연산을 실행한 뒤 결과를 다시 스택에 저장

### 중위 표기식 ➡️ 후위 표기식
- 중위 표기법과 후위 표기법의 공통점: 피연산자의 순서
- 연산자들의 순서만 다름(우선순위 순서)
➡️ **연산자만 스택에 저장**했다가 출력하면 된다!!

```C
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_STACK_SIZE 100
typedef int element; //사용할 데이터 타입 : int
/..스택 구현 코드../

void infix_to_postfix(char exp[]){
  char letter, top_op;
  StackType s;
  init_stack(&s);
  
  for(int i=0;i<strlen(exp);i++){
    letter = exp[i];
    switch(letter){
      case'+': case'-': case'*': case'/': 
      //**스택에 있는 연산자의 우선순위가 더 크거나 같으면 출력**
      while(!is_empty(&s) && prec(letter)<=prec(peek(&s))){ //prec - 우선순위 반환 함수
        printf("%c", pop(&s));
      }
      push(&s, letter);
      break;
    }
    case '(' : //왼쪽 괄호
      push(&s, letter);
      break;
    case ')' : //오른쪽 괄호
      top_op = pop(&s);
      while(top_op !='('){ //왼쪽 괄호를 만날 때까지 연산자 출력
        printf("%c", top_op);
        top_op=pop(&s);
      }
      break;
    default: //피연산자는 그대로 출력
      printf("%c", letter);
      break;
  }
  while(!is_empty(&s)) printf("%c", pop(&s)); //스택에 저장된 연산자들 출력
}

int main(){
  char*s = "(2+3)*4+9";
  infix_to_postfix(s);
}
```
- 피연산자는 그대로 출력
- 이번에 읽은 연산자보다 **우선순위가 더 크거나 같은 게 있으면 이들을 모두 출력** 후 push
- 왼쪽 괄호는 push = 왼쪽 괄호를 가장 우선순위가 낮은 연산자로 취급
- 오른쪽 괄호를 만나면 왼쪽 괄호를 만날 때까지 연산자를 모두 출력

# 응용: 미로 탐색
![image](https://user-images.githubusercontent.com/56028436/135871282-e15d24b0-1dd4-4e31-a263-740094048a87.png)

- 현재의 위치에서 가능한 방향을 스택에 저장해 놓았다가 막다른 길을 만나면 스택에서 다음 탐색 위치를 꺼낸다.

```C
#include <stdio.h>
#include <stdlib.h>
#define MAX_STACK_SIZE 100
#define MAZE_SIZE 6

typedef struct {
  short r; //row
  short c; //column
} element
typedef struct{
  element data[MAX_STACK_SIZE];
  int top;
} StackType;

/..스택 구현 코드../

element here = {1,0}, entry={1,0}; 
char maze[MAZE_SIZE][MAZE_SIZE] = {
  {'1','1','1','1','1','1'},
  {'e','0','1','0','0','1'},
  {'1','0','0','0','1','1'},
  {'1','0','1','0','1','1'},
  {'1','0','1','0','0','x'},
  {'1','1','1','1','1','1'},
}

// 탐색 가능한 위치를 스택에 삽입
void push_loc(StackType*s, int r, int c){
  if(r<0||c<0) return;
  if(maze[r][c] !='1' && max[r][c] !='.'){ //벽이 아니거나 이미 방문하지 않았다면 push
    element tmp;
    tmp.r=r;
    tmp.c=c;
    push(s,tmp);
  }
}

int main(){
  int r,c;
  StackType s;
  init_stack(&s);
  
  here = entry;
  while(maze[here.r][here.c]!='x'){ //출구에 도달할 때까지
    r=here.r;
    c=here.c;
    maze[r][c]='.' //현재 위치에 방문 표시
    push_loc(&s, r-1,c); //위
    push_loc(&s, r+1,c); //아래
    push_loc(&s, r,c-1); //좌
    push_loc(&s, r,c+1); //우
    
    if(is_empty(&s)){
      return; //실패
    }
    else{
      here = pop(&s); //스택에서 하나의 위치를 꺼내어서 현재 위치로 만든다(= 탐색 가능한 위치로 이동)
    }
    printf("성공");
  }
}
```
