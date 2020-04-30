package company.surious.data

import company.surious.domain.repositories.SampleRepository
import org.koin.dsl.module

val repositoriesModule = module {
    single<SampleRepository> {
        SampleRepositoryImpl()
    }
}

