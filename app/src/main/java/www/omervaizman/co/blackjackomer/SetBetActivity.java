package www.omervaizman.co.blackjackomer;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class SetBetActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Animation animMove;
    Button btnRaise,btnPlay,btnSetBet;
    Dialog setBet;
   ImageView ivChips;
   SeekBar sbSetBet;
   int money,bet;
   int n=1;
    TextView tvBet,tvMoneyChanged;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_bet);
        Intent intent=getIntent();
       money= intent.getExtras().getInt("money");
        animMove= AnimationUtils.loadAnimation(this,R.anim.anim_move);
        ivChips=(ImageView)findViewById(R.id.ivChips);
        btnPlay=(Button)findViewById(R.id.btnPlay);
        tvBet=(TextView)findViewById(R.id.tvBet);
        btnRaise=(Button)findViewById(R.id.btnRaise);
        btnRaise.setOnClickListener(this);
        btnPlay.setOnClickListener(this);
    }
    public void createDialog(){
        setBet=new Dialog(SetBetActivity.this);
        setBet.setCancelable(false);
        setBet.setContentView(R.layout.bet_dialog);
        btnSetBet=(Button)setBet.findViewById(R.id.btnSetBet);
        sbSetBet=(SeekBar)setBet.findViewById(R.id.sbSetBet);
        tvMoneyChanged=(TextView)setBet.findViewById(R.id.tvMoneyChanged);
        sbSetBet.setOnSeekBarChangeListener(this);
        btnSetBet.setOnClickListener(this);
        sbSetBet.setMax(money);
        setBet.show();
    }
    @Override
    public void onClick(View v) {
if(v==btnRaise){
    createDialog();
}
if (v==btnPlay) {
    if (bet>0) {
        Intent intent = new Intent(this, PlayActivity.class);
        intent.putExtra("bet",bet);
        intent.putExtra("money",money);
        startActivity(intent);
    }
    else
        Toast.makeText(this,"bet is bigger than 0",Toast.LENGTH_LONG).show();
}
if (v==btnSetBet){
    setBet.cancel();
    tvBet.setText(""+bet+"$");
    ivChips.setImageResource(R.drawable.chip);
    ivChips.startAnimation(animMove);
}
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        bet=progress;
        tvMoneyChanged.setText(""+progress+"");
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
