package com.tiffany;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by runyaosheng on 9/12/16.
 */
public class BFS {
    private Queue<Node> queue = new LinkedList<Node>();
    private Stack<Node> result = new Stack<Node>();
    private int level = 0;
    private Node end = new Node();
    private LinkedList<Node> nodesInQueue = new LinkedList<Node>();
    private Node currentNode = new Node();

    public void runBFS() {
        //add start node into queue
        for(int i = 0; i < Main.numOfSunday; i++) {
            if(Main.startNode.equals(Main.nodes[i].getId())) {
                queue.add(Main.nodes[i]);
                level++;
            }
        }

        //get end node
        for(int i = 0; i < Main.numOfSunday; i++) {
            if(Main.endNode.equals(Main.nodes[i].getId())) {
                end = Main.nodes[i];
            }
        }

        //add nodes into queue
        while(!queue.contains(end)) {
            LinkedList<Node> nList = new LinkedList<Node>();
            nList = Main.graph.get(queue.element());
            for(int i = 0 ; i < nList.size(); i++) {
                Node n = new Node();
                n = nList.get(i);
                n.setParent(queue.element());
                n.setLevel(level);
                queue.add(nList.get(i));
                nodesInQueue.add(n);

            }
            queue.remove();
            level++;

        }

        //get results
        currentNode = end;
        result.push(currentNode);

        while(currentNode.getParent() != null) {
            currentNode = currentNode.getParent();
            result.push(currentNode);
        }



    }

}
