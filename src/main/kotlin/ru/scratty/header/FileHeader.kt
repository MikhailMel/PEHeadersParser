package ru.scratty.header

import ru.scratty.type.DWord
import ru.scratty.type.Word

data class FileHeader(
    val machine: Word,
    val numberOfSections: Word,
    val timeDateStamp: DWord,
    val pointerToSymbolTable: DWord,
    val numberOfSymbols: DWord,
    val sizeOfOptionalHeader: Word,
    val characteristics: Word
) {
    override fun toString() = StringBuilder()
        .appendln("--------------------FILE HEADER--------------------")
        .appendln(String.format("0x%-16XОбозначение процессора", machine.value))
        .appendln(String.format("0x%-16XКоличество секций в файле", numberOfSections.value))
        .appendln(String.format("0x%-16XДата и время создания файла", timeDateStamp.value))
        .appendln(String.format("0x%-16XСмещение до таблицы символов или 0", pointerToSymbolTable.value))
        .appendln(String.format("0x%-16XКоличество элементов в таблице символов", numberOfSymbols.value))
        .appendln(String.format("0x%-16XРазмер необязательного заголовка", sizeOfOptionalHeader.value))
        .appendln(String.format("0x%-16XАтрибуты файла", characteristics.value))
        .toString()
}