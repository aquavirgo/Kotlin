package colection





fun main (args :Array<String>){
    var a = listOf("Kobuszewski", "Arnold",  "Hans", "Tolkien")
    val b1 = Book("Marian w opalach", a)
    val b2 = Book("Grom w raju", a)
    val b3 = Book("Pustynna burza", a)
    val b4 = Book("Wrota do polowy otwarte", a)


    val books = listOf(b1,b2,b3,b4)
        books.flatMap { it.authors }.toSet() //toSet remove duplication from list of date

    
}