package pt.maven.theTree;

public class myNode<T extends Comparable<T>>
{
    private T data;
    private myNode<T> left;
    private myNode<T> right;

    public myNode(T node)
    {
        this.data = node;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }

    public void setLeft(myNode<T> left)
    {
        this.left = left;
    }

    public myNode<T> getLeft()
    {
        return left;
    }

    public void setRight(myNode<T> right)
    {
        this.right = right;
    }

    public myNode<T> getRight()
    {
        return right;
    }
}
