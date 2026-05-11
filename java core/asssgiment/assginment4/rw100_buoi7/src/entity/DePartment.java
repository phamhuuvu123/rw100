
package entity;
public  class DePartment {
    private int id;
    private String name;
    public DePartment(){}

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

    @Override
    public String toString() {
        return "DePartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public DePartment(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
