package emipity;

import java.util.PrimitiveIterator;

public class Student {
    private int id;
    private  String name;
    private String hometomw;
    private float score;

    public Student(){}
    public void plusscore(float n)
    {   this.score += n;
    }
    public void showInFor()
    {
        System.out.println("họ và tên"+this.name);
        if(this.score<4.0){
            System.out.println("học lực yếu");
        }
        else if(this.score<6.0)
        {
            System.out.println("học lực trung bình");
        }
        else if (this.score<8.0) System.out.println("học lực khá");
        else System.out.println("học lực giỏi");
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHometomw() {
        return hometomw;
    }

    public void setHometomw(String hometomw) {
        this.hometomw = hometomw;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Student(int id, String name, String hometomw, float score) {
        this.id = id;
        this.name = name;
        this.hometomw = hometomw;
        this.score = score;
    }
}
