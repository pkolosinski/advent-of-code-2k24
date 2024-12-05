package com.github.pkolosinski

import java.io.File

fun readInputAsList(filename: String): List<String> {
    val resource = object {}::class.java.getResource("/inputs/$filename")!!
    return File(resource.toURI()).readLines()
}

fun readInputAsString(filename: String): String {
    val resource = object {}::class.java.getResource("/inputs/$filename")!!
    return File(resource.toURI()).readText()
}
