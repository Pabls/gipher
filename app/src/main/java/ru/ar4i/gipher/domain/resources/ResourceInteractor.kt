package ru.ar4i.gipher.domain.resources

import ru.ar4i.gipher.domain.repositories.IResourceRepository

class ResourceInteractor(private val resourceRepository: IResourceRepository) : IResourceInteractor {
    override fun getStringById(id: Int): String {
        return resourceRepository.getStringById(id)
    }
}