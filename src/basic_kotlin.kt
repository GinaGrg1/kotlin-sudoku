/**
 * Created by ReginaGurung on 27/02/2018.
 */


fun main(args:Array<String>){

    print("Please enter your name:")
    var name = readLine()
    print("Please enter your age:")
    var age = readLine()!!.toInt()
    print("Please enter your department:")
    var dep:String? // means this variable can be null.
    dep = readLine()
    print("Please enter pi: ")
    var pi:Double = readLine()!!.toDouble()
    println("The name is $name, the age is $age years old and from $dep department")

    var address:String?
    address = null
    print(address!!) // !! means that this var CANNOT be null.
    // other options are .toString, .toFloat
}
