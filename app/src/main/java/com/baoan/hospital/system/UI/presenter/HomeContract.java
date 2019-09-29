package com.baoan.hospital.system.UI.presenter;

import com.baoan.hospital.system.UI.BasePresenter;
import com.baoan.hospital.system.UI.BaseView;
import com.baoan.hospital.system.UI.data.XH;

import java.util.List;

/**
 * Discription:
 * Created by guokun on 2019/9/29.
 */
public interface HomeContract {
    interface View extends BaseView<Presenter> {
        void showData(List<XH> xhs);
    }

    interface Presenter extends BasePresenter {
//        void loadData();
    }
}
