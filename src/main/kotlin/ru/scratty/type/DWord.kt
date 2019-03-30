package ru.scratty.type

data class DWord(val value: Int): HexType {
    override fun toString() = value.toString()
}