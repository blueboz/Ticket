package cn.boz.utils

/**
 * kotlin 类可以包括构造函数，初始化代块,函数，属性，内部类，对象声明
 * 拼音输入法一定要很好用才行，否则都是垃圾
 * 就想看看有多哦然
 *
 */
class Runoob{

    fun run(){
        print("Foo from jupiter");//成员函数
    }

    //属性的定义
    var name:String=""
    var url:String=""
    var city:String=""
}


//we can define a empty class
class Empty


//Kotlin中的类可以有一个主要构造器件

fun main(vars:Array<String>){
    println("hello kotlin");
    println("hello kotlin");
    val site=Runoob();//Kotlin 中并没有new关键字

    //引用属性
    site.name;//使用.来引用

}