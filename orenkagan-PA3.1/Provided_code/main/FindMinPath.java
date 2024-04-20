/**
 * Oren Kagan
 * orenkagan@brandeis.edu
 * PA3
 */

package main;

import java.io.*;

public class FindMinPath {

	private static GraphNode start;
	private static GraphNode end = null;

	/**
	 * Method that runs Dijkstra's algorithm to locate the shortest route to a end
	 * point from a specified starting point. Then prints that out to a text file
	 * detailing the path. The runtime is O(E) where E is the number of edges we
	 * have.
	 * 
	 * @param args
	 * @throws FileNotFoundException if file is not found.
	 */
	public static void main(String args[]) throws FileNotFoundException {
		PrintStream output = new PrintStream(new File("answer.txt"));
		GraphWrapper gWrapper = new GraphWrapper(false);
		MinPriorityQueue Q = new MinPriorityQueue();
		start = gWrapper.getHome();
		start.priority = 0;
		Q.insert(start);
		boolean endFound = false;
		while (!Q.isEmpty() || !endFound) {
			GraphNode curr = Q.pullHighestPriorityElement();
			if (curr.isGoalNode()) {
				end = curr;
				endFound = true;
			} else {
				if (curr.hasNorth()) {
					GraphNode neighbor = curr.getNorth();
					int x = curr.priority + curr.getNorthWeight();
					if (!Q.contains(neighbor)) {
						if (Q.getValue(neighbor) == -2) {
							if (x < neighbor.priority) {
								neighbor.priority = x;
								neighbor.previousNode = curr;
								neighbor.previousDirection = "North";
								Q.insert(neighbor);
							}
						} else {
							neighbor.priority = x;
							neighbor.previousNode = curr;
							neighbor.previousDirection = "North";
							Q.insert(neighbor);
						}
					} else if (Q.contains(neighbor) && x < neighbor.priority) {
						neighbor.priority = x;
						Q.decreaseKey(neighbor, x);
						neighbor.previousNode = curr;
						neighbor.previousDirection = "North";
					}
				}
				if (curr.hasEast()) {

					GraphNode neighbor = curr.getEast();
					int x = curr.priority + curr.getEastWeight();
					if (!Q.contains(neighbor)) {
						if (Q.getValue(neighbor) == -2) {
							if (x < neighbor.priority) {
								neighbor.priority = x;
								neighbor.previousNode = curr;
								neighbor.previousDirection = "East";
								Q.insert(neighbor);
							}
						} else {
							neighbor.priority = x;
							neighbor.previousNode = curr;
							neighbor.previousDirection = "East";
							Q.insert(neighbor);
						}
					} else if (Q.contains(neighbor) && x < neighbor.priority) {
						neighbor.priority = x;
						Q.decreaseKey(neighbor, x);
						neighbor.previousNode = curr;
						neighbor.previousDirection = "East";
					}
				}
				if (curr.hasSouth()) {

					GraphNode neighbor = curr.getSouth();
					int x = curr.priority + curr.getSouthWeight();
					if (!Q.contains(neighbor)) {
						if (Q.getValue(neighbor) == -2) {
							if (x < neighbor.priority) {
								neighbor.priority = x;
								neighbor.previousNode = curr;
								neighbor.previousDirection = "South";
								Q.insert(neighbor);
							}
						} else {
							neighbor.priority = x;
							neighbor.previousNode = curr;
							neighbor.previousDirection = "South";
							Q.insert(neighbor);
						}
					} else if (Q.contains(neighbor) && x < neighbor.priority) {
						neighbor.priority = x;
						Q.decreaseKey(neighbor, x);
						neighbor.previousNode = curr;
						neighbor.previousDirection = "South";
					}
				}
				if (curr.hasWest()) {

					GraphNode neighbor = curr.getWest();
					int x = curr.priority + curr.getWestWeight();
					if (!Q.contains(neighbor)) {
						if (Q.getValue(neighbor) == -2) {
							if (x < neighbor.priority) {
								neighbor.priority = x;
								neighbor.previousNode = curr;
								neighbor.previousDirection = "West";
								Q.insert(neighbor);
							}
						} else {
							neighbor.priority = x;
							neighbor.previousNode = curr;
							neighbor.previousDirection = "West";
							Q.insert(neighbor);
						}
					} else if (Q.contains(neighbor) && x < neighbor.priority) {
						neighbor.priority = x;
						Q.decreaseKey(neighbor, x);
						neighbor.previousNode = curr;
						neighbor.previousDirection = "West";
					}
				}
			}

		}
		if (!endFound) {
			output.print("There is no path from start to the end.");
		} else {
			GraphNode curr = end;
			while (curr.previousNode != null) {
				output.println(curr.previousDirection);
				System.out.println(curr.previousDirection);
				curr = curr.previousNode;
			}
		}
	}

}
