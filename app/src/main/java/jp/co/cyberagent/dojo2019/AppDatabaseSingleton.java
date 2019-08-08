package jp.co.cyberagent.dojo2019;

import android.content.Context;
import androidx.room.Room;

public class AppDatabaseSingleton {
    private static AppDatabase instance = null;
    private AppDatabaseSingleton() {}

    public static AppDatabase getInstance(Context context) {
        if (instance != null) {
            return instance;
        }
        instance =  Room.databaseBuilder(context,
                AppDatabase.class, "app_database").build();
        return instance;
    }

}
