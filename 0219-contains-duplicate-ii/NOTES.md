# [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/description/)

## 👉 문제 이해
- 배열 내의 같은 값이 있는지 확인하고, 동일한 값의 인덱스 차이가 주어진 k의 값보다 작거나 같아야 합니다.
  
## 👉 접근 방식
### 1. hashmap을 사용하여 map에 배열의 요소(key)와 인덱스(index)를 넣습니다.
### 2. for문의 인덱스 i와 맵에 저장된 값의 차이를 k의 값과 비교합니다.
- 조건에 맞으면 true 리턴합니다.
- 아니면 map에 해당 값과 인덱스를 넣습니다.

## 📌의사코드
```java
for(k == 0)
-> return false;
for(i = 0 , 배열의 길이, 1씩 증가)
  if: map에 diff값이 key가 존재하면서, i - map의 밸류 <= k
    -> return true;
  else:
  -> map.put(배열의 값, 인덱스);

return false;
```

## ✅ 내가 작성한 코드
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        Map<Integer,Integer> map = new HashMap<>(100001);

        if(k == 0){
            return false;
        }
        
        for(int i = 0; i < len; i++){
           if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
               return true;
           }
           map.put(nums[i], i);
        }
        
        return false;
   }
 

```

## 👉 시간 복잡도, 공간 복잡도
시간 복잡도: O(n)
공간 복잡도 : O(n)

---

## 📖 다른 풀이
### HashSet
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>(nums.length, 1); // set 설정

        for(int i = 0; i < nums.length; i++){
            if(!set.add(nums[i])){ //set에 중복된 값이 있으면,
                for(int j = 1; j <= k; j++){ //k의 차이만큼 순회하면서 동일한 값이 있는지 확인
                  if(nums[Math.abs(i - j)] == nums[i])
                    return true;
                }
            }
        }
        return false;
    }
}
```
> HashSet은 중복을 허용하지 않는다는 속성을 이용한 방법도 좋은 방법인 것 같습니다.

---

## 👉 회고
- map을 사용할 경우 for문에서 인덱스로 사용하는 변수와 map에 저장한 인덱스 2개를 사용하여 연산이 가능합니다.
- 다른 풀이로 set의 속성을 활용하여 문제를 해결하는 방법을 생각해 볼 수 있었습니다.
