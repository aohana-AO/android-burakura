package com.example.burakura2;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.DigitalClock;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Button;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static long START_TIME = 0;

    private int web=0;
    private TextView mTextViewCountDown;

    private TextView mTextViewCountDown2;
    private TextClock mTextViewCountDown3;
    private  TextClock mTextViewCountDown4;
    private DigitalClock mTextViewCountDown5;
    private ImageView img;

    private Button mButtonStartPause;
    private Button getmButtonReset;
    private Button getmButtonkousinnhunn;
    private Button getmButtonkousinnbyou;
    private Button getmButtonhunnmaina;
    private Button getmButtonbyoumaina;
    private Button getmButtonsyoki;
    private Button getButtonjikapura;
    private Button getButtonjikamaina;


    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private int minutesg;
    private int secondsg;
    private int jikann;

    private long mTimeLeftInMillis = START_TIME;
    private long mTimeLeftInMillis2;


    WebView myWebView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("mTimerRunningの初期値は？ " + mTimerRunning);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTextViewCountDown = findViewById(R.id.text_view_countdown);

        mTextViewCountDown2 = findViewById(R.id.text_view_countdown2);
        mTextViewCountDown3 = findViewById(R.id.tokei);
        mTextViewCountDown4 = findViewById(R.id.tokei2);
        mTextViewCountDown5 = findViewById(R.id.tokei3);
        img = findViewById(R.id.img);

        mButtonStartPause = findViewById(R.id.button_start_pause);
        getmButtonReset = findViewById(R.id.buttonreset);
        getmButtonkousinnbyou = findViewById(R.id.buttonbyou);
        getmButtonkousinnhunn = findViewById(R.id.buttonhunn);
        getmButtonhunnmaina = findViewById(R.id.buttonhunnmaina);
        getmButtonbyoumaina = findViewById(R.id.buttonbyoumaina);
        getmButtonsyoki = findViewById(R.id.buttonriseto0);
        getButtonjikapura = findViewById(R.id.buttonjikannpura);
        getButtonjikamaina = findViewById(R.id.buttonjikannmaina);



        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("mTimerRunningの値は？ " + mTimerRunning);
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();

                    web++;
                    if(web==3){

                        mButtonStartPause.setVisibility(View.INVISIBLE);
                        mTimerRunning = true;

                        getmButtonReset.setVisibility(View.INVISIBLE);
                        getmButtonkousinnbyou.setVisibility(View.INVISIBLE);
                        getmButtonkousinnhunn.setVisibility(View.INVISIBLE);
                        getmButtonbyoumaina.setVisibility(View.INVISIBLE);
                        getmButtonhunnmaina.setVisibility(View.INVISIBLE);
                        getButtonjikamaina.setVisibility(View.INVISIBLE);
                        getButtonjikapura.setVisibility(View.INVISIBLE);
                        getmButtonsyoki.setVisibility(View.INVISIBLE);
                        mTextViewCountDown.setVisibility(View.INVISIBLE);
                        mTextViewCountDown2.setVisibility(View.INVISIBLE);
                        mTextViewCountDown3.setVisibility(View.INVISIBLE);
                        mTextViewCountDown4.setVisibility(View.INVISIBLE);
                        mTextViewCountDown5.setVisibility(View.INVISIBLE);
                        img.setVisibility(View.INVISIBLE);
                        // WebView呼び出し
                        myWebView = (WebView) findViewById(R.id.webView);
                        myWebView.setBackgroundColor(0);//ここ追加、透明化わからん
                        myWebView.setWebViewClient(new WebViewClient());
                        myWebView.loadUrl("file:///android_asset/burakura1.html"); // ローカルのhtmlファイルを指定
                        // WebView内のJavaScriptの実行を許可
                        myWebView.getSettings().setJavaScriptEnabled(true);


                    }
                }
            }
        });

        getmButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        getmButtonkousinnhunn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kousinn();
            }
        });
        getmButtonkousinnbyou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kousinn2();
            }
        });
        getmButtonhunnmaina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kousinn3();
            }
        });
        getmButtonbyoumaina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kousinn4();
            }
        });
        getmButtonsyoki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                syoki();
            }
        });
        getButtonjikapura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kousinn5();
            }
        });
        getButtonjikamaina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kousinn6();
            }
        });

        updateCountDownText();
    }


    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("スタート");
                getmButtonReset.setVisibility(View.INVISIBLE);


            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("一時停止");
        getmButtonReset.setVisibility(View.INVISIBLE);
        getmButtonkousinnbyou.setVisibility(View.INVISIBLE);
        getmButtonkousinnhunn.setVisibility(View.INVISIBLE);
        getmButtonbyoumaina.setVisibility(View.INVISIBLE);
        getmButtonhunnmaina.setVisibility(View.INVISIBLE);
        getButtonjikamaina.setVisibility(View.INVISIBLE);
        getButtonjikapura.setVisibility(View.INVISIBLE);
        getmButtonsyoki.setVisibility(View.INVISIBLE);

    }

    private void pauseTimer() {
        System.out.println("一時停止処理前のmTimerRunningは？ " + mTimerRunning);
        mCountDownTimer.cancel();
        mTimerRunning = false;
        System.out.println("一時停止処理後のmTimerRunningは？ " + mTimerRunning);
        mButtonStartPause.setText("スタート");
        getmButtonReset.setVisibility(View.VISIBLE);
        getmButtonkousinnbyou.setVisibility(View.VISIBLE);
        getmButtonkousinnhunn.setVisibility(View.VISIBLE);
        getmButtonbyoumaina.setVisibility(View.VISIBLE);
        getmButtonhunnmaina.setVisibility(View.VISIBLE);
        getButtonjikamaina.setVisibility(View.VISIBLE);
        getButtonjikapura.setVisibility(View.VISIBLE);
        getmButtonsyoki.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = mTimeLeftInMillis2;
        updateCountDownText2();
        mButtonStartPause.setVisibility(View.VISIBLE);
        getmButtonReset.setVisibility(View.INVISIBLE);
    }

    private void kousinn() {

        mTimeLeftInMillis += 60000;
        mTimeLeftInMillis2 = mTimeLeftInMillis;
        int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
        jikann = jikann2;
        minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
        secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
        mTextViewCountDown.setText(timerLeftFormatted);
        getmButtonkousinnhunn.setVisibility(View.VISIBLE);
        getmButtonkousinnbyou.setVisibility(View.VISIBLE);
    }

    private void kousinn2() {

        mTimeLeftInMillis += 1000;
        mTimeLeftInMillis2 = mTimeLeftInMillis;
        int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
        jikann = jikann2;
        minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
        secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
        mTextViewCountDown.setText(timerLeftFormatted);
        getmButtonkousinnhunn.setVisibility(View.VISIBLE);
        getmButtonkousinnbyou.setVisibility(View.VISIBLE);
    }

    private void kousinn3() {
        if (mTimeLeftInMillis >= 60000) {
            mTimeLeftInMillis -= 60000;
            mTimeLeftInMillis2 = mTimeLeftInMillis;
            int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
            jikann = jikann2;
            minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
            secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
            String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
            mTextViewCountDown.setText(timerLeftFormatted);
            getmButtonkousinnhunn.setVisibility(View.VISIBLE);
            getmButtonkousinnbyou.setVisibility(View.VISIBLE);
        }
    }

    private void kousinn4() {

        if (mTimeLeftInMillis >= 1000) {
            mTimeLeftInMillis -= 1000;
            mTimeLeftInMillis2 = mTimeLeftInMillis;
            int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
            jikann = jikann2;
            minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
            secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
            String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
            mTextViewCountDown.setText(timerLeftFormatted);
            getmButtonkousinnhunn.setVisibility(View.VISIBLE);
            getmButtonkousinnbyou.setVisibility(View.VISIBLE);
        }
    }

    private void kousinn5() {

        mTimeLeftInMillis += 3600000;
        mTimeLeftInMillis2 = mTimeLeftInMillis;
        int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
        jikann = jikann2;
        minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
        secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
        mTextViewCountDown.setText(timerLeftFormatted);
        getmButtonkousinnhunn.setVisibility(View.VISIBLE);
        getmButtonkousinnbyou.setVisibility(View.VISIBLE);
    }

    private void kousinn6() {
        if (mTimeLeftInMillis >= 3600000) {
            mTimeLeftInMillis -= 3600000;
            mTimeLeftInMillis2 = mTimeLeftInMillis;
            int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
            jikann = jikann2;
            minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
            secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
            String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
            mTextViewCountDown.setText(timerLeftFormatted);
            getmButtonkousinnhunn.setVisibility(View.VISIBLE);
            getmButtonkousinnbyou.setVisibility(View.VISIBLE);
        }
    }

    private void syoki() {

        mTimeLeftInMillis = 0;
        mTimeLeftInMillis2 = mTimeLeftInMillis;
        int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
        jikann = jikann2;
        minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
        secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
        mTextViewCountDown.setText(timerLeftFormatted);

    }

    private void updateCountDownText() {
        int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
        jikann = jikann2;
        minutesg = (int) ((mTimeLeftInMillis / 1000) / 60) - (jikann2 * 60);
        secondsg = (int) (mTimeLeftInMillis / 1000) % 60;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
        mTextViewCountDown.setText(timerLeftFormatted);
    }

    private void updateCountDownText2() {
        int jikann2 = (int) ((mTimeLeftInMillis / 1000) / 3600);
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        jikann = jikann2;
        minutesg = minutes;
        secondsg = seconds;
        String timerLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d:%02d", jikann, minutesg, secondsg);
        mTextViewCountDown.setText(timerLeftFormatted);
    }
}
