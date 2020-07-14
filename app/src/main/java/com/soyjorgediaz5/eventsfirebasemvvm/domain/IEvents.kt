package com.soyjorgediaz5.eventsfirebasemvvm.domain

import com.soyjorgediaz5.eventsfirebasemvvm.model.Event
import com.soyjorgediaz5.eventsfirebasemvvm.vo.Resource

interface IEvents {
    suspend fun getEvents(): Resource<MutableList<Event>>
}