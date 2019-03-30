package ru.scratty.type

data class Byte(val value: Int): HexType {
    override fun toString() = value.toString()
}