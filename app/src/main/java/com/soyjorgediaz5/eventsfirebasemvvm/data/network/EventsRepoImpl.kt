package com.soyjorgediaz5.eventsfirebasemvvm.data.network

import com.google.firebase.firestore.FirebaseFirestore
import com.soyjorgediaz5.eventsfirebasemvvm.model.Event
import com.soyjorgediaz5.eventsfirebasemvvm.vo.Resource
import kotlinx.coroutines.tasks.await

class EventsRepoImpl : IEventsRepo {
    override suspend fun getEventsDB(): Resource<MutableList<Event>> {
        val eventList = mutableListOf<Event>()
        val resultList = FirebaseFirestore.getInstance()
            .collection("events")
            .get().await()

        for (document in resultList) {
            val photoUrl = document.getString("photoUrl")
            val eventName = document.getString("eventName")
            val time = document.getString("time")
            eventList.add(Event(photoUrl!!, eventName!!, time!!))
        }

        return Resource.Success(eventList)
    }
}