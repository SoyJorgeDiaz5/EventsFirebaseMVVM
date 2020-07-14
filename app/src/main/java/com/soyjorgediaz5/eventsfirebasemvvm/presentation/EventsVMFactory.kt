package com.soyjorgediaz5.eventsfirebasemvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.soyjorgediaz5.eventsfirebasemvvm.domain.IEvents

class EventsVMFactory(private val useCase: IEvents) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IEvents::class.java).newInstance(useCase)
    }
}