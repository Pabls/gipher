package ru.ar4i.gipher.domain.resources

interface IResourceInteractor {
    fun getStringById(id: Int): String
}