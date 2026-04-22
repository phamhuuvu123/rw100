public class Exercise_1 {
    public void question1(Account[] account){
        System.out.println("question1");
        Account account2= account[1];
        if(account2.DepartmentID==null)
        {
            System.out.println("nhan vien chua co phoong ban");
        }
        else {
            System.out.println("phong ban nhan vien la:"+account2.DepartmentID.name);
        }
    }
    public void question2(Account[] account)
    {
        System.out.println("question2");
        Account account2=account[1];
        if(account2.group==null)
        {
            System.out.println("nhan vien chua co group");
        }else { int countgroup = account2.group.length;
            if(countgroup==1||countgroup==2)
            {
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
            } else if (countgroup==3) {
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
            } else  {
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group\n");
            }
        }

    }
    public void question3(Account account2)
    {
        System.out.println( account2.DepartmentID==null?
                "Nhân viên này chưa có phòng ban":("Phòng ban của nhân viên này là …"+account2.DepartmentID.name));
    }
    public  void question4(Account account1)
    {
        System.out.println(account1.PositionID.Name== Position.PositionName.DEV?
                "Đây là Develope":"Người này không phải là Developer");
    }
    public  void question5(Group[] group)
    {   Group group1=group[0];
        int countaccounts=group1.accounts.length;
        switch(countaccounts){
            case 1:
                System.out.println("Nhóm có một thành viên ");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên ");
                break;
            case 3:
                System.out.println("\"Nhóm có ba thành viên\" ");
                break;
            default:
                System.out.println( "Nhóm có nhiều thành viên" );
                break;
    }

    }
    public void Question6(Account[] account)
    {   Account account2=account[1];
         int countgroup = account2.group.length;
         switch (countgroup){
             case 0:
                 System.out.println("Nhân viên này chưa có group");
                 break;
             case 1:
             case 2:
                 System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                 break;
             case 3:
                 System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                 break;
             default:
                 System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
         }
    }
    public  void Question7(Account account1)
    {
        switch (account1.PositionID.Name)
        {
            case DEV:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println(" Người này không phải là Developer");
                break;
        }
    }
    public void Question8(Account[] account1)
    {
        for (var acc : account1)
        {
            System.out.println("Username:" +acc.Username);
            System.out.println("phòng ban"+acc.DepartmentID.name);
            System.out.println("chuc vu"+acc.PositionID.Name);
        }
    }
    public void question9 (Position[] position1)
    {
        for(var po:position1)
        {
            System.out.println("id: "+po.id);
            System.out.println("name: "+po.Name);
        }
    }
    public void question10(Account[] account)
    {
        for (int i =0;i<account.length;i++)
        {   if(i==2) break;
            System.out.println("thông tin account thứ: "+i );
            System.out.println("username: " +account[i].Username);
            System.out.println("phòng ban: "+account[i].PositionID.Name);
        }
    }
    public void question11(Department[] department)
    {
        for(int i=0;i<department.length;i++)
        {
            System.out.println(" thông tin thu: "+i);
            System.out.println("id: "+ department[i].id);
            System.out.println("department: "+department[i].name);
        }
    }
    public void question12(Department[] departments)
    {
        for (int i=0;i<departments.length;i++)
        {
            if(i==2)break;
            System.out.println(" thông tin thu: "+i);
            System.out.println("id: "+ departments[i].id);
            System.out.println("department: "+departments[i].name);
        }
    }
    public void question13(Account[] account)
    {
        for (int i =0;i<account.length;i++)
        {   if(i==2) continue;
            System.out.println("thông tin account thứ: "+i );
            System.out.println("username: " +account[i].Username);
            System.out.println("phòng ban: "+account[i].PositionID.Name);
        }
    }
    public void question14(Account[] account)
    {
        for (int i =0;i<account.length;i++)
        {   if(account[i].id<4) {
            System.out.println("thông tin account thứ: " + i);
            System.out.println("username: " + account[i].Username);
            System.out.println("phòng ban: " + account[i].PositionID.Name);
            }
        }
    }
    public  void question15(){
        for(int i=0;i<=20;i++)
        {
            if(i%2==0)
            {
                System.out.println("số chẵn là: " +i);
            }
        }
    }
    public void question16(Account[] account)
    {   int i=0;
        while (i<account.length)
        {   if(i==2) break;
            System.out.println("thông tin account thứ: "+i );
            System.out.println("username: " +account[i].Username);
            System.out.println("phòng ban: "+account[i].PositionID.Name);
            i++;
        }
    }
    public void question16(Department[] department)
    {
       int i=0;
       while (i<department.length)
        {
            System.out.println(" thông tin thu: "+i);
            System.out.println("id: "+ department[i].id);
            System.out.println("department: "+department[i].name);
            i++;
        }
    }
    public void question17(Account[] account)
    {   int i=0;
     do
        {   if(i==2) break;
            System.out.println("thông tin account thứ: "+i );
            System.out.println("username: " +account[i].Username);
            System.out.println("phòng ban: "+account[i].PositionID.Name);
            i++;
        }while (i<account.length);
    }
    public void question17(Department[] department)
    {
        int i=0;
        do
        {
            System.out.println(" thông tin thu: "+i);
            System.out.println("id: "+ department[i].id);
            System.out.println("department: "+department[i].name);
            i++;
        }   while (i<department.length);
    }
}