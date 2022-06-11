package Ejercicios

fun main() {

    var elevator = Elevator()
    var option: Int

    println("Menu Operaciones Ascensor \n" +
            "1.  Definir atributos del ascensor \n" +
            "2.  Ascender un piso \n" +
            "3.  Descender un piso \n" +
            "4.  Numero de pisos que atiende el ascensor \n" +
            "5.  Piso Actual \n" +
            "6.  Salir \n")

    do {

        print("Ingrese el numero de la operacion a realizar: ")
        option = readln()!!.toInt()

        when (option) {
            1 -> {
                print("Ingrese el numero de pisos del edificio: ")
                elevator.floors = readln()!!.toInt()
                print("Ingrese el numero de sotanos del edificio: ")
                elevator.basements = readln()!!.toInt()
                println("Ascensor definido para operar en edificio con ${elevator.floors} pisos y ${elevator.basements} sotanos")
            }

            2 -> {
                println("Ascendiendo un piso ... ")
                elevator.next_floor()
            }

            3 -> {
                println("Descendido un piso ... ")
                elevator.previous_floor()
            }

            4 -> println("El ascensor atiende un total de ${elevator.work_floors()}")

            5 -> println("El ascensor se encuentra en el piso ${elevator.current_floor}")

            6 -> println("Cerrando aplicacion ... ")

            else -> println("Operacion no reconocida.")
        }

    } while (option != 6)
}

data class  Elevator(
    var floors: Int = 1,
    var basements: Int = 0,
    var current_floor: Int = 1,
) {
    fun next_floor() {
        var next_floor_number = current_floor + 1
        current_floor = when {
            next_floor_number > floors -> floors
            next_floor_number.equals(0) -> 1
            else -> next_floor_number
        }
    }

    fun previous_floor() {
        var previous_floor_number = current_floor - 1
        current_floor = when {
            previous_floor_number < -basements -> -basements
            previous_floor_number.equals(0) -> -1
            else -> previous_floor_number
        }
    }

    fun work_floors(): Int = floors + basements

}