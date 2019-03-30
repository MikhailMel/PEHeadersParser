package ru.scratty

import ru.scratty.type.Byte
import ru.scratty.type.DWord
import ru.scratty.type.Word
import ru.scratty.type.ULong
import java.io.BufferedInputStream

class HexReader(private val bufferedInputStream: BufferedInputStream) {

    var position = 0L
        private set

    fun readByte() = Byte(byte())

    fun readWord() = Word(byte() or (byte() shl 8))

    fun readDWord() = DWord(byte() or (byte() shl 8) or (byte() shl 16) or (byte() shl 24))

    fun readULong() = ULong(
        ((byte() or (byte() shl 8) or (byte() shl 16) or (byte() shl 24)).toLong() and 0x00000000ffffffffL) or
                ((byte() or (byte() shl 8) or (byte() shl 16) or (byte() shl 24)).toLong().shl(32))
    )

    fun skipBytes(count: Long) {
        position += count

        for (i in 0 until count) {
            bufferedInputStream.read()
        }
    }

    private fun byte(): Int {
        position++
        return bufferedInputStream.read()
    }
}