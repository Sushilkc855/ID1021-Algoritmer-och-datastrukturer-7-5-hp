package Upp9;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.xml.crypto.Data;

public class Collisions {
    Node[] data;
    int max;
    public static void main(String[] args) {
        Collisions foo = new Collisions("C:\\Users\\Sushil's pc\\OneDrive\\Skrivbord\\AOD\\Upp9\\postnummer.csv");
       
        int[] keys = new int[9675];
        int  z = 0;  
        for(int i = 0; i < 100000; i++){
            if (foo.data[i] != null) {
                keys[z] = foo.data[i].code; 
                z++;
            }
        }

        foo.collision(19990, keys); 

    
    }

    public class Node {
        Integer code; 
        String name; 
        Integer pop; 
        public Node(Integer code, String name, Integer pop){
            this.code = code; 
            this.name = name; 
            this.pop = pop; 
        }
    }


    public Collisions (String file) {
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


    public void collision(int mod, int[] keys) {
        int[] data = new int[mod];
        int[] cols = new int[10];

        for (int i = 0; i < 9675; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }

        System.out.print(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

}
