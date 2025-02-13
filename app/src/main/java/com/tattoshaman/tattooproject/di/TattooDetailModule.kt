package com.tattoshaman.tattooproject.di

import com.tattoshaman.domain.repository.TattooRepository
import com.tattoshaman.tattoo_detail_impl.GetTattooUseCase
import com.tattoshaman.tattoo_detail_impl.TattooDetailVMFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TattooDetailModule {
    @Provides
    @Singleton
    fun provideGetTattooUseCase(tattooRepository: TattooRepository): GetTattooUseCase {
        return GetTattooUseCase(tattooRepository)
    }

    @Provides
    @Singleton
    fun provideVMFactory(getTattooUseCase: GetTattooUseCase): TattooDetailVMFactory {
        return TattooDetailVMFactory(getTattooUseCase)
    }
}