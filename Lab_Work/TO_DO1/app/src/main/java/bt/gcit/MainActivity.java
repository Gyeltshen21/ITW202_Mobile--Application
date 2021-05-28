package bt.gcit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.text1);
    }
    public void view(View view) {
        Toast t = Toast.makeText(this,"Hello Toast"+ "",Toast.LENGTH_LONG);
        t.show();
    }

    public void count(View view) {
        count++;
        txt.setText(Integer.toString(count));
    }
}