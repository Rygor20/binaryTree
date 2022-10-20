package pt.maven.theTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class startTree
{
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        chooseTree();
    }

    private static <T extends Comparable<T>> void chooseTree()
    {
        myTree<T> tree = new myTree<>();
        while(true)
        {
            System.out.println("Podaj rodzaj danych w drzewie : Integer, Double, String");
            String data = scanner.nextLine();

            if(data.equals("Integer"))
            {
                System.out.println("Utworzono dzewo zmiennej typu Integer, mozliwe operacje to: insert, display, search, remove, end");
                doActions(tree, 1);
                break;
            }
            else if(data.equals("Double"))
            {
                System.out.println("Utworzono dzewo zmiennej typu Double, mozliwe operacje to: insert, display, search, remove, end");
                doActions(tree, 2);
                break;
            }
            else if(data.equals("String"))
            {
                System.out.println("Utworzono dzewo zmiennej typu String, mozliwe operacje to: insert, display, search, remove, end");
                doActions(tree, 3);
                break;
            }
            else
            {
                System.out.println("Blad, nieprawidlowy rodzaj danych!");
            }
        }
    }

    private static <T extends Comparable<T>> void doActions(myTree<T> tree, int type)
    {
        myParse p;
        if(type == 1)
        {
            p = new myParseI();

        }
        else if(type == 2)
        {
            p = new myParseD();
        }
        else
        {
            p = new myParseS();
        }

        while(true)
        {
            String operation = scanner.nextLine();
            try
            {
                if(operation.equals("insert"))
                {
                    String input = scanner.nextLine();
                    tree.insert((T) p.parse(input));

                }
                else if(operation.equals("display"))
                {
                	System.out.println(tree.display());
                    //tree.display();
                }
                else if(operation.equals("search"))
                {
                    String input = scanner.nextLine();
                    System.out.println("Element " + input + " w drzewie? : " + tree.search((T) p.parse(input)));
                }
                else if(operation.equals("remove"))
                {
                    String input = scanner.nextLine();
                    tree.remove((T) p.parse(input));
                }
                else if(operation.equals("end"))
                {
                    break;
                }
                else
                {
                    System.out.println("Wprowadzone polecenie nie jest obslugiwane przez program");
                }
            }
            catch(final InputMismatchException e)
            {
                System.out.println("Blad, nieprawidlowy rodzaj zmiennej");
            }
            catch(final NumberFormatException e)
            {
                System.out.println("Blad, nieprawidlowy format zmiennej");
            }
        }
    }
}
