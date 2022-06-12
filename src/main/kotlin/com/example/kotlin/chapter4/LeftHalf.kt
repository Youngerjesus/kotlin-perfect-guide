package com.example.kotlin.chapter4

val IntRange.leftHalf: IntRange
    get() = start..(start + endInclusive) / 2

