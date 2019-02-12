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


    //getter 与　setter都是可选的，
    var lastName:String="zhang"
        get()=field.toUpperCase()
        set
    var no:Int=100
        set(value) {
            if(value<10){
                field=value
            }else{
                field=-1;
            }
        }

    //不能重新设置值，相当与常量
    var heigh:Float=145.5f
        private set

    //延迟初始化
    var subject:String

    /**
     * 因为主构造器件中不能包含任何的初始化代码，初始化代码，可以使用init 进行初始化
     */
    init {
        subject="Math";
    }


}


//we can define a empty class
class Empty



//Kotlin中的类可以有一个主要构造器件

fun main2(vars:Array<String>){
    println("hello kotlin");
    println("hello kotlin");
    val site=Runoob();//Kotlin 中并没有new关键字

    //引用属性
    site.name;//使用.来引用
    //一旦set 被声明为private ，将不能进行修改
    //site.heigh=88.8;

    println("no:${site.no}")
    //一旦在调用的时候的时候，还没有初始化，则会报错
    println(site.subject);
    var pp=Person("菜鸟教程网");
    println(pp.siteName);

    //次构造函数打使用
    var pjay=Person("周杰伦","男");

    println("如果构造函数所有参数都有默认值，那么编译器会自动生成一个没有参数的构造函数，并且我们无需设置参数")
    var jpaUser=DefaultJPA();
    //并且允许我们随意设置任意一个参数值
    var jpaUser2=DefaultJPA("里诶");
    println(jpaUser.username)
    println(jpaUser.gender)

}

class Person constructor(name:String){
    //可以通过构造函数传入函数
    var siteName=name;
    //可以看到，输出打siteName已经存在着值了。
    init {
        println("初始化的网站名称为${name} 并且sitename为:${siteName}")
    }
    //使用次构造函数打参数作为属性赋值是不能直接允许的，是间接允许的
    //var genders=gender;
    var gender:String="Male"
    //次构造函数,必须调用this。给初始化参数赋值，
    constructor(lastName:String,gender:String) : this(lastName) {
        //次构造函数不允许忽略lateinit
        //但是允许通过间接打方式设置属性值
        this.gender=gender
    }


}


//默认会生成一个空的public构造函数，如果不希望公有，可以采用如下方法
class DontCreateMe private constructor(){

}

class DefaultJPA (username:String="Jay",gender:String="Male"){
    var username:String=username;
    var gender:String=gender;
}


//抽象类

open class Base{
    open fun f(){
        println("jj");
    }
    open fun f2(){//do nothing

        println("health");
    }
}

abstract class Child:Base(){
    override  fun f() {
        println("Call before override");
        super.f()
    }
    override abstract fun f2();
}


fun main3(args: Array<String>) {
    var base=Base();
    base.f()
    //var child=Child();
    //child.f();
    println(Outer.Nested().foo()());
    println(Outer.Nested().foo2());
}
//嵌套类

class Outer{
    private val bar:Int=1;
    class Nested{
        fun foo()={2}
        fun foo2()=3;
        fun foo3() { 4 }
        fun foo4(): Int { return 4 }
        fun foo5()={"jay"}//神奇的是，需要设置返回值
    }
}


//匿名内部类
interface TestInterface{
    fun test();
}
class Test{
    var v="成员属性";
    fun setInterface(test:TestInterface){
        test.test();
    }
}

fun main(args: Array<String>) {
    var tinst=Test();
    tinst.setInterface(object:TestInterface{
        override fun test() {
            println("对象表达式创建匿名内部类");
        }

    })
}