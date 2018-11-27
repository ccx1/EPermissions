# EPermissions


代码量极少。并且非常简单。通过rxjava进行实现rxpermission


### 如何使用



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