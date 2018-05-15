package io.boscoin.toknenet.wallet;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        mContext = this;

        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView ti = findViewById(R.id.title);
        ti.setText(R.string.title_activity_settings);

       //getAppVersion();
       TextView tvVersion = findViewById(R.id.tv_version);
       tvVersion.setText("BOScoin wallet Version: "+getAppVersion());
    }

    private String getAppVersion() {
        PackageInfo pinfo = null;
        String version ="";
        PackageManager packageManager = mContext.getPackageManager();

        try {
            pinfo =  packageManager.getPackageInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
            version = pinfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return version+"v";
    }

    public void changeOrder(View view) {
        Intent it = new Intent(SettingActivity.this, WalletOrderActivity.class);
        it.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT);
        startActivity(it);
    }

    public void changeLanguage(View view) {

    }

    public void viewPreCaution(View view) {
        Intent it = new Intent(SettingActivity.this, PreCautionOneActivity.class);
        startActivity(it);
    }
}
