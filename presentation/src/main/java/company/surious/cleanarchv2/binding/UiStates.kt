package company.surious.cleanarchv2.binding

sealed class UiState

object Loading : UiState()
object HasData : UiState()
object Empty : UiState()
object Error : UiState()