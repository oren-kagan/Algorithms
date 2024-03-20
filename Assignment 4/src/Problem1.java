import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        System.out.println(subdomainVisits(cpdomains));
        String[] cpdomains2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cpdomains2));
    }
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain: cpdomains){
            String[] info = domain.split("\\s+");
            String[] subDomains = info[1].split("\\.");
            int amount = Integer.parseInt(info[0]);
            String current = "";
            for (int i = subDomains.length - 1; i >= 0; i--){
                current = subDomains[i] + (i < subDomains.length - 1 ? ".": "") + current;
                counts.put(current, counts.getOrDefault(current, 0) + amount);
            }
        }
        List<String> result = new ArrayList<>();
        for (String iter: counts.keySet()){
            result.add(counts.get(iter) + " " + iter);
        }
        return result;
    }

    }