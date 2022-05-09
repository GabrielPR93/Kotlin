package com.openwebinars.retrofitandjobqueuekotlin.view.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.birbit.android.jobqueue.JobManager
import com.birbit.android.jobqueue.Params
import com.birbit.android.jobqueue.config.Configuration
import com.openwebinars.retrofitandjobqueuekotlin.R
import com.openwebinars.retrofitandjobqueuekotlin.model.ItemModel
import com.openwebinars.retrofitandjobqueuekotlin.task.GetResourceListJob
import com.openwebinars.retrofitandjobqueuekotlin.view.adapter.ItemAdapter
import com.openwebinars.retrofitandjobqueuekotlin.view.contract.MainView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
    }

    fun loadData() {
        val builder = Configuration.Builder(this)
                .minConsumerCount(1)
                .maxConsumerCount(3)
                .loadFactor(3)
                .consumerKeepAlive(120)

        val jobManager = JobManager(builder.build())
        val serviceJob = GetResourceListJob(Params(50).requireNetwork(), this)
        jobManager.addJobInBackground(serviceJob)
        jobManager.start()
    }

    override fun setDataSet(items: List<ItemModel>) {
        loadingView.visibility = View.GONE
        mainRecycler.visibility = View.VISIBLE
        mainRecycler.layoutManager = LinearLayoutManager(this)
        mainRecycler.adapter = ItemAdapter(items) {
            toast(String.format("Click en %s", it.farmerId))
        }
    }

    fun Context.toast(message: CharSequence) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
