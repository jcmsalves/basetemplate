package com.jaapps.basetemplate.ui;

public interface Presenter<V> {

    void attachView(V mvpView);

    void detachView();
}
