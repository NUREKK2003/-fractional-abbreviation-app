package com.example.skracaczulamkowapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.skracaczulamkowapp.databinding.ActivityMainBinding

private lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun Skracanie(licznik:Int,mianownik:Int){
            var nwd:Int = NWD(licznik,mianownik)
            var calkowita:Int = licznik/mianownik

            binding.Calkowita.text = calkowita.toString()

            binding.LicznikNiew.text = (licznik/nwd).toString()
            binding.LicznikWlaw.text = (licznik/nwd-mianownik*calkowita/nwd).toString()

            binding.MianownikNiew.text = (mianownik/nwd).toString()
            binding.MIanownikWlasc.text = (mianownik/nwd).toString()

        }

        binding.Licznik.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if(binding.Mianownik.text.toString() != "" && binding.Licznik.text.toString() !=""){

                    var licznik1:Int = Integer.parseInt(binding.Licznik.text.toString())
                    var mianownik1:Int = Integer.parseInt(binding.Mianownik.text.toString())
                    Skracanie(licznik1,mianownik1)
                }

            }

        })

        binding.Mianownik.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                if(binding.Mianownik.text.toString() != "" && binding.Licznik.text.toString() !=""){
                    var licznik1:Int = Integer.parseInt(binding.Licznik.text.toString())
                    var mianownik1:Int = Integer.parseInt(binding.Mianownik.text.toString())
                    Skracanie(licznik1,mianownik1)
                }

            }

        })


    }



}

fun NWD(a1:Int,b1:Int): Int {
    var a:Int = a1
    var b:Int = b1
    while (a!=b){
        if (a>b){
            a -= b
        }
        else{
            b -= a
        }

    }
    return b
}