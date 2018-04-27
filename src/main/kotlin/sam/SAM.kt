package sam
//sam.SAM constructor -> jawna konwersja lambdy na instacje interfejsu funkcyjnego
//sam.SAM bierze 1 argument, lambde ktora jest wykorzystana jako cialo pojedynczej metody abstrakcyjnej w interfejsie funkcyjnym
//i zwraca instancje klasy implementujacej interface

class SAM {
}


fun main(args: Array<String>) {
    createAllDoneRunnable().run()
}


fun createAllDoneRunnable(): Runnable {
    return Runnable { println("All done!") }
}


