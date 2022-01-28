package com.example.cursokotlinprincipiantes

import android.util.Log
import java.lang.IndexOutOfBoundsException

class EstructurasDeControl {

     fun condicionales(){
         val flag=true;

        if(10>5){
            Log.d(TAG, "condicionales: TRUE")
        }else if(flag){
            Log.d(TAG, "condicionales: flag")
        }
        else{
            Log.d(TAG, "condicionales: FALSE")
        }
    }
    
    fun condicionalesWhen(){
        val language="Kotlin"
        val number=40
        
        when(language){

            "Kotlin" -> Log.d(TAG, "condicionalesWhen: KOTLIN")
            "Java" -> Log.d(TAG, "condicionalesWhen: JAVA")
            "C#","C++" -> Log.d(TAG, "condicionalesWhen: C# o C++")
            else -> Log.d(TAG, "condicionalesWhen: Otro lenguaje")
        }

        when(number){
            in 0..10 -> Log.d(TAG, "condicionalesWhen: del 0 a 10")
            in 11..40 -> Log.d(TAG, "condicionalesWhen: del 11 al 40")
            in 41..50 -> Log.d(TAG, "condicionalesWhen: del 41 al 50")
        }
    }

    fun listados(){
        val list= listOf<String>() //es inmutable no se puede modificar
        val list2:List<String> = listOf()

        val arrayList= arrayListOf<String>() //es mutable puede modificarse, añadir elementos...
        val arrayList2:ArrayList<String> = arrayListOf()

        val myList= listOf("Gabri","Manu","Rebe")
        val myArrayList:ArrayList<String> = arrayListOf("Gabriel","Manu","Rebe")
        //myList[0]="pepe" //Error no se puede modificar
        myArrayList[0]="Pepe" //lo modifica
        myArrayList.remove("Manu") //lo borra
        val listItem:String = myList[0]
        Log.d(TAG, "listados: "+listItem)
        Log.d(TAG, "listados: "+myArrayList[0])
    }

    fun bucleFor(){
        val myArrayList:ArrayList<String> = arrayListOf("Gabriel","Manu","Rebe","Pepe","Carlos")

        for (persona in myArrayList){
            Log.d(TAG, persona)
        }

        for (position in 0..10){ // en lugar de .. con until ignora la ultima posicion
            Log.d(TAG, position.toString())
        }

        for (position in 0..10 step 2){ // de 2 en 2
            Log.d(TAG, position.toString())
        }

        for (position in 10 downTo 6){ // de 10 reduciendo hasta 6
            Log.d(TAG, position.toString())
        }
    }

    fun bucleWhile(){
        var myNumber=0

        while (myNumber <= 10){
            Log.d(TAG, myNumber.toString())
            myNumber++;
        }
    }

    fun bucledoWhile(){
        var myNumber=0

        do{
            Log.d(TAG,myNumber.toString())
            myNumber++
        } while (myNumber <= 10)
    }

     fun controlDeErrores(){
         val myArrayList:ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5)

         try{

         for(posicion in 0..myArrayList.size){
             Log.d(TAG, myArrayList[posicion].toString())
         }
         }catch (exception: IndexOutOfBoundsException){
             exception.printStackTrace()
         }
    }

    //UN PEQUEÑO EJEMPLO
    /*
  1.- Crear una funcion que se llame botDeSeguridad() y llamarla desde nuestro metodo onCreate()
  2.- Crear una clase de datos llamada Persona
  Reglas:
  1.- La clase de datos debe incluir tres constantes llamadas name, age y hobbies (que es un listado de strings)
  2.- Creamos una variable de tipo Persona con nuestra información (nombre, edad y un listado de hobbies)
  3.- Mediante el uso de condicionales nuestro bot debe:
      - Mostrarnos un mensaje de error en caso de que el nombre que tenga la clase Persona no sea el nuestro y
      no dejarnos acceder, o de lo contrario, mostrar el mensaje de éxito y continuar
      - Manejar los siguientes rangos de edad:
          - En caso de que tengamos entre 0 y 17 años, el bot nos dirá que somos menores de edad, y que por tanto
          acceso denegado, en caso de tener entre 65 y 100 nos diría lo mismo pero por ser demasiado mayores y si
          tenemos entre 18 y 64 años dejarnos pasar y mostrar un mensaje de éxito.
      - Por último, recorrer con un bucle nuestros hobbies y mostrarlos por pantalla
  */


    fun botDeSeguridad(){
        val persona = Persona("Gabriel",27, arrayListOf("Programar","futbol","Deportes de Riesgo"))

        if(persona.name=="Gabriel"){
            Log.d(TAG, "Bienvenido ${persona.name} !!")
            when(persona.age){
                in 0..17 -> {
                    Log.d(TAG, "Eres menor de Edad")
                }
                in 18..64 ->{
                    Log.d(TAG, "Bien eres mayor de edad")

                    for (hobbie in persona.hobbies)
                        Log.d(TAG, "Te gusta $hobbie")
                }
                in 65..100 ->{
                    Log.d(TAG, "Eres demasiado mayor")
                }
            }
        }else{
            Log.d(TAG, "No eres Gabriel, Adios ${persona.name} !!")
        }
    }
    data class Persona(
            val name:String,
            val age:Int,
            val hobbies:ArrayList<String>
    )
}