package company.surious.domain.use_case

import company.surious.domain.entities.SampleEntity
import company.surious.domain.repositories.SampleRepository
import company.surious.domain.use_case.base.SingleUseCase
import io.reactivex.Single

class GetSampleEntityUseCase(private val sampleRepository: SampleRepository) :
    SingleUseCase<Void?, SampleEntity>() {

    override fun createSingle(params: Void?): Single<SampleEntity> =
        sampleRepository.getSampleEntity()
}