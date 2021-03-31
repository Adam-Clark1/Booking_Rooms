
package rooms;


public class booking {
    
    
    private String name;
    private String time;
    private int room;
    private String request;

    public booking(String name, String time, int room, String request) {
        this.name = name;
        this.time = time;
        this.room = room;
        this.request = request;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
    
    
    
    
}
