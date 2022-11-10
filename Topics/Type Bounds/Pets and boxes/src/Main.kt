class Box <T : Animal> {
    fun <T : Animal> add(body: T) { /* any fun body */ }
}

// Don't change the class below
open class Animal
class Cat : Animal()