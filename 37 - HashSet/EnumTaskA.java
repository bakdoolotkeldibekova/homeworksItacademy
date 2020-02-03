package hw38;

import java.util.*;

public class EnumTaskA {
    static void sorted(int[] a){
        for(int i=0; i<a.length; i++){int k=0;
            for(int j=0; j<a.length-1; j++){
                if(a[j] > a[j+1]){
                    int helper = a[j];
                    a[j] = a[j+1];
                    a[j+1] = helper;
                    k=1;
                }
            }if(k==0) break;
        }
    }
    static void sorted(ArrayList<Integer> a){
        Collections.sort(a);
    }
    static void sorted(LinkedList<Integer> a){
        Collections.sort(a);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 20;

        int[] arrays = new int[n];
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++){
            arrays[i] = rand.nextInt(2);
            linkedList.addLast(rand.nextInt(2));
            arrayList.add(rand.nextInt(2));
        }

        sorted(arrays);
        for(int i=0; i<arrays.length; i++) System.out.print(arrays[i] + " ");

        sorted(arrayList);
        System.out.println("\n" + arrayList);

        sorted(linkedList);
        System.out.println(linkedList);


    }
}
