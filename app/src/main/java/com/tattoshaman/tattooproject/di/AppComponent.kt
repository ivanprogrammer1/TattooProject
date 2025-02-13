package com.tattoshaman.tattooproject.di

import com.tattoshaman.article_detail_impl.ArticleDetailVMFactory
import com.tattoshaman.articles_impl.ArticlesVMFactory
import com.tattoshaman.catalog_impl.CatalogVMFactory
import com.tattoshaman.core.utils.FileManager
import com.tattoshaman.data.room.AppDatabase
import com.tattoshaman.form_impl.FormVMFactory
import com.tattoshaman.sketch_impl.SketchVMFactory
import com.tattoshaman.tattoo_detail_impl.TattooDetailVMFactory
import com.tattoshaman.tattooproject.main.MainVMFactory
import dagger.BindsInstance
import dagger.Component
import dagger.Component.Builder
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,

        MainModule::class,
        ArticleDetailModule::class,
        ArticlesModule::class,
        CatalogModule::class,
        FormModule::class,
        SketchModule::class,
        TattooDetailModule::class
    ]
)
abstract class AppComponent {

    @Singleton
    abstract fun getMainVMFactory(): MainVMFactory

    @Singleton
    abstract fun getArticleDetailVMFactory(): ArticleDetailVMFactory

    @Singleton
    abstract fun getArticlesVMFactory(): ArticlesVMFactory

    @Singleton
    abstract fun getCatalogVMFactory(): CatalogVMFactory

    @Singleton
    abstract fun getFormVMFactory(): FormVMFactory

    @Singleton
    abstract fun getSketchVMFactory(): SketchVMFactory

    @Singleton
    abstract fun getTattooDetailVMFactory(): TattooDetailVMFactory

    @Builder
    interface AppComponentBuilder {
        @BindsInstance
        fun fileManager(value: FileManager): AppComponentBuilder

        @BindsInstance
        fun database(value: AppDatabase): AppComponentBuilder

        fun build(): AppComponent
    }
}