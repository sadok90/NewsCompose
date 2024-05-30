package com.sadok.newscompose.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadok.newscompose.domain.usecases.app_entry.AppEntryUsesCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(
    private val appEntryUsesCase: AppEntryUsesCase
): ViewModel() {

    fun onEvent(event: OnBoardingEvent) {
        when(event) {
            is OnBoardingEvent.SaveAppEntry -> {
                saveEntry()
            }
        }
    }

    private fun saveEntry() {
        viewModelScope.launch {
            appEntryUsesCase.saveAppEntry()
        }
    }
}