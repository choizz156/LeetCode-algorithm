# [55. Jump Game](https://leetcode.com/problems/jump-game/description/)
## 👉 문제 이해
- 배열의 값을 통해 인덱스를 더해 마지막 인덱스 까지 도달할 수 있는지를 판단하는 문제입니다.
## 👉 접근 방식

#### 1. 최대로 이동할 수 있는 거리(maxSpot)를 변수에 저장한다.  
#### 2. 인덱스와 해당 인덱스의 값을 더하고, maxSpot과 비교하여 큰 값을 maxSpot에 다시 저장한다.
#### 3. 인덱스와 maxSpot을 비교하여 인덱스가 클 경우 false리턴한다.
#### 4. 모두 순회한다면 true를 리턴한다.

## 📌 의사 코드
```java
maxSpot = 0;

for(0,nums.length,1증가)
  if:maxSpot이 i보다 작다면
    -> false;
  if: maxSpot이 i + nums[i]보다 작다면
    -> maxSpot을 i + nums[i]으로 교체

true;
```
## ✅ 나의 풀이
```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxSpot=0;
        
        for(int i = 0; i < nums.length; i++){
            
            if(maxSpot<i){
                return false;
            }
            
            if(maxSpot < i + nums[i]){
                maxSpot = i + nums[i];
            }
        }
        
        return true;
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`
 
---
## 📖 다른 풀이
### 1. 변수를 하나만 사용
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(1)`
```java
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxTarget = 0;

        for(int i = 0; i < len; i++){

            if(i > maxTarget){
                return false;
            }

            maxTarget = Math.max(maxTarget, i + nums[i]);  
        }
        return true;
    }
}
```
> if문으로 비교하여 최대값을 비교하는게 아니라 Math 클래스를 이용하여 교체하는 방법을 떠올리지 못했습니다.
---
## 👉 회고
- 인덱스 + 해당 값이 다음 인덱스라이고 이것을 변수에 저장하여 비교한다는 생각을 하기까지 오랜 시간이 걸렸습니다.
- 값을 비교할 때, Math 클래스를 사용해야 겠다는 생각을 먼저 해야할 것 같습니다.
  ​
