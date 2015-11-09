package com.gpc.jay.campusmapp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Jay on 11/8/2015.
 */
public class Pathing {

    public static Stack<Node> findPathBetween(Node start, Node end){
        Queue<Node> bfsQueue = new LinkedList<Node>();
        Stack<Node> visited = new Stack<Node>();
        Stack<Node> path;
        bfsQueue.add(start);
        visited.push(start);

        Node currNode;
        do{
            currNode = bfsQueue.poll();

            for(Node node:currNode.getConnectingNodes()){
                if(!node.isVisited()) {
                    node.setPrev(currNode);
                    bfsQueue.add(node);
                    visited.push(node);
                    node.visit();
                }

                if(node==end){
                    path = generatePathStack(currNode, true);
                    break;
                }
            }
        }while(!bfsQueue.isEmpty());

        path = generatePathStack(currNode, false);

        Node visitedNode;
        while(!visited.isEmpty()){
            visitedNode = visited.pop();
            visitedNode.clearPrev();
            visitedNode.unvisit();
        }
        return path;
    }

    private static Stack<Node> generatePathStack(Node currNode, boolean pathExists){
        if(pathExists){
            Stack<Node> path = new Stack<Node>();
            Node nextNode = currNode;
            while(nextNode != null){
                path.push(currNode);
                nextNode = nextNode.getPrev();
            }
            return path;
        }
        else {
            return new Stack<Node>();
        }

    }
}
