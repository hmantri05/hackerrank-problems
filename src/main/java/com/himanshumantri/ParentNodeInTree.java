package com.himanshumantri;

import java.util.Arrays;
import java.util.Scanner;

public class ParentNodeInTree {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int T = Integer.parseInt(s.nextLine());
		
		for (int t = 0; t < T; t++) {
			int numOfNodes = Integer.parseInt(s.nextLine());
			String nodeVals[] = s.nextLine().split(" ");
			
			int parent[] = new int[numOfNodes];
			Arrays.fill(parent, -1);
			
			for (int e = 0; e < numOfNodes - 1; e++) {
				String edge[] = s.nextLine().split(" ");
				int u = Integer.parseInt(edge[0]);
				int v = Integer.parseInt(edge[1]);
				parent[v-1] = u-1;
			}
			
			int newParent[] = new int[numOfNodes];
			for (int n = 0; n < numOfNodes; n++) {
				newParent[n] = findRightParent(parent, n, nodeVals);
			}
			
			int numOfSubtreeNodes[] = new int[numOfNodes];
			Arrays.fill(numOfSubtreeNodes, 1);
			
			for (int n = 0; n < numOfNodes; n++) {
				if (newParent[n] != -1) {
					numOfSubtreeNodes[newParent[n]]++;
				}
			}
			
			for (int i : numOfSubtreeNodes) {
				System.out.print(i + " ");
			}
		}
		s.close();
	}

	private static int findRightParent(int[] parent, int n, String[] nodeVals) {
		int currParent = parent[n];
		
		while(true) {
			if ((currParent == -1) || (nodeVals[n].equals(nodeVals[currParent]))) {
				return currParent;
			} else {
				currParent = parent[currParent];
			}
		}
	}

}
