package com.demo.deliveoo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform