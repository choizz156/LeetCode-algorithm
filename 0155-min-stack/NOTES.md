# [155. Min Stack](https://leetcode.com/problems/min-stack/description/)

## 👉 문제 이해
- 최소값을 가질 수 있는 stack 자료구조를 만듭니다.
- 
## 👉 접근 방식
### 1. LinkedList를 활용합니다.
### 2. LinkedList의 타입으로 최소값을 가지는 객체 타입을 사용합니다.

## ✅ 나의 코드

```java
class MinStack {

    private LinkedList<Value> stack;

    public MinStack() {
       stack = new LinkedList<Value>();
    }
    
    public void push(int val) {
        int min;
        if(stack.size() == 0){
          min = val;
        }else{
          int curMin = stack.getFirst().min;
          min = val < curMin ? val : curMin;
       }
       stack.addFirst(new Value(val, min));
    }
    
    public void pop() {
        stack.removeFirst();
    }
    
    public int top() {
        return stack.peekFirst().val;
    }
    
    public int getMin() {
        return stack.peekFirst().min;
    }

    static class Value {
      int val;
      int min;

      public Value(int val, int min){
        this.val = val;
        this.min = min;
      }
    }
}

```
## 👩🏽‍💻 코드 자체 평가
- 내부 클래스를 만들어 그 클래스에 최소값과 push될 값을 저장할 필드를 만들었습니다.

---

## 📖 다른 풀이
### ArrayList 사용
  
```java
import java.util.ArrayList;

class MinStack {
    ArrayList<Integer> stack; // 기본적인 stack으로 활용
    ArrayList<Integer> minStack; // 최소 스택을 따로 저장

    public MinStack() {
        stack = new ArrayList<Integer>();
        minStack = new ArrayList<Integer>();
    }

    public void push(int val) {
        stack.add(val); //일반 stack값을 넣는다.
        if (minStack.isEmpty() || val <= minStack.get(minStack.size() - 1)) {
            minStack.add(val); //최소 스택에 최소값을 넣는다.
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int poppedValue = stack.remove(stack.size() - 1);
            if (!minStack.isEmpty() && poppedValue == minStack.get(minStack.size() - 1)) {
                minStack.remove(minStack.size() - 1);
            }
        }
    }

    public int top() {
            return stack.get(stack.size() - 1);
    }

    public int getMin() {
            return minStack.get(minStack.size() - 1);
    }
}
```
> - 기본적인 스택과 최소값을 가지는 스택을 필드로 두면 그것을 사용하는 메서드에서 두 가지 필드를 모두 조작하는 로직을 작성해야하는 단점이 있는 것 같습니다.
> - 만약 로직 변경이 있을 경우 관리가 힘들 수도 있을 것 같습니다.

---

## 👉 회고
- Java에서 제공하는 Stack은 Vector로 이루어져 있어 동기화가 되어 성능이 떨어질 가능성이 있습니다.
- 그래서, Java에서도 ArrayDeque를 사용하라고 권장하고 있습니다. thread-safe하지 않아도 되는 상황이라면요!
- 이번 문제의 자료구조를 만들때도, ArrayDeque로 만들 수 있지만, 기본 자료 구조인 LinkedList 학습 차원에서 LinkedList로 작성했습니다.

  ​​
