package com.project.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 于德海 on 2018/3/21.
 * package com.project.base
 * email : yudehai0204@163.com
 *
 * @describe Presenter 基类
 */

public abstract class BasePresenter<T extends IBaseView> implements IBasePresenter<T>{
    public T rootView;
    public CompositeDisposable compositeDisposable = new CompositeDisposable();
    @Override
    public void attachView(T rootView) {
        this.rootView = rootView;
    }

    /***
     * 检测是否绑定
     */
    public void checkView(){
        if(rootView==null){
            throw  new RuntimeException("Please First Use attachView() in your project");
        }
    }

    /***
     *
     * @param disposable
     */
    public void addDisposable(Disposable disposable){
        compositeDisposable.add(disposable);
    }

    @Override
    public void detachView() {
        this.rootView = null;
        if(!compositeDisposable.isDisposed()){//取消Rxjava所有订阅
            compositeDisposable.clear();
        }
    }
}
