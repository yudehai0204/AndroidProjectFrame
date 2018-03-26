github地址:[点击跳转到Github](https://github.com/yudehai0204/AndroidProjectFrame)

#原因
 - 为了方便以后项目的使用
 - 项目中用的都还是比较古老的东西，mvc,volley等，搭建的过程中也学习一下新技术.
#如何使用And图片

	下载下来改个包名直接当新项目就可以啦
![这里写图片描述](https://img-blog.csdn.net/2018032617110820?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E5NDA2NTkzODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180326171315477?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E5NDA2NTkzODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180326171337568?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E5NDA2NTkzODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
本来不太需要上传图片 ，但不知道为什么就想传点。
数据来源是showapi  官网地址：[ShowAPi](https://www.showapi.com/)
#搭建过程 
	先介绍下用到的各种第三方库的版本号吧

**都在一个.build文件中**
```java
ext{

    dependVersion = [
            rxJava          : "2.1.11",
            rxAndroid       : "2.0.1",
            retrofit        :  "2.4.0",
            glide           : "4.6.1",
            support_version : "27.0.2"
    ]
    supportLib=[
            v7              : "com.android.support:appcompat-v7:$dependVersion.support_version",
            design          : "com.android.support:design:$dependVersion.support_version",
            recyclerview    : "com.android.support:recyclerview-v7:$dependVersion.support_version",
            cardview        : "com.android.support:cardview-v7:$dependVersion.support_version",
            annotations     : "com.android.support:support-annotations:$dependVersion.support_version"
    ]

    rxJava = [
            rxJava          : "io.reactivex.rxjava2:rxjava:$dependVersion.rxJava",
            rxAndroid       : "io.reactivex.rxjava2:rxandroid:$dependVersion.rxAndroid"
    ]
    retrofit=[
            retrofit        : "com.squareup.retrofit2:retrofit:$dependVersion.retrofit",
            retrofit_gson   : "com.squareup.retrofit2:converter-gson:$dependVersion.retrofit",
            retrofit_rxjava : "com.squareup.retrofit2:adapter-rxjava2:$dependVersion.retrofit",
            retrofit_log    : "com.squareup.okhttp3:logging-interceptor:3.4.1"
    ]
    glide=[
            glide           :"com.github.bumptech.glide:glide:$dependVersion.glide",
            glide_ok        :"com.github.bumptech.glide:okhttp3-integration:$dependVersion.glide",
    ]
    glideCompiler ="com.github.bumptech.glide:compiler:$dependVersion.glide"//没什么必要  只写上不引用

    rxJavaLibs = rxJava.values()
    retrofitLibs = retrofit.values()
    glideLibs = glide.values()
    supportLibs = supportLib.values()
}
```
**调用上代码的方法的代码**

```java
apply plugin: 'com.android.application'

android {
    compileSdkVersion 27
    defaultConfig {
        applicationId "com.project"
        minSdkVersion 17
        targetSdkVersion 24
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
    buildToolsVersion '26.0.2'
}

dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    //官方库
    implementation rootProject.ext.supportLibs
    //解析库
    implementation 'com.google.code.gson:gson:2.6.2'
    //RxJava
    implementation rootProject.ext.rxJavaLibs
    //Retrofit
    implementation rootProject.ext.retrofitLibs
    //Glide
    implementation rootProject.ext.glideLibs
    //SmartRefresh
    implementation 'com.scwang.smartrefresh:SmartRefreshLayout:1.1.0-alpha-1'
    //Leakcanary
    debugCompile 'com.squareup.leakcanary:leakcanary-android:1.3'
    releaseCompile 'com.squareup.leakcanary:leakcanary-android-no-op:1.3'
    //Log日志打印
    implementation 'com.orhanobut:logger:2.1.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.1'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.1'
    implementation project(':utilcode')
}

```
详细的东西可以在git上clone下来项目自己看看，

**SmartRefreshLayout**
很火的一个第三方下拉刷新上拉加载的第三方依赖库，
地址：[SmartRefreshLayout](https://github.com/scwang90/SmartRefreshLayout)

**然后就是核心类**

 - ApiService:  存放接口的类
 - RetrofitManager: 看名字就知道了 不多bb
使用这个类方式也简单 ：

```
RetrofitManager.getApiService()
                .getShowApiGifData(page,max_Results)
                .compose(new IoToMainTransformer());
```

 - MVP的三大基类（位于base包下）
	  - IBasePresenter 
	  - IBaseView
	  - BasePresenter
 使用方式在mvp包下。网上好多关于这方面文章  不太理解的自行google.

最后说下工具类，这个项目搭建的这么快主要就是工具类这个东东，很是发愁，本着死马活马医的本性在github上找到了一个依赖库,贼鸡儿全面的一个util工具类的库基本你能想到的都有，当我找到这个工具库的时候，ne脑海浮现的画面是一个抖音小哥的短视频，大家可以看看  ：[点我点我](https://www.douyin.com/share/video/6534232411012599047/?region=CN&mid=6534232444711275272&titleType=title&utm_source=copy_link&utm_campaign=client_share&utm_medium=android&share_app_name=aweme&share_iid=29028101748&timestamp=1522059810)
github地址：[AndroidUtil类](https://github.com/Blankj/AndroidUtilCode)
但是推荐大家下载下来代码放到项目里用，有什么自己的奇葩相关需求可以直接在代码里加，
比如什么Sp存登录信息，然后一键清空功能之类的。


#尾语
	
该介绍的都介绍完毕了。项目现在只是初步搭建完毕，以后如果什么技术比较新，比较好的话我还是会替换现在的东西的，大家喜欢的话就star下我的项目噢，接下来的计划就是：

 - 写一个Progress的工具类，比较好多网络清请求都是点击按钮进行的。
 - 封装一个Glide加载图片的进度条
 - 选一个比较好的第三方RecyclerViewAdapter的工具库
 - 等等等等

当然大家也可以fork一起维护，或者给一些什么建议，为的就是能过实现快速上手写项目吗。人多力量大，毕竟博主的脑容量就这个，ne 也不是 爱因斯坦，思考的还是不够全面滴。

最后再发一遍项目地址：[点ne(三声)点ne（三声）](https://github.com/yudehai0204/AndroidProjectFrame)


  
 



		

