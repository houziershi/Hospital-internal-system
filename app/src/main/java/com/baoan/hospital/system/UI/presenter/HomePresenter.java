package com.baoan.hospital.system.UI.presenter;


import com.baoan.hospital.system.UI.data.XH;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Discription:
 * Created by guokun on 2019/9/29.
 */
public class HomePresenter implements HomeContract.Presenter {
    private final HomeContract.View view;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public HomePresenter(HomeContract.View view) {
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        /**Created by guokun on 2019/9/29.
         * Description: 加载数据*/
        compositeDisposable.add(Observable.create(new ObservableOnSubscribe<List<XH>>() {
            @Override
            public void subscribe(ObservableEmitter<List<XH>> observableEmitter) throws Exception {
                /**Created by guokun on 2019/9/29.
                 * Description: 网络请求*/
                List<XH> xhs = new ArrayList<>();
                for (int i = 0; i < 200; i++) {
                    XH xh = new XH("1", "xh");
                    xhs.add(xh);
                }
                observableEmitter.onNext(xhs);
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<XH>>() {
                    @Override
                    public void onNext(List<XH> xhs) {
                        view.showData(xhs);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }));
    }
}
