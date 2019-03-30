package ru.scratty.type

data class Word(val value: Int): HexType {
    override fun toString() = value.toString()
}