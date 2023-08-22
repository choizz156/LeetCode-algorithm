# [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/description/)
## 👉 문제 이해
- 2개의 숫자 배열을 합친 후 오름차순 정렬을 진행하는 문제라고 이해했습니다.
## 👉 접근 방식

### 1.배열을 합친다.
   - System.arraycopy()메서드를 활용하여 배열을 합쳤습니다.
### 2. 오름차순 정렬한다.
   - Arrays.sort()를 이용해 오름차순 정렬했습니다.

## 📌 의사 코드
```java
if(n == 0){
  nums1을 바로 출력;
}

if(m == 0){
  nums2를 nums1에 복사 후 출력
}

for(0,nums1의 길이,1증가){
  => nums1이 0인 인덱스를 찾는다.
}

System.arraycopy(인덱스부터 nums1에 nums2 삽입);
Arrays.sort()로 정렬
//출력
```
## ✅ 풀이
```java
class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
       Arrays.sort(nums1); // [1,0,0,3,3,0] 이러한 경우에 오름차순을 해야됨.
    

       if(n == 0){
           System.out.println(Arrays.toString(nums1));
           return;
       }

       if(m == 0){
           System.arraycopy(nums2, 0, nums1, 0, n);
           System.out.println(Arrays.toString(nums1));
           return;
       }

       int length = m + n; 
       int index = 0;
       for(int i = 0; i < length; i++){
           if(nums1[i] == 0){
               index = i;
               break;
           }
       }
       
       System.arraycopy(nums2, 0, nums1, index, n);
    
       Arrays.sort(nums1);// (2)
       System.out.println(Arrays.toString(nums1));
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(m * log(m) + (m + n) * log(m + n))`
  - Arrays.sort는 Dual-Pivot Quicksort 알고리즘을 사용하기 때문에 O(n*logn)
  - 마지막 정렬(2)은 Arrays.sort에 nums2의 요소가 추가되므로  O((m + n) * log(m + n))
- 공간 복잡도 : `O(1)`
  - nums1 공간에서 연산이 수행합니다.
 
---
## 📖 더 나은 풀이
### 1. for문을 이용
- 시간 복잡도: `O((m+n)log(m+n))` <- Arrays.sort 사용
- 공간 복잡도: `O(1)`
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int j = 0, i = m; j < n; j++) { //j와 i를 동시에 증가시키면서 nums1 배열에 추가합니다. nums의 m번째 부터 삽입합니다.
            nums1[i] = nums2[j]; 
            i++;
        }
        Arrays.sort(nums1); //마지막에 정렬을 합니다.
    }
}
```
> for문을 변수 하나로만 사용해 와서 위의 코드처럼 생각도 못했습니다.

### 2. two pointer
- 시간 복잡도: `O(m+n)`  <- 반복문 활용
- 공간 복잡도: `O(1)`
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // nums1에서 마지막 인덱스
        int j = n - 1; // nums2에서 마지막 인덱스
        int k = m + n - 1; // 전체 배열의 마지막 인덱스

        //n = 0일 경우, 바로 nums1을 출력하면 된다.
        while (j >= 0) {
            //오름차순이 되어있기 때문에 마지막 인덱스 부터 비교를 한다.
            // nums1과 nums2를 비교하여 nums1이 크면 전체 배열의 마지막 부분에 삽입한다.
            // i,j,k들을 감소 시켜 큰 수에서 작은 수로 이동한다.
            if (i >= 0 && nums1[i] > nums2[j]) { 
                nums1[k--] = nums1[i--];
            } else {
                // m = 0일 경우, i는 음수가 올 수 있다. -> nums2를 nums1으로 합친 후 출력한다.
                nums1[k--] = nums2[j--];
            }
        }
    }
}
```
> - two pointer의 활용하는 방법을 배울 수 있었습니다.
> - 이미 오름차순 정렬된 배열들과의 비교라는 것을 이용하는 방법을 생각해야 함을 배웠습니다.
---
## 👉 회고
- 문제를 풀 때, 시간 복잡도를 고려해서 풀려고 생각하지 않았는데, 시간 복잡도를 고려하면서 로직을 짜야할 것 같습니다.
- for문의 활용법을 배울 수 있었습니다. for문에 인자 2개를 활용하는 것은 고려하지 못했었습니다.
- 반례를 잘 생각하지 못해, 틀리는 경우가 많이 생겼습니다. 반례를 어떻게 하면 잘 생각할 수 있을지 고민해야 할 것 같습니다.
  
