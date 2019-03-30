package ru.scratty.header

import ru.scratty.type.DWord

data class DataDirectory(
    val virtualAddress: DWord,
    val size: DWord
) {
    override fun toString() = StringBuilder()
        .appendln(String.format("0x%-16XОтносительный виртуальный адрес", virtualAddress.value))
        .appendln(String.format("0x%-16XРазмер каталога", size.value))
        .toString()
}