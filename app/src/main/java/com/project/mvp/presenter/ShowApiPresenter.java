package com.project.mvp.presenter;

import com.project.base.BasePresenter;
import com.project.mvp.contract.ShowApiContract;
import com.project.mvp.model.ShowApiModel;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.mvp.presenter
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ShowApiPresenter extends BasePresenter<ShowApiContract.IView>implements ShowApiContract.IPresenter {

    private ShowApiModel model = new ShowApiModel();
    @Override
    public void getShowApiData(int page, int data_num) {
        checkView();
        Disposable disposable = model.getShowApiData(page,data_num).subscribe(new Consumer<ShowApiModel.Bean>() {
            @Override
            public void accept(ShowApiModel.Bean bean) throws Exception {
                rootView.initShowApiData(bean);
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
