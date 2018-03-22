package com.project.mvp.contract;

import com.project.base.IBasePresenter;
import com.project.base.IBaseView;
import com.project.mvp.model.ShowApiModel;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.mvp.contract
 * email : yudehai0204@163.com
 *
 * @describe
 */

public interface ShowApiContract {

    interface IView extends IBaseView{
        void initShowApiData(ShowApiModel.Bean bean);

    }
    interface IPresenter extends IBasePresenter<IView>{
        /***
         *
         * @param page 页数
         * @param data_num 每页数量
         */
        void getShowApiData(int page,int data_num);
    }
}
