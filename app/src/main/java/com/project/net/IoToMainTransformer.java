package com.project.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.net
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class IoToMainTransformer implements ObservableTransformer {


    @Override
    public ObservableSource apply(Observable upstream) {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
