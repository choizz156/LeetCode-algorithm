# [169. Majority Element](https://leetcode.com/problems/majority-element/)
## 👉 문제 이해
- 배열에서 가장 가장 많은 수를 차지하는 숫자를 리턴하는 로직을 구현합니다.
## 👉 접근 방식

### 1.배열을 오름차순 정렬한다.
   - Arrays.sort()를 사용했습니다. 선형 탐색으로 정렬할 방법을 찾지 못했습니다.
### 2. 가장 많은 수를 차지하는 숫자를 리턴한다.

## 📌 의사 코드
```java
배열의 크기가 1이면 바로 리턴

mid = 배열의 길이 /2;

배열 정렬
cnt = 1;
ret = 0;
for(1, length, 1증가)
  if(앞 == 뒤){
  cnt++;
  if(cnt > mid){
     ret = i
  }
} 일치하지 않으면{
  cnt = 1;
}

return ret;
```
## ✅ 나의 풀이
```java
import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        
        if(length == 1){
            return nums[0];
        }

        int mid = length / 2;
        
        Arrays.sort(nums);

        int cnt = 1;
        int ret = 0;
        for(int i = 1; i < length; i++){
           if(nums[i] == nums[i - 1]){
               cnt++;
               if(cnt > mid){
                   ret = nums[i];
                   break;
               }
           }else{
               cnt = 1;
           }
        }
        return ret;
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n * logn)`
  - Arrays.sort는 Dual-Pivot Quicksort 알고리즘을 사용하기 때문에 O(n*logn)
- 공간 복잡도 : `O(1)`
  - nums1 공간에서 연산이 수행합니다.
 
---
## 📖 다른 풀이
### 1. sort
- 시간 복잡도: `O(n * logn)`
- 공간 복잡도 : `O(1)`
```java
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2]; // 정렬된 상태에서 majority element는 가운데의 요소다.
                          // n / 2 이상이기 때문에
    }
}
```
> majority element를 구하기 위해 정렬하면, 가운데 요소는 majority element가 된다는 사실을 인지하지 못 했습니다.

### 2. Map 활용
- 시간 복잡도: `O(2n) -> O(n)` <- 반복문 2번
- 공간 복잡도: `O(n)` <- map 활용
```java
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); // 요소를 key, count는 value
        }
        
        n = n / 2; 

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) { // 엔트리를 체크
            if (entry.getValue() > n) {
                return entry.getKey();
            }
        }
        
        return nums[0];
    }
}
```
> map을 사용해서, count를 저장하는 방식을 알게 됐습니다.

### 3. Moore Voting algorithm
> -  majority element를 빠르게 찾는 알고리즘
> - majority element 배열의 크기가 n일 때, n/2회 이상 나타나는 요소.
> - 선형 시간 복잡도를 갖는다.
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(1)` 
```java
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        
        for (int num : nums) {
            if (count == 0) {
                candidate = num; //후복 값을 넣는다.
            }
            
          count += (num == candidate) ? 1 : -1; //후보 값이 일치하면 1을 더하고 아니면 1을 뺀다.
                                                // 만약 count가 0이되면 후보값을 바꾼다.
                                                // 카운트가 0이 아니면 그것이 다수 요소가 될 확률이 크다.
         /* 이 로직이 더 빠른 결과를 리턴함 -> 삼항 연산자는 컴파일 시 분기 구문이 추가돼 처리할 가능성이 있다.
           if(num == candidate){
               count++;
           }else{
               count--;
           }
         */                                       
        }

        // 다수 요소인지 검증한다.
        count = 0; 
        for(int num: nums){
            if (num == candidate) {
                count++;
            }
        }

        return (count > nums.length / 2) ? candidate : -1;
    }
}
```
>  Moore Voting algorithm에 대해 알 수 있었습니다.
---
## 👉 회고
- 너무 단순하고 무식하게 문제를 풀려고하는 것 같습니다. 문제 조건들을 더 생각하며 코드를 짜는 연습이 필요할 것 같습니다.
- majority element에 대한 개념과 그에 대한 알고리즘을 학습할 수 있었습니다.
- map을 활용하는 방법에 대해서 배울 수 있었습니다.
  
