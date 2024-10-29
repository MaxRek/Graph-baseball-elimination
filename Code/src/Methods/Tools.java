package Methods;

import Entity.Equipe;

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

    public static void printMatrixArray(int[][] m){
        for(int i = 0; i<m.length;i++){
            printIntArray(m[i]);
        }
    }

    public static int[][] copyMatrixWithoutTeam(int[][] M, int e){
        
        int a = -1;
        int[][] mRet = new int[M.length-1][M[0].length-1];

        for(int i = 0; i<M.length-1 ; i++){
            a = a + 1;
            if(i == e){
                a = a + 1;
            }
            int b = -1 ;
            for(int j = 0; j<M[0].length-1 ; j++){
                b = b + 1;
                if(j == e+2){
                    b = b + 1;
                }
                if(a<M.length && b<M[0].length && i<mRet.length && j<mRet[0].length){

                    mRet[i][j] = M[a][b];
                }
            }
        }        
        return mRet;
    }

}
