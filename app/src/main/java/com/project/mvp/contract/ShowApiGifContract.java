package com.project.mvp.contract;

import com.project.base.IBasePresenter;
import com.project.base.IBaseView;
import com.project.mvp.model.ShowApiGifModel;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.mvp.contract
 * email : yudehai0204@163.com
 *
 * @describe
 */

public interface ShowApiGifContract {

    interface IView extends IBaseView{
        void initShowApiGifData(ShowApiGifModel.Bean bean);

    }
    interface IPresenter extends IBasePresenter<IView>{
        /***
         *
         * @param page 页数
         * @param data_num 每页数量
         */
        void getShowApiGifData(int page, int data_num);
    }
}
