# EPermissions


代码量极少。并且非常简单。通过rxjava进行实现rxpermission


### 如何使用

#### 0. 集成

    implementation 'com.ccx1:EPermissions:1.0.0'

如果报错,请在project中的build.gradle中加入

    allprojects {
        repositories {
            jcenter()
            maven {url 'https://dl.bintray.com/ci250454344/EPermissions'}
        }
    }

如果没有rxjava与rxandroid，则得先集成

    implementation "io.reactivex.rxjava2:rxandroid:lastVersion"
    implementation "io.reactivex.rxjava2:rxjava:lastVersion"


#### 1. 初始化

        mEPermissions = new EPermissions(this);

#### 2. 请求权限

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


#### 3. 请求回调

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            mEPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }