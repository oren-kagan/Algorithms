import java.util.*;
public class RadixSort {
    public ArrayList<String> radixSort(ArrayList<String> list){
        if (list.size() == 1){
            return list;
        }
        int lastLetter = getMaxChars(list);
        System.out.println("Max Length: " + lastLetter);
        HashMap<Character, ArrayList<String>> map = alphabetInitialize();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() < lastLetter) {
                while (list.get(i).length() < lastLetter) {
                    list.set(i, list.get(i) + ' ');
                }
                System.out.println("Remade String: " + list.get(i));
            }
        }
        for (int i = lastLetter-1; i >= 0; i--){
            list = letterSort(list, i, map);
        }
        for (int j = 0; j < list.size();j++){
            list.set(j, list.get(j).replaceAll("\\s+$", ""));
        }
        return list;
    }
    public ArrayList<String> letterSort(ArrayList<String> list, int size, HashMap<Character, ArrayList<String>> map){
        for(String str: list){
            map.get(str.charAt(size)).add(str);
        }
        list.clear();
        Iterator<String> iter = map.get(' ').iterator();
        for(int i = 0; i < map.get(' ').size(); i++){
            list.add(iter.next());
        }
        map.get(' ').clear();
        for(int c = 65;c <= 90;c++){
            movingCode(list, map, (char) c);
        }
        for(int c = 97;c <= 122;c++){
            movingCode(list, map, (char) c);
        }
        return list;
    }

    private void movingCode(ArrayList<String> list, HashMap<Character, ArrayList<String>> map, char c) {
        Iterator<String> iter;
        if(!map.get(c).isEmpty()) {
            iter = map.get(c).iterator();
            for(int i = 0; i < map.get(c).size(); i++){
                list.add(iter.next());
            }
            map.get(c).clear();
        }
    }

    private int getMaxChars(ArrayList<String> strArr){
        int maxChar = strArr.get(0).length();
        for(String str: strArr)
            if (str.length() > maxChar) {
                maxChar = str.length();
            }
        return maxChar;
    }
    public HashMap<Character, ArrayList<String>> alphabetInitialize(){
        HashMap<Character, ArrayList<String>> map = new HashMap<>();
        map.put(' ', new ArrayList<>());
        char c1 = 'A';
        char c2 = 'a';
        for (int i = 1; i <= 52; i++){
            if (i < 27){
                map.put(c1++, new ArrayList<>());
            } else{
                map.put(c2++, new ArrayList<>());
            }
        }
        return map;
    }

}
