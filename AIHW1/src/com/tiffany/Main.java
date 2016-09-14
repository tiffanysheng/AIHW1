package com.tiffany;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static String alg = "";
    public static String startNode = "";
    public static String endNode = "";
    public static int numOfLive = 0;
    public static Path[] paths;
    public static int numOfSunday = 0;
    public static Node[] nodes;
    public static HashMap<Node, LinkedList<Node>> graph = new HashMap<>();

    public static void main(String[] args) {
        //readTxtFile(args[0]);
        readTxtFile("input.txt");

        if(alg.equals("BFS")) {
            BFS bfs = new BFS();
            bfs.runBFS();

        }

        if(alg.equals("DFS")) {

        }

        if(alg.equals("UCS")) {

        }

        if(alg.equals("A*")) {

        }
    }

    //read file
    public static void readTxtFile(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            if((tempString = reader.readLine()) != null) {
                alg = tempString;
                startNode = reader.readLine();
                endNode = reader.readLine();
                numOfLive = Integer.parseInt(reader.readLine());
                paths = new Path[numOfLive];
                for(int i = 0; i < numOfLive; i++) {
                    String temp = reader.readLine();
                    String[] tempArray = temp.split(" ");
                    Path p = new Path();
                    p.setStart(tempArray[0]);
                    p.setEnd(tempArray[1]);
                    p.setCost(Integer.parseInt(tempArray[2]));
                    paths[i] = p;

                }
                numOfSunday = Integer.parseInt(reader.readLine());
                nodes = new Node[numOfSunday];
                for(int i = 0; i < numOfSunday; i++) {
                    String temp = reader.readLine();
                    String[] tempArray = temp.split(" ");
                    Node n = new Node();
                    n.setId(tempArray[0]);
                    n.setSundayCost(Integer.parseInt(tempArray[1]));
                    nodes[i] = n;

                }

                //create graph
                for(int i = 0; i < numOfSunday; i++) {
                    LinkedList<Node> list = new LinkedList<Node>();
                    for(int j = 0; j < numOfLive; j++) {
                        if(paths[j].getStart().equals(nodes[i].getId())) {
                            for(int k = 0; k < numOfSunday; k++) {
                                if(paths[j].getEnd().equals(nodes[k].getId())) {
                                    list.add(nodes[k]);
                                }
                            }
                        }
                    }
                    graph.put(nodes[i],list);
                }

            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //write file
    public static void writeFile(Stack<Node> nodesStack) {
        try{
            FileWriter fw = new FileWriter(new File("output.txt"));
            BufferedWriter bw = new BufferedWriter(fw);

            for(Node n: nodesStack) {
                bw.write(n.getId()+" "+n.getLevel());
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
