package com.yu.moveevnet.broadcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String Action = "recever";
    public static final String MSG = "message";
    private Button button;
    private Activity mInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mInstance = this;
        initView();
        IntentFilter intentFilter = new IntentFilter(Action);
        registerReceiver(BR, intentFilter);
    }

    private void initView() {
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(Action);
                intent.putExtra(MSG, "Hi,I send a message!");
                sendBroadcast(intent);
                break;
        }
    }

    BroadcastReceiver BR = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(Action)) {
                String message = intent.getStringExtra(MSG);
                button.setText(message);
            }
        }
    };

    @Override
    protected void onDestroy() {
        unregisterReceiver(BR);
        super.onDestroy();
    }
}
