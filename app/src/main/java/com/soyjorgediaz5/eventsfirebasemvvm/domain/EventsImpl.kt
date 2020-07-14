package com.soyjorgediaz5.eventsfirebasemvvm.domain

import com.soyjorgediaz5.eventsfirebasemvvm.data.network.IEventsRepo
import com.soyjorgediaz5.eventsfirebasemvvm.model.Event
import com.soyjorgediaz5.eventsfirebasemvvm.vo.Resource

class EventsImpl(private val eventsRepo: IEventsRepo) : IEvents {
    override suspend fun getEvents(): Resource<MutableList<Event>> = eventsRepo.getEventsDB()
}