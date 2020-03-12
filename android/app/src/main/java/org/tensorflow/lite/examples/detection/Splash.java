package org.tensorflow.lite.examples.detection;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Splash extends AppCompatActivity {
    private ImageView iv;
    TextView tv;
    Animation a,a2;
    public Window window;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP) {
            window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.nav));
        }
        tv = findViewById(R.id.text);
        iv = findViewById(R.id.fullscreen_content);
        a = AnimationUtils.loadAnimation(this,R.anim.myalpha);
        iv.startAnimation(a);
        tv.startAnimation(a);


        Thread t = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4050);
                        Intent homeIntent = new Intent(Splash.this, DetectorActivity.class);
                        startActivity(homeIntent);
                        finish();
                }
                catch (Exception e){e.printStackTrace();}
            }
        };
        t.start();
    }
}
