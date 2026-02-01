import task2.*;
import java.util.*;
import java.util.ArrayList;

class perimitercompare implements Comparator<PlanarShape>{
    @Override
    public int compare(PlanarShape s1,PlanarShape s2){
        return Double.compare(s1.getPerimiter(), s2.getPerimiter());
    }
}

class distansecompare implements Comparator<PlanarShape>{
    @Override
    public int compare(PlanarShape s1,PlanarShape s2){
        double d1 = Math.sqrt(Math.pow(s1.getX(), 2) + Math.pow(s1.getY(), 2));
        double d2 = Math.sqrt(Math.pow(s2.getX(), 2) + Math.pow(s2.getY(), 2));
        return Double.compare(d1, d2);
    }
}

public class TestTask2 {
    public static void main(String[] args){
        ArrayList<PlanarShape> shapeslist=new ArrayList<>();
        Random random=new Random();

        for(int i=0;i<5;i++){
            shapeslist.add(new Circle(random.nextInt(10),random.nextInt(10),random.nextInt(5)+1,"Red",true));
            shapeslist.add(new Rectangle(random.nextInt(10),random.nextInt(10),random.nextInt(5)+1,random.nextInt(5)+1,"Blue",false));
        }
        PlanarShape maxP=Collections.max(shapeslist,new perimitercompare());
        System.out.println(maxP.getPerimiter());

        PlanarShape minP=Collections.min(shapeslist,new perimitercompare());
        System.out.println(minP.getPerimiter());

        shapeslist.sort(new distansecompare());
        for(PlanarShape s:shapeslist){
            double dist = Math.sqrt(Math.pow(s.getX(), 2) + Math.pow(s.getY(), 2));
            System.out.printf("Дистанция: %.2f\n", dist, s.getType(), s.toString());
        }
    }
}
