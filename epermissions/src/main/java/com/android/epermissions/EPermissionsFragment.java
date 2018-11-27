package com.android.epermissions;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

/**
 * @author ccx
 * create time 2018/11/27
 */
public class EPermissionsFragment extends Fragment {

    private static final int PERMISSIONS_REQUEST_CODE = 1002;

    private Map<String, PublishSubject<Permission>> mSubjectMap = new HashMap<>();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != PERMISSIONS_REQUEST_CODE) {
            return;
        }
        Schedulers.io().createWorker().schedule(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < permissions.length; i++) {
                    String                     permission = permissions[i];
                    PublishSubject<Permission> subject    = mSubjectMap.get(permission);
                    if (subject == null) {
                        return;
                    }
                    mSubjectMap.remove(permission);
                    boolean granted = grantResults[i] == PackageManager.PERMISSION_GRANTED;
                    subject.onNext(new Permission(permissions[i], granted));
                    subject.onComplete();
                }
            }
        });

    }


    public PublishSubject<Permission> get(String permission) {
        return mSubjectMap.get(permission);
    }

    public void put(String permission, PublishSubject<Permission> subject) {
        mSubjectMap.put(permission, subject);
    }

    public void requestPermissions(String[] unRequest) {
        requestPermissions(unRequest, PERMISSIONS_REQUEST_CODE);
    }

}
