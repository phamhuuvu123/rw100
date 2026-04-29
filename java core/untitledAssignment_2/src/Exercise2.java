import java.time.LocalDateTime;

public class Exercise2 {

    public void question1()
    {
        int i=5;
        System.out.println("số nguyên là "+i);
    }
    public void question2()
    {
        long i=5;
        System.out.println("%d"+"số nguyên là "+i);
    }
    public void question3()
    {
        double i=5.567098;
        System.out.println("%.4f%n "+i);
    }
    public void question4()
    {
      String hovaten ="Nguyễn Văn A";
        System.out.println("tên tôi là "+hovaten+" và tôi đang đọc thân ");
    }
    public  void question5()
    {
        LocalDateTime time=LocalDateTime.now();
        System.out.println(time);
    }
    public void question6(Account[] account){
        for (var acc: account)
        {
            System.out.println("id:" +acc.id);
            System.out.println("tên là :" +acc.username);
            System.out.println("tên chức vụ: "+acc.positionID.Name);
            System.out.println("tên phong ban: "+acc.departmentID.name);
            System.out.println("ngày tạo"+acc.createDate);
        }
    }
}
