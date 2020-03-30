package com.example.popularrepo.remote

import com.example.popularrepo.data.Repo
import io.reactivex.Single
import retrofit2.http.GET
import rx.Observable

public interface NetworkService {

    @GET("/repositories?language=&since=daily&spoken_language_code=")
    fun getPopularRepo() : Single<Repo>
}