package jp.co.cyberagent.dojo2019;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);
        RecyclerView rv = findViewById(R.id.RecyclerView);
        RecycleViewAdapter adapter = new RecycleViewAdapter(this.createDataset());

        LinearLayoutManager llm = new LinearLayoutManager(this);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);
    }

    private List<RowData> createDataset() {
        AppDatabase db = AppDatabaseSingleton.getInstance(ListActivity.this);
        final String all = db.userDao().getAll().toString();
        List<RowData> dataset = new ArrayList<>();
            RowData data = new RowData();

            data.setTitle(all);
            data.setDetail(all);

            dataset.add(data);

        return dataset;
    }
}
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                AppDatabase db = AppDatabaseSingleton.getInstance(ListActivity.this);
                final String all = db.userDao().getAll().toString();
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        // ui
                      title.setText(all);
                      detail.setText(all);
                    }
                });
            }
        }).start();
    }

    public void setScreenMain(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void setScreenQR(View v) {
        Intent intent = new Intent(ListActivity.this, QRCodeActivity.class);
        startActivity(intent);
    }
    public void setScreenQRRead(View v){
        Intent intent = new Intent(ListActivity.this, QRReadActivity.class);
        startActivity(intent);
    }
*/
