package ru.scratty.type

data class ULong(val value: Long): HexType {
    override fun toString() = value.toString()
}