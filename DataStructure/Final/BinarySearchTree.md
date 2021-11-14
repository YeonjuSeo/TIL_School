# Binary Search Tree 이진 탐색 트리 
![image](https://user-images.githubusercontent.com/56028436/141668178-7abded80-34e0-4a5a-b552-fadf45f47953.png)

<br/>

```
KEY(왼쪽 서브 트리) ≤ KEY(루트 노드) ≤ KEY(오른쪽 서브 트리)
```
- 탐색 작업을 효율적으로 하기 위한 자료 구조(빠른 탐색 가능)
- `중위 순회`하면 `오름 차순`으로 정렬된 값을 얻을 수 있다.

## 탐색 연산
![image](https://user-images.githubusercontent.com/56028436/141668278-f5f17de8-8816-4d87-b4bb-e9853c21a7c4.png)

<br/>

- 탐색하고자 하는 숫자와 노드 값이 같으면 탐색 성공<br/>NULL 포인터와 조우하면 실패
  - 주어진 키 값 < 루트 노드 값 ➡️ 루트 노드의 왼쪽으로
  - 주어진 키 값 > 루트 노드 값 ➡️ 루트 노드의 오른쪽으로
   
- 순환적 방법
```C
TreeNode* search(TreeNode* node, int key){ // tree의 루트와 key
  if(node == NULL) return NULL; // 탐색 실패
  
  if(key==node->key) return node; // 탐색 성공
  else if(key < node->key) return search(node->left, key); // 주어진 키가 루트보다 작으면 왼쪽으로
  else return search(node->right, key); // 주어진 키가 루트보다 크면 오른쪽으로
}
```

- 반복적 방법
```C
TreeNode* search(TreeNode* node, int key){ // tree의 루트와 key
  while(node != NULL){
    if(key==node->key) return node;
    else if(jkey <node->key) node = node->left;
    else node = node->right;
  }
  return NULL; // 탐색 실패
}
```
 
 ## 삽입 연산
 ![image](https://user-images.githubusercontent.com/56028436/141668557-831dc126-51ef-4cc4-bf85-0b917a23f4a7.png)

 - 탐색 수행 ➡️ `색에 실패한 위치 = 새로운 노드 삽입 위치`

```C
TreeNode* new_node(int item){
  TreeNOde* temp = (TreeNode*)malloc(sizeof(TreeNode));
  temp->key = item;
  temp->left=temp->right=NULL; // 양쪽 자식이 없다고 표시
  return temp;
}

TreeNode* insert_node(TreeNode* node, int key){
  if(node == NULL) return new_node(key); // 트리가 공백이면 새 노드 반환(삽입)
  
  // 아니라면 탐색 과정 진행
  if(key<node->key) node->left = insert_node(node-<left, key);
  else if(key>node->key) node->right = insert_node(node->right, key);

  return node;
}
```
