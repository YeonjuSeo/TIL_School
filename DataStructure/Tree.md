# Tree 트리
- 계층적 자료구조<br/>*선형 자료구조 - 스택, 큐, 리스트
- 부모-자식 관계의 노드들로 구성

### 용어
![image](https://user-images.githubusercontent.com/56028436/138051599-5d236a5c-ccf9-44b4-abfe-02d48a2b1ab4.png)

1. 노드 : 트리의 구성요소
2. 루트 : 부모가 없는 노드
3. 서브 트리 : 하나의 노드 & 그 노드의 자손들
4. 단말 노드 : 자식 X vs 비단말 노드 : 적어도 하나 이상의 자식 O
5. 레벨: 트리의 층 번호
6. 높이: 트리의 최대 레벨 ex) 위 트리의 높이는 3
7. 차수: 노드가 가지고 잇는 자식 노드의 개수 ex) 노드 B의 차수 = 3

## 종류
1. 이진 트리 : 모든 노드의 child가 최대 2<br/>
![image](https://user-images.githubusercontent.com/56028436/138052236-eeebf7e3-da31-4131-b806-9d5bea44fbb4.png)
![image](https://user-images.githubusercontent.com/56028436/138052505-a0cf23b7-775c-4ea3-8d3e-c283e315a72c.png)<br/>

- 모든 노드의 child가 최대 2개<br/>= 모든 노드가 2개의 서브 트리를 갖되 서브 트리가 공집합일 수 있음<br/>= 모든 노드의 차수가 2 이하<br/>= 이진 트리의 서브 트리들은 모두 이진 트리
- 서브 트리 간의 순서 존재 ; left, right
- 이진 트리의 성질
  - 노드의 개수 = n ➡️ 간선의 개수 = n-1
  - 높이가 h ➡️ 가질 수 있는 노드의 개수 : h ~ 2<sup>h</sup>-1
  - n 개의 노드 ➡️ 가능한 이진 트리의 높이 : (올림)⌈log<sub>2</sub>(n+1)⌉

*노드가 하나도 없어도, 일자로 이어져 있어도 이진트리

2. 일반 트리 : 차수가 맘대로

## 이진 트리의 분류
1. 포화 이진 트리 : 트리의 각 레벨에 노드가 꽉 차있음<br/>
![image](https://user-images.githubusercontent.com/56028436/138056530-7da047fc-52ac-4ab8-9b64-2ee81f9c46fa.png)

- 전체 노드 개수 = 2<sup>k</sup>-1

2. 완전 이진 트리 : 노드가 순서대로 모두 채워져있는 이진 트리<br/>
![image](https://user-images.githubusercontent.com/56028436/138056594-ed44cef5-99e2-432a-bd34-d9d4edfa7678.png)

- 포화 이진 트리와 노드 번호가 일치
- 다 차있어도 완전 이진 트리라고 할 수 있음

3. 기타 이진 트리<br/>
- 다 차지 X
- 순서대로 채워지지 X

# 이진 트리의 표현
## 배열 표현법
모든 이진 트리르 포화 이진 트리로 가정 ➡️ 노드에 번호를 부여 ➡️ 해당 노드 번호 = 배열의 인덱스<br/>
![image](https://user-images.githubusercontent.com/56028436/138056924-ecea3e67-260e-48e8-8f26-9a2e6cae8c10.png)

- 인덱스 번호가 1부터 시작(0번은 비어있음)
- 인덱스 i의 
  - 부모 인덱스 : i/2 *정수나눗셈
  - 왼쪽 자식 노드 인덱스 : 2*i
  - 오른쪽 자식 노드 인덱스 : 2*i + 1

*⚠️skewed binary tree에서 노드 번호가 순서대로 진행되지 X

## 링크(포인터) 표현법
포인터를 이용하여 부모 노드가 자식 노드를 가리킴<br/>
![image](https://user-images.githubusercontent.com/56028436/138058633-5dba5cc4-bb4d-4b81-a052-3f7ec72531a1.png)

```C
#include <stdio.h>
#include <stdlib.h> // include <malloc.h> 생략 가능

typedef struct TreeNode {
  int data;
  struct TreeNode* left, * right;
} TreeNode;

int main(){
  TreeNode* n1, * n2, * n3; // 루트 선언 : TreeNode* root = &n1
  n1 = (TreeNode*)malloc(sizeof(TreeNode));
  n2 = (TreeNode*)malloc(sizeof(TreeNode));
  n3 = (TreeNode*)malloc(sizeof(TreeNode));
  
  // 첫번쨰 노드 설정
  n1->data = 10;
  n1->left = n2;
  n1->right = n3;
  // 두번째 노드 설정
  n2->data = 20;
  n2->left = NULL;
  n2->right = NULL;
  // 세번째 노드 설정
  n3->data = 30;
  n3->left = NULL;
  n3->right = NULL;
  
  free(n1); free(n2); free(n3);
  
}

```

# 이진 트리의 순회
*자식 노드 방문 순서는 무조건 왼쪽이 먼저

## 전위 순회 Preorder ; VLR
루트 노드 방문 ➡️ 자식 노드 순서대로 방문<br/>
![image](https://user-images.githubusercontent.com/56028436/138060358-3c508635-6165-4188-a664-b92e00000c71.png)<br/>

```C
preorder(TreeNode* root){
  if (root){                  // root != NULL
    printf("%d",root->data);
    preorder(root->left);
    preorder(root->right);
  }
}
```
<br/>
*적용 - 구조화된 문서나 조직도 출력

## 중위 순회 Inorder ; LVR
왼쪽 자손 - 루트 - 오른쪽 자손<br/>
![image](https://user-images.githubusercontent.com/56028436/138060613-76ead3da-305e-490f-9705-53303eea6f43.png)<br/>

```C
inorder(TreeNode* root){
  if (root){                  // root != NULL
    inorder(root->left);
    printf("%d",root->data);
    inorder(root->right);
  }
}
```
<br/>
*적용 - 수식 트리<br/>
![image](https://user-images.githubusercontent.com/56028436/138060880-a5206247-4d2d-4757-a693-8192c79b6244.png)


## 후위 순회 Postorder ; LRV
자손 노드 순서대로 방문 ➡️ 루트 노드 방문<br/>
![image](https://user-images.githubusercontent.com/56028436/138060935-96a69b1a-2570-44df-b0af-3f91a8828450.png)
```C
postorder(TreeNode* root){
  if (root){                  // root != NULL
    postorder(root->left);
    postorder(root->right);
    printf("%d",root->data);
  }
}
```
<br/>
*응용 - 디렉토리 용량 계산<br/>
![image](https://user-images.githubusercontent.com/56028436/138061115-350e81ca-4985-400a-8a9b-62738477d636.png)<br/>
'그림' 디렉토리 상단에 쓰인 용량은 하위의 '정지 영상' 디렉토리와 '동영상' 디렉토리의 용량을 제외한 나머지 파일에 대한 용량


