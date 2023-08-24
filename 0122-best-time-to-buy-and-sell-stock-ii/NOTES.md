# [122. Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150)
## 👉 문제 이해
- 배열의 두 수의 차이들의 합 중 가장 큰 수를 찾는 로직을 작성해야 합니다.
## 👉 접근 방식

### 1. 배열의 구간 내에 오름차순이 있을 경우, 오름차순의 첫 번째 값과 마지막 값의 차이가 가장 크다.
### 2. 오름차순이 있는 구간을 찾는다.
   - 오름차순이 진행되다가 중단되는 경우, 이전의 숫자들의 차이를 변수에 저장하고, 중단된 숫자부터 다시 오름차순이 진행되는지 확인하는 과정을 거친다.

## 📌 의사 코드
```java
min = 배열의 첫째항;
diff = 차이;
total = 차이들의 합;

for(1,길이,1증가){
  if:diff가 값 - min 보다 크면 (오름 차순 중단)
      -> min에 값을 저장
      -> total에 diff 더함
      -> diff를 0으로 리셋
  else: (오름 차순 진행)
      -> diff에 차이 값 저장
}

return total값에 마지막으로 diff 더해줌.
```
## ✅ 나의 풀이
```java
class Solution {
    public int maxProfit(int[] prices) {
       int len = prices.length;
       int min = prices[0];
       int diff = 0;
       int total = 0;

        for(int i = 1; i < len; i++){
            int tmp = prices[i] - min;
            if(diff > tmp){
                min = prices[i];
                total += diff;
                diff = 0;
            }else{
                diff = tmp;
            }
        } 
       return total + diff;
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(1)`
---
## 📖 더 나은 풀이
### 1. for문을 이용
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(1)`
  
```java
class Solution {
    public int maxProfit(int[] prices) {
       int len = prices.length;
       int min = prices[0];
       int total = 0;

        for(int i = 1; i < len; i++){
            if(prices[i] > min){ //오름차순인 구간에서 오름차순이 끝날 때까지두 수의 차를 더 해주면, 처음과 마지막 값의 차와 동일하다.
                total += prices[i] - min;
                min = prices[i];
            }else{
                min = prices[i];
            }
        }
        return total;
    }
}
```
> 오름차순일 경우, 예를 들어, 1,4,5 => 5-1 == 4-1 + 5-4 가 성립된다는 것을 문제풀 때, 생각을 하지 못했습니다. 
---

## 👉 회고
- 문제에서 나오는 예시를 훨씬 더 주의깊게 생각해야, 효율적으로 문제에 접근할 수 있을 것 같습니다.
- 문제를 접근할 때, 일반화하지 못하고 너무 지엽적으로만 하나하나 생각하는 것 같습니다.
  ​
