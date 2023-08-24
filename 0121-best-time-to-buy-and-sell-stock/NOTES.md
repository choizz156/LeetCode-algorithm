# [121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/)
## 👉 문제 이해
- 두개의 숫자를 골라 차이의 최대값을 구하는 로직을 작성해야합니다. 해당 인덱스의 값보다 큰 인덱스 값과의 차이를 구해야합니다.
## 👉 접근 방식
### 1. 첫 번째 시도
#### 1.1 `조합`으로 인식 -> 2개를 뽑는다.
#### 1.2 2개의 차이를 저장하고 비교한다. 
```java
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int ret = 0;

        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if(prices[i] < prices[j] && ret < prices[j] - prices[i] ){
                    ret = prices[j] - prices[i];
                }         
            }
        }
        
        return ret;
    }
}
```
#### `첫 번째 시도 결과`
![image](https://github.com/choizz156/LeetCode-algorithm/assets/106965005/e6a5bb0f-7f22-4a0a-ac5e-764aac2b9f39)
- 시간 복잡도가 O(N^2)이 되어 시간초과가 됐습니다.
---
### 2. 두 번째 시도
#### 2.1 맨 처음의 값이 최소값이라고 가정하고, 변수에 저장한다.
#### 2.2 최대 profit과 최소값을 연산하여 변수에 저장한다.

```java
class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0]; //최솟값으로 둔다.
        int diff = 0; //이익의 최솟값

        for(int i = 0; i < prices.length ; i++){
            diff = Math.max(diff, prices[i] - min); //앞에 있는게 크면 음수가 나옴.  -> 최대 profit을 구한다.
            min = Math.min(prices[i], min); // min 값을 저장하고 비교 -> 최소값 교체
        }

        return diff;
    }
}
```
#### `두 번째 시도 결과`
![image](https://github.com/choizz156/LeetCode-algorithm/assets/106965005/91a25240-7f9b-4b28-9d24-0f6b155dfd8b)

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`
---
## 📖 다른 풀이
### 1. Math 클래스를 쓰지 않고 직접 비교
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`
```java
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int min = 100003;
        int ret = 0;
        int diff = 0;

        for(int i = 0; i < len; i++){
            if(prices[i] < min){
                min = prices[i];
            }

            diff = prices[i] - min;

            if(ret < diff){
                ret = diff;
            }
        }
        return ret;
    }
}
```
> 접근 방법은 저의 풀이와 비슷하고 표현이 다른 듯 합니다. 
---
## 👉 회고
- 처음에 조합으로 인식했을 때, 시간 초과가 걸려는데도 불구하고, 다른 접근방식을 생각하는데 너무 오랜 시간이 걸렸습니다.
- 시간 복잡도를 O(n)으로 할 수 있는 방법부터 우선적으로 생각해 봐야 할 것 같습니다.
  ​
