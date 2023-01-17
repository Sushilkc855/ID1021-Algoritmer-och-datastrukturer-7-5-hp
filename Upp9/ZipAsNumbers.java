package Upp9;
import java.io.BufferedReader;
import java.io.FileReader;

public class ZipAsNumbers {
    Node[] data;
    int max;

    public static void main(String[] args) {
        ZipAsNumbers foo = new ZipAsNumbers("C:\\Users\\Sushil's pc\\OneDrive\\Skrivbord\\AOD\\Upp9\\postnummer.csv");
        long t0 = 0; 
        long t1 = 0;
        long sum = 0; 
        int n = 0;
        while (n < 10_000) {
            t0 = System.nanoTime(); 
            foo.binary_search(11115);
            foo.binary_search(99499);
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
    
    public ZipAsNumbers(String file) {
        data = new Node[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
            }
        max = i-1;
        } 
        catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean binary_search(Integer zipCode) {
        int first = 0;
        int last = 9674;
        while (true) {
            int index = first + ((last-first)/2);
            if (data[index].code.equals(zipCode)) {
                return true; 
            }
            if (data[index].code < zipCode && index < last) { 
                first = index +1; 
            continue;
            }
            if (data[index].code > zipCode  && index > first) {
                last = index - 1;
            continue;
            }
            break;     
        }
            return false;
    } 
}
