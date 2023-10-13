import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

    ArrayList<Node> visitedList = new ArrayList<>();

    Stack<Node> stack = new Stack<>();

    Node startNode;
    Node goalNode;
    Node currentNode;
    Node[][] nodeArray;
    int maxCol;
    int maxRow;

    public DFS(Node startNode, Node goalNode, Node currentNode, Node[][] nodeArray, int maxCol, int maxRow) {
        this.startNode = startNode;
        this.goalNode = goalNode;
        this.currentNode = currentNode;
        this.nodeArray = nodeArray;
        this.maxCol = maxCol;
        this.maxRow = maxRow;
    }


    public void startSearch(){

        stack.add(startNode);
        visitedList.add(startNode);

        while (!stack.isEmpty()){


            Node cur = stack.pop();

            if (cur.goal){
                break;
            }

            cur.setAsSearched();
            ArrayList<Node> neighbourList = getNeighbours(cur);

            for (Node n: neighbourList){
                if (!visitedList.contains(n)){
                    stack.push(n);
                    visitedList.add(n);
                }
            }

        }

        System.out.println("Stack is empty");


    }

    public ArrayList<Node> getNeighbours(Node n){

        ArrayList<Node> neighbourList = new ArrayList<>();

        System.out.println(n);



        if (n.col - 1 >= 0){
            Node uppernode = nodeArray[n.col-1][n.row];
            if (!uppernode.wall){
                neighbourList.add(uppernode);
            }
        }

        if (n.col + 1 < maxCol){
            Node rightnode = nodeArray[n.col+1][n.row];
            if (!rightnode.wall){
                neighbourList.add(rightnode);
            }
        }

        if (n.row + 1 < maxRow){
            Node downnode = nodeArray[n.col][n.row+1];
            if (!downnode.wall){
                neighbourList.add(downnode);
            }
        }

        if (n.row - 1 >= 0){
            Node leftnode = nodeArray[n.col][n.row-1];
            if (!leftnode.wall){
                neighbourList.add(leftnode);
            }
        }

        return neighbourList;




    }


}
