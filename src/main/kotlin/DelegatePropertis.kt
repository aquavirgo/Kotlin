import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegatePropertis {


}


fun main(args: Array<String>){
    //Delegation
    val e = Example()
    print(e.p)
    e.p = "WKS"

    //Delegate.observer

    val user = Observer()
    user.name = "first"
    user.name = "second"

    //map delegation

    val mDelegate = MapDelegation(mapOf("name" to "John Doe", "age" to 25))

    println(mDelegate.name) // Prints "John Doe"
    println(mDelegate.age)

}

class Example{
    var p: String by Delegate()
}



class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, bierzesz delegacje  z'${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class Observer{
    var name : String by Delegates.observable("<no name>"){
        property, oldValue, newValue ->

        if(newValue.startsWith('f')) println("$oldValue -> $newValue")
    }



}
//it works also for mutable var for this you should use MutableMap
class MapDelegation (val map : Map<String,Any?> ){
    val name:String by map
    val age: Int by map
}