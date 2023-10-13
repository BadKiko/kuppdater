package com.kiko.kuppdater.data.update.json.module

import com.kiko.kuppdater.data.update.json.remote.api.UpdateJsonApi
import com.kiko.kuppdater.data.update.json.repository.UpdateJsonRepositoryImpl
import com.kiko.kuppdater.domain.update.json.repository.UpdateJsonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UpdateJsonModule {
    @ViewModelScoped
    @Provides
    fun provideArticleApi(retrofit: Retrofit): UpdateJsonApi {
        return retrofit.create(UpdateJsonApi::class.java)
    }

    @ViewModelScoped
    @Provides
    fun provideUpdateJsonRepository(updateJsonApi: UpdateJsonApi): UpdateJsonRepository {
        return UpdateJsonRepositoryImpl(updateJsonApi)
    }
}