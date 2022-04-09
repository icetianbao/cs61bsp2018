public class LinkedListDeque<house> {
    public class IntNode {
        public IntNode pre;
        public house item;
        public IntNode next;

        public IntNode(IntNode p,house i ,IntNode n){
            pre = p;
            item = i;
            next = n;
        }
    }
    private int size;
    public house i;
    public IntNode sentinel;
    private IntNode last;
    public LinkedListDeque(){
        size = 0;
        sentinel = new IntNode(null,i,null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
    }
    public LinkedListDeque(house i){
        size = 1;
        sentinel = new IntNode(null,-5 ,null);
        sentinel.next = new IntNode(null,i,null);
        sentinel.pre = sentinel.next;
        sentinel.next.next = sentinel;
        sentinel.next.pre = sentinel;

    }
    public void addFirst(house i ){
        size +=1;
        sentinel.next = new IntNode(sentinel,i,sentinel.next);
        sentinel.next.next.pre = sentinel.next;
    }
    public void addLast(house i){
        size +=1;
        sentinel.pre = new IntNode(sentinel.pre,i,sentinel);
        sentinel.pre.pre.next = sentinel.pre;
    }
    public boolean isEmpty(){
        if (sentinel.next == sentinel){
            return True;
        }
        return False;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        String output;
        IntNode p = sentinel.next
        if (p != sentinel){
            output += p.item + "" +" ";
            p = p.next
        }
        System.out.printf(output);
    }
    public house removeFirst(){
        if (sentinel.next == sentinel){
            return null;
        }
        house k  = sentinel.next.item;
        sentinel.next.pre = null;
        sentinel.next = sentinel.next.next;
        sentinel.next.pre = sentinel;
        size -=1
        return k;
    }
    public house removeLast(){
        if (sentinel.pre == sentinel){
            return null;
        }
        house k = sentinel.pre.item;
        sentinel.pre .next = null;
        sentinel.pre =sentinel.pre.pre;
        sentinel.pre.next = sentinel;
        size -=1;
        return k;
    }
    public house get(int index){
        IntNode p = sentinel.next
        for (int i=0;i<index;i++){
            p=p.next;
        }
        return p.item;
    }
    public house getRecursive(int index){
        if (index >(index-1)){
            return null;
        }
        if (index == 0){
            return .item;
        }else {
            sentinel.next.getRecursive(index-1);
        }
    }


}