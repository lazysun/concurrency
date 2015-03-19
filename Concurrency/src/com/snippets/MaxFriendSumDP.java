package com.snippets;

import java.util.ArrayList;
import java.util.List;

public class MaxFriendSumDP {
	
	
	
	int f(Node n) {
		int csum =0; // children Max Friend Sum
		int gsum=0; // grand children MAx FriendSum 
		for(Node node : n.c) {
			csum += f(node);
			for(Node gNode : node.c) {
				gsum += f(gNode);
			}
		}
		return Math.max(n.rank + gsum, csum); 
	}
	
	class Node {
		int rank;
		List<Node> c = new ArrayList<MaxFriendSumDP.Node>(); // children of this node  
	}

}
