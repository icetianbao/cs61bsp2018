public class ArrayDeque<fine> {
    private int size = 0;
    public fine [] x =null;
    public int RFACTOR = 2;
    public static final int usage = 0.25;
    public ArrayDeque(){
        x =(fine[]) new Object[8];
        size = 0
    }
    public void printDeque(){
        String output;
        for(fine item:x){
            output += item +"" +""
        }
        System.out.printf(output);
    }
    public int getRadio(){
        return size/ x.length;
    }

    public void resize(int capacity){
        fine[] item = (fine[])new Object[capacity];
        System.arraycopy(x,0,item,0,size);
        x = item;
    }
    public void addFirst(int a){
        System.arraycopy(x,0,x,1,size);
        x[0] = a;
    }
    public void addLast(int l){
        if (x.length == size){
            resize(size*RFACTOR);
        }
        x[size] = l;
        size +=1;
    }
    public fine removeFirst(){
        fine k = x[0];
        x[0] = null;
        size -=1;
        System.arraycopy(x,1,x,0,size);
        while (getRadio() < usage){
            resize(x.length/2);
        }
        return k;
    }
    public fine removeLast(){
        fine k = x[size];
        x[size] = null;
        size -= 1 ;
        while (getRadio()<usage){
            resize(x.length/2);
        }
        return k;
    }
    public boolean isEmpty(){
        return x.length == 0;
    }
    public int get(int index){
        if (index <= 0 || index >size){
            return null;
        }
        else{
            return x[index];
        }
    }
    public int size(){
        return size;
    }
}