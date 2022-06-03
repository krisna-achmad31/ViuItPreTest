package id.krisna.viuit.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.krisna.viuit.application.AppPreference
import id.krisna.viuit.network.IRetrofitService
import id.krisna.viuit.repository.AppRepository
import id.krisna.viuit.repository.AuthRepository
import id.krisna.viuit.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideAppRepository(retrofitService: IRetrofitService, appPreference: AppPreference): AppRepository {
        return AppRepository(retrofitService, appPreference)
    }

    @Singleton
    @Provides
    fun provideAuthRepository(retrofitService: IRetrofitService, appPreference: AppPreference): AuthRepository {
        return AuthRepository(retrofitService, appPreference)
    }

    @Singleton
    @Provides
    fun provideUserRepository(retrofitService: IRetrofitService, appPreference: AppPreference): UserRepository {
        return UserRepository(retrofitService, appPreference)
    }
}