import java.util.concurrent.CountDownLatch

fun strLen(s: String) = s.length

fun strLenSafe(s:String?):Int =
        if(s != null) s.length else 0
//?. if null to out = null if value to out = upperCasse
fun printAllCaps(s :String?){
    val allCaps : String? =s?.toUpperCase()
    println(allCaps)
}
//nullable type checker in ?.
class Employee(val name:String,val manager: Employee?)
fun managerName(employee: Employee) :String? =employee.manager?.name

//chain of nullable type
class Address(val streetAddress: String, val zipCode:Int,val city:String,val country:String)
class Company(val name:String,val address:Address?)
class Persons(val name: String,val company: Company?)

fun Persons.countryName():String{
    val country = this.company?.address?.country //safe-asccess operator can be in a chain.
    return if(country!=null) country else "Unknown"
}
//similar like above but in on line
fun Persons.countryName2() = company?.address?.country ?: "Unknown"


fun printShippingLabel(persons: Persons){
    val address = persons.company?.address?:throw IllegalArgumentException("No address")
    //bierze argument i lambde -> lambda w funkcji, ostania linijka lambdy jako wartosc zwracana
    // unikamy powtarzania address 4 raz np: address.zipCode, address.city
    with(address){
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class Persons2(val firstName : String, val lastName : String){
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Persons2 ?: return false

        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}


//if null return default value Elvis operator

fun foo(s:String?) : String{
    val t : String = s ?: "WKS"
    return t
}
//Elvis operator works tougether with safe call operator
//if null will not do length check and if null print 0
//if s string make length check and print lenght
fun strLenSafe2(s:String?):Int = s?.length ?: 0


fun ignoreNulls(s:String?){
    val sNotNull : String = s!!
    println(sNotNull.length)
}


//if you would like to put nullable type (String ?) to not -null function, you should use let
//after this if input value is null function doesn't work
//email?.let {email -> sendEmailTo(email)}

fun sendEmailTo(email: String){
    println("Sending email to $email")
}

class MyService{
    fun perforAction():String = "foo"
}

class Mytest{
    private lateinit var myService : MyService

    //@Before fun setUp() {
    // myService = MyService()}

    //@Test fun testAction(){
    // Assert.assertEquals("foo", myService.performAction()}


}

//if sometimes would you like to test something in JUnit initialization of object is in @Before,
//and instead null value you should use lateinit

fun main(args: Array<String>) {
    //println(strLenSafe("abc"))
    //printAllCaps(null)

    //val ceo = Employee("Da Boss",null)
    //val developer = Employee("Bob Smith", ceo)

    //println(managerName(developer))
    //println(managerName(ceo))

    /*val person = Persons("Dimitry",null)
    println(person.countryName())
    println(person.countryName2())*/


    //println(foo(null))

    //println(strLenSafe2(null))


    /*val address = Address("Elsestr. 47", 80687,"Munich","Germany")
    val jetbrains = Company("JetBrains", null)
    val person = Persons("Dimitry", jetbrains)
    printShippingLabel(person)*/

   /* val p1 = Persons2("Dimitry","Jemerow")
    val p2 = Persons2("Dimitry","Jemerow")

    println(p1==p2)
    println(p1.equals(42))*/

    //ignoreNulls(null)
/*
var email : String? = "j@mt.de"
    email?.let { sendEmailTo(it) }*/
    verifyUserInput("")

    printHashCode(null)
}

fun verifyUserInput(input: String?){
    if(input.isNullOrBlank()){
        println("Please fill in the required fields")
    }
}

//inferred type for parameter T is nullable Any?, parameter t is allowed to hold null
//without question mark after T np: T?
fun <T> printHashCode(t: T){
    println(t?.hashCode())
}

//if you could block T, that it can n't be a nullable type you should use upper bound for it
fun <T : Any> printHashCode2(t:T){
    println(t.hashCode())
}


fun yellAt(ludzie: Ludzie){
    println(ludzie.name.toUpperCase() + "!!!")
}





