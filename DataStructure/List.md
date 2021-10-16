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

```C
#define MAX_LIST_SIZE 100 // 리스트 최대 크기
#include <stdio.h>
#include <stdlib.h>

typedef int element;

typedef struct {
  element array[MAX_LIST_SIZE]; //배열 정의
  int size; // 현재 리스트에 저장된 항목들의 개수 
} ArrayListType;

//리스트 초기화
vodi init(ArrayListType* L){
  L->size = 0;
}

// 리스트 비어있는지 여부 확인(비어있으면 1 그렇지 않으면 0)
int is_empty(ArrayListType* L){
  return L->size == 0;
}

// 리스트 가득 찼는지 여부 확인(다 찼다면 1 그렇지 않으면 0)
int is_full(ArrayListType* L){
  return L->size == MAX_LIST_SIZE;
}

// pos 위치의 요소값 확인
element get_entry(ArrayListType* L, int pos){
  if(pos < 0 || pos >= L->size) exit(1);
  return L->array[pos];
}

// 리스트 출력
void print_list(ArrayListType* L){
  for(int i=0;i<L->size;i++){
    printf("%d->", L->array[i]);
  printf("\n");
  }
}

// 리스트의 맨 뒤에 항목 삽입
void insert_last(ArrayListType* L, element item){\
  if(L->size >= MAX_LIST_SIZE) exit(1);
  L->array[L->size++] = item; // size 크기를 늘리고 해당 위치에 item 삽입
}

// 리스트의 pos 위치에 항목 삽입
vodi insert(ArrayListType* L, int pos, element item){
  if(!is_full(L) && (pos>=0) && (pos<=L->size)){
    for(int i=(L->size -1); i>=pos; i--){
      L->array[i+1] = L->array[i]; // 한 칸씩 뒤로 밀기
    }
    L->array[pos] = item; // pos 위치에 item 입력
    L->size++;
  }
}

// 리스트의 pos 위치에 있는 항목 삭제 (삭제된 item 반환)
element delete(ArrayListType* L, int pos){
  element item;
  if(pos<0 || pos>=L->size) exit(1);
  item = L-> array[pos];
  for(int i=pos;i<(L->size -1); i++){
    L->array[i] = L->array[i+1]; //한 칸씩 당기기
  }
  L->size--;
  return item;
}

int main(){
  ArratyListType list; // 리스트 정적으로 생성
  init(&list); // 리스트 초기화
}
```

- get_entry() : 항목에 바로 접근 가능 ➡️ O(1)
- insert(), delete() : 다른 항목 이동 필요 ➡️ 최악의 경우 O(n)

## 연결 리스트로 구현된 리스트 ; LinkedList
동적 메모리 할당 ➡️ 연결 리스트(LinkedList)로 구현

# 연결 리스트
![image](https://user-images.githubusercontent.com/56028436/137577972-c5a23487-3a95-47d9-bbd8-f976ce2dc305.png)

- 크기 제한 X (동적)
- 리스트 가운데에서 삽입과 삭제가 수월 (데이터 이동 필요 X)<br/>=연결된 표현
- 항목 검색 시 배열보다 탐색 시간이 오래 걸림
- 항목을 노드에 분산 저장(연결만 순서대로)<br/>`head->link = p`

  - 연속된 메모리 공간 필요X

<br/>
*노드<br/>

```C
typedef int element;
typedef struct ListNode {
  element data;
  struct ListNode* link;
} ListNode;
```
- 자기 참조 구조체를 이용하여 정의
  - 데이터 필드와 링크 필드로 구성
- 필요할 때마다 동적으로 생성<br/>
```C
ListNode* head = NULL;
head = (ListNode*)malloc(sizeof(ListNode));
head->data = 10;
head->link = NULL;
```

*헤드포인터: 리스트의 **첫번째 노드를 가리키는** 포인터<br/>


## 단순 연결 리스트
![image](https://user-images.githubusercontent.com/56028436/137578028-cc6a316c-1fae-4260-8fa4-d228ef96042c.png)

- 하나의 링크 필드를 이용하여 연결
- 마지막 노드의 링크 값은 NULL
- 연산
  - insert_first<br/>
```C
ListNode* insert_first(ListNode* head,int value){
  ListNode* p = (ListNode*)malloc(sizeof(ListNode));
  p->data = value;
  p->link = head; // p가 먼저 head를 가리키고
  head = p; // head에 p 대입
  return head;
}
```
  - insert<br/>
```C
// 노드 pre 뒤에 새로운 노드 삽입
ListNode* insert(ListNode* head, ListNode* pre, element value){
  ListNode* p = (ListNode*)malloc(sizeof(ListNode));
  p->data = value;
  p->link = pre->link; // p 링크에 pre가 가리키던 링크 저장
  pre->link = p; // pre가 새로 추가된 p를 가리킴
  return head;
}
```
  - delete_first <br/>
```C
ListNode* delete_first(ListNode* head){
  ListNode* removed;
  if(head==NULL) return NULL; // 헤드포인터가 NULL == 빈 리스트
  removed = head;
  head = removed->link; // 다음 노드로 헤드 포인터 이동
  free(removed);
  return removed;
}
```
  - delete <br/>
```C
// pre가 가리키는 노드의 다음 노드 삭제
ListNode* delete(ListNode* head, ListNode* pre){
  ListNode* removed;
  removed = pre->link; // pre 다음 노드 삭제
  pre->link = removed ->link; // pre가 다음 노드의 다음 노드를 가리키도록
  free(removed);
  return head;
}
```
  - (주의)print_list <br/>
```C
// head가 가리키는 리스트 전체 출력
void print_list(ListNode* head){
  for(ListNode* p = head; p!=NULL; p = p->link){ 
    printf("%d->",p->data);
  }
  printf("NULL \n");
}
```

<br/>
*data가 string일 경우 : `strcpy(data.name, "APPLE");` <br/>

### 특정한 값을 탐색하는 함수 ; Search_list
리스트에 특정한 값이 저장되어있는지 확인하는 함수<br/>

```C
ListNode* search_list(ListNode* head, element x){
  ListNode* p = head;
  while(p!=NULL){
    if(p->data == x) return p;
    p = p->link;
  }
  return NULL; // 탐색 실패
}

int main(){
  ListNode* head = NULL;
  head = insert_first(head, 10);
  head = insert_first(head, 20);
  head = insert_first(head, 30);
  
  if(search_list(head, 10) != NULL) printf("리스트에서 10 찾음");
  else printf("리스트에서 10 찾지못함");
}
```

### 2개의 리스트를 합하는 함수
2개의 리스트를 생성하고 두 리스트를 합하는 함수<br/>
![image](https://user-images.githubusercontent.com/56028436/137580698-e46d0e89-7834-4a63-b26c-ada91d7fd4bc.png) <br/>

```C
ListNode* concat_list(ListNode* head1, ListNode* head2){
  if(head1 == NULL) return head2; //head1 리스트가 비었으면 합쳐도 head2 리스트
  else if(head2 == NULL) return head1; // head2 리스트가 비었으면 합쳐도 head1 리스트
  else {
    ListNode* p;
    p = head1;
    // 마지막 노드 찾아가기
    while(p->link != NULL){
      p = p->link;
    }
    p->link = head2; // head1의 마지막 노드와 head2의 첫번째 노드 연결
    return head1;
  }
}
```

### 리스트를 역순으로 만드는 함수
리스트의 모든 링크를 바꾸어 리스트 전체가 역순이 되도록 하는 함수<br/>
![image](https://user-images.githubusercontent.com/56028436/137580983-c0026353-56c2-4334-bc60-148567382e6d.png)<br/>

```C
ListNode* reverse(ListNode* head){
  ListNode* p, *q, *r; // 순회 포인터 p,q,r
  
  p = head; // 역순으로 만들 리스트의 head p
  q = NULL; // p 뒤의 노드를 가리키는 노드 q
  while(p != NULL){ // 마지막 노드를 가리킬 때까지
    r = q; // q 뒤를 잇는 r 노드
    q = p; // 뒤의 p 노드를 가리키는 q
    p = p->link; // p는 다음 노드로 이동
    q->link = r;  // q의 링크 방향 바꿈
  }
  return q; // 역순이 된 리스트의 head 노드
}
```
<br/>

![image](https://user-images.githubusercontent.com/56028436/137581409-06ed05cf-e452-44ae-945e-773a65ab0235.png)

## 연결 리스트의 응용
### 다항식
![image](https://user-images.githubusercontent.com/56028436/137581504-fb1a41a5-4980-4ef6-9aed-0a06a83dbceb.png)<br/>

```C
#include <stdio.h>
#include <stdlib.h>

typedef struct ListNode{
  int coef; // 계수
  int expon; // 지수
  struct ListNode* link; // 자기참조구조체
} ListNode; 

// 연결 리스트의 헤더 노드 타입
typedef struct ListType{
  int size;
  ListNode* head;
  ListNode* tail;
} ListType;

// 리스트 헤더 & 리스트 생성
ListType* create(){
  ListType* plist = (ListType*)malloc(sizeof(ListType)); // 연결 리스트의 헤더를 가리키는 포인터
  plist->size = 0;
  plsit->head = plist->tail = NULL;
  return plist;
}

// 리스트 끝에 노드 삽입
void insert_last(ListType* plist, int coef, int expon){ // 헤더 노드, 계수, 지수
  ListNode* temp = (ListNode*)malloc(sizoef(ListNode));
  if(temp == NULL) exit(1);
  temp->coef = coef;
  temp->expon = expon;
  temp->link = NULL; // 마지막 노드이므로 link는 NULL
  
  if(plist->tail == NULL){ // 헤더 노드가 아무것도 가리키고 있지 않을 때 = 리스트가 비어있을 때
    plist->head = plist->tail = temp;
  }
  else{
    plist->tail->link = temp; // 마지막 노드 연결
    plist->tail = temp; // 헤더 노드에서 마지막 노드 갱신
  }
  plist->size++; // 헤더 노드에서 파악하고 있는 리스트 길이 +1
}

// 덧셈 함수 plist3 = plist1 + plist2
void poly_add(ListType* plist1, ListType* plist2, ListType* plist3){
  ListNode* a = plist1->head;
  ListNode* b = plist2->head;
  int sum;
  
  while(a && b){
    if(a->expon == b->expon) { // a의 계수 == b의 계수
      sum = a->coef + b->coef;
      if(sum!=0) insert_last(plist3, sum, a->expon); // plist3의 마지막에 a->expon<sup>sum</sup> 삽입
      a = a->link; b = b->link; // 다음 항으로 이동
    }
    else if(a->expon > b->expon){ // a의 차수 > b의 차수
      insert_last(plist3, a->coef, a->expon); //a->expon<sup>a->coef</sup> 삽입
      a = a->link; // a만 다음 항으로 이동
    }
    else{ // a의 차수 < b의 차수
      insert_last(plist3, b->coef, b->expon); //b->expon<sup>b->coef</sup> 삽입
      b = b->link;
    }
  }
  // 둘 중 하나가 먼저 끝나면 남아있는 항들은 모두 결과 다항식으로 복사
  for(; a!= NULL; a = a->link){
    insert_last(plist3, a->coef, a->expon);
  }
  for(; b!= NULL; b = b->link){
    insert_last(plist3, b->coef, b->expon);
  }
}

// 다항식 출력
void poly_pinrt(ListType* plist){
  ListNode* p = plist->head;
  for(; p; p= p->link){
    printf("%d%d + ", p->coef, p->expon);
  }
  printf('\n');
}

int main(){
   ListType* list1, *list2, *list3;
   
   // 연결 리스트의 헤더 노드 생성
   list1 = create(); list2 = create(); list3 = create();
   
}
```

- p와 q가 가리키는 항들의 지수가 같으면 계수를 더한다.
- p나 q가 가리키는 항의 지수가 더 높으면 그대로 C로 옮긴다.

*헤더 노드 (header node)<br/>
![image](https://user-images.githubusercontent.com/56028436/137581619-09d9a1b1-1dbe-4632-904c-a0c106b9eab1.png)

- 효율적인 계산을 위해 활용
- 리스트의 앞과 뒤를 가리키는 포인터를 가짐 ➡️ 리스트 마지막에 노드를 삽입하기 수월
