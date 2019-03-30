package ru.scratty

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val path = if (args.isEmpty()) {
        print("Введите путь к файлу: ")
        val line = Scanner(System.`in`).nextLine()

        if (line == null || line.isEmpty()) {
            println("Введен пустой путь к файлу")
            return
        }

        line
    } else {
        args[0]
    }

    if (!File(path).exists()) {
        println("Файл не существует или введен неверный путь")
        return
    }

    val peHeaders = PeParser().parse(path)
    println(peHeaders)
}