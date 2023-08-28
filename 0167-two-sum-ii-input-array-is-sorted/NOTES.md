# [167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)
## 👉 문제 이해
- 배열 내의 두 수의 합과 타겟 값이 같아지는 인덱스를 찾는 문제입니다(리턴되는 인덱스는 1부터 시작).
## 👉 접근 방식
### 1. two pointer를 활용합니다.
### 2. target 값과 start, end 인덱스 값의 합을 비교합니다.
    - 합이 더 크다면, end를 왼쪽으로 옮김니다.
    - 합이 더 작다면, start를 오른쪽으로 옮김니다.

## 📌 의사 코드
```java
s : 왼쪽 끝 인덱스
e : 오른쪽 끝 인덱스

while(타겟 != 인덱스의 값의 합){
  if: 인덱스의 값의 합 > 타겟
      -> e를 왼쪽으로 한 칸 이동
  else:
      -> s를 오른쪽으로 한 칸 이동

  return {s + 1, e + 1}
}

```
## ✅ 나의 코드

```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = numbers.length - 1;
        
        while(numbers[s] + numbers[e] != target){
            if(numbers[s] + numbers[e] > target){
                e--;
            }else{
                s++;
            }
        }
        
        return new int[]{s + 1, e + 1};
    }

```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`

## 👩🏽‍💻 코드 자체 평가
- two pointer를 적절하게 이용한 것 같습니다.
---

## 📖 다른 풀이
### 1. two pointer
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(1)`
  
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int tmp;

        while (left < right)
        {
            if (numbers[left] + numbers[right] == target) break;
            tmp = target - numbers[right]; // 타겟과 오른쪽 인덱스의 값과의 차이를 구한다.
            while (numbers[left] < tmp) left++; //왼쪽 인덱스의 값보다 그 차이가 작다면 왼쪽으로 옮긴다.
            if (numbers[left] + numbers[right] == target) break;
            tmp = target - numbers[left];// 타겟과 오른쪽 인덱스의 값과의 차이를 구한다.
            while (numbers[right] > tmp) right--;//왼쪽 인덱스의 값보다 그 차이가 작다면 왼쪽으로 옮긴다.
        }

        return new int[]{left + 1, right + 1};
    }
}
```
> 제가 적용한 코드와 표현식이 다를 뿐 원리는 같은 것 같습니다. 
---

## 👉 회고
- 값을 비교할 때, 두 개의 포인터를 활용하는 것이 중요한 것 같습니다.
- while문이 실행되는 조건을 대소 비교만이 아닌 조금 더 유연하게 생각을 해야할 것 같습니다.
  ​​
