package com.example.memorygame.memory_feature.domain.util

import com.example.memorygame.memory_feature.domain.model.MemoryCard

fun generateCardsArray(matches: Int) : Array<MemoryCard> {

    val singles = 1..matches
    val doubles = singles + singles


    return doubles.shuffled().map {number ->
        MemoryCard(number)
    }.toTypedArray()
}