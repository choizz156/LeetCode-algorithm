# [189. Rotate Array](https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150)

## 👉 문제 파악
- 배열의 맨 뒤의 요소부터 맨 앞으로 옮기고, 나머지 요소들을 한 칸씩 이동시키는 로직을 작성해야 합니다.
## 👉 접근 방식
### 1. 첫 번째 시도
#### 1.1 맨 뒤의 요소를 변수에 저장한다.
#### 1.2 k의 값과 배열의 길이 만큼 루프를 돌려 한칸 씩 오른쪽으로 이동시킨다.
#### 1.3 배열의 맨 처음에 저장해뒀던 값을 삽입한다.
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        while(k-- > 0){
            int last = nums[len - 1]; // 마지막 요소 저장
            for(int i = 1; i < len; i++){
                nums[i] = nums[0]; // 첫 번째 요소로 값 교체
                nums[0] =  nums[i]; // 첫 번째 요소에 해당 값 저장
            }
            nums[0] = last; // 마지막 값을 배열의 첫 번째에 대입
        }
    }
}
```
#### `첫 번째 시도 결과`
![image](https://github.com/choizz156/LeetCode-algorithm/assets/106965005/17d52a19-2844-43bb-b6fe-1cf590457f4f)

- 시간 복잡도가 O(n*k)으로 데이터가 많을 시 연산이 오래 걸렸습니다.
---
### 2. 두 번째 시도
#### 2.1 첫 번째 시도에서 for문을 제거하고 System.arraycopy()로 교체
```java
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
       
       for(int i = 0; i < k; i++){
           int last = nums[len - 1];
           System.arraycopy(nums, 0, nums, 1, len -1);
           nums[0] = last;
       }
    }
}
```
#### `두 번째 시도 결과`
![image](https://github.com/choizz156/LeetCode-algorithm/assets/106965005/17d52a19-2844-43bb-b6fe-1cf590457f4f)
- 코드는 단축됐지만 System.arraycopy()도 시간 복잡도가 O(n)이 들기 때문에 첫 번째 시도와의 차이가 없었습니다.
---
### 3. 세 번째 시도
#### 3.1 순환된다는 특징을 고려해 `%연산`을 통해 시도 횟수를 줄인다.
#### 3.2 for문을 돌며 k의 횟수만큼 순회하는 것이 아니라, System.arraycopy()를 이용하여 한 번에 교체한다.

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;

        int[] nums2 = nums.clone(); // 복사를 할 때, 값을 사용할 배열을 클론한다.
        //%연산을 사용한다.
        int size = k % len;
        System.arraycopy(nums2, 0, nums, size, Math.abs(len - size));
        System.arraycopy(nums2, Math.abs(len - size), nums, 0, size);
    }
}
```
#### `세 번째 시도 결과`
![image](https://github.com/choizz156/LeetCode-algorithm/assets/106965005/70e95e98-06d8-497d-bd4c-fff8be7d5dc7)

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(2n) -> O(n)`
  - System.arraycopy()는 O(n) 소요.
- 공간 복잡도 : `O(n)`
  - nums2라는 배열이 새로운 배열 생성.
 
---
## 📖 다른 풀이
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`
  - nums 배열 안에서 연산
```java
class Solution {

public static void reverse(int nums[], int start, int end){
    while(start < end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++; //시작 지점은 늘리고
        end--; // 끝 지점은 줄인다.
    }
}

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1); // 오름차순인 배열을 내림차순으로 변경
        reverse(nums, 0, k - 1); //k-1 인덱스를 기준으로 오름 차순으로 변경
        reverse(nums, k, nums.length - 1); // k인덱스를 기준으로 오름차순으로 변경
    }
}
```
#### 👍 배운 점
> - 오름 차순으로 돼있는 배열을 내림 차순으로 변경하여 활용 가능하다는 것을 알게 됐습니다.
> - 정렬돼 있는 배열을 활용하는 방법에 대해 꾸준히 생각해야 할 것 같습니다.
---
## 👉 회고
- 정렬돼 있는 배열을 활용하는 방법을 더 생각하면서 풀어야 할 것 같습니다.
- 순환일 경우 %연산을 사용한다는 것을 기억해야 할 것 같습니다.
- two point를 활용하여 -> <- 이런 식으로 범위를 좁혀나가는 방법을 알 수 있었습니다.
