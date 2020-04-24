package com.app.newsapplication.dashboard

interface DataSourceCallBack<T> {
    fun onSuccess(responseData: T)
    fun onError(errorMsg : String)
}