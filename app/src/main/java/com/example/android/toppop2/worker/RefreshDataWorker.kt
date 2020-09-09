package com.example.android.toppop2.worker

import android.app.Application
import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.android.toppop2.repository.Repository
import com.example.android.toppop2.room.getDatabase
import retrofit2.HttpException

class RefreshDataWorker(private val application: Application, appContext: Context, params: WorkerParameters): CoroutineWorker(appContext, params){

    override suspend fun doWork(): Result {
        val repository = Repository(application)

        return try {
            repository.refresh()
            Result.success()
        } catch(e: HttpException){
            Result.retry()
        }
    }

    companion object{
        const val WORKER_NAME = "RefreshDataWorker"
    }
}