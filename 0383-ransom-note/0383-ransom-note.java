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