package com.example.popularrepo.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.popularrepo.ui.main.RepoViewModel
import com.example.popularrepo.ui.main.RepoViewModelFactory
import com.example.popularrepo.ui.main.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindviewModelFactory(factory: RepoViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(RepoViewModel::class)
    internal abstract fun postRepoViewModel(viewModel: RepoViewModel): ViewModel

}