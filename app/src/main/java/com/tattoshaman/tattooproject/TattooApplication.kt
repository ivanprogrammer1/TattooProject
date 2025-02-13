package com.tattoshaman.tattooproject

import android.app.Application
import com.tattoshaman.article_detail_impl.ArticleDIProvider
import com.tattoshaman.articles_impl.ArticlesDIProvider
import com.tattoshaman.catalog_impl.CatalogDIProvider
import com.tattoshaman.core.utils.FileManager
import com.tattoshaman.data.room.AppDatabase
import com.tattoshaman.form_impl.FormDIProvider
import com.tattoshaman.sketch_impl.SketchDIProvider
import com.tattoshaman.tattoo_detail_impl.TattooDetailDIProvider
import com.tattoshaman.tattooproject.di.AppComponent
import com.tattoshaman.tattooproject.di.DaggerAppComponent
import com.tattoshaman.tattooproject.main.MainDIProvider

class TattooApplication : Application() {
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initDI()
    }

    fun initDI() {
        val database = AppDatabase.create(applicationContext)
        val fileManager = FileManager(applicationContext)
        appComponent =
            DaggerAppComponent.builder().database(database).fileManager(fileManager).build()

        //Initialise VM factories
        MainDIProvider.viewModelFactory = appComponent.getMainVMFactory()
        ArticleDIProvider.viewModelFactory = appComponent.getArticleDetailVMFactory()
        ArticlesDIProvider.viewModelFactory = appComponent.getArticlesVMFactory()
        CatalogDIProvider.viewModelFactory = appComponent.getCatalogVMFactory()
        FormDIProvider.viewModelFactory = appComponent.getFormVMFactory()
        SketchDIProvider.viewModelFactory = appComponent.getSketchVMFactory()
        TattooDetailDIProvider.viewModelFactory = appComponent.getTattooDetailVMFactory()
    }
}