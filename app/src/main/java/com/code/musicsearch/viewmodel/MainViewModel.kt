package com.code.musicsearch.viewmodel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.code.musicsearch.DataRepository
import com.code.musicsearch.adapter.SongAdapter
import com.code.musicsearch.SongData
import com.code.musicsearch.databinding.FragmentMainBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class MainViewModel: ViewModel(), CoroutineScope {
    var jobLaunch: Job? = null

    private val job = Job()
    private val handler = CoroutineExceptionHandler { _, exception ->
        Log.d("Coroutine exception -->", "${exception.message}")
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job + handler

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    fun loadData(binding: FragmentMainBinding, term: String, limit: String) {
        jobLaunch = launch {
            val result: SongData? = dataCall(term, limit)

            binding.recycler.adapter = SongAdapter(result)
            hideProgress(binding)

            Log.d("Coroutine Result -->", "$result")
        }
    }

    private suspend fun dataCall(term: String, limit: String): SongData? {
        return withContext(Dispatchers.IO) {
            DataRepository().getSongData(term, limit)
        }
    }

    fun showProgress(binding: FragmentMainBinding) {
        binding.progress.visibility = View.VISIBLE
    }

    fun hideProgress(binding: FragmentMainBinding) {
        binding.progress.visibility = View.GONE
    }
}
