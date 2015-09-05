import java.util.*;

public class HashTableG{

  final static int SIZE = 128;
  LinkedList<Pair>[] table;
  
  private class Pair{
    int key;
    int val;
    
    public Pair(){   
    }
    
    public Pair(int k, int v){
      this.key = k;
      this.val = v;
    }
  }
  
  public static void main(String[] args){
    HashTableG ht = new HashTableG();
    ht.put(1,20);
    ht.put(99,1000);
    ht.put(8,5);
    ht.put(8,3);
       
    System.out.println(ht.get(8));
    System.out.println(ht.size());
    
  }
  
  public HashTableG(){
    this.table = new LinkedList[SIZE];
  }
  
  public int size(){
    return this.table.length;
  }
  
  public void put(int key, int val){
    int index = hash(key);
    LinkedList<Pair> list = this.table[index];
    if(list==null){
      list = new LinkedList<Pair>();
      this.table[index] = list;
    }
    Pair p = new Pair(key,val);
    list.add(p);
  }
  
  public List<Integer> get(int key){
    int index = hash(key);
    LinkedList<Pair> list = this.table[index];
    List<Integer> res = new ArrayList<Integer>();
    if(list==null)
      return res;
    for(Pair p : list){
      if(p.key == key)
        res.add(p.val);
    }
    return res;
  }
  
  public int hash(int key){
    return key%SIZE;
  }
  
}