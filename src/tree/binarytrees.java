package tree;

import java.util.Scanner;

class binarytrees {
    public class Node {
        int value;
        Node left;
        Node right;

        // create a node with data.
        public Node(int value) {
            this.value = value;
        }
    }
    private Node root;
    //now create a function and insert in a binary tree.
    public void insertinBT(Scanner scn){
        System.out.println("Enter the data of the root node ");
        int value = scn.nextInt();
        this.root = new Node(value);
        insertinBT(scn, this.root);
    }
    private void insertinBT(Scanner scn, Node node){
        System.out.println("Do you want to insert in the left of the current node " + node.value);
        boolean left = scn.nextBoolean();
        if(left){
            System.out.println("Enter the left node ");
            int lvalue = scn.nextInt();
            node.left = new Node(lvalue);
            insertinBT(scn, node.left);
        }
        System.out.println("Do you want to insert in the right of the current node " + node.value);
        boolean right = scn.nextBoolean();
        if(right){
            System.out.println("Enter the data of the right node ");
            int rvalue = scn.nextInt();
            node.right = new Node(rvalue);
            insertinBT(scn, node.right);
        }
    }
    public void displayBT(){
        displayBT(root, " ");
    }
    public void displayBT(Node node, String space){
        if(node == null){
            return;
        }
        System.out.println(space + node.value);
        displayBT(node.right, space + "\t");
        displayBT(node.left, space + "\t");
    }
    public void prettierdisplayBT(){
        prettierdisplayBT(this.root, 0);
    }
    public void prettierdisplayBT(Node node, int space) {
        if (node == null) {
            return;
        }
        prettierdisplayBT(node.right, space + 1);
        if (space != 0) {
            for (int i = 0; i < space - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
            prettierdisplayBT(node.left, space+1);
        }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        binarytrees bt = new binarytrees();
        bt.insertinBT(scn);
//        bt.displayBT();
        bt.prettierdisplayBT();
        /*
        |		|		|------->80
|		|------->70
|		|		|------->65
|------->60
|		|------->55
50
|		|------->45
|------->40
|		|		|------->35
|		|------->30
|		|		|		|------->25
|		|		|------->20
|		|		|		|		|------->15
|		|		|		|------->10
        */
    }
}
