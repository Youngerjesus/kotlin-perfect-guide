package com.example.kotlin.chapter9


class TreeNode<T> (val data: T){
    lateinit var childeren: Set<TreeNode<T>>

    fun addChild(t: T): TreeNode<T> {
        TODO("Not yet implemented")
    }
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

    val root = TreeNode<Number>(123)
    val treeNode1 = TreeNode<Int>(45)
    root.addSubtree(treeNode1)

}

fun <T> TreeNode<T>.addSubtree(node: TreeNode<out T>): TreeNode<T> {
    val newNode = addChild(node.data)
    node.childeren.forEach { newNode.addSubtree(it) }
    return newNode
}

inline fun <reified T> TreeNode<*>.isInstanceOf() = this.data is T

