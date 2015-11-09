package com.gpc.jay.campusmapp;

import android.graphics.Point;

/**
 * Created by Jay on 11/8/2015.
 */
public class Node {

    private String label;
    private Point position;
    private Node[] connectingNodes;
    private boolean visited;
    private Node prev;

    public Node(String label, Point position, Node[] connectingNodes){
        this.label = label;
        this.position = position;
        this.connectingNodes = connectingNodes;
        this.visited = false;
        this.prev = null;
    }

    public String getLabel(){
        return this.label;
    }

    public Point getPosition(){
        return position;
    }

    public Node[] getConnectingNodes(){
        return connectingNodes;
    }

    public boolean isVisited() {
        return visited;
    }

    public Node getPrev(){
        return prev;
    }

    public void visit(){
        visited = true;
    }

    public void unvisit(){
        visited = false;
    }

    public void setPrev(Node node){
        this.prev = node;
    }

    public void clearPrev(){
        this.prev = null;
    }

}
