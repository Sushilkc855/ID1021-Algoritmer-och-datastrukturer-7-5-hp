package Upp9;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.xml.crypto.Data;

public class KeyAsIndex {
    Node[] data;
    int max;
    public static void main(String[] args) {
        KeyAsIndex foo = new KeyAsIndex("C:\\Users\\Sushil's pc\\OneDrive\\Skrivbord\\AOD\\Upp9\\postnummer.csv");
        long t0 = 0; 
        long t1 = 0;
        long sum = 0; 
        int n = 0;
        while (n < 10_000) {
            t0 = System.nanoTime();
            
            foo.lookUp(11115);
            foo.lookUp(99499);
            t1 = System.nanoTime();   
            sum += t1- t0;  
            n++;
        }
        System.out.println(sum/10000);
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
    
    public KeyAsIndex(String file) {
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

    public Integer lookUp (Integer zipCode) {
        if ( data[zipCode] == null) {
            return null;
        }
        return data[zipCode].code;
    } 
}
