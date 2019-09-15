package ru.ar4i.gipher.data.repositories

import android.content.Context
import ru.ar4i.gipher.domain.repositories.IResourceRepository

class ResourceRepository(private val context: Context) : IResourceRepository {

    override fun getStringById(id: Int): String {
        return context.getString(id)
    }
}