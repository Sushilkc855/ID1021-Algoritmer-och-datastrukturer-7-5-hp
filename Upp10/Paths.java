package Upp10;

public class Paths {
    City[] path;
    int sp;
    


    public Paths() {
        path = new City[54];
        sp = 0;
    }
    
    public Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        
        Integer shrt = null;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;

        for (int i = 0; i < from.head.length; i++) {
            if (from.head[i] != null) {
                Connections conn = from.head[i];
                Integer totDist = shortest(conn.city, to, max-conn.distance);
                
                if (totDist != null && (shrt == null || (shrt > totDist + conn.distance))) {
                    shrt = totDist + conn.distance; 
                }
            }
        }
        path[sp--] = null;
        return shrt;
    }

}
