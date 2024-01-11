package org.pytorch.demo.objectdetection;

public class ListData{
    private String name,roomno,floor;

    public ListData(String name, String floor, String roomno) {
        this.name = name;
        this.floor=floor;
        this.roomno = roomno;
    }
    public String getName() {
        return name;
    }
    public void setName(String description) {
        this.name = description;
    }
    public String getRoomno() {
        return roomno;
    }
    public void setImgId(String roomno) {
        this.roomno = roomno;
    }

    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }
}
