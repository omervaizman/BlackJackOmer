package www.omervaizman.co.blackjackomer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnStart;
    int money=2000;
    TextView tvMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        tvMoney=(TextView)findViewById(R.id.tvMoney);
        btnStart=(Button)findViewById(R.id.btnStart);
        btnStart.setOnClickListener(this);
        tvMoney.setText(money+"$");
    }

    @Override
    public void onClick(View v) {
        if(v==btnStart){
            Intent intent=new Intent(MainActivity.this,SetBetActivity.class);
      intent.putExtra("money",money);
            startActivity(intent);
        }

    }
}
