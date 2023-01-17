package Upp10;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 541;
    
    public Map(String file) {
        cities = new City[mod];
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            City city1; 
            City city2; 
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                System.out.println(row[0]+": "+row[1] + ": "+row[2]); 
                city1 = lookUpCity(row[0]); 
                city2 = lookUpCity(row[1]);
                System.out.println(city1.headCity+": "+city2.headCity + ": "+row[2]); 
                city1.addNewConnection(city2, Integer.valueOf(row[2]));
                city2.addNewConnection(city1, Integer.valueOf(row[2]));
            }
        } 
        catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }
    
    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public City lookUpCity(String city1){
        int index1 = hash(city1);
        while (cities[index1] != null) {
            if (cities[index1].headCity.equals(city1)) {
                return cities[index1]; 
            }
            index1++; 
        }

        if (cities[index1] == null) {
            cities[index1] = new City(city1);
            return cities[index1]; 
        }
        return cities[index1]; 
    }

    public void print(){
        int z = 0; 
        int antal = 0; 
        for(int i = 0; i <mod; i++){
            if (cities[i] != null) {
                System.out.println("Connection form: " + cities[i].headCity + ": " + hash(cities[i].headCity));
                while (cities[i].head[z] != null) {
                    System.out.println(cities[i].head[z].city.headCity +  ": " + "  " + cities[i].head[z].distance);
                    z++;
                }
                System.out.println(++antal);
                z=0;
            }
        }
    }


}
        

