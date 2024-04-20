import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ElectionSystem {
    public static void main(String[] args) {
        randomElection();
        orchestratedElection();
    }
    public static void orchestratedElection(){
        Election e = new Election();
        LinkedList<String> candidates= new LinkedList<>(List.of("Kratos", "Winnie the Pooh", "Ezio Auditore", "Omniman", "Rick Grimes", "Tanjiro Kamado"));
        e.initializeCandidates(candidates);
        e.castVote("Kratos");
        e.castVote("Kratos");
        e.castVote("Omniman");
        e.castVote("Tanjiro Kamado");
        e.castVote("Tanjiro Kamado");
        e.castRandomVote();
        e.castRandomVote();
        e.getTopKCandidates(4);
        e.auditElection();
        e.rigElection("Omniman");
        e.auditElection();
    }

    public static void randomElection(){
        Election e = new Election();
        LinkedList<String> firstNames = new LinkedList<>(List.of("John", "Emma", "Olivia", "Ava", "Isabella", "Sophia", "Oren", "Esteban", "Connor", "Austin", "Victoria"));
        LinkedList<String> lastNames = new LinkedList<>(List.of("Doe", "Smith", "Johnson", "Williams", "Jones", "Brown", "Hood", "Cummings", "Ibrahim", "Ismail", "Maloul", "Rogriguez", "Tackett", "Young", "Kagan", "Bentley"));
        LinkedList<String> candidates= new LinkedList<>();
        int amtOfCandidates = ThreadLocalRandom.current().nextInt(1, Math.min(firstNames.size(), lastNames.size()));
        int randFirst, randLast;
        for (int i = 0; i < amtOfCandidates;i++){
            randFirst = ThreadLocalRandom.current().nextInt(0, firstNames.size());
            randLast = ThreadLocalRandom.current().nextInt(0, lastNames.size());
            candidates.add(firstNames.get(randFirst) + " " + lastNames.get(randLast));
            firstNames.remove(randFirst);
            lastNames.remove(randLast);
        }
        e.initializeCandidates(candidates);
        int amtOfVotes = ThreadLocalRandom.current().nextInt(1, 100);
        for (int i = 0; i < amtOfVotes;i++){
            e.castRandomVote();
        }
        e.auditElection();
    }
}
