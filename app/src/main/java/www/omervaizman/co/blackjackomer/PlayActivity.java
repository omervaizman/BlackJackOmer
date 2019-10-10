package www.omervaizman.co.blackjackomer;

import android.app.Dialog;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    Card[] cards;
    Animation SlideCard;
    Boolean stopClicked;
    Dialog win, lose, draw,setBet;
    LinearLayout linearLayoutstop;
    SeekBar sbSetBet;
    Card c;
    Player player;
    Player oponnent;
    int z = 0,bet,money;
    TextView tvScore, tvScoreOponnent,tvMoney,tvMoneyChanged;
    ImageView ivCard, ivBack;
    Button btnPush, btnStop, btnPlayAgain, btnDouble,btnSetBet,btnNewBet;
    FrameLayout LL_player, LL_opponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        linearLayoutstop=(LinearLayout)findViewById(R.id.LL_stop);
        References();
        CardsToArray();
        Intent intent = getIntent();
        bet=intent.getExtras().getInt("bet");
        money=intent.getExtras().getInt("money");
        tvScore.setVisibility(View.INVISIBLE);
        tvScoreOponnent.setVisibility(View.INVISIBLE);
        player = new Player();
        oponnent = new Player();
        Play();
        btnPlayAgain.setVisibility(View.INVISIBLE);
        tvMoney.setVisibility(View.INVISIBLE);
    }

    protected void References() {
        SlideCard = AnimationUtils.loadAnimation(this, R.anim.anim_slidecard);
        tvMoney=(TextView)findViewById(R.id.tvMoneyOnGame);
        tvScoreOponnent = (TextView) findViewById(R.id.tvScoreOponnent);
        btnPlayAgain = (Button) findViewById(R.id.btnPlayAgain);
        btnDouble = (Button) findViewById(R.id.btnDouble);
        btnPlayAgain.setOnClickListener(this);
        btnPush = (Button) findViewById(R.id.btnPush);
        btnPush.setOnClickListener(this);
        btnStop = (Button) findViewById(R.id.btnStop);
        tvScore = (TextView) findViewById(R.id.tvScore);
        btnStop.setOnClickListener(this);
        cards = new Card[52];
        btnNewBet=new Button(this);
        btnNewBet.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(300,150);
        layoutParams.setMargins(300,0,0,0);
        btnNewBet.setText("New Bet");
        btnNewBet.setBackgroundResource(R.drawable.shaped_button);
        btnNewBet.setLayoutParams(layoutParams);
        ivCard = new ImageView(this);
        LL_opponent = (FrameLayout) findViewById(R.id.LL_Opponent);
        LL_player = (FrameLayout) findViewById(R.id.LL_Player);
      //  btnPush.setClickable(false);
    }

    public void CardsToArray() {
        for (int CardValue = 1; CardValue <= 13; CardValue++)//the value of the card(1-11)
        {
            for (int t = 0; t <= 3; t++)//the type of the card (heart,clover...)
            {
                cards[z] = new Card(t, CardValue);
                z++;
            }
        }
    }

    public void ivToCard(int t, int c, ImageView iv) {

        if (c == 1 && t == 0)
            iv.setImageResource(R.drawable.ah);
        if (c == 2 && t == 0)
            iv.setImageResource(R.drawable.h2);
        if (c == 3 && t == 0)
            iv.setImageResource(R.drawable.h3);
        if (c == 4 && t == 0)
            iv.setImageResource(R.drawable.h4);
        if (c == 5 && t == 0)
            iv.setImageResource(R.drawable.h5);
        if (c == 6 && t == 0)
            iv.setImageResource(R.drawable.h6);
        if (c == 7 && t == 0)
            iv.setImageResource(R.drawable.h7);
        if (c == 8 && t == 0)
            iv.setImageResource(R.drawable.h8);
        if (c == 9 && t == 0)
            iv.setImageResource(R.drawable.h9);
        if (c == 10 && t == 0)
            iv.setImageResource(R.drawable.h10);
        if (c == 11 && t == 0)
            iv.setImageResource(R.drawable.jh);
        if (c == 12 && t == 0)
            iv.setImageResource(R.drawable.qh);
        if (c == 13 && t == 0)
            iv.setImageResource(R.drawable.kh);
        //......................................................................................
        if (c == 1 && t == 1)
            iv.setImageResource(R.drawable.ad);
        if (c == 2 && t == 1)
            iv.setImageResource(R.drawable.d2);
        if (c == 3 && t == 1)
            iv.setImageResource(R.drawable.d3);
        if (c == 4 && t == 1)
            iv.setImageResource(R.drawable.d4);
        if (c == 5 && t == 1)
            iv.setImageResource(R.drawable.d5);
        if (c == 6 && t == 1)
            iv.setImageResource(R.drawable.d6);
        if (c == 7 && t == 1)
            iv.setImageResource(R.drawable.d7);
        if (c == 8 && t == 1)
            iv.setImageResource(R.drawable.d8);
        if (c == 9 && t == 1)
            iv.setImageResource(R.drawable.d9);
        if (c == 10 && t == 1)
            iv.setImageResource(R.drawable.d10);
        if (c == 11 && t == 1)
            iv.setImageResource(R.drawable.jd);
        if (c == 12 && t == 1)
            iv.setImageResource(R.drawable.qd);
        if (c == 13 && t == 1)
            iv.setImageResource(R.drawable.kd);
        //......................................................................................
        if (c == 1 && t == 2)
            iv.setImageResource(R.drawable.ac);
        if (c == 2 && t == 2)
            iv.setImageResource(R.drawable.c2);
        if (c == 3 && t == 2)
            iv.setImageResource(R.drawable.c3);
        if (c == 4 && t == 2)
            iv.setImageResource(R.drawable.c4);
        if (c == 5 && t == 2)
            iv.setImageResource(R.drawable.c5);
        if (c == 6 && t == 2)
            iv.setImageResource(R.drawable.c6);
        if (c == 7 && t == 2)
            iv.setImageResource(R.drawable.c7);
        if (c == 8 && t == 2)
            iv.setImageResource(R.drawable.c8);
        if (c == 9 && t == 2)
            iv.setImageResource(R.drawable.c9);
        if (c == 10 && t == 2)
            iv.setImageResource(R.drawable.c10);
        if (c == 11 && t == 2)
            iv.setImageResource(R.drawable.jc);
        if (c == 12 && t == 2)
            iv.setImageResource(R.drawable.qc);
        if (c == 13 && t == 2)
            iv.setImageResource(R.drawable.kc);
        //......................................................................................
        if (c == 1 && t == 3)
            iv.setImageResource(R.drawable.as);
        if (c == 2 && t == 3)
            iv.setImageResource(R.drawable.s2);
        if (c == 3 && t == 3)
            iv.setImageResource(R.drawable.s3);
        if (c == 4 && t == 3)
            iv.setImageResource(R.drawable.s4);
        if (c == 5 && t == 3)
            iv.setImageResource(R.drawable.s5);
        if (c == 6 && t == 3)
            iv.setImageResource(R.drawable.s6);
        if (c == 7 && t == 3)
            iv.setImageResource(R.drawable.s7);
        if (c == 8 && t == 3)
            iv.setImageResource(R.drawable.s8);
        if (c == 9 && t == 3)
            iv.setImageResource(R.drawable.s9);
        if (c == 10 && t == 3)
            iv.setImageResource(R.drawable.s10);
        if (c == 11 && t == 3)
            iv.setImageResource(R.drawable.js);
        if (c == 12 && t == 3)
            iv.setImageResource(R.drawable.qs);
        if (c == 13 && t == 3)
            iv.setImageResource(R.drawable.ks);
    }

    public int RandomInt() {

        return (int) (Math.random() * 52 + 1);
    }

    public LinearLayout.LayoutParams addIV(FrameLayout fl) {
        int ML = 50;
        if (fl == LL_player) {
            for (int i = 0; i < player.getCardCounter(); i++) {
                player.setML();
            }
            ML = player.getML();
            player.reserML();
        }
        if (fl == LL_opponent) {

            for (int i = 0; i < oponnent.getCardCounter(); i++) {
                oponnent.setML();
            }
            ML = oponnent.getML();
            oponnent.reserML();
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(230, 420);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins(ML, 0, 0, 0);

        return layoutParams;
    }

    public void OponnentPlay() {

        while (oponnent.getScore() <17) {
            PullCardForStart(LL_opponent,oponnent);
            if (oponnent.getScore() > 21) {
                if (oponnent.getAceCounter() > 0) {
                    for (int i = 0; i < oponnent.getAceCounter(); i++)
                        oponnent.setScore(-10);
                }
            }
        }


    }

    @Override
    public void onClick(View v) {
        if (v == btnStop) {
            stopClicked = true;
            OponnentPlay();
            Winner();
            ivToCard(c.getCardType(), c.getCardValue(), ivBack);
            tvScoreOponnent.setText("score=" + oponnent.getScore() + "");
        }
        if (v==btnNewBet){
            createDialogBet();
      }
if (v==btnSetBet){
    setBet.cancel();
}
        //*************************************************************************************************
        if (v == btnPush) {
            Push(LL_player);
        }
        //**********************************************************************************************************
        if (v == btnPlayAgain) {
            Play();
        }
    }

    public void Push(FrameLayout frameLayout) {
        int i = RandomInt();
        ivCard = new ImageView(this);
        ivToCard(cards[i].getCardType(), cards[i].getCardValue(), ivCard);
        ivCard.setLayoutParams(addIV(frameLayout));
        ivCard.startAnimation(SlideCard);
        frameLayout.addView(ivCard);
        if (frameLayout == LL_player) {
            //-----------------------------------------------
            if (cards[i].getRealCardValue() == 1 && player.getScore() + 11 < 21) {
                player.setScore(11);
                player.setAceCounter();
            } else
                player.setScore(cards[i].getRealCardValue());
            //-----------------------------------------------
            if (player.getScore() > 21) {
                if (player.getAceCounter() > 0) {
                    for (int p = 0; p < player.getAceCounter(); p++) {
                        player.setScore(-10);
                        tvScore.setText("score=" + player.getScore() + "");
                    }
                }
            }
            player.setCardCounter();
            tvScore.setText("score= " + player.getScore() + "");
        }
            if (frameLayout == LL_opponent) {

                if (cards[i].getRealCardValue() == 1 && player.getScore() < 21) {
                    oponnent.setScore(11);
                    oponnent.setAceCounter();
                    oponnent.setCardCounter();
                } else
                    oponnent.setScore(cards[i].getRealCardValue());
                oponnent.setCardCounter();
            }

            Winner();


    }

    public void Play() {
        btnPush.setClickable(true);
        btnStop.setClickable(true);
        stopClicked = false;
        RestartGame();
        tvScore.setVisibility(View.VISIBLE);
        //............................................
        for (int i = 0; i < 2; i++) {
            PullCardForStart(LL_player, player);
        }

        //.................................................
        PullCardForStart(LL_opponent, oponnent);
        //.................................................
        int y = RandomInt();
        c = cards[y];
        oponnent.setCardCounter();
        //.................................................
        if (cards[y].getRealCardValue() == 1) {
            if (oponnent.getAceCounter() == 0) {
                oponnent.setScore(11);
            }
            oponnent.setAceCounter();
        } else
            oponnent.setScore(cards[y].getRealCardValue());
        //.................................................

        ivBack = new ImageView(this);
        ivBack.setLayoutParams(addIV(LL_opponent));
        ivBack.setImageResource(R.drawable.card_back);
        ivBack.startAnimation(SlideCard);
        LL_opponent.addView(ivBack);
        tvScore.setText("score= " + player.getScore() + "");
        //***********************************************************************
        Winner();
        //***********************************************************************
    }

    public void RestartGame() {
        tvMoney.setVisibility(View.INVISIBLE);
        stopClicked = false;
        btnPlayAgain.setVisibility(View.INVISIBLE);
        btnPush.setVisibility(View.VISIBLE);
        btnStop.setVisibility(View.VISIBLE);
        btnDouble.setVisibility(View.VISIBLE);
       linearLayoutstop.removeView(btnNewBet);
        LL_player.removeAllViews();
        LL_opponent.removeAllViews();
        player.ResetPlayer();
        oponnent.ResetPlayer();
        tvScoreOponnent.setVisibility(View.INVISIBLE);
    }

    public void PullCardForStart(FrameLayout frameLayout, Player player1) {
        int K = RandomInt();
        player1.setCardCounter();
        ivCard = new ImageView(this);
        ivToCard(cards[K].getCardType(), cards[K].getCardValue(), ivCard);
        ivCard.setLayoutParams(addIV(frameLayout));
        ivCard.startAnimation(SlideCard);
        frameLayout.addView(ivCard);
        if (cards[K].getRealCardValue() == 1) {
            if (player1.getAceCounter() == 0) {
                player1.setAceCounter();
                player1.setScore(11);
            }
        } else
            player1.setScore(cards[K].getRealCardValue());
        player1.setCardCounter();
    }

    public void createDialogWin() {
        win = new Dialog(this);
        win.setContentView(R.layout.win_dialog);
        win.setCancelable(true);
        win.show();
    }

    public void createDialogLose() {
        lose = new Dialog(this);
        lose.setContentView(R.layout.lose_dialog);
        lose.setCancelable(true);
        lose.show();
    }

    public void createDialogDraw() {
        draw = new Dialog(this);
        draw.setContentView(R.layout.draw_dialog);
        draw.setCancelable(true);
        draw.show();
    }

    public void Winner() {
        if (stopClicked) {
            if (player.getScore()<21&&oponnent.getScore()<21&&player.getScore()<oponnent.getScore()){
                createDialogLose();
                afterWin();
            }
if (player.getScore()<21&&oponnent.getScore()>21){
    createDialogWin();
    afterWin();
}
            if (player.getScore() < 21 && oponnent.getScore() < 21 && player.getScore() > oponnent.getScore()) {
                createDialogWin();
                afterWin();
            }
            if (player.getScore() == oponnent.getScore()) {
                createDialogDraw();
                afterWin();
            }

            if (oponnent.getScore() == 21 && player.getScore() < 21) {
                createDialogLose();
                afterWin();
            }
        }
        else {
            if (player.getScore() == 21 && oponnent.getScore() == 21) {
                createDialogDraw();
                afterWin();
            }
            if (player.getScore() > 21) {
                createDialogLose();
                afterWin();
            }
            if (oponnent.getScore() == 21) {
                createDialogLose();
                afterWin();
            }

            if (player.getScore() == 21 &&oponnent.getScore()!=player.getScore()) {
                createDialogWin();
                afterWin();
            }
        }


    }

    public void afterWin() {
        tvMoney.setText(""+money+"$");
        tvMoney.setVisibility(View.VISIBLE);
        btnPlayAgain.setVisibility(View.VISIBLE);
        btnPlayAgain.setClickable(true);
        btnNewBet.setVisibility(View.VISIBLE);
        btnPush.setVisibility(View.INVISIBLE);
      btnStop.setVisibility(View.INVISIBLE);
        btnDouble.setVisibility(View.INVISIBLE);
        tvScoreOponnent.setVisibility(View.VISIBLE);
        tvScoreOponnent.setText("score=" + oponnent.getScore() + "");
        ivToCard(c.getCardType(), c.getCardValue(), ivBack);
        btnPush.setClickable(false);
        btnStop.setClickable(false);
 linearLayoutstop.addView(btnNewBet);

    }
    public void createDialogBet(){
        setBet=new Dialog(this);
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
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvMoneyChanged.setText(""+progress+"");
       // bet=progress;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
