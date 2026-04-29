import java.time.format.DateTimeFormatter;

public class Exercise3 {
    public void question1(Exam[] exams)
    {
        if(exams==null|| exams.length==0) System.out.println("khong có kỳ thi nào");
        Exam exam1=exams[0];
        System.out.println("mã đề thi: "+exam1.Code);
        System.out.println("người tạo đề thi:"+exam1.CreatorID.username);
        System.out.println(" tiêu đề: "+exam1.Title);
        System.out.println("thời gian thi:"+exam1.Duration);
        System.out.println("Category : "+exam1.CategoryID);
        DateTimeFormatter time=DateTimeFormatter.ofPattern("dd//MM//yyyy");
        String formatDate =exam1.CreateDate.format(time);
        System.out.println("ngay tao:" +formatDate);
    }
    public void question2(Exam[] exams)
    {
        if(exams==null|| exams.length==0) System.out.println("khong có kỳ thi nào");
        Exam exam1=exams[0];
        System.out.println("mã đề thi: "+exam1.Code);
        System.out.println("người tạo đề thi:"+exam1.CreatorID.username);
        System.out.println(" tiêu đề: "+exam1.Title);
        System.out.println("thời gian thi:"+exam1.Duration);
        System.out.println("Category : "+exam1.CategoryID);
        DateTimeFormatter time= DateTimeFormatter.ofPattern("yyyy//MM//dd//HH//mm//ss");
        String formatDate =exam1.CreateDate.format(time);
        System.out.println("ngay tao:" +formatDate);
    }
    public void question3(Exam[] exams)
    {
        if(exams==null|| exams.length==0) System.out.println("khong có kỳ thi nào");
        Exam exam1=exams[0];
        System.out.println("mã đề thi: "+exam1.Code);
        System.out.println("người tạo đề thi:"+exam1.CreatorID.username);
        System.out.println(" tiêu đề: "+exam1.Title);
        System.out.println("thời gian thi:"+exam1.Duration);
        System.out.println("Category : "+exam1.CategoryID);
        DateTimeFormatter time= DateTimeFormatter.ofPattern("yyyy");
        String formatDate =exam1.CreateDate.format(time);
        System.out.println("ngay tao:" +formatDate);
    } public void question4(Exam[] exams)
    {
        if(exams==null|| exams.length==0) System.out.println("khong có kỳ thi nào");
        Exam exam1=exams[0];
        System.out.println("mã đề thi: "+exam1.Code);
        System.out.println("người tạo đề thi:"+exam1.CreatorID.username);
        System.out.println(" tiêu đề: "+exam1.Title);
        System.out.println("thời gian thi:"+exam1.Duration);
        System.out.println("Category : "+exam1.CategoryID);
        DateTimeFormatter time= DateTimeFormatter.ofPattern("yyyy//MM");
        String formatDate =exam1.CreateDate.format(time);
        System.out.println("ngay tao:" +formatDate);
    }
    public void question6(Exam[] exams)
    {
        if(exams==null|| exams.length==0) System.out.println("khong có kỳ thi nào");
        Exam exam1=exams[0];
        System.out.println("mã đề thi: "+exam1.Code);
        System.out.println("người tạo đề thi:"+exam1.CreatorID.username);
        System.out.println(" tiêu đề: "+exam1.Title);
        System.out.println("thời gian thi:"+exam1.Duration);
        System.out.println("Category : "+exam1.CategoryID);
        DateTimeFormatter time= DateTimeFormatter.ofPattern("//MM//dd");
        String formatDate =exam1.CreateDate.format(time);
        System.out.println("ngay tao:" +formatDate);
    }
}