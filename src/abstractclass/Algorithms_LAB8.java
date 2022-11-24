/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package abstractclass;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

class Railway{
    ArrayList<Integer> train = new ArrayList<Integer>();
    ArrayList<Railway> railways = new ArrayList<Railway>();
    public void addtrain(int a){
        train.add(a);
    }
    public void addrailway(Railway a){
        railways.add(a);
    }

}
public class Algorithms_LAB8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m, n, count, count2;
        m = input.nextInt();
        n = input.nextInt();
        Railway[]  railway = new Railway[n];
        for(int i=0; i<n; i++){
            railway[i]= new Railway();
        }
        for(int a=0; a<n; a++){
            count = input.nextInt();
            for(int b=0; b<count; b++){
                count2 = input.nextInt();
                railway[a].addtrain(count2);
            }
        }

        int count3 = input.nextInt();
        int[] in = new int[count3];
        int[] out = new int[count3];

        for(int i=0; i<count3; i++){
            in[i] = input.nextInt();
            out[i] = input.nextInt();
        }

        for(Railway a: railway){
            for(int b: a.train){
                for(Railway c: railway){
                    for(int d: c.train){
                        if(b==d && !a.railways.contains(c)){
                            a.addrailway(c);
                        }
                    }
                }
            }
        }

        for(int i=0; i<out.length; i++){
            for(int a=0; a<n; a++){
                if(railway[a].train.contains(out[i])){
                    //check(railway[i],in,out,0,n);
                }
            }
        }

    }

    public static int check(Railway railway, int in, int out, int count, int n){
        if(railway.railways.contains(in)){

        }

        if(railway.railways.contains(out)){
            return count;
        }
        else if(count>=n-1){
            return -1;
        }
        else{
            for(Railway r:railway.railways){
                return check(r,in,out,count+1,n);
            }
        }
        return -1;
    }
}
