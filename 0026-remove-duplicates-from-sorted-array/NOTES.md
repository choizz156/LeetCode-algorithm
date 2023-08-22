​# [26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)
## 👉 문제 이해
- 중복이 있는 숫자들을 하나씩만 앞 쪽에 배치하고 나머지는 다 뒤 쪽으로 배치하는 로직을 작성하는 것으로 이해했습니다.
## 👉 접근 방식

#### 1. index 변수와 cnt 변수를 둔다.
#### 2. 배열의 앞뒤의 요소들을 비교한다.
#### 3. 앞뒤의 숫자가 다르면 인덱스를 증가시키고 그 인덱스에 해당 값을 넣는다.

## 📌 의사 코드
```java
index = 0;
cnt = 1;
for(0, nums.length, 1증가)
  if(앞 != 뒤){
      배열[++인덱스] = 해당 값;
      cnt++;      
  }
return cnt;
```
## ✅ 나의 풀이
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int index = 0;
        int cnt = 1; //중복되지 않는 것이 무조건 하나는 있음.

        for(int i = 0; i < length; i++){
            if(nums[index] != nums[i]){
              nums[++index] = nums[i];
              cnt++;
            }
        }
        return cnt;
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
  - for문 n회 탐색 O(n).   
- 공간 복잡도 : `O(1)`
  - nums 공간에서 연산이 수행됩니다.
 
---
## 📖 다른 풀이
### 1. 변수를 하나만 사용
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(1)`
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int cnt = 1;
        for(int i = 1; i < length; i++){ //초기값을 1로 넣고 시작
            if(nums[i] != nums[i - 1]){ //i의 값을 연산하여 앞뒤를 비교
              nums[cnt] = nums[i];
              cnt++;
            }
        }
        return cnt;
    }
}
```
---
## 👉 회고
- 이번 문제는 two pointer를 잘 활용한 것 같습니다.
- 제가 푼 풀이는 변수를 하나 더 사용하였지만, 변수를 줄이는 것도 괜찮은 방법인 것 같습니다. 그런데, 변수를 하나 더 쓰는게 엄청난 차이를 가지고 오는지는 모르겠습니다.
- for문에서 초기값, 조건, 증가량을 조절하여 배열의 앞뒤 요소를를 비교하는 로직을 생각해볼 필요가 있을 것 같습니다.
