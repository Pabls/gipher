package ru.ar4i.gipher.presentation.base.view

interface IMvpView {
    fun showError(error: String)
    fun showLoading()
    fun hideLoading()
}