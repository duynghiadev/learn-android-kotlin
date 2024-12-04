package com.example.baitaproomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baitaproomdb.repository.Repository
import com.example.baitaproomdb.room.StudentEntity
import kotlinx.coroutines.launch

class StudentViewModel(private val repository: Repository): ViewModel() {

    fun addStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.addStudentToRoom(student)
        }
    }

    val students = repository.getAllStudents()

    fun deleteStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.deleteStudentFromRoom(student)
        }
    }

    fun updateStudent(student: StudentEntity) {
        viewModelScope.launch {
            repository.updateStudent(student)
        }
    }
}