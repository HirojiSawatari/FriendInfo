package edu.njnu.friendinfo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Sawatari on 2017/1/26.
 */

public class SplashScreen extends Activity {
    /** Called when the activity is first created. */

    private SharedPreferences fromInfo;

    @Override
    //界面样式
    public void onCreate(Bundle icicle){
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(icicle);
        getWindow().setFormat(PixelFormat.RGBA_8888);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DITHER);
        setContentView(R.layout.splash_screen);

        //恢复sp值为0
        fromInfo = this.getSharedPreferences("fromInfo.xml", 0);	//开启sp
        SharedPreferences.Editor editor = fromInfo.edit();
        editor.putInt("code", 0);
        editor.commit();

        new Handler().postDelayed(new Runnable(){
            public void run(){
                Intent mainIntent = new Intent(SplashScreen.this, UserLogin.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        },3000);
    }
}