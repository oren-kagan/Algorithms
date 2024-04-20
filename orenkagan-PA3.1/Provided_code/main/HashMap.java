/**
 * Oren Kagan
 * orenkagan@brandeis.edu
 * PA3
 */
package main;

/**
 * 
 * @author orenk An object HashMap that uses entries made of GraphNode keys, and
 *         integer values reflecting their priority in the Heap.
 */
public class HashMap {

	private static final int OGNumBuckets = 10000;
	public int updatedBuckets;
	public Entry bucketArray[];
	private int size;

	/**
	 * Constructs a HashMap with a default size of 10,000
	 * Runtime is O(1)
	 */
	public HashMap() {
		bucketArray = new Entry[OGNumBuckets];
		size = 0;
		updatedBuckets = OGNumBuckets;
	}

	/**
	 * Getter for the amount of entries in the array
	 * Runtime is O(1)
	 * @return the variable "size"
	 */
	public int getSize() {
		return size;
	}

	/**
	 * returns whether or not the HashMap is empty
	 * Runtime is O(1)
	 * @return getSize() == 0
	 */
	public boolean isEmpty() {
		return getSize() == 0;
	}

	/**
	 * Sets the value representing the index in the MPQ to the key specified
	 * Runtime is O(1)
	 * @param key,   the Key being looked for
	 * @param value, the new value of the key
	 */
	public void set(GraphNode key, int value) {
		if (key != null) {
			int s = search(key);
			if (s < 0) {
				Entry e = new Entry(key, value);
				insert(e);
			} else {
				bucketArray[s].setValue(value);
			}
		} else {
			System.out.println("Key is null. Not inserted.");
		}
	}

	/**
	 * Inserts an entry into the HashMap, and uses Quadratic Probing to find a null
	 * index to insert into.
	 * Runtime is O(1)
	 * @param e, the entry being inserted
	 */
	public void insert(Entry e) {
		if (e != null) {
			int originalHashNum = hash(e.getKey());
			int newHash = originalHashNum;
			int i = 0;
			boolean ins = false;

			while (!ins) {
				if (bucketArray[newHash] == null) {
					bucketArray[newHash] = e;
					ins = true;
					size++;
				} else {
					newHash = (int) ((originalHashNum + Math.pow(i, 2)) % updatedBuckets);
					i++;
				}
			}
		}
	}

	/**
	 * Rehashes the HashMap into an array with twice the size.
	 * Runtime is O(n)
	 */
	public void rehash() {
		updatedBuckets *= 2;
		size = 0;
		Entry newBucketArray[] = new Entry[updatedBuckets];
		Entry oldBucketArray[] = bucketArray;
		bucketArray = newBucketArray;
		for (int i = 0; i < oldBucketArray.length; i++) {
			insert(oldBucketArray[i]);
		}
	}

	/**
	 * a method that searches for the GraphNode in the map, and then returns -1 if
	 * the node doesn't exist, or the value if it is more than 0.
	 * Runtime is O(1)
	 * @param g is the key of the HashMap being looked for
	 * @return -1 or the value of the node
	 */
	public int getValue(GraphNode g) {

		int i = search(g);
		if (i < 0) {
			return -1;
		}
		return bucketArray[i].getValue();
	}
	/**
	 * Mimics the insertion method to look for keys in the map. Returns -1 if not there and the hashcode if it is.
	 * @param g, the key being looked for
	 * @return the index of the key in the map or -1 if not found.
	 * Runtime is O(1)
	 */
	public int search(GraphNode g) {
		int x = 0;
		int hashC = hash(g);
		int upHashC = hashC;
		for (int i = 0; i < updatedBuckets; i++) {
			if (bucketArray[upHashC] == null) {
				return -1;
			} else if (g.equals(bucketArray[upHashC].getKey())) {
				return upHashC;
			} else {
				upHashC = (int) ((hashC + Math.pow(x, 2)) % updatedBuckets);
				x++;
			}
		}
		return -1;
	}

	/**
	 * Creates and returns a new Entry with the same key and value as the node.
	 * @param g, the key connected to the entry
	 * @return an entry with their values
	 * Runtime is O(1)
	 */
	public Entry getEntry(GraphNode g) {
		return new Entry(g, getValue(g));
	}
	/**
	 * The method that takes the entire UUID, sums up each character, then mods it by the size of the bucketArray.
	 * @param key the key with the respective hash code being generated
	 * @return the new hash function, between 0 and the size
	 * Runtime is O(1)
	 */
	public int hash(GraphNode key) {
		String UUID = key.getId();
		int hash = 0;
		for (int i = 0; i < 36; i++) {
			hash += (int) (UUID.charAt(i));
		}
		hash = hash % updatedBuckets;
		return hash;
	}
	/**
	 * A method that looks for the index of the node and returns -1 if it doesn't touch
	 * @param g, the node being looked for
	 * @return the index in the map or -1 if it doesn't exist
	 */
	public int searchIndex(GraphNode g) {
		int i = search(g);
		if (i > -1) {
			return bucketArray[i].getValue();
		}
		return -1;
	}
	/**
	 * Method that "deletes" the node from the hashmap. Just gives it a value of -2.
	 * @param g is the node being removed from the heap
	 * Runtime is O(1)
	 */
	public void delete(GraphNode g) {
		int i = search(g);
		if (i >= 0) {
			bucketArray[i].setValue(-2);
		}
	}
	/**
	 * Check to see if the map contains a key that is the same as g
	 * @param g the GraphNode being located
	 * @return a boolean corresponding to whether the key exists in the map
	 * Runtime is O(1)
	 */
	public boolean containsKey(GraphNode g) {
		int i = search(g);
		if (i < 0) {
			return false;
		}
		return true;

	}
}
