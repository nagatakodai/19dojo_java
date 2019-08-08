package jp.co.cyberagent.dojo2019;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public abstract class DaoUsers {
    @Query("select id from EntityUsers order by id desc limit 1")
    public static long getMaxId() {
        return 0;
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insert(EntityUsers user);

    @Query("delete from EntityUsers where id = :id")
    abstract void delete(long id);

}
