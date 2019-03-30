package ru.scratty.header

import ru.scratty.type.Byte
import ru.scratty.type.DWord
import ru.scratty.type.ULong
import ru.scratty.type.Word

data class OptionalHeader64(
    val magic: Word,
    val majorLinkerVersion: Byte,
    val minorLinkerVersion: Byte,
    val sizeOfCode: DWord,
    val sizeOfInitializedData: DWord,
    val sizeOfUninitializedData: DWord,
    val addressOfEntryPoint: DWord,
    val baseOfCode: DWord,
    val imageBase: ULong,
    val sectionAlignment: DWord,
    val fileAlignment: DWord,
    val majorOperatingSystemVersion: Word,
    val minorOperatingSystemVersion: Word,
    val majorImageVersion: Word,
    val minorImageVersion: Word,
    val majorSubsystemVersion: Word,
    val minorSubsystemVersion: Word,
    val win32VersionValue: DWord,
    val sizeOfImage: DWord,
    val sizeOfHeaders: DWord,
    val checkSum: DWord,
    val subsystem: Word,
    val dllCharacteristics: Word,
    val sizeOfStackReserve: ULong,
    val sizeOfStackCommit: ULong,
    val sizeOfHeapReserve: ULong,
    val sizeOfHeapCommit: ULong,
    val loaderFlags: DWord,
    val numberOfRvaAndSizes: DWord,
    var dataDirectory: Array<DataDirectory>? = null
): OptionalHeader {
    override fun toString() = StringBuilder()
        .appendln("--------------------OPTIONAL HEADER--------------------")
        .appendln(String.format("0x%-16XСигнатура заголовка", magic.value))
        .appendln(String.format("0x%-16XСтаршая цифра номера версии сборщика", majorLinkerVersion.value))
        .appendln(String.format("0x%-16XМладшая цифра номера версии сборщика", minorLinkerVersion.value))
        .appendln(String.format("0x%-16XСумма размеров всех секций, содержащих програмный код", sizeOfCode.value))
        .appendln(String.format("0x%-16XСумма размеров всех секций, содержащих инициализированные данные", sizeOfInitializedData.value))
        .appendln(String.format("0x%-16XСумма размеров всех секций, содержащих неинициализированные данные", sizeOfUninitializedData.value))
        .appendln(String.format("0x%-16XRVA точки запуска программы", addressOfEntryPoint.value))
        .appendln(String.format("0x%-16XRVA начала кода программы", baseOfCode.value))
        .appendln(String.format("0x%-16XПредпочтительный базовый адрес программы в памяти", imageBase.value))
        .appendln(String.format("0x%-16XВыравнивание в байтах для секций при загрузке в память", sectionAlignment.value))
        .appendln(String.format("0x%-16XВыравнивание в байтах для секций внутри файла", fileAlignment.value))
        .appendln(String.format("0x%-16XСтаршая цифра номера версии операционной системы", majorOperatingSystemVersion.value))
        .appendln(String.format("0x%-16XМладшая цифра номера версии операционной системы", minorOperatingSystemVersion.value))
        .appendln(String.format("0x%-16XСтаршая цифра номера версии данного файла", majorImageVersion.value))
        .appendln(String.format("0x%-16XМладшая цифра номера версии данного файла", minorImageVersion.value))
        .appendln(String.format("0x%-16XСтаршая цифра номера версии подсистемы", majorSubsystemVersion.value))
        .appendln(String.format("0x%-16XМладшая цифра номера версии подсистемы", minorSubsystemVersion.value))
        .appendln(String.format("0x%-16XЗарезервировано, всегда равно 0", win32VersionValue.value))
        .appendln(String.format("0x%-16XРазмер файла в памяти, включая все заголовки", sizeOfImage.value))
        .appendln(String.format("0x%-16XСуммарный размер заголовка и заглушки DOS, заголовка PE и заголовков секций", sizeOfHeaders.value))
        .appendln(String.format("0x%-16XКонтрольная сумма файла", checkSum.value))
        .appendln(String.format("0x%-16XИсполняющая подсистема Windows для данного файла", subsystem.value))
        .appendln(String.format("0x%-16XДополнительные атрибуты файла", dllCharacteristics.value))
        .appendln(String.format("0x%-16XРазмер стека стартового потока программы в байтах виртуальной памяти", sizeOfStackReserve.value))
        .appendln(String.format("0x%-16XНачальный размер стека программы в байтах", sizeOfStackCommit.value))
        .appendln(String.format("0x%-16XРазмер кучи программы в байтах", sizeOfHeapReserve.value))
        .appendln(String.format("0x%-16XНачальный размер кучи программы в байтах", sizeOfHeapCommit.value))
        .appendln(String.format("0x%-16XУстаревшее поле, не используется", loaderFlags.value))
        .appendln(String.format("0x%-16XКоличество описателей каталогов данных", numberOfRvaAndSizes.value))
        .appendln("\n--------------------DATA DIRECTORIES--------------------")
        .apply {
            dataDirectory!!.forEach {
                appendln(it)
            }
        }
        .toString()
}