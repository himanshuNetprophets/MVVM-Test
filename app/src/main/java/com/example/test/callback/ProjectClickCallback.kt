package com.example.test.callback

import android.view.View
import com.example.test.service.model.Project


interface ProjectClickCallback {
    fun onClick(view: View, project: Project)
}