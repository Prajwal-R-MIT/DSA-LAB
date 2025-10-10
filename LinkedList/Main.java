import java.util.Scanner;

class Node
{
    String SongName;
    Node LeftNode;
    Node RightNode;

    public Node(String SongName)
    {
        this.SongName = SongName;
        this.LeftNode = null;
        this.RightNode = null;
    }
}

class Playlist
{
    Node Head;
    public Playlist()
    {
        this.Head = new Node("1");
    }
    public void AddSong(int Position, String SongName)
    {
        if(Head.RightNode != null)
        {
            Node TempNodeForTraversal = Head;
            while(Position > 0)
            {
                if(TempNodeForTraversal.RightNode != null)
                {
                    TempNodeForTraversal = TempNodeForTraversal.RightNode;
                    Position--;
                }
                else
                {
                    System.out.println("Error: Position outside of Range. Inserting Song at the end of List.");
                    Position = 0;
                }
            }
            Node NewSong = new Node(SongName);
            NewSong.LeftNode = TempNodeForTraversal.LeftNode;
            NewSong.RightNode = TempNodeForTraversal;
            TempNodeForTraversal.LeftNode.RightNode = NewSong;
            TempNodeForTraversal.LeftNode = NewSong;
        }
        else
        {
            Node NewSong = new Node(SongName);
            NewSong.LeftNode = Head;
            Head.RightNode = NewSong;
        }
    }
    public void RemoveSong(int Position)
    {
        if(Head.RightNode != null)
        {
            Node TempNodeForTraversal = Head;
            while(Position > 0)
            {
                if(TempNodeForTraversal.RightNode != null)
                {
                    TempNodeForTraversal = TempNodeForTraversal.RightNode;
                    Position--;
                }
                else
                {
                    System.out.println("Error: Position out of Range. Deleting Song at the end of List.");
                    Position = 0;
                }
            }
            String RemovedSong = TempNodeForTraversal.SongName;
            TempNodeForTraversal.LeftNode.RightNode = TempNodeForTraversal.RightNode;
            TempNodeForTraversal.RightNode.LeftNode = TempNodeForTraversal.LeftNode;
            System.out.println("Removed Song: " + RemovedSong);
        }
        else
        {
            System.out.println("Error: Playlist is Empty.");
        }
    }
    public void DisplayInOrder()
    {
        if(Head.RightNode == null)
        {
            System.out.println("Error: Playlist is empty.");
            return;
        }
        else
        {
            Node TempNodeForTraversal = Head.RightNode;
            System.out.println("Here's the playlist : ");
            while(TempNodeForTraversal != null)
            {
                System.out.println(TempNodeForTraversal.SongName);
                TempNodeForTraversal = TempNodeForTraversal.RightNode;
            }
        }
    }
    public void DisplayInReverseOrder()
    {
        if(Head.RightNode == null)
        {
            System.out.println("Error: Playlist is empty.");
            return;
        }
        else
        {
            Node TempNodeForTraversal = Head.RightNode;
            while(TempNodeForTraversal.RightNode != null)
            {
                TempNodeForTraversal = TempNodeForTraversal.RightNode;
            }
            System.out.println("Here's the playlist in Reverse order : ");
            while(TempNodeForTraversal.LeftNode != null)
            {
                System.out.println(TempNodeForTraversal.SongName);
                TempNodeForTraversal = TempNodeForTraversal.LeftNode;
            }
        }
    }
}

public class Main 
{
    public static void main(String [] args)
    {
        Scanner inputScanner = new Scanner(System.in);
        int exitProgram = 1;

        while(exitProgram != 0)
        {
            Playlist PlaylistObj = new Playlist();
            int returnToMainMenu = 1;
            while(returnToMainMenu != 0)
            {
                System.out.println("Enter the operation you'd like to perform : ");
                System.out.println("1 for Add Song at Position.");
                System.out.println("2 for Remove Song from Position.");
                System.out.println("3 for Display In Order.");
                System.out.println("4 for Display In Reverse Order.");
                System.out.println("5 for RESET");
                System.out.println("6 for EXIT");

                switch(inputScanner.nextInt())
                {
                    case 1 : 
                        System.out.println("Enter the position & Song Name: ");
                        PlaylistObj.AddSong(inputScanner.nextInt(), inputScanner.nextLine());
                        break;
                    case 2 : 
                        System.out.println("Enter position: ");
                        PlaylistObj.RemoveSong(inputScanner.nextInt());
                        break;
                    case 3 : 
                        PlaylistObj.DisplayInOrder();
                        break;
                    case 4 : 
                        PlaylistObj.DisplayInReverseOrder();
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
