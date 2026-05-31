package org.example.utlis;

import java.util.Objects;
import java.util.Scanner;

public class ScannerUtils {
    private static   Scanner scanner = new Scanner(System.in);

    public static String inputstring()
    {
        String text;
        while (true)
        {   text = scanner.nextLine();
            if(Objects.isNull(text)||text.trim().isEmpty())
            {
                System.out.println("nhâp lại");
            }else {
                return text;
            }
        }
    }
    public static Integer inputInt()
    {
        String text;
        while (true)
        {
            text =scanner.nextLine();
            try{
                return  Integer.parseInt(text);
            }catch ( Exception e)
            {
                System.out.println("vui lòng nhập số , nhập lại");
            }
        }
    }
    public static String inputEmail()
    {
        String email;
        while(true)
        {
            email =scanner.nextLine();
            String regex = "^[a-zA-Z0-9_+.-]+@[a-zA-Z0-9.-]+$";
            if(!email.matches(regex))
            {
                System.out.println("sai định dang nhập lại");
            }
            else {
                return email;
            }
        }
    }
    public static Integer inputIntgreatThenZero()
    {
        while (true)
        {
            Integer integer =ScannerUtils.inputInt();
            if(integer<=0)
            {
                System.out.println(" vui lòng nhập số >0");
            }
            else {
                return integer;
            }
        }
    }
}
