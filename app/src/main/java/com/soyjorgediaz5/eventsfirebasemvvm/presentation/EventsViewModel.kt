package com.soyjorgediaz5.eventsfirebasemvvm.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.soyjorgediaz5.eventsfirebasemvvm.domain.IEvents
import com.soyjorgediaz5.eventsfirebasemvvm.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class EventsViewModel(private val useCase: IEvents) : ViewModel() {
    val fetchEventList = liveData(Dispatchers.IO) {
        try {
            val eventList = useCase.getEvents()
            emit(eventList)
        } catch (e: Exception) {
            emit(Resource.Failure(e.cause!!))
        }
    }
}