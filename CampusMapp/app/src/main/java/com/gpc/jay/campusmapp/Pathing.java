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
        ArrayList<Queue<Node>> levels = new ArrayList<Queue<Node>>();
        Stack<Node> visited = new Stack<Node>();
        Node currNode = start;
        levels.add(new LinkedList<Node>());

        int currLevel = 0;
        while (!(currNode == end) && !levels.get(levels.size()-1).isEmpty()){

        }


        Stack<Node> path = generatePathStack(currNode, true);
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
