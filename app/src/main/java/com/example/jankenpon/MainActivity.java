package com.example.jankenpon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //とりあえずボタン設定
        Button rock = (Button) findViewById(R.id.rock);
        Button scissors = (Button) findViewById(R.id.scissors);
        Button paper = (Button) findViewById(R.id.paper);

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //インテント作成 第二引数にはパッケージ名からの指定で、遷移先クラスを指定
                Intent intent = new Intent(MainActivity.this, com.example.jankenpon.ResultActivity.class);
                //値を引き渡す(識別名,値)の順番で指定します
                intent.putExtra("choice_hand", "ぐー");
                //Activityを起動
                startActivity(intent);
            }
        });

        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.example.jankenpon.ResultActivity.class);

                intent.putExtra("choice_hand", "ちょき");

                startActivity(intent);
            }
        });

        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, com.example.jankenpon.ResultActivity.class);

                intent.putExtra("choice_hand", "ぱー");

                startActivity(intent);
            }
        });
    }

}
