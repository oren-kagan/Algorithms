/**
 * Oren Kagan
 * orenkagan@brandeis.edu
 * PA3
 */

package main;
/**
 * The object that holds the key and its respective value
 * @author orenk
 *
 */
public class Entry {

	private GraphNode key;
	private int value;
	/**
	 * Generic constructor
	 * @param k is the key
	 * @param v is the value
	 * Runtime is O(1)
	 */
	public Entry(GraphNode k, int v){
		key = k;
		value = v;
	}
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public GraphNode getKey() {
		return key;
	}
	

}
