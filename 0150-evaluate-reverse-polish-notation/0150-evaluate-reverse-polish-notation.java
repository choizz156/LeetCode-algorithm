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
