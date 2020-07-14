package com.soyjorgediaz5.eventsfirebasemvvm.data.network

import com.soyjorgediaz5.eventsfirebasemvvm.model.Event
import com.soyjorgediaz5.eventsfirebasemvvm.vo.Resource

interface IEventsRepo {
    suspend fun getEventsDB(): Resource<MutableList<Event>>
}