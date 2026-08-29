package com.lifeos

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform