package Ejercicios

fun main() {
    println("Creacion de pendulo.")
    var p = Pendulum()
    print("Ingrese la longitud del pendulo: ")
    p.set_length(readln()!!.toDouble())
    print("Ingrese la aceleracion del pendulo: ")
    p.set_accel(readln()!!.toDouble())
    println("El periodo del pendulo de longitud ${p.get_length()} y aceleracion ${p.get_accel()} es ${p.oscillation_period()}")
}

class Pendulum{

    private var l: Double = 0.0
    private var a: Double = 0.0

    constructor()

    constructor(l: Double, a: Double) {
        this.l = l
        this.a = a
    }

    // Analizadoras
    fun get_length(): Double {
        return this.l
    }

    fun get_accel(): Double {
        return this.a
    }

    // Modificadoras
    fun set_length(new_l: Double) {
        if (new_l != 0.0) {
            this.l = new_l
        }
    }

    fun set_accel(new_a: Double) {
        if (new_a != 0.0) {
            this.a = new_a
        }
    }

    // Metodos
    fun oscillation_period(): Double{
        val period = 2 * Math.PI * Math.sqrt(this.a / this.l)
        return period
    }
}
