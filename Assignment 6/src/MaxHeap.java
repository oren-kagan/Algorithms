public class MaxHeap {
    private ElectionCandidate[] Heap;
    private int size;
    private int maxsize;
    public MaxHeap(int maxsize){
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new ElectionCandidate[this.maxsize];
    }
    public ElectionCandidate getCandidate(int pos){
        return Heap[pos];
    }

    public int getSize(){
        return size;
    }
    public void addVote(int pos, int amt){
        for (int i = 0; i < amt; i++) Heap[pos].addVote();
        buildHeap();
    }
    public int getTotalVotes(){
        int total = 0;
        for(ElectionCandidate ec: Heap){
            total += ec.getVotes();
        }
        return total;
    }
    public void removeVote(int pos, int amt){
        for (int i = 0; i < amt && Heap[pos].getVotes() > -1; i++) Heap[pos].removeVote();
        buildHeap();
    }
    public ElectionCandidate findCandidate(String name){
        for(int i = 0; i < getSize();i++) {
            if (Heap[i].getName().equals(name)) return Heap[i];
        }
        return null;
    }
    public int findIndex(String name){
        for(int i = 0; i < getSize();i++) {
            if (Heap[i].getName().equals(name)) return i;
        }
        return -1;
    }
    private int parent(int pos){ return (pos-1)/2; }
    private int leftChild(int pos){ return (2 * pos) + 1; }
    private int rightChild(int pos){ return (2 * pos) + 2; }
    private boolean isLeaf(int pos){
        return pos > (size / 2) && pos <= size;
    }
    private void swap(int first, int second) {
        ElectionCandidate tmp;
        tmp = Heap[first];
        Heap[first] = Heap[second];
        Heap[second] = tmp;
    }
    private void buildHeap(){
        int startIndex = (Heap.length/2)-1;
        for (int i = startIndex; i >= 0; i--){
            maxHeapify(i);
        }
    }

    private void maxHeapify(int pos) {
        int maxVal = pos;
        int l = leftChild(pos);
        int r = rightChild(pos);
        if (l < Heap.length && Heap[l].compareTo(Heap[maxVal]) > 0) {
            maxVal = l;
        }
        if (r < Heap.length && Heap[r].compareTo(Heap[maxVal]) > 0) {
            maxVal = r;
        }
        if (maxVal != pos) {
            swap(pos, maxVal);
            maxHeapify(maxVal);
        }
    }

    public void insert(ElectionCandidate element){
        Heap[size] = element;
        int current = size;
        while (Heap[current].compareTo(Heap[parent(current)]) > 0){
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }
    public ElectionCandidate viewMax(){
        return Heap[0];
    }
    public ElectionCandidate extractMax(){
        ElectionCandidate popped = Heap[0];
        Heap[0] = Heap[--size];
        maxHeapify(0);
        return popped;
    }
}
