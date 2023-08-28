# [209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/description/)
## 👉 문제 이해
- 배열 내의 값들 중 값의 합이 타겟의 값보다 크거나 같아야 할 때, 필요한 값들의 최소 개수(배열의 최소 길이)를 구해야합니다.
## 👉 접근 방식
### 1. slide window를 활용합니다.
### 2. 배열을 인덱스를 증가시키면서 값을 더한다.
### 3. 타겟의 값과 배열의 값들을 비교한다.
      - 만약 배열 요소들의 합이 타겟 값보다 크거나 같으면, 최소의 길이를 비교하여 교체한다.
      - 가장 왼쪽의 배열의 값을 뺀다.
      - 왼쪽의 인덱스 값을 증가시킨다.
      

## 📌 의사 코드
```java
left = 0;
minLength = 최소값;
sum = 0;

for(0, 배열 길이, 1증가)
  sum += 배열의 값;
  while(sum >= target)
    minlength = Math.min(target, 배열의 길이);
    sum -= num[left];
    left++;

return minLength != Integer.MAX_VALUE ? minLength : 0
```
## ✅ 나의 코드

```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }

```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n + n) -> O(n)`
  - while 문을 돌지만, left가 증가하면서 감소시키는 로직이 한 번씩 만 수행됩니다.    
- 공간 복잡도 : `O(1)`

## 👩🏽‍💻 코드 자체 평가
- slid window 전략을 잘 적용한 것 같습니다.

---
## 📖 다른 풀이
### 1. slide windoew
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(1)`
  
```java
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans =Integer.MAX_VALUE;
        int sum=0;
        int i=0;int j=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>=target){
                ans=Math.min(ans,j-i+1);
                sum-=nums[i++];
            }
            j++;
            
        }
         if(ans==Integer.MAX_VALUE){
             return 0;
         }
         else {
             return ans;
         }
    }
}
```
> 표현만 다를 뿐 slide window 전략을 적용하는 원리는 비슷한 것 같습니다.
---

## 👉 회고
- slide window를 적용하는데 너무 많은 시간이 걸렸습니다.
- for문 안에 while문이 들어있다고 하더라도 O(n)의 시간 복잡도가 나올 수 있다는 것을 알게 됐습니다. 

  ​​​
