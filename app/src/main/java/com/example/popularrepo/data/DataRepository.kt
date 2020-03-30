package com.example.popularrepo.data

import com.example.popularrepo.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class DataRepository @Inject constructor(private val networkService: NetworkService) {

    fun popularRepo(): Single<Repo> {
        return networkService.getPopularRepo()
    }

}