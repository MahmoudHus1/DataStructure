package data.structure;

public abstract class MyAbstractList<T> implements MyList<T> {
    
    protected int size = 0;
    
    protected MyAbstractList(){
        
    }
    
    protected MyAbstractList(T [] data){
        for (int i = data.length -1; i >= 0; i--) {
            add(data[i]);
        }
    }
    
    @Override
    public abstract void add(T e);
    
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    
    
}
