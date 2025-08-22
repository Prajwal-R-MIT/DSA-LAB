import java.util.Scanner;

class Node
{
    int Data;
    Node NextAddress;

    public Node(int Data)
    {
        this.Data = Data;
        this.NextAddress = null;
    }
}

class StackUsingLinkedList
{
    Node Head;

    public StackUsingLinkedList()
    {
        this.Head = new Node(0);
    }
    public void PushToStack(int Item)
    {
        Node StackItem = new Node(Item);
        if(Head.NextAddress != null)
        {
            StackItem.NextAddress = Head.NextAddress;
        }
        Head.NextAddress = StackItem;
        Head.Data++; 
    }
    public int PopFromStack()
    {
        if(Head.NextAddress == null)
        {
            System.out.println("Error : Stack Underflow!");
            return -1;
        }
        Node Temp = Head.NextAddress;
        int ReturnVal = Temp.Data;
        Head.NextAddress = Temp.NextAddress;
        return ReturnVal;
    }
    public int PeekOnStack()
    {
        if(Head.NextAddress == null)
        {
            System.out.println("Error : Stack is Empty!");
            return -1;
        }
        return Head.NextAddress.Data;
    }
    public int IsEmpty()
    {
        if(Head.NextAddress == null)
        {
            return 1;
        }
        return 0;
    }
    public void DisplayStackItems()
    {
        if(Head.NextAddress == null)
        {
            System.out.println("Error: Stack is Empty!");
            return;
        }

        System.out.println("Stack elements are : ");
        Node Temp = Head.NextAddress;
        while(Temp != null)
        {
            System.out.print(Temp.Data + " ");
            Temp = Temp.NextAddress;
        }
        System.out.println("");
    }
    public int CountOfItems()
    {
        return Head.Data;
    }
}

public class linkedlist_stack
{
    public static void main (String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int exitProgram = 1;

        while(exitProgram != 0)
        {
            System.out.println("Enter the size of the stack : ");
            
            StackUsingLinkedList StackObj = new StackUsingLinkedList();

            int returnToMainMenu = 1;
            while(returnToMainMenu != 0)
            {
                System.out.println("Enter the operation you'd like to perform : ");
                System.out.println("1 for PUSH");
                System.out.println("2 for POP");
                System.out.println("3 for PEEK");
                System.out.println("4 for DISPLAY");
                System.out.println("5 for COUNT OF STACK ITEMS");
                System.out.println("6 for IS EMPTY");
                System.out.println("7 for RESET");
                System.out.println("8 for EXIT");

                switch(inputScanner.nextInt())
                {
                    case 1 : 
                        System.out.println("Enter Item to Push : ");
                        StackObj.PushToStack(inputScanner.nextInt());
                        break;
                    case 2 : 
                        System.out.println("Item Popped : " + StackObj.PopFromStack());
                        break;
                    case 3 : 
                        System.out.println("Top most element : " + StackObj.PeekOnStack());
                        break;
                    case 4 : 
                        StackObj.DisplayStackItems();
                        break;
                    case 5 :
                        System.out.println("Count of Stack Items : " + StackObj.CountOfItems());
                        break;
                    case 6 :
                        int OutputFlag = StackObj.IsEmpty();
                        if(OutputFlag == 1)
                        {
                            System.out.println("Stack is Empty!");
                        }
                        else
                        {
                            System.out.println("Stack is Not Empty!");
                        }
                        break;
                    case 7 : 
                        returnToMainMenu = 0;
                        break;
                    case 8 :
                        returnToMainMenu = 0; 
                        exitProgram = 0;
                        break;
                }
                // stackObject.pushToStack(100);
                // stackObject.pushToStack(200);
                // stackObject.displayStackItems();
            }
        }
    }
}