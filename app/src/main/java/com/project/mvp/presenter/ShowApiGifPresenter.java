package com.project.mvp.presenter;

import com.project.base.BasePresenter;
import com.project.mvp.contract.ShowApiGifContract;
import com.project.mvp.model.ShowApiGifModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.mvp.presenter
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ShowApiGifPresenter extends BasePresenter<ShowApiGifContract.IView>implements ShowApiGifContract.IPresenter {

    private ShowApiGifModel model = new ShowApiGifModel();
    @Override
    public void getShowApiGifData(int page, int data_num) {
        checkView();
        Disposable disposable = model.getShowApiGifData(page,data_num).subscribe(new Consumer<ShowApiGifModel.Bean>() {
            @Override
            public void accept(ShowApiGifModel.Bean bean) throws Exception {
                rootView.initShowApiGifData(bean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                rootView.showError(throwable);
            }
        });
        addDisposable(disposable);
    }
}
