import java.util.Scanner;

class hashArrayItem
{
    int data;
    boolean empty;
    boolean deleted;

    public hashArrayItem()
    {
        this.data = 0;
        this.empty = true;
        this.deleted = false;
    }
}

class hash
{
    hashArrayItem[] hashArray;
    int sizeOfHashArray;
    
    public hash(int size)
    {
        this.hashArray = new hashArrayItem[size];
        this.sizeOfHashArray = size;

        for(int iterator = 0; iterator < sizeOfHashArray; iterator++)
        {
            this.hashArray[iterator] = new hashArrayItem();
        }
    }

    public void insertUsingLinearProbing(int item)
    {
        int position = item % sizeOfHashArray; // Hash function is x % sizeOfHashArray. Ex: x % 15.
        while(!hashArray[position].empty && !hashArray[position].deleted)
        {
            if((position + 1) == (item % sizeOfHashArray))
            {
                System.out.println("This item can't be inserted into the Hash Table using Linear Probing.");
                return;
            }
            System.out.println("Collision at Position : " + position);
            position = (position + 1) % sizeOfHashArray;
        }
        System.out.println("Inserting at Position : " + position);
        hashArrayItem itemToInsert = new hashArrayItem();
        itemToInsert.data = item;
        itemToInsert.empty = false;
        itemToInsert.deleted = false;
        hashArray[position] = itemToInsert;
    }

    public void insertUsingQuadraticProbing(int item)
    {
        int position = item % sizeOfHashArray; // Hash function is x % sizeOfHashArray. Ex: x % 15.
        int iteration = 1;
        while(!hashArray[position].empty && !hashArray[position].deleted)
        {
            System.out.println("Collision at Position : " + position);
            position = ((item % sizeOfHashArray) + (iteration * iteration)) % sizeOfHashArray;
            iteration++;
        }
        System.out.println("Inserting at Position : " + position);
        hashArrayItem itemToInsert = new hashArrayItem();
        itemToInsert.data = item;
        itemToInsert.empty = false;
        itemToInsert.deleted = false;
        hashArray[position] = itemToInsert;
    }

    public void deleteFromLinearProbingHashTable(int item)
    {
        int position = item % sizeOfHashArray;
        while(hashArray[position].data != item)
        {
            if((position + 1) == (item % sizeOfHashArray))
            {
                System.out.println("Item not found in the Hash Table.");
                return;
            }
            position = (position + 1) % sizeOfHashArray;
        }
        hashArray[position].deleted = true;
    }

    public void displayHashItems()
    {
        System.out.println("Here are the items : ");
        for(int iterator = 0; iterator < sizeOfHashArray; iterator++)
        {
            System.out.println(hashArray[iterator].data);
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Scanner inputReader = new Scanner(System.in);
        int exitProgram = 0;
        while(exitProgram == 0)
        {
            System.out.println("Enter size of Hash table :");
            int sizeOfHashTable = inputReader.nextInt();
            hash hash = new hash(sizeOfHashTable);
            System.out.println("Choose the probing type : \n1 for Linear Probing\n2 for Quadratic probing");
            int option = inputReader.nextInt();
            int returnToMainMenu = 0;
            while(returnToMainMenu == 0)
            {
                System.out.println("Choose your action : \n1 for Insert\n2 for Delete\n3 for Display\n4 for Return to main menu\n5 for Exit");
                int choice = inputReader.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter the item to be inserted : ");
                        hash.insertUsingLinearProbing(inputReader.nextInt());
                        break;
                    case 2:
                        System.out.println("Enter the item to be deleted : ");
                        hash.insertUsingLinearProbing(inputReader.nextInt());
                        break;
                    case 3:
                        hash.displayHashItems();
                        break;
                    case 4:
                        returnToMainMenu = 1;
                        break;
                    case 5:
                        returnToMainMenu = 1;
                        exitProgram = 1;
                        break;
                    default:
                        System.out.println("Please enter a valid choice.");
                        break;
                }
            }
        }
    }
}