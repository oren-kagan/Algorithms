public class ElectionCandidate implements Comparable<ElectionCandidate> {
    private int votes;
    private String name;

    public ElectionCandidate(int votes, String name){
        this.votes = votes;
        this.name = name;
    }

    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes){this.votes = votes;}

    public void addVote() {
        this.votes += 1;
    }
    public void removeVote() {
        if (this.votes > 0) this.votes -= 1;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return name + " - " + votes;
    }

    @Override
    public int compareTo(ElectionCandidate o) {
        return Integer.compare(this.votes, o.votes);
    }
}
