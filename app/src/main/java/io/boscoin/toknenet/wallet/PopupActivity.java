package io.boscoin.toknenet.wallet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import io.boscoin.toknenet.wallet.conf.Constants;

public class PopupActivity extends AppCompatActivity {

    private String isRecover, mKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView ti = findViewById(R.id.title);
        ti.setText(R.string.t_new_pw);

        Intent it = getIntent();
        isRecover = it.getStringExtra(Constants.Invoke.RECOVER_WALLET);
        mKey = it.getStringExtra(Constants.Invoke.KEY);
    }

    public void newWallet(View view) {
        Intent it = new Intent(PopupActivity.this, CreateWalletActivity.class);
        it.putExtra(Constants.Invoke.RECOVER_WALLET, "seedkey-recover");
        it.putExtra(Constants.Invoke.KEY, mKey);
        startActivity(it);
    }
}
