package com.example.cursokotlinprincipiantes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
val TAG=":::TAG"
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val estructuras=EstructurasDeControl()

        var name="Gabriel"
        //variablesYConstantes()
        //tiposDeDatos()
        //operadores()
        //nullSafety()
        //funciones()
        //clases()
        //interfaces()
        //estructuras.condicionales()
        //estructuras.condicionalesWhen()
        //estructuras.listados()
        //estructuras.bucleFor()
        //estructuras.bucleWhile()
        //estructuras.bucledoWhile()
        //estructuras.controlDeErrores()
        estructuras.botDeSeguridad()

    }

    //las funciones se declaran con fun y el nombre
    private fun variablesYConstantes(){

        //var --> variable
        //val --> constante

        var myFirstVariable="HelloWorld"
        Log.d(TAG,myFirstVariable)

    }

    private fun tiposDeDatos(){
        var string = "My string"
        var number = 10
        var number2:Long =100 //especificando tipo
        Log.d(TAG, "tiposDeDatos: "+number)

    }

    private fun operadores(){
        val firstValue=5
        val secondValue=2

        val suma=firstValue+secondValue
        val resta = firstValue-secondValue
        val mul=firstValue*secondValue
        val div=firstValue/secondValue
        val resto=firstValue%secondValue

        Log.i(TAG, "operadores: "+suma)
        Log.i(TAG, "operadores: "+resta)
        Log.i(TAG, "operadores: "+mul)
        Log.i(TAG, "operadores: "+div)
        Log.i(TAG, "operadores: "+resto)

        val igual = firstValue == secondValue
        val diferente = firstValue != secondValue
        // >= <= o tambien  > y <

        Log.i(TAG, "operadores: "+igual)
        Log.i(TAG, "operadores: "+diferente)

        //operadores logicos (and y or)

        val conjuncion=igual && diferente
        val disyuncion=igual || diferente

        Log.i(TAG, "operadores: "+conjuncion)
        Log.i(TAG, "operadores: "+disyuncion)
    }

    private fun nullSafety(){
        val nullString:String? = null // ? indica que puede ser nula

        if(nullString != null){

            Log.d(TAG, "nullSafety: "+nullString)
        }

        nullString?.let {
            Log.d(TAG, "nullSafety: No es nulo "+nullString) //Se ejecuta solo si no es nulo (la misma funcion que el if anterior)
        } ?: kotlin.run { Log.d(TAG, "nullSafety: Es nulo: "+nullString) } //se ejecuta cuando es nulo
    }

    private fun funciones(){
        nullSafety() //funcion simple
        funcionConParametros("Gabriel") //Con parametros

        val res=funcioRetorno(5,5) //Con retorno
        Log.d(TAG, "funciones: "+res)
    }

    private fun funcionConParametros(name: String){
        Log.d(TAG, "funcionConParametros: "+name)
    }
    private fun funcioRetorno(num1: Int, num2: Int): Int{
        val suma= num1+num2
        return suma
    }

    private fun clases(){
       val gab= Persona("Gabriel")
       val manu= Persona("Manuel")
        gab.presentacion()
        manu.presentacion()

        val rebe=Persondata("rebeca",21)
        val rebeca=Persona2(rebe)
        rebeca.presentacion()

    }

    class Persona(private val name: String){
        fun presentacion(){
            Log.d(TAG, "My name is $name")
        }
    }
    class Persona2(private val data: Persondata){
        fun presentacion(){
            Log.d(TAG, "My name is ${data.name} and my age is ${data.age}")
        }
    }

    data class Persondata( //Clase de datos
        val name: String?,
        val age: Int
    )

    private fun interfaces(){
        val manuelData=Persondata("Manu",25)
        val manu=SecondPerson(manuelData)
        manu.presentacion()
        val cash:Int = manu.Cash(0)
        Log.d(TAG, "interfaces: CASH "+cash)

    }

    class SecondPerson(private val data: Persondata): PersonInterface{
        fun presentacion(){
            Log.d(TAG, "My name is ${data.name} and my age is ${data.age}")
        }

        override fun Cash(funcioRetorno: Int): Int = 1000*5

    }
    interface PersonInterface{

        fun Cash(funcioRetorno: Int): Int
    }
}