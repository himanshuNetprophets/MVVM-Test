package com.example.test.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.test.service.model.Project
import com.example.test.service.repository.ProjectRepository


class ProjectListViewModel(application: Application): AndroidViewModel(application) {
    private val projectListObservable= ProjectRepository.getInstance().getProjectList("Google")

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    fun getProjectListObservable(): LiveData<List<Project>> {
        return projectListObservable
    }
}