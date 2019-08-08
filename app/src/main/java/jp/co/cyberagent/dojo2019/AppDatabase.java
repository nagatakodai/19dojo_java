package jp.co.cyberagent.dojo2019;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EntityUsers.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DaoUsers userDao();
}
