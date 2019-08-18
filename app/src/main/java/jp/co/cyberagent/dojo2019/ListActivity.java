package jp.co.cyberagent.dojo2019;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final RecyclerView rv = findViewById(R.id.RecyclerView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                final AppDatabase db = AppDatabaseSingleton.getInstance(ListActivity.this);
                final List<User> users;
                users = db.userDao().getAll();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ListActivity.this, users.size()+"人登録されています" ,Toast.LENGTH_LONG).show();
                        RecycleViewAdapter adapter = new RecycleViewAdapter(users);
                        LinearLayoutManager llm = new LinearLayoutManager(ListActivity.this);

                        rv.setHasFixedSize(true);
                        rv.setLayoutManager(llm);
                        rv.setAdapter(adapter);

                        /*Mainに戻る処理*/

                    }
                });
            }
        }).start();
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}
