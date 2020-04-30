package company.surious.domain

import company.surious.domain.use_case.GetSampleEntityUseCase
import org.koin.dsl.module

val useCasesModule = module {
    factory { GetSampleEntityUseCase(get()) }
}