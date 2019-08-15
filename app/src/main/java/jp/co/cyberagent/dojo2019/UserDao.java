package jp.co.cyberagent.dojo2019;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

   @Query("SELECT tw FROM user WHERE uid")
    String getTwitter();

    @Query("SELECT gh FROM user WHERE uid")
    String getGitHub();

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
