package ru.scratty.header

import ru.scratty.type.DWord

data class NtHeaders(
    val signature: DWord,
    val fileHeader: FileHeader,
    var optionalHeader: OptionalHeader? = null
) {
    override fun toString() = StringBuilder()
        .appendln("--------------------NT HEADERS--------------------")
        .appendln(String.format("%-18XСигнатура\n", signature.value))
        .appendln(fileHeader)
        .appendln(optionalHeader)
        .toString()
}