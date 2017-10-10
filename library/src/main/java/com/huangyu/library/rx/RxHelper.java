package com.huangyu.library.rx;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by huangyu on 2017/10/10.
 */

public class RxHelper {

    public RxHelper() {
    }

    public static <T> Observable.Transformer<T, T> handleResult() {
        return new Observable.Transformer<T, T>() {
            public Observable<T> call(Observable<T> mObservable) {
                return mObservable.flatMap(new Func1<T, Observable<T>>() {
                    public Observable<T> call(T jsonBean) {
                        return RxHelper.createData(jsonBean);
                    }
                }).subscribeOn(Schedulers.io()).unsubscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    private static <T> Observable<T> createData(final T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }

}