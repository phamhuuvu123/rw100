import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise4 {
    public  void question1(){
        Random random = new Random();
        int x =random.nextInt(10);
        System.out.println(x);
    }
    public  void question2()
    {
        Random fl = new Random();
        float f= fl.nextFloat(100);
        System.out.println(f);
    }
    public  void question3()
    {
     String[] arrs = new String[3];
    arrs = new String[] { "a","b","c"};
     Random rd = new Random();
    int index =rd.nextInt(arrs.length);
    String result = arrs[index];
        System.out.println( result);
    }
    public void question4()
    {
        LocalDate batdau= LocalDate.of(1995,7,24);
        LocalDate ketthuc = LocalDate.of(1995,12,20);
        long intbatdau = batdau.toEpochDay();
        long  intketthuc = ketthuc.toEpochDay();
        long  random = ThreadLocalRandom.current().nextLong(intbatdau,intketthuc+1);
        LocalDate ramdomDate = LocalDate.ofEpochDay(random);
        System.out.println("ngay ngau nhien" + ramdomDate);

    }
    public  void question7()
    {   Random random = new Random();
        int randomNumber = random.nextInt(900)+100;
        System.out.println("số ngẫu nhiên:"+ randomNumber);

    }


}
