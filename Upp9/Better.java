package Upp9;

import java.io.BufferedReader;
import java.io.FileReader;

public class Better {
    Node[] data;
    int max;
    public static void main(String[] args) {
        Better foo = new Better("C:\\Users\\Sushil's pc\\OneDrive\\Skrivbord\\AOD\\Upp9\\postnummer.csv");
       
        int[] keys = new int[9675];
        int  z = 0;  
        for(int i = 0; i < 100000; i++){
            if (foo.data[i] != null) {
                keys[z] = foo.data[i].code; 
                z++;
            }
        }
        List list[];
        int mod = 40000; 
        list = foo.hashMap(keys, mod);
        /* 
        for(int i = 0; i < 20000; i++){
            if (list[i] != null) {
                System.out.println(list[i].value);     
            }
           
        }
        */
        int sum =0;
        int testValue = 10000; 
        for(int i = 0; i < 90000; i++){
            sum += foo.lookUp(list,testValue, mod);     
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


    public Better (String file) {
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


    public List[] hashMap(int[] keys, int mod){
        List list[] = new List[mod*2];
        for (int i = 0; i < 9675; i++) {
            Integer index = keys[i] % mod;  
            while (list[index] != null) {
                index++; 
            }
            list[index] = new List(keys[i]);; 
        }
        return list; 
    }

    public Integer lookUp(List[] lists, int key, int mod){
        Integer index =key % mod;  
        int i = 0; 
        if (lists[index] == null) {
            return i; 
        }
        while (lists[index].value != key) {
            i++; 
            index++; 
            if (lists[index] == null) {
                return i; 
            }
        }
        return i; 
    }


    public class List{
        int value; 
        public List(int value) {
            this.value = value;
        }
    }




}
