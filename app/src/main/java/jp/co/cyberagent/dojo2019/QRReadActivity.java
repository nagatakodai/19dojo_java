package jp.co.cyberagent.dojo2019;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

public class QRReadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrread);
        new IntentIntegrator(QRReadActivity.this).initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            Toast.makeText(QRReadActivity.this, ""+result.getContents(),Toast.LENGTH_LONG).show();
            /*ここでdbに保存する*/
            final User user = new User();

            final AppDatabase db = AppDatabaseSingleton.getInstance(QRReadActivity.this);
            int indexStart = result.getContents().indexOf("iam=");

            int indexEnd = result.getContents().indexOf("&tw");

            user.setName(result.getContents().substring(indexStart+4 , indexEnd));

            indexStart = result.getContents().indexOf("tw=");
            indexEnd = result.getContents().indexOf("&gh");

            Uri.Builder builder = new Uri.Builder();
            builder.scheme("http");
            builder.authority("www.twitter.com");
            builder.path(result.getContents().substring(indexStart+3 , indexEnd));
            user.setTw(builder.toString());

            indexStart = result.getContents().indexOf("gh=");
            builder.scheme("http");
            builder.authority("www.github.com");
            builder.path(result.getContents().substring(indexStart+3));
            user.setGh(builder.toString());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    db.userDao().insertAll(user);
                }
            }).start();
            } else {
            super.onActivityResult(requestCode, resultCode, data);
        }

    }
    public void setScreenMain(View v) {
        Intent intent = new Intent(QRReadActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void setScreenQR(View v) {
        Intent intent = new Intent(QRReadActivity.this, QRCodeActivity.class);
        startActivity(intent);
    }
    public void setScreenList(View v){
        Intent intent = new Intent(QRReadActivity.this, ListActivity.class);
        startActivity(intent);
    }
}
