package com.example.rocketgiant.utils

/**
 * Function for simplifying couple of null checks and avoid nested a?.let { b?.let{ .. }}
 * */
fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

/**
 * Small function to retrieve TAG and avoid unnecessary declarations on each class
 * */
inline fun <reified T> T.TAG(): String = T::class.java.simpleName