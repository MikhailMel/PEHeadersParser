package ru.scratty.header

import ru.scratty.type.DWord
import ru.scratty.type.Word

data class DosHeader(
    val magic: Word,
    val usedBytesInLastPage: Word,
    val fileSizeInPages: Word,
    val numRelocationItems: Word,
    val headerSizeInParagraphs: Word,
    val minExtraParagraphs: Word,
    val maxExtraParagraphs: Word,
    val initialSS: Word,
    val initialSP: Word,
    val checksum: Word,
    val initialIP: Word,
    val initialRelativeCS: Word,
    val addressOfRelocationTable: Word,
    val overlayNumber: Word,
    val reserved: Array<Word>,
    val oemId: Word,
    val oemInfo: Word,
    val reserved2: Array<Word>,
    val addressOfNewExeHeader: DWord
) {
    override fun toString() = StringBuilder()
        .appendln("--------------------DOS HEADER--------------------")
        .appendln(String.format("0x%-16XСигнатура заголовка", magic.value))
        .appendln(String.format("0x%-16XКоличество байт на последней странице файла", usedBytesInLastPage.value))
        .appendln(String.format("0x%-16XКоличество страниц в файле", fileSizeInPages.value))
        .appendln(String.format("0x%-16XПеренос", numRelocationItems.value))
        .appendln(String.format("0x%-16XРазмер заголовка в параграфах", headerSizeInParagraphs.value))
        .appendln(String.format("0x%-16XМинимальные дополнительные параграфы", minExtraParagraphs.value))
        .appendln(String.format("0x%-16XМаксимальные дополнительные параграфы", maxExtraParagraphs.value))
        .appendln(String.format("0x%-16XНачальное  относительное значение регистра SS", initialSS.value))
        .appendln(String.format("0x%-16XНачальное значение регистра SP", initialSP.value))
        .appendln(String.format("0x%-16XКонтрольная сумма", checksum.value))
        .appendln(String.format("0x%-16XНачальное значение регистра IP", initialIP.value))
        .appendln(String.format("0x%-16XНачальное относительное значение регистра CS", initialRelativeCS.value))
        .appendln(String.format("0x%-16XАдрес в файле на таблицу переадресации", addressOfRelocationTable.value))
        .appendln(String.format("0x%-16XКоличество оверлеев", overlayNumber.value))
        .appendln(String.format("0x%-16XOEM идентифкатор", oemId.value))
        .appendln(String.format("0x%-16XOEM информация", oemInfo.value))
        .appendln(String.format("0x%-16XАдрес в файле нового .exe заголовка (PE)", addressOfNewExeHeader.value))
        .toString()
}