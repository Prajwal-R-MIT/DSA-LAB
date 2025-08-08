import java.util.Scanner;

class Stack
{
    int topOfStack, capacity;
    int[] stack;

    public Stack(int capacity)
    {
        this.capacity = capacity;
        topOfStack = -1;
        stack = new int[capacity];
    }

    public boolean pushToStack(int item)
    {
        if(topOfStack >= capacity-1)
        {
            System.out.println("Error : Stack Overflow.");
            return false;
        }
        stack[++topOfStack] = item;
        return true;
    }

    public int popFromStack()
    {
        if(topOfStack < 0)
        {
            System.out.println("Error : Stack Underflow.");
            return 0;
        }
        return stack[topOfStack--];
    }

    public int peekIntoStack()
    {
        if(topOfStack < 0)
        {
            System.out.println("Error : Stack is Empty.");
            return 0;
        }
        return stack[topOfStack];
    }

    public void displayStackItems()
    {
        if(topOfStack < 0)
        {
            System.out.println("Error : Stack is Empty.");
            return;
        }
        System.out.println("Stack elements are : ");
        for(int displayPointer = 0; displayPointer <= topOfStack; displayPointer++)
        {
            System.out.print(stack[displayPointer] + " ");
        }
        System.out.println("");
    }
}

public class Main 
{
    public static void main (String[] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int exitProgram = 1;

        while(exitProgram != 0)
        {
            System.out.println("Enter the size of the stack : ");
            Stack stackObject = new Stack(inputScanner.nextInt());

            int returnToMainMenu = 1;
            while(returnToMainMenu != 0)
            {
                System.out.println("Enter the operation you'd like to perform : ");
                System.out.println("1 for PUSH");
                System.out.println("2 for POP");
                System.out.println("3 for PEEK");
                System.out.println("4 for DISPLAY");
                System.out.println("5 for RESET");
                System.out.println("6 for EXIT");

                switch(inputScanner.nextInt())
                {
                    case 1 : 
                        System.out.println("Enter Item to Push : ");
                        stackObject.pushToStack(inputScanner.nextInt());
                        break;
                    case 2 : 
                        System.out.println("Item Popped : " + stackObject.popFromStack());
                        break;
                    case 3 : 
                        System.out.println("Top most element : " + stackObject.peekIntoStack());
                        break;
                    case 4 : 
                        stackObject.displayStackItems();
                        break;
                    case 5 : 
                        returnToMainMenu = 0;
                        break;
                    case 6 :
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