package jp.co.cyberagent.dojo2019;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(indices = {@Index(value = {"name"}, unique = true)})
public class EntityUsers {
        @PrimaryKey
        public long id;

        @ColumnInfo
        public String name;
    }
