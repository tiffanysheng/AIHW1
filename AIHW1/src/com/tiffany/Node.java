package com.tiffany;

/**
 * Created by runyaosheng on 9/12/16.
 */
public class Node {
    private String id;
    private Node parent;
    private int sundayCost;
    private int level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getSundayCost() {
        return sundayCost;
    }

    public void setSundayCost(int sundayCost) {
        this.sundayCost = sundayCost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
