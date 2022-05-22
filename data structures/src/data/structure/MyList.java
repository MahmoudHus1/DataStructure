package data.structure;

public interface MyList<T> {

    public void add(int index, T t);

    public void add(T t);

    public void clear();

    public boolean contains(T t);

    public T get(int index);

    public int indexOf(T t);

    public boolean isEmpty();

    public int lastIndexOf(T t);

    public T remove(T t);

    public int size();

    public T removeByIndex(int index);

    public T set(int index, T t);

}
