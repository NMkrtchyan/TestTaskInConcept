package com.example.testtaskinconcept.ui.model

data class Command(val command: Int, val data: Any? = null, var isFirst: Boolean = false)