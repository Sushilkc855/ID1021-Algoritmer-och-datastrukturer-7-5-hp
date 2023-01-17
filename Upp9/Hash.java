package Upp9;

import java.io.BufferedReader;
import java.io.FileReader;


public class Hash {
    Node[] data;
    int max;
    public static void main(String[] args) {
        Hash foo = new Hash("C:\\Users\\Sushil's pc\\OneDrive\\Skrivbord\\AOD\\Upp9\\postnummer.csv");
       
        int[] keys = new int[9675];
        int  z = 0;  
        for(int i = 0; i < 100000; i++){
            if (foo.data[i] != null) {
                keys[z] = foo.data[i].code; 
                z++;
            }
        }

        List[] list;
        int mod  =10000; 
        list = foo.collision(mod, keys); 
        for(int i = 0; i< 9675; i++){
            if(list[i] != null){
              // list[i].print(); 
            }
        }
        int sum =0;
        int testValue = 10000; 
        
        for(int i = 0; i < 90000; i++){
            sum += foo.lookUp(testValue,mod, list);     
            testValue++; 
        }
        
        System.out.println(sum/90000.0);

    
    }

    public class Node {
        Integer code; 
        String name; 
        Integer pop; 
        Node nxt; 
        public Node(Integer code, String name, Integer pop){
            this.code = code; 
            this.name = name; 
            this.pop = pop; 
            this.nxt = null; 
        }
    }


    public Hash (String file) {
        data = new Node[100000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
        max = i-1;
        } 
        catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }


    public List[] collision(int mod, int[] keys) {
        List[] list = new List[mod];

        for (int i = 0; i < 9675; i++) {
            Integer index = keys[i] % mod;
           /*  while (list[index] != null) {
               list[index] = list[index].nxt; 
            }*/
            if(list[index] == null){
                list[index] = new List(keys[i]);
            }
            else{
                list[index].append(new List(keys[i]));
            }
        }
        return list; 
    }

    public int lookUp(Integer key,Integer mod, List[] list){
        Integer index = key % mod;
        int i = 0;
        while (list[index] != null) {
            //System.out.println();
           // System.out.println(list[index].code);
            if (list[index].code.equals(key)) {
                return i;
            }
            i++; 
            list[index] = list[index].nxt; 
        }
        return i;
    }


    public class List {
        Integer code; 
        List nxt; 
        public List(Integer code){
            this.code = code;
            this.nxt = null; 
        }

        public void append(List b) {
            List nxt = this;
           // LinkedList before = this;
            while (nxt.nxt != null) {
                nxt = nxt.nxt;
            }
            nxt.nxt = b;
        }

        public void print(){
            List curr = this; 
            while (curr != null) {
                System.out.println(curr.code);
                curr = curr.nxt; 
            }
            System.out.println();
        }
    }

}
