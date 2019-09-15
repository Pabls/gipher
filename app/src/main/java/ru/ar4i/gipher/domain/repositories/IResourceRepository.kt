package ru.ar4i.gipher.domain.repositories

interface IResourceRepository {
    fun getStringById(id: Int): String
}