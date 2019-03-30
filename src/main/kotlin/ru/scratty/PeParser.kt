package ru.scratty

import ru.scratty.header.*
import java.io.BufferedInputStream
import java.io.FileInputStream

class PeParser {

    private lateinit var hexReader: HexReader

    fun parse(path: String): PEHeaders {
        hexReader = HexReader(BufferedInputStream(FileInputStream(path)))

        val dosHeader = parseDosHeader()

        hexReader.skipBytes(dosHeader.addressOfNewExeHeader.value - hexReader.position)
        val ntHeaders = parseNtHeaders()

        return PEHeaders(dosHeader, ntHeaders)
    }

    private fun parseDosHeader() = DosHeader(
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        readWordArray(4),
        hexReader.readWord(),
        hexReader.readWord(),
        readWordArray(10),
        hexReader.readDWord()
    )

    private fun parseNtHeaders() = NtHeaders(
        hexReader.readDWord(),
        parseFileHeader()
    ).apply {
        optionalHeader = if (fileHeader.sizeOfOptionalHeader.value == 224) {
            parseOptionalHeader32()
        } else {
            parseOptionalHeader64()
        }
    }

    private fun parseFileHeader() = FileHeader(
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readWord(),
        hexReader.readWord()
    )

    private fun parseOptionalHeader32() = OptionalHeader32(
        hexReader.readWord(),
        hexReader.readByte(),
        hexReader.readByte(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord()
    ).apply {
        dataDirectory = readDataDirectories(numberOfRvaAndSizes.value)
    }

    private fun parseOptionalHeader64() = OptionalHeader64(
        hexReader.readWord(),
        hexReader.readByte(),
        hexReader.readByte(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readULong(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readDWord(),
        hexReader.readWord(),
        hexReader.readWord(),
        hexReader.readULong(),
        hexReader.readULong(),
        hexReader.readULong(),
        hexReader.readULong(),
        hexReader.readDWord(),
        hexReader.readDWord()
    ).apply {
        dataDirectory = readDataDirectories(numberOfRvaAndSizes.value)
    }

    private fun readWordArray(count: Int) = Array(count) { hexReader.readWord() }

    private fun readDataDirectories(count: Int) = Array(count) {
        DataDirectory(
            hexReader.readDWord(),
            hexReader.readDWord()
        )
    }
}