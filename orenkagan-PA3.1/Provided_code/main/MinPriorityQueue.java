/**
 * Oren Kagan
 * orenkagan@brandeis.edu
 * PA3
 */

package main;

public class MinPriorityQueue {

	private GraphNode heap[];
	private int totalSize;
	private int size;
	private HashMap hashMap;
	
	/**
	 * Constructor for an empty min-Priority Queue with a size of 10,000
	 * Runtime is O(1)
	 */
	public MinPriorityQueue() {
		heap = new GraphNode[10000];
		setSize(0);
		hashMap = new HashMap();
	}
	/**
	 * Returns the index of the left child of the specified index.
	 * @param i, the current index
	 * @return the left child's index
	 * Runtime is O(1)
	 */
	private int leftChild(int i) {
		return (i * 2) + 1;
	}
	/**
	 * 
	 * @param i
	 * @return
	 * Runtime is O(1)
	 */
	private int rightChild(int i) {
		return (i * 2) + 2;
	}
	/**
	 * Returns the index of the parent of the specified index
	 * @param i, current index
	 * @return the parent's index
	 * Runtime is O(1)
	 */
	private int parent(int i) {
		return (i - 1) / 2;
	}
	/**
	 * Inserts the GraphNode g into the priority Queue
	 * @param g is the GraphNode being inserted
	 * Runtime is O(logn) due to the heapify
	 */
	public void insert(GraphNode g) {
		if ((double) (totalSize / heap.length) >= 0.5) {
			GraphNode temp[] = heap.clone();
			heap = new GraphNode[temp.length * 2];
			for (int i = 0; i < temp.length; i++) {
				heap[i] = temp[i];
			}
			hashMap.rehash();
		}
		if (!contains(g)) {
			heap[size] = g;
			hashMap.set(g, getSize()); // DIFFERENCE
			rebalance(g);
			size++;
			totalSize++;
		}

	}
	/**
	 * 
	 * @param g
	 * @param k
	 * Runtime is O(1)
	 */
	public void decreaseKey(GraphNode g, int k) {
		if (k < g.priority) {
			g.priority = k;
			rebalance(g);
		}
	}
	/**
	 * 
	 * @return the entry with the lowest priority, or the root
	 * Runtime is O(logn)
	 */
	public GraphNode pullHighestPriorityElement() {
		if (!isEmpty()) {
			GraphNode temp = heap[0];
			hashMap.delete(temp);
			if (size != 1) {
				heap[0] = heap[size - 1];
				hashMap.set(heap[0], 0);
				heapify(heap[0]);
			} else {
				heap[0] = null;
			}
			size--;
			return temp;
		}
		throw new IndexOutOfBoundsException("Queue is empty.");
	}

	public void rebalance(GraphNode g) {
		heapify(g);
	}
	/**
	 * 
	 * @param g
	 * Runtime is O(logn)
	 */
	public void heapify(GraphNode g) {
		heapifyUp(g);
		heapifyDown(g);
	}

	private void heapifyUp(GraphNode g) {
		int i = hashMap.getValue(g);
		while (i > 0 && heap[i].priority < heap[parent(i)].priority) {
			heapSwap(i, parent(i));
			hashMap.set(heap[i], i);
			hashMap.set(heap[parent(i)], parent(i));
			i = parent(i);
		}
	}

	public boolean contains(GraphNode g) {
		if (hashMap.containsKey(g)) {
			int y = hashMap.getValue(g);
			if ((y > 0 || y == -2) && y <= (size - 1)) {
				return true;
			}
		}
		return false;
	}

	private void heapifyDown(GraphNode g) {
		int i = hashMap.getValue(g);
		if (i >= 0) {
			int left = leftChild(i);
			int right = rightChild(i);
			int smallest = i;
			if (left < getSize() && heap[left].priority < heap[i].priority) {
				smallest = left;
			}
			if (right < getSize() && heap[right].priority < heap[smallest].priority) {
				smallest = right;
			}
			if (smallest != i) {
				heapSwap(i, smallest);
				hashMap.set(g, i);
				hashMap.set(heap[smallest], smallest);
				heapifyDown(heap[smallest]);
			}
		}
	}

	public void heapSwap(int x, int y) {
		GraphNode temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;

	}

	public int getIndex(GraphNode g) {
		return hashMap.search(g);
	}

	public int getValue(GraphNode g) {
		return hashMap.getValue(g);

	}

	public boolean isEmpty() {
		return this.getSize() < 1;
	}

	public GraphNode[] getHeap() {
		return heap;
	}

	public int getTSize() {
		return totalSize;
	}

	public void setTSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
