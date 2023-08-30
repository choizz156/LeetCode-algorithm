# [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

## 👉 문제 이해
- 배열의 값을 사칙 연산을 해야합니다.
    
## 👉 접근 방식
### 1. ArrayDeque를 사용합니다.
### 2. 연산 값을 다시 stack에 넣고 재사용합니다.

## 📌 의사 코드
```java

for(문자열){
  if: 사칙연산자 라면
   -> stack에서 2개를 뽑는다.
   -> 사칙연산에 따라 계산을 한다.
   -> stack에 다시 넣는다.
  else: 숫자리면,
   -> stack에 넣는다.
}

return stack의 마지막 값 리턴
```
## ✅ 나의 코드

```java
class Solution {
    static Deque<Integer> stack = new ArrayDeque<>();
    static int ret;

    public int evalRPN(String[] tokens) {
       for(String s : tokens){
             if(s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")){
                  int b = stack.pollLast();
                   int f = stack.pollLast();

               if(s.equals("+")){
                    ret = f + b;
               }else if(s.equals("-")){
                    ret = f - b;
               }else if(s.equals("*")){
                    ret = f * b;
               }else if(s.equals("/")){
                    ret = f / b;
               }

               stack.addLast(ret);
                
            } else {
               stack.addLast(Integer.parseInt(s));
            }
          }
          
          return stack.getLast();
    }
}

```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(n)`

---

## 📖 다른 풀이
### 재귀 함수 활용
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(n)`
  
```java
class Solution {

    int pointer;

    public int evalRPN(String[] tokens) {
        if (tokens == null) return 0;
        if (tokens.length == 1) return Integer.parseInt(tokens[0]);
        pointer = tokens.length - 1;
        return dfs(tokens);
    }

    public int dfs(String[] tokens){
        String s = tokens[pointer--]; // 맨 마지막 인덱스부터 인덱스를 왼쪽으로 이동한다.
        if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) // base case를 둔다. 
            return Integer.parseInt(s);

        int right = dfs(tokens); //재귀함수를 실행한다.
        int left = dfs(tokens);

        int result = 0;
        if (s.equals("+")) return left + right;
        else if (s.equals("-")) return left - right;
        else if (s.equals("*")) return left * right;
        else if (s.equals("/")) return left / right;

        return result; //결과를 출력한다.
    }
}

```
> 재귀를 이용해서 푸는 방법은 지금 적용하기는 좀 어려울 것 같다는 생각이 듭니다. 다음에 재귀학습을 한 후 다시 한 번 생각해야봐야 할 것 같습니다.
---

## 👉 회고
- 배열에서 연달아 있는 요소에 대한 로직이 필요할 경우 stack을 사용하는 것이 효율적이라는 생각을 하게 됐습니다.
  ​​
