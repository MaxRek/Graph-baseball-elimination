package Methods;

public class Tools {
    
    public static void printIntArray(int[] a){
        String str = "[";
        for(int i = 0; i<a.length;i++){
            if(i!=a.length-1){
                str += Integer.toString(a[i])+",";
            } else {
                str += Integer.toString(a[i]);
            }
            
        }
        str += "]";
        System.out.println(str);
    }

}
