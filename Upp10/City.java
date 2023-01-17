package Upp10;

public class City {
    
    Connections[] head; 
    String headCity;
    int neighbors = 0; 
    public City(String city){
        this.headCity = city; 
        head = new Connections[8];
    }

    public void addNewConnection(City city, Integer distance){ 
        head[neighbors] = new Connections(city, distance); 
        neighbors++;   
    }



}


