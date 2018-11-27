# EPermissions


代码量极少。并且非常简单。通过rxjava进行实现rxpermission


### 如何使用

#### 0. 集成

    implementation 'com.ccx1:EPermissions:1.0.1'

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


#### 1. 使用

    EPermissions.with(this)
                .request(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .subscribe(new Observer<Boolean>() {
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
                });'


### 注意点：

request方法传入的是一个可变参数

    request(String... permissions)