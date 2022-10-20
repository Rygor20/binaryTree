package pt.maven.theTree;

//Uruchamia oczekianie na inpu usera, pojedyncze drzewo

public class myTree<T extends Comparable<T>>
{
    private myNode<T> root;

    public myTree()
    {
        root = null;
    }

    public void insert(T data)
    {
        root = insertHelper(data, root);
    }
    private myNode<T> insertHelper(T data, myNode<T> node)
    {
        if(node == null)
        {
            return new myNode<>(data);
        }
        else
        {
            if(data.compareTo(node.getData()) < 0)
            {
                node.setLeft(insertHelper(data, node.getLeft()));
            }
            else if(data.compareTo(node.getData()) > 0)
            {
                node.setRight(insertHelper(data, node.getRight()));
            }
            return node;
        }
    }

    public String display()
    {
        return displayHelper(root);

    }
    private String displayHelper(final myNode<T> node)
    {
        if(node != null ) {
            return "(" + node.getData() + "L" + displayHelper(node.getLeft()) + "P" + displayHelper(node.getRight()) + ")";
        }
        return "()";
    }

    public boolean search(T data)
    {
        return searchHelper(root, data);
    }
    private boolean searchHelper(myNode<T> node, T data)
    {
        if(node == null)
        {
            return false;
        }
        if(node.getData().equals(data))
        {
            return true;
        }
        else if(node.getData().compareTo(data) > 0)
        {
            return searchHelper(node.getLeft(), data);
        }
        else
        {
            return searchHelper(node.getRight(), data);
        }
    }

    public void remove(T data)
    {
        if(search(data))
        {
            removeHelper(root, data);
        }
        else
        {
            System.out.println(data + " : Nie mozna znalezc podanej danej");
        }
    }
    private myNode<T> removeHelper(myNode<T> node, T data)
    {
        if(node == null)
        {
            return node;
        }
        if(data.compareTo(node.getData()) < 0)
        {
            node.setLeft(removeHelper(node.getLeft(), data));
        }
        else if(data.compareTo(node.getData()) > 0)
        {
            node.setRight(removeHelper(node.getRight(), data));
        }
        else
        {
            if(node.getLeft() == null && node.getRight() == null)
            {
                if(node.equals(this.root))
                {
                    this.root = null;
                }
                node = null;
            }
            else if(node.getRight() != null)
            {
                node.setData(successor(node));
                node.setRight(removeHelper(node.getRight(), node.getData()));
            }
            else if(node.getLeft() != null)
            {
                node.setData(predecessor(node));
                node.setLeft(removeHelper(node.getLeft(), node.getData()));
            }
        }
        return node;
    }

    private T successor(myNode<T> node)
    {
        node = node.getRight();
        while(node.getLeft() != null)
        {
            node = node.getLeft();
        }
        return node.getData();
    }

    private T predecessor(myNode<T> node)
    {
        node = node.getLeft();
        while(node.getRight() != null)
        {
            node = node.getRight();
        }
        return node.getData();
    }
}
