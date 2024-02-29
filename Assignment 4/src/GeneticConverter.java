import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.System.*;

public class GeneticConverter {
    public static void main(String[] args){
        String s1 = "AGCTGGGAAACGTAGGCCTA";
        String s2 = "TAAAGAGAAGCCAGC";
        String s3 = "ACTCGTATTCCTTAAATGGAGTT";
        out.println("GeneticConverter.java");
        out.println("Sample Input: " + s1 + " What are the equivalent proteins? " + RNAtoProtein(DNAtoRNA(s1)));
        out.println("Sample Input: " + s2 + " What are the equivalent proteins? " + RNAtoProtein(DNAtoRNA(s2)));
        out.println("Sample Input: " + s3 + " What are the equivalent proteins? " + RNAtoProtein(DNAtoRNA(s3)));
    }
    private static String DNAtoRNA(String DNA){
        String RNA = "";
        char temp = '\0';
        for (int i = 0; i < DNA.length(); i++){
            temp = DNA.charAt(i);
            if (temp == 'A' || temp== 'C' || temp == 'G'){
                RNA += temp;
            } else {
                RNA += 'U';
            }
        }
        return RNA;
    }
    private static String RNAtoProtein(String RNA){
        StringBuilder proteins = new StringBuilder();
        Queue<Character> q = new LinkedList<Character>();
        for(int i = 0; i < RNA.length(); i++){
            q.add(RNA.charAt(i));
        }
        StringBuilder codon = new StringBuilder();
        while(!q.isEmpty()){
            codon.append(q.remove());
            if (codon.length() == 3){
                proteins.append(proteinGenerator(codon.toString()));
                codon.delete(0, 3);
            }
        }
        if (codon.length() < 3 && !codon.isEmpty()){
            proteins.append('.');
        }
        return proteins.toString();
    }
    private static Character proteinGenerator(String codon){
        return switch (codon) {
            case "UUU", "UUC" -> 'F';
            case "UUA", "UUG", "CUU", "CUC", "CUA", "CUG" -> 'L';
            case "UCU", "UCC", "UCA", "UCG", "AGU", "AGC" -> 'S';
            case "UAU", "UAC" -> 'Y';
            case "UAA", "UAG", "UGA" -> '.';
            case "UGU", "UGC" -> 'C';
            case "UGG" -> 'W';
            case "CCU", "CCC", "CCA", "CCG" -> 'P';
            case "CAU", "CAC" -> 'H';
            case "CAA", "CAG" -> 'Q';
            case "CGU", "CGC", "CGA", "CGG", "AGA", "AGG" -> 'R';
            case "AUU", "AUC", "AUA" -> 'I';
            case "AUG" -> 'M';
            case "ACU", "ACC", "ACA", "ACG" -> 'T';
            case "AAU", "AAC" -> 'N';
            case "AAA", "AAG" -> 'K';
            case "GUU", "GUC", "GUA", "GUG" -> 'V';
            case "GCU", "GCC", "GCA", "GCG" -> 'A';
            case "GAU", "GAC" -> 'D';
            case "GAA", "GAG" -> 'E';
            case "GGU", "GGC", "GGA", "GGG" -> 'G';
            default -> throw new IllegalStateException("Unexpected value: " + codon);
        };
    }
}
