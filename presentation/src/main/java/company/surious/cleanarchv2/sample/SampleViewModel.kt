package company.surious.cleanarchv2.sample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import company.surious.cleanarchv2.binding.*
import company.surious.domain.entities.SampleEntity
import company.surious.domain.use_case.GetSampleEntityUseCase
import io.reactivex.disposables.CompositeDisposable

class SampleViewModel(private val getSampleEntityUseCase: GetSampleEntityUseCase) :
    ViewModel() {

    private val subscriptions = CompositeDisposable()

    val state: MutableLiveData<UiState> = MutableLiveData<UiState>().apply {
        value = Empty
    }

    val entity: MutableLiveData<SampleEntity> = MutableLiveData()
    val error: MutableLiveData<Throwable> = MutableLiveData()

    fun update() {
        state.value = Loading
        subscriptions.add(
            getSampleEntityUseCase.execute(null).subscribe(
                ::displayDataState,
                ::displayErrorState
            )
        )
    }

    private fun displayDataState(data: SampleEntity) {
        entity.value = data
        error.value = null
        state.value = HasData
    }

    private fun displayErrorState(error: Throwable) {
        entity.value = null
        this@SampleViewModel.error.value = error
        state.value = Error
    }

    override fun onCleared() {
        super.onCleared()
        subscriptions.clear()
    }
}