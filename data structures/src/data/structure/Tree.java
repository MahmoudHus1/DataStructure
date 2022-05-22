package data.structure;

public interface Tree<T extends Comparable<T>> {

    public boolean search(T element);

    public boolean insert(T element);

    public boolean delete(T element);

    public void inorder();

    public void preorder();

    public void postorder();

    public int size();

    public boolean isEmpty();

    public void clear();

}
