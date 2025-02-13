package com.tattoshaman.tattooproject.di

import com.tattoshaman.data.repository.ArticlesRepositoryImpl
import com.tattoshaman.data.repository.FormRepositoryImpl
import com.tattoshaman.data.repository.SketchRepositoryImpl
import com.tattoshaman.data.repository.TattooCategoryRepositoryImpl
import com.tattoshaman.data.repository.TattooRepositoryImpl
import com.tattoshaman.data.room.AppDatabase
import com.tattoshaman.data.room.dao.SketchDao
import com.tattoshaman.data.room.storage.ArticlesStorageImpl
import com.tattoshaman.data.room.storage.FormStorageImpl
import com.tattoshaman.data.room.storage.SketchesStorageImpl
import com.tattoshaman.data.room.storage.TattooCategoryStorageImpl
import com.tattoshaman.data.room.storage.TattooStorageImpl
import com.tattoshaman.data.storage.ArticlesStorage
import com.tattoshaman.data.storage.FormStorage
import com.tattoshaman.data.storage.SketchStorage
import com.tattoshaman.data.storage.TattooCategoryStorage
import com.tattoshaman.data.storage.TattooStorage
import com.tattoshaman.domain.repository.ArticlesRepository
import com.tattoshaman.domain.repository.FormRepository
import com.tattoshaman.domain.repository.SketchRepository
import com.tattoshaman.domain.repository.TattooCategoryRepository
import com.tattoshaman.domain.repository.TattooRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    //Storages
    @Singleton
    @Provides
    fun provideSketchStorage(appDatabase: AppDatabase): SketchStorage{
        return SketchesStorageImpl(appDatabase.getSketchDao())
    }

    @Singleton
    @Provides
    fun provideFormStorage(appDatabase: AppDatabase): FormStorage {
        return FormStorageImpl(appDatabase.getFormDao())
    }

    @Singleton
    @Provides
    fun provideArticlesStorage(appDatabase: AppDatabase): ArticlesStorage {
        return ArticlesStorageImpl(appDatabase.getArticleDao())
    }

    @Singleton
    @Provides
    fun providerTattooStorage(appDatabase: AppDatabase): TattooStorage {
        return TattooStorageImpl(appDatabase.getTattooDao())
    }

    @Singleton
    @Provides
    fun providerTattooCategoryStorage(appDatabase: AppDatabase): TattooCategoryStorage {
        return TattooCategoryStorageImpl(appDatabase.getTattooCategoryDao())
    }

    //Repositories
    @Singleton
    @Provides
    fun provideSketchRepository(sketchStorage: SketchStorage): SketchRepository {
        return SketchRepositoryImpl(sketchStorage)
    }

    @Singleton
    @Provides
    fun provideTattooRepository(tattooStorage: TattooStorage): TattooRepository {
        return TattooRepositoryImpl(tattooStorage)
    }

    @Singleton
    @Provides
    fun provideTattooCategoryRepository(tattooCategoryStorage: TattooCategoryStorage): TattooCategoryRepository {
        return TattooCategoryRepositoryImpl(tattooCategoryStorage)
    }

    @Singleton
    @Provides
    fun provideArticlesRepository(articlesStorage: ArticlesStorage): ArticlesRepository {
        return ArticlesRepositoryImpl(articlesStorage)
    }

    @Singleton
    @Provides
    fun provideFormRepository(formStorage: FormStorage): FormRepository {
        return FormRepositoryImpl(formStorage)
    }
}