# [1. Two Sum](https://leetcode.com/problems/two-sum/description/)

## 👉 문제 이해
- 주어진 타켓의 값과 배열의 두 수의 합이 같아지는 인덱스를 찾는 알고리즘을 작성해야 합니다.
  
## 👉 접근 방식
### 1. hashmap을 사용하여 map에 배열의 요소(key)와 인덱스(index)를 넣는다.
### 2. 타겟값과 배열의 요소와의 차이를 구한다.
### 3. 차이 값이 map에 key로 있는지 확인한다.

## 📌의사코드
```java
for(0 , 배열의 길이, 1씩 증가)
  diff = 타겟과 배열의 요소와의 차이값
  if: map에 diff값이 key로 존재하면
    -> return {map.get(diff), i};
  else:
  -> map.put(배열의 값, 인덱스);

return new int[]{};

```

## ✅ 내가 작성한 코드
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(100001);
        int len = nums.length;

        for(int i = 0; i < len; i++){
            int diff = target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
시간 복잡도: O(n)
공간 복잡도 : O(n)

---

## 📖 다른 풀이
### 1. Math 클래스를 쓰지 않고 직접 비교
- 시간 복잡도: `O(n^3)`
- 공간 복잡도 : `O(1)`
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int x = 1;
        while (x < nums.length) {
            for (int i = 0; i < nums.length - 1;) {
                for (int j = x; j < nums.length;) {
                    if (nums[i] + nums[j] == target) {
                        arr[0] = i;
                        arr[1] = j;
                        return arr;
                    } else {
                        i++;
                        j++;
                    }
                }
                i = 0;
                x += 1;
            }
        }
        return arr;
    }
}
```
> 반복문을 3번 반복하기 때문에 시간복잡도 O(n^3)이 나오지만 leetcode 상에서는 runtime 속도는 제일 빠르게 나옵니다.

---

## 👉 회고
- map을 활용한 알고리즘 문제풀이를 생각해볼 수 있었습니다.​
- 반복문을 활용하는 풀이는 성능면에서는 결과가 가장 높게 나왔지만, 시간 복잡도가 O(n)으로 작성한 알고리즘이 더 좋은 풀이가 아닌가 싶습니다.
