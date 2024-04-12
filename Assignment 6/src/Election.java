import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Election {
    private int totalVotes;
    private MaxHeap maxHeap;
    private LinkedList<String> candidateNames;
    public Election() {
        totalVotes = 0;
        this.candidateNames = new LinkedList<>();
    }

    public void initializeCandidates(LinkedList<String> candidates){
        candidateNames = candidates;
        maxHeap = new MaxHeap(candidateNames.size());
        for(String candidate: candidates){
            maxHeap.insert(new ElectionCandidate(0, candidate));
        }
    }

    public boolean castVote (String candidate){
        int ind = maxHeap.findIndex(candidate);
        if (ind < 0) return false;
        maxHeap.addVote(ind, 1);
        totalVotes++;
        return true;
    }

    public void castRandomVote(){
        int random = ThreadLocalRandom.current().nextInt(0, maxHeap.getSize());
        maxHeap.addVote(random, 1);
        totalVotes++;
    }
    public void rigElection(String candidate){
        if(maxHeap.findCandidate(candidate).equals(maxHeap.viewMax())) return;
        int votesHad = maxHeap.findCandidate(candidate).getVotes();
        int votesNeeded = maxHeap.viewMax().getVotes();
        int change = (votesNeeded+1) < totalVotes ? (votesNeeded-votesHad+1): totalVotes-votesHad;
        maxHeap.addVote((maxHeap.findIndex(candidate)),change);
        int temp = 0;
        while (maxHeap.getTotalVotes() > totalVotes){
            temp = temp == maxHeap.getSize() -1 ? 1 : temp + 1;
            maxHeap.removeVote(temp, 1);
        }
    }
    public void getTopKCandidates(int k){
        System.out.println("The top " + k + " candidates of the race thus far!");
        int i = 0;
        int j = 0;
        while (i < k){
            if (j == maxHeap.getSize()) i = k;
            if (maxHeap.getCandidate(j).getVotes() != 0){
                System.out.print(maxHeap.getCandidate(j).getName() + (i++ == k-1 ?"":", "));
            }
            j++;
        }
        System.out.print("\n");
    }
    public void auditElection(){
        MaxHeap tmpMax = maxHeap;
        if (tmpMax != null) {
            System.out.println("Votes for everyone in the race thus far!");
            for (int i = 0; i < tmpMax.getSize(); i++) {
                System.out.println(tmpMax.extractMax().toString());
            }
        }
    }
}
