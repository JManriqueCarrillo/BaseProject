package com.jmanrique.lolproject.utils.extensions

fun <T> T?.safeValue(default: T) : T = this ?: default

fun <T> T?.isNull(): Boolean = this == null

fun <T> T?.isNotNull(): Boolean = ! this.isNull()

fun <T : Any> T?.notNull(f: (it: T) -> Unit) {
    if (this != null) f(this)
}

fun <T : Any> T?.isNull(f: () -> Unit) {
    if (this == null) f()
}
