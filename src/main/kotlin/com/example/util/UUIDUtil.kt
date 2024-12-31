package com.example.util

import com.github.f4b6a3.ulid.UlidCreator
import java.util.*

fun getUuid(): UUID = UlidCreator.getUlid().toUuid()


