# [27. Remove Element](https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150)
## 👉 문제 이해
- target이 되는 숫자와 배열 안의 숫자가 일치하면, 그 수를 맨 뒤에 정렬하고, 그 수를 제외한 나머지 숫자들의 갯수를 세면 된다고 생각했습니다.
## 👉 접근 방식

#### 1. for문을 돌며 target 숫자와 비교하고, 일치하면 값을 51로 바꾼다.
#### 2. target 숫자와 일치하지 않은 카운트를 센다.
#### 3. 오름차순 정렬한다.

## 📌 의사 코드
```java
for(0, nums.length, 1증가)
  if(배열의 숫자 == target 숫자){
      배열[i] = 51;
      continue;
  }
카운트 증가++;
오름차순 정렬
return 카운트;
```
## ✅ 나의 풀이
```java
import java.util.*;

class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int cnt = 0;
        for(int i = 0; i < length; i++){
            if(nums[i] == val){
                nums[i] = 51;
                continue;
            }
          cnt++;
        }
        
        Arrays.sort(nums);
        return cnt;
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n + n * log(n))`
  - for문 n회 탐색 O(n).   
  - Arrays.sort는 Dual-Pivot Quicksort 알고리즘을 사용하기 때문에 O(n*logn).
  
- 공간 복잡도 : `O(1)`
  - nums 공간에서 연산이 수행됩니다.
 
---
## 📖 더 나은 풀이
### 1. two pointer
- 시간 복잡도: `O(n)`  <- 반복문 활용
- 공간 복잡도: `O(1)`
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int cnt = 0; //카운트 값
        for(int i = 0; i < length; i++){
            if(nums[i] != val){ // 불일치 하면
              nums[cnt] = nums[i]; // 카운트를 인덱스로 사용하고 그 곳에 타겟값과 다른 값을 넣는다. 이렇게 되면 자연스럽게 정렬이 된다.
              cnt++; //카운트를 증가시킨다.
            }
        }
        return cnt;
    }
}
```
> cnt를 인덱스로 사용해서, 그 인덱스의 값으로 타겟 값과 불일치하는 값을 넣는다.

---
## 👉 회고
- cnt를 인덱스로 사용할 생각을 하지 못했습니다.
- cnt가 1씩 증가한다는 것을 이용했다면 더 좋은 풀이를 했을 것 같습니다.
- 정렬을 생각할 때, Arrays.sort만 생각해서 효율적인 방법을 생각하지 못하는 것 같습니다.
