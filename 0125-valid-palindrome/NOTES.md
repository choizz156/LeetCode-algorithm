# [125. Valid Palindrome](https://leetcode.com/problems/valid-palindrome/description/)
## 👉 문제 이해
- 문자열을 뒤집어도 처음과 같은 단어가 나오는지 판단하는 알고리즘을 구성해야 합니다.
## 👉 접근 방식
### 1. StringBuilder의 reverse()메서드 사용합니다.
### 2. 정규표현식을 사용해 문자와 숫자가 아닌 것을 없앱니다.

```
## ✅ 나의 코드
```java
class Solution {
    public boolean isPalindrome(String s) {
      
      s = s.toLowerCase();
      s = s.replaceAll("[^a-z0-9]", "");

      StringBuilder sb = new StringBuilder(s);
      String t = sb.reverse().toString();
      System.out.println(t);

      if(t.equals(s)){
          return true;
      }else{
          return false;
      }
    }
}
```

## 👉 시간 복잡도, 공간 복잡도
- 시간 복잡도: `O(n)`
- 공간 복잡도 : `O(n)`

## 👩🏽‍💻 코드 자체 평가
- toLowerCase()를 사용하면 문자열 전체를 순회하게 됩니다.
- replaceAll로 정규표현식을 사용하면, 컴파일하는데 시간이 오래걸릴 수 있습니다.

---

## 📖 다른 풀이
### 1. two pointer
- 시간 복잡도: `O(n)` 
- 공간 복잡도: `O(n)`
  
```java
class Solution {
    public boolean isPalindrome(String s) {
        
        int start = 0;
        int last = s.length() - 1;

        while(start <= last){
            char cf = s.charAt(start);
            char cl = s.charAt(last);

            if(!Character.isLetterOrDigit(cf)){
                start++; // 만약 없다면, 숫자나 문자가 아니라면, 포인터를 로 옮긴다.
            }else if(!Character.isLetterOrDigit(cl)){
                last--; // 만약 없다면, 숫자나 문자가 아니라면, 포인터를 앞으로 옮긴다.
            }else{
                // 만약 숫자나 문자라면
                if(Character.toLowerCase(cf) != Character.toLowerCase(cl)){
                    return false;
                }
                // 양쪽에서 앞뒤로 옮긴다.
                start++;
                last--;
            }
        }
        //순회를 완료하면 true 리턴
        return true;
    } 
}
```
> - Character.isLetterOrDigit() 메서드를 학습했습니다.
> - two pointer에 적용에 학습할 수 있었습니다.
---

## 👉 회고
- two pointer를 활용하면, 문자열을 전부 순회하지 않고 false를 리턴할 수 있기 때문에 제가 작성한 코드보다 조금 더 빠른 처리 속도가 나올 수 있습니다.
  ​​
