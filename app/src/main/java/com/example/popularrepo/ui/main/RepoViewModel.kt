package com.example.popularrepo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.popularrepo.data.DataRepository
import com.example.popularrepo.data.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class RepoViewModel @Inject constructor(private val dataRepository: DataRepository): ViewModel() {
    private val repoMutableLiveData = MutableLiveData<Repo>()
    private val disposable = CompositeDisposable()

    fun getRepoMutableLiveData():MutableLiveData<Repo>{
        loadData()
        return repoMutableLiveData
    }

    private fun loadData() {
        disposable.add(
            dataRepository.popularRepo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Repo?>() {
                    override fun onSuccess(userModel: Repo) {
                        getRepoMutableLiveData().setValue(userModel)
                    }

                    override fun onError(e: Throwable) {}
                })
        )

    }

}