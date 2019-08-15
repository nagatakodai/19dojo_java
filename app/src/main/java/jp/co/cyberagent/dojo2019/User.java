package jp.co.cyberagent.dojo2019;

        import androidx.room.Entity;
        import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey (autoGenerate = true)
    private int uid;

    private String name;
    private String tw;
    private String gh;

    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getUid() {
        return uid;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setTw(String tw) {
        this.tw = tw;
    }
    public String getTw() {
        return tw;
    }
    public void setGh(String gh) {
        this.gh = gh;
    }
    public String getGh() {
        return gh;
    }
}
