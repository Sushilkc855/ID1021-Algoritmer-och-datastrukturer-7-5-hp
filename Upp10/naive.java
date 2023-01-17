package Upp10;

public class naive {
    public static void main(String[] args) {
        Map foo = new Map("C:\\Users\\Sushil's pc\\OneDrive\\Skrivbord\\AOD\\Upp10\\trains.csv");

        Paths better = new Paths();
        Better better2 = new Better();
        

        String from = "MalmÃ¶";
        String to = "Kiruna";
        Integer max = 20000;

        long t4 = System.nanoTime();
        Integer dist = better2.shortest(foo.lookUpCity(from), foo.lookUpCity(to), max);
        long time = (System.nanoTime() - t4)/1_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");

       /*  
        long t0 = System.nanoTime();
       Integer dist2 = shortest(foo.lookUpCity(from), foo.lookUpCity(to), max);
        long time2 = (System.nanoTime() - t0)/1_000;
        System.out.println("shorest: " + dist2 + " min (" + time2 + " ms)");
        */


       
        long t2 = System.nanoTime();
        Integer bdist = better.shortest(foo.lookUpCity(from), foo.lookUpCity(to), max);
        long btime = (System.nanoTime() - t2)/1_000;
        System.out.println("shorest: " + bdist + " min (" + btime + " ms)");
        
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        Integer shrt = null; 
        for (int i = 0; i < from.head.length; i++) {
            if (from.head[i] != null) {
                Connections conn = from.head[i];
                Integer totDist = shortest(conn.city, to, max-conn.distance);
               
            if (totDist != null && (shrt == null || (shrt > totDist + conn.distance))) {
                shrt = totDist + conn.distance; 
            }
        }
        }
        return shrt;
    }
                    

}

