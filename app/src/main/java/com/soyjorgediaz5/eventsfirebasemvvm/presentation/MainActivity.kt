package com.soyjorgediaz5.eventsfirebasemvvm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.soyjorgediaz5.eventsfirebasemvvm.R
import com.soyjorgediaz5.eventsfirebasemvvm.data.network.EventsRepoImpl
import com.soyjorgediaz5.eventsfirebasemvvm.domain.EventsImpl
import com.soyjorgediaz5.eventsfirebasemvvm.vo.Resource

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy {
        ViewModelProviders.of(
            this,
            EventsVMFactory(EventsImpl(EventsRepoImpl()))
        ).get(EventsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.fetchEventList.observe(this, Observer {
            when (it) {
                is Resource.Loading -> {
                    /* Before try catch in viewmodel we can use emit(Resource.Loading()) to tell
                     * the view we started fetching results and this will be triggered
                     */
                }

                is Resource.Success -> {
                    // We get the list data with it.data
                }

                is Resource.Failure -> {
                    // Handle the failure
                    Toast.makeText(
                        this,
                        "An error has ocurred: ${it.throwable.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }
}