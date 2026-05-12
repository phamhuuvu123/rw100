package entity;

import enums.Enums;

public class Position {
    private int id;
    private Enums.Positionanme name;
    public Position(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enums.Positionanme getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Position(int id, Enums.Positionanme name) {
        this.id = id;
        this.name = name;
    }
}
