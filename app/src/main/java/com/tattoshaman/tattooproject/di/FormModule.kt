package com.tattoshaman.tattooproject.di

import com.tattoshaman.domain.repository.FormRepository
import com.tattoshaman.domain.repository.SketchRepository
import com.tattoshaman.domain.repository.TattooRepository
import com.tattoshaman.form_impl.FormVMFactory
import com.tattoshaman.form_impl.GetSketchUseCase
import com.tattoshaman.form_impl.GetTattooUseCase
import com.tattoshaman.form_impl.SendFormUseCase
import dagger.Module
import dagger.Provides

@Module
class FormModule {
    @Provides
    fun provideSendFormUseCase(formRepository: FormRepository): SendFormUseCase {
        return SendFormUseCase(
            formRepository = formRepository
        )
    }

    @Provides
    fun provideGetSketchUseCase(sketchRepository: SketchRepository): GetSketchUseCase {
        return GetSketchUseCase(
            sketchRepository = sketchRepository
        )
    }

    @Provides
    fun provideGetTattooUseCase(tattooRepository: TattooRepository): GetTattooUseCase {
        return GetTattooUseCase(
            tattooRepository = tattooRepository
        )
    }

    @Provides
    fun provideVMFactory(
        sendFormUseCase: SendFormUseCase,
        getSketchUseCase: GetSketchUseCase,
        getTattooUseCase: GetTattooUseCase
    ): FormVMFactory {
        return FormVMFactory(
            sendFormUseCase = sendFormUseCase,
            getSketchUseCase = getSketchUseCase,
            getTattooUseCase = getTattooUseCase
        )
    }
}