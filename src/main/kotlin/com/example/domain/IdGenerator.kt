package com.example.domain

import com.github.f4b6a3.ulid.UlidCreator
import java.util.UUID

interface IdGenerator {
    fun generateId(): UUID
}

class UlidBasedIdGenerator : IdGenerator {
    override fun generateId(): UUID = UlidCreator.getUlid().toUuid()
}
