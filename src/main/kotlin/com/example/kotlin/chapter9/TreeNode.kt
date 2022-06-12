package com.example.kotlin.chapter9

class TreeNode<T> (val data: T){
}

interface Named {
    val name: String
}

interface Identified {
    val id: Int
}

class Registry<T> where T : Named, T : Identified {

}

fun main() {
    val treeNode = TreeNode("abc")
    println(treeNode.isInstanceOf<String>())
}

inline fun <reified T> TreeNode<*>.isInstanceOf() = this.data is T

