package com.example.tetris.helpers

fun array2OfByte(sizeOuter:Int, sizeInner:Int):Array<ByteArray> = Array(sizeOuter){
    ByteArray(sizeInner)
}