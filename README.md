github地址:[点击跳转到Github](https://github.com/yudehai0204/AndroidProjectFrame)

# 原因
 - 为了方便以后项目的使用
 - 项目中用的都还是比较古老的东西，mvc,volley等，搭建的过程中也学习一下新技术.
# 组成
 - 采用MVP模式 
 - 集成butterknife(推荐跟Butterknife Zelezny 配合使用)
 - BRAVH（[点我查看具体使用方式](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)）
 - RxJAVA+Retrofit2+Glide
 - SmartRefreshLayout([点我查看使用](https://github.com/scwang90/SmartRefreshLayout)) 个人比较喜欢用SwipeRefresh
 - Material Dialog([点我查看使用](https://github.com/afollestad/material-dialogs)) 推荐以model方式导入
 - Gson 解析（推荐配合GsonFormat使用）
 - 屏幕适配采用Smallest Width（最小宽度）
# 使用
下载下来改个包名直接当新项目就可以啦
![这里写图片描述](https://img-blog.csdn.net/2018032617110820?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E5NDA2NTkzODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180326171315477?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E5NDA2NTkzODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
![这里写图片描述](https://img-blog.csdn.net/20180326171337568?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L2E5NDA2NTkzODc=/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
时间太长了 现在可能已经没有图片跟这个笑话了  应该是申请的key过期了
# 详细介绍 

## 主要依赖
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


 ## MVP的三大基类（位于base包下）
	  - IBasePresenter 
	  - IBaseView
	  - BasePresenter
 使用方式在mvp包下。网上好多关于这方面文章  不太理解的自行google.（对于mvp 每个技术人的理解都不一样，只要能达到完美解耦就可以，不用过于追求同步）
## Util类介绍
 - DisplayUtils: 获取屏幕尺寸 dp2sp 等；
 - EncodeUtils: 编码类。utf-8的转码解码等
 - GlideUtils: 把图片加载封装起来。
 - MaterialDesignDialogUtils: 把几个比较通用的弹窗封装起来；
 - SPUtils: 顾名思义  sp存储类；
 - StatusBarUtil:状态栏的设置类;
 - ToastManager: 封装了toast跟snackBar;
 - 其他后续添加。




# 尾语
	
时代再进步，现在的时代已经不是一个人单干的时代了，要紧跟时代的步伐，能站在巨人的肩膀上就站在巨人的肩膀上，所以很多这个很多都是将各种最实用的第三方库搭建到一起，对于变动比较大的，推荐以model方式集成到项目中，如：material-dialogs 或者相册选择之类的。

项目会继续更新的 伴随google的io大会新技术同步更新。

最后再发一遍项目地址：[点我直达](https://github.com/yudehai0204/AndroidProjectFrame)


  
 



		
