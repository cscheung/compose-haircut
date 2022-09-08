package com.example.haircut

import androidx.lifecycle.ViewModel

class HaircutViewModel() : ViewModel() {
    val services = arrayListOf(
        Service(name = "Haircut"),
        Service(name = "Hair Styling"),
        Service(name = "Wash and Dry"),
        Service(name = "Trim")
    )
}