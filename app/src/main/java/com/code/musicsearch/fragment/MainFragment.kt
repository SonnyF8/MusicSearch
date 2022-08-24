package com.code.musicsearch.fragment

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.code.musicsearch.viewmodel.MainViewModel
import com.code.musicsearch.R
import com.code.musicsearch.databinding.FragmentMainBinding

class MainFragment(): Fragment() {
    private val termLength: Int = 2
    private var resultsLength: String? = null

    private lateinit var mainViewModel: MainViewModel
    private lateinit var viewBinding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentMainBinding.inflate(layoutInflater)

        return viewBinding.mainFragment
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewBinding.search.requestFocus()

        viewBinding.icDismiss.setOnClickListener {
            showSoftKeyboard(viewBinding.search)
            viewBinding.search.text.clear()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        resultsLength = getString(R.string.search_limit)

        viewBinding.search.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(charSeq: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun beforeTextChanged(charSeq: CharSequence?, start: Int, count: Int, after: Int) {
                cancelJob(charSeq.toString())
            }

            override fun afterTextChanged(charSeq: Editable?) {
                charSeq?.let { searchTerm ->
                    if (searchTerm.length > termLength) {
                        mainViewModel.showProgress(viewBinding)
                        mainViewModel.loadData(
                            viewBinding, searchTerm.toString(), resultsLength!!
                        )
                    } else {
                        mainViewModel.hideProgress(viewBinding)
                    }
                }
            }
        })
    }

    private fun cancelJob(charSeq: String) {
        mainViewModel.jobLaunch?.let { job ->
            if (job.isActive) {
                job.cancel()
                Log.d("DataCall Cancelled -->", charSeq)
            }
        }
    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val iMgr = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            iMgr.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}