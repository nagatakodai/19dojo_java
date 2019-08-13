package jp.co.cyberagent.dojo2019;

        import androidx.room.Entity;
        import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey
    private int uid;

    private String name;

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
}
