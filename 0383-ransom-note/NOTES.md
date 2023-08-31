# [383. Ransom Note](https://leetcode.com/problems/ransom-note/description/)

## 👉 문제 이해
- magazine안에 있는 문자로 ransomNote의 문자를 만들 수 있어야합니다.
## 👉 접근 방식

### 1. hashmap을 사용하여 map에 문자열의 문자(key)와 개수(value)를 넣습니다.
### 2. 만약 magazine문자 안에 ransomNote의 문자가 없거나 문자의 개수가 적은지 확인한다.

## 📌의사코드
```java
if: magazine, ransomNote의 문자가 1개이고 둘이 같지 않다면
-> return false

map1 : ransomNote <- 문자열과 개수 저장
map2 : magazine <- 문자열과 개수 저장

for(map1.keySet()){
  if: map2에 map1의 key가 없거나, map1이 가지고 있는 문자열의 개수가 map2보다 많다면
   -> return false;
}

return true;
```

## ✅ 내가 작성한 코드
```java
class Solution {
    public boolean canConstruct(String note, String maga) {
        if(note.length() + maga.length() == 2 && !note.equals(maga)){
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>(note.length());
        Map<Character, Integer> map2 = new HashMap<>(maga.length());

        for(char c : note.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(char c : maga.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for(char c : map1.keySet()){
            if(map2.get(c) == null){
                return false;
            }
            if(map2.get(c) < map1.get(c)){
                return false;
            }
        }

        return true;
    }   
}

```
---

## ✅ 코드 자체 평가
- map을 2개를 사용하기 때문에 공간 복잡도 측면에서 효율적이지 못할 것 같습니다.
- map에 데이터를 넣기 위해 for 문을 도는 것이 비효율적이라는 생각이 듭니다.

## 👉 시간 복잡도, 공간 복잡도
시간 복잡도: O(n)
공간 복잡도 : O(n)

---

## 📖 다른 풀이
### 아스키코드 이용
- 시간 복잡도: `O(m*n)`
- 공간 복잡도 : `O(1)`
```java
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
          return false;

        int letters[] = new int[26];
        for(int i = 0;i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int index = magazine.indexOf(ch, letters[ch-'a']); // ch가 이전에 사용한 마지막 위치 이후부터 등장하는 첫번째 위치를 찾는다.
            if(index == -1) //존재하니 않는다면
              return false;

              letters[ch-'a'] = index + 1; // 다음에 등장할 경우 이 인덱스 다음부터 탐색한다.
        }
        return true;
    }
}
```
> - 아스키코드와 배열을 활용하여 문제를 해결하는 방법도 있다는 것을 알게 됐습니다.
> - String의 indexOf 메서드 활용 방법을 학습했습니다. 

---

## 👉 회고
- 제가 작성한 코드의 경우 데이터가 증가할 수록 비효율적일 것 같습니다. for문을 계속 돌아야하기 때문입니다.
- 문자를 활용할 경우 아스키코드와 배열을 활용하는 방법을 생각하는 것이 좋을 것 같습니다.
