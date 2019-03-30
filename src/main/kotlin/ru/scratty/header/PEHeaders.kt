package ru.scratty.header

import java.lang.StringBuilder

data class PEHeaders(
    val dosHeader: DosHeader,
    val ntHeaders: NtHeaders
) {
    override fun toString() = StringBuilder()
        .appendln(dosHeader)
        .appendln(ntHeaders)
        .toString()
}