public class SortsOfSorts{

  public static void main(String[] args){
  
    int[] a = {5,7,12,1,3,9,2,11};
    System.out.println(mergeSort(a));
    
  }
  
  public static int[] mergeSort(int[] a){
    
    if(a.length == 1)
      return a;
   
    int[] a1 = new int[a.length/2];
    int[] a2 = new int[a.length/2];
    
    a1 = System.arraycopy(a, 0, a1, 0, a.length/2);
    a2 = System.arraycopy(a, a.length/2, a2, 0, a.length/2);
    
    return(merge(mergeSort(a1), mergeSort(a2)));
    
  }

  public static int[] merge(int[] a1, int[] a2){
    if(a1.length == 0)
      return a2;
    else if(a2.length == 0)
      return a1;
    
    int[] tmp;
    if(a1[1] <= a2[1]){
      tmp = new int[a1.length-1];
      System.arraycopy(a1, 1, tmp,0, a1.length - 1);
      return(prepend(a[1], merge(tmp, a2)));
    }
    else{
      tmp = new int[a2.length -1];
      System.arraycopy(a2, 1, tmp, 0, a2.length-1);
      return(prepend(a2[1], merge(a1, tmp)));
    }
  }
  
  public static int[] prepend(int i, int[] a){
    int[] tmp = new int[a.length + 1];
    tmp[0] = i;
    return(System.arraycopy(a, 0, tmp, 1, a.length));
  }
  
}