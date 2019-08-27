package jp.co.cyberagent.dojo2019;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.content.Intent;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    private String[] str = new String[3];
    private EditText[] editText = new EditText[3];

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_dashboard:
                    intent = new Intent(MainActivity.this, QRCodeActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_notifications:
                    intent = new Intent(MainActivity.this, ListActivity.class);
                    startActivity(intent);
                    return true;
            }
            return false;
        }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* getSupportFragmentManager().beginTransaction()
                .replace(//R.id.fragmentContainer,BlankFragment.newInstance)
                .commit();*/
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void setScreenQR(View v) {
        Intent intent = new Intent(MainActivity.this, QRCodeActivity.class);
        startActivity(intent);
    }
    public void setScreenQRRead(View v){
        Intent intent = new Intent(MainActivity.this, QRReadActivity.class);
        startActivity(intent);
    }
    public void setScreenList(View v){
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        startActivity(intent);
    }
    public void onClickKeep(View v) {
       /* {
            editText[0] = findViewById(R.id.text1);
            str[0] = editText[0].getText().toString();
            editText[1] = findViewById(R.id.text2);
            str[1] = editText[1].getText().toString();
            editText[2] = findViewById(R.id.text3);
            str[2] = editText[2].getText().toString();
        } // 入力値をString型に代入 */
        {
            SharedPreferences data = getSharedPreferences("DataSave", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = data.edit();
            editor.putString("name", findViewById(R.id.text1).toString());
            editor.putString("github", findViewById(R.id.text2).toString());
            editor.putString("twitter", findViewById(R.id.text3).toString());
            editor.apply();
        } //String型の入力値をeditorに代入

    }
}
