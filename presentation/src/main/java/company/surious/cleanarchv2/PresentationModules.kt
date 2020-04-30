package company.surious.cleanarchv2

import company.surious.cleanarchv2.sample.SampleViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel { SampleViewModel(get()) }
}