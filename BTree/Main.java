import java.util.Scanner;

class bTreeNode
{
    int[] Keys;
    int Order;
    bTreeNode[] Children;
    int NumberOfNodes;
    boolean Leaf;

    public bTreeNode(int Order, boolean Leaf)
    {
        this.Keys = new int[Order - 1];
        this.Order = Order;
        this.Children = new bTreeNode[Order];
        this.NumberOfNodes = 0;
        this.Leaf = Leaf;
    }
}

class bTree
{
    bTreeNode Root;

    public bTree(int Order)
    {
        this.Root = new bTreeNode(Order, true);
    }
}

public class Main
{
    public static void main(String[] args)
    {
    }
}