package kr.co.roonets.sharedpreferenceexe;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = sharedPreferences.edit();

        final EditText et_shared = (EditText) findViewById(R.id.et_shared);
        Button btn_save = (Button) findViewById(R.id.btn_save);

        et_shared.setText(sharedPreferences.getString("initString", ""));

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("score", 1001);
                editor.putString("initString", et_shared.getText().toString());
                editor.apply(); // 비동기방식 (<-> commit())
                Toast.makeText(MainActivity.this, "저장 되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();

        // 보통의 경우 상태값을 저장하기 때문에 여기에 로직을 작성한다
    }
}
