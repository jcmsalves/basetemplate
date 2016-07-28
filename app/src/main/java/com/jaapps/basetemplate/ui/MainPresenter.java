package com.jaapps.basetemplate.ui;

import android.util.Log;

import com.jaapps.basetemplate.data.models.Sample;
import com.jaapps.basetemplate.data.remote.BackendService;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by joaoalves on 18/07/2016.
 */
public class MainPresenter implements Presenter<MainView> {

    private static final String TAG = MainPresenter.class.getSimpleName();

    private MainView mainView;

    @Override
    public void attachView(MainView mvpView) {
        this.mainView = mvpView;
    }

    @Override
    public void detachView() {
        this.mainView = null;
    }

    public void getData(int id) {

        BackendService.getInstance().getSample(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Sample>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG, "Failed to get sample" + e.toString());
                    }

                    @Override
                    public void onNext(Sample sample) {
                        mainView.showContent(sample.getTitle());
                    }
                });

    }

}
