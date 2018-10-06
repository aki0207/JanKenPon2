package com.example.jankenpon;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        //メインアクティビティからインテントを取得
        Intent intent = this.getIntent();
        //値を取得
        String choice_hand = intent.getStringExtra("choice_hand");

       //自分の選んだ手を表示
       /* TextView my_hand = (TextView) findViewById(R.id.textView);
        my_hand.setText(c);*/

        //乱数生成
        int hand_number = randomNumber();
        //乱数から敵の手を決定
        String enemy_hand = enemyHand(hand_number);
        //勝敗判定
        String result = judgeResult(choice_hand,enemy_hand);


        //画面に表示
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(result);

        Button finishButton = (Button) findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }

    //0～2の乱数を生成
    int randomNumber() {

        Random rnd = new Random();
        int hand = rnd.nextInt(3);
        return hand;
    }

    //生成された乱数に応じて相手の手を決定
    String enemyHand(int hand) {

        String enemy_hand = "";

        if (hand == 0) {

            enemy_hand = "ぐー";

        } else if (hand == 1) {

            enemy_hand = "ちょき";

        } else {

            enemy_hand = "ぱー";

        }

        return enemy_hand;
    }

    //勝敗の判定
    String judgeResult(String your_hand, String enemy_hand) {

        String result = "";

        if (your_hand.equals("ぐー") && enemy_hand.equals("ちょき") ||
                your_hand.equals("ちょき") && enemy_hand.equals("ぱー") ||
                your_hand.equals("ぱー") && enemy_hand.equals("ちょき")) {

            result = "勝ち";

        } else if (your_hand.equals("ぐー") && enemy_hand.equals("ぐー") ||
                your_hand.equals("ちょき") && enemy_hand.equals("ちょき") ||
                your_hand.equals("ぱー") && enemy_hand.equals("ぱー")) {

            result = "ひきわけ";

        } else {

            result = "負け";

        }

        return result;


    }


}
