​​# [80. Remove Duplicates from Sorted Array II]()
## 👉 문제 이해
- 중복이 있는 숫자들을 최대 2개 씩만 앞 쪽에 배치하고 나머지는 다 뒤 쪽으로 배치하는 로직을 작성하는 것으로 이해했습니다.
## 👉 접근 방식

#### 1. flag를 두어 몇개가 들어있는지 센다.
#### 2. 배열의 앞뒤의 요소들을 비교한다.
- 만약 같다면 flag를 증가시킵니다.
- 다르다면 flag를 1로 리셋합니다.
- flag가 3 이상이라면, 그 요소를 다음으로 넘깁니다.
#### 3. 해당 값을 넣는다.

## 📌 의사 코드
```java
index = 1;
flag = 1;
for(0, nums.length, 1증가)
  if(앞 == 뒤){
      flag 1 증가;
      if(flag가 3이상)
        continue;
      값 삽입
      index++;      
  }(앞 != 뒤){
     값 삽입
     index++;
     flag 리셋 
}
return index;
```
## ✅ 나의 풀이
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int flag = 1;
        int index = 1;
        for(int i = 1; i < length; i++){
            if(nums[i] == nums[i - 1]){
                flag++;
                if(flag >= 3){
                    continue;
                }
                nums[index] = nums[i];
                index++;
            }else{
                nums[index] = nums[i];
                index++;
                flag = 1;
            }
        }
        return index;
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
        if (nums.length <= 2) { // nums의 길이가 2보다 작다면, 그냥 바로 길이를 리턴
            return nums.length;
        }

        int index = 2; //여기서 부터 배열의 크기는 3부터 시작, 마지막 인덱스는 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) { // 중복의 최대 개수가 2이기 때문에 2칸 씩 비교해서 다른 값이면 삽입, 같은 값이면 중복되는 숫자가 3 이상이 됨.
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
```
---
## 👉 회고
- 제가 작성한 코드는 중복된 코드도 있고, if문이 두 번 들어가는 등 코드가 약간 더러운 느낌이 났지만, 다른 풀이는 훨씬 더 깔끔합니다.
- 중복이 두 번 되는 경우 2칸 씩 비교하여 같으면 3개가 중복이라는 것을 생각하지 못 했습니다. 그래서 일일이 flag를 두어 세려고 한 것 같습니다.
- 변수가 증가할 수록, 그것을 다룰 로직이 추가돼 코드가 복잡해지는 것 같습니다.  
  
