package com.myapplication.app.main.base

enum class State {
    Loading, Error, Empty, Content, NoResult
}

data class ContentState(val state: State, val message: String?)