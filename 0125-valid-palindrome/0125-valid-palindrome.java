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