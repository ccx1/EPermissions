package com.android.epermissions.sample;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.epermissions.EPermissions;
import com.android.epermissions.sample.R;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author chicunxiang
 */
public class MainActivity extends AppCompatActivity {

    private EPermissions mEPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEPermissions = new EPermissions(this);
        mEPermissions.request(Manifest.permission.CAMERA).subscribe(new Observer<Boolean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                System.out.println(aBoolean);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mEPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
