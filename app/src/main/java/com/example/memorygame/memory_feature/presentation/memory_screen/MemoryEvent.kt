package com.example.memorygame.memory_feature.presentation.memory_screen

sealed class MemoryEvent {

    data class CardClick(val cardId: Int) : MemoryEvent()

    data object AddPair: MemoryEvent()
    data object ReducePair: MemoryEvent()
    data object ChangeTheme: MemoryEvent()
    data object ResetGame: MemoryEvent()

}