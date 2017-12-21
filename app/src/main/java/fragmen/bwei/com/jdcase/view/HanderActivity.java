package fragmen.bwei.com.jdcase.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import fragmen.bwei.com.jdcase.R;


public class HanderActivity extends AppCompatActivity {
    private int progress = 5;
 Handler handler = new Handler(){
     @Override
    public void handleMessage(Message msg) {
        if(progress == 1){
            Intent intent = new Intent(HanderActivity.this, ShowActivity.class);
            startActivity(intent);
            HanderActivity.this.finish();
        }
    }
};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hander);

      /*  //取出状态值进行判断,查看是否是第一次登录
        final boolean ischeck = handle.getBoolean("ischeck", true);
        Log.d("------------------",ischeck+"");*/
        //创建编辑


        new Thread(){
            @Override
            public void run() {
                super.run();
                while (progress > 0) {
                    try {
                        sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress--;
                    handler.sendEmptyMessage(progress);
                }
            }
        }.start();
       /* if(ischeck){

            edit.putBoolean("ischeck",false);
            edit.commit();
            Log.d("------------------",ischeck+"");

        }else{
          *//* Intent intent = new Intent(HanderActivity.this, ShowActivity.class);
            startActivity(intent);
            finish();*//*
        }*/



    }

}
