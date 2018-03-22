package com.project.mvp.model;

import com.project.net.IoToMainTransformer;
import com.project.net.RetrofitManager;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by 于德海 on 2018/3/22.
 * package com.project.mvp.model
 * email : yudehai0204@163.com
 *
 * @describe
 */

public class ShowApiModel {

    public class Bean{
        private int showapi_res_code;
        private Body showapi_res_body;

        public int getShowapi_res_code() {
            return showapi_res_code;
        }

        public void setShowapi_res_code(int showapi_res_code) {
            this.showapi_res_code = showapi_res_code;
        }

        public Body getShowapi_res_body() {
            return showapi_res_body;
        }

        public void setShowapi_res_body(Body showapi_res_body) {
            this.showapi_res_body = showapi_res_body;
        }

        public class Body{
            private List<Content> contentlist;

            public List<Content> getContentlist() {
                return contentlist;
            }

            public void setContentlist(List<Content> contentlist) {
                this.contentlist = contentlist;
            }

            public class Content{
                private String title;
                private String text;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }
            }
        }
    }

    public Observable<Bean> getShowApiData(int page, int max_Results){
        return RetrofitManager.getApiService()
                .getShowApiData(page,max_Results)
                .compose(new IoToMainTransformer());
    }
}
