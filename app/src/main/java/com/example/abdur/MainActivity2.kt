package com.example.abdur

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)



        val swDegreeCert = findViewById<Switch>(/* id = */ R.id.swDegreeCert)
        val spnDegree = findViewById(R.id.spnDegree) as Spinner
        val spnCertificate = findViewById(R.id.spnCertificate) as Spinner
        val txtCertificate = findViewById(R.id.lblCertificate) as TextView
        val txtDegree = findViewById(R.id.lblDegree) as TextView
        val btnNext = findViewById(R.id.btnNext) as Button
        val firstName = findViewById(R.id.txtFirstName) as EditText
        val lastName = findViewById(R.id.txtLastName) as EditText
        val phone = findViewById(R.id.txtPhone) as EditText
        val spMonth = findViewById(R.id.spnMonth) as Spinner
        val txtDay = findViewById(R.id.txtDay) as EditText
        val txtYear = findViewById(R.id.txtYear) as EditText


        firstName.requestFocus()
        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->

            if (isChecked) {
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE


            } else {

                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE

            }
        }
    btnNext.setOnClickListener {
        if(checkData()){
            var doBirth = ""
            doBirth = spMonth.selectedItem.toString() +  "/" + txtDay.text.toString() + "/" + txtYear.text.toString()
            val nextScreen  = Intent(this@MainActivity2 , ChooseClass ::class.java)
            nextScreen.putExtra("FirstName" , firstName.text.toString())
            nextScreen.putExtra("LastName" , lastName.text.toString())
            nextScreen.putExtra("Phone" , phone.text.toString())
            nextScreen.putExtra("BirthDate" , doBirth)

            if(spnDegree.visibility == View.VISIBLE)
            {
                nextScreen.putExtra("isDegreeCert" , "Degree")
                nextScreen.putExtra("degreeCert" , spnDegree.selectedItem.toString())

            }
            else{
                nextScreen.putExtra("isDegreeCert" , "Certificate")
                nextScreen.putExtra("degreeCert" , spnCertificate.selectedItem.toString())
            }

                startActivity(nextScreen)
        }


    }

            }
    private fun checkData(): Boolean{

        val firstName = findViewById(R.id.txtFirstName) as EditText
        val lastName = findViewById(R.id.txtLastName) as EditText
        val phone = findViewById(R.id.txtPhone) as EditText
        val spMonth = findViewById(R.id.spnMonth) as Spinner
        val txtDay = findViewById(R.id.txtDay) as EditText
        val txtYear = findViewById(R.id.txtYear) as EditText

        if(firstName.text.toString().isEmpty())
        {
            firstName.error = "Invalid First Name"
            firstName.requestFocus()
        }
        else{
            lastName.error = "Invalid First Name"
            lastName.requestFocus()
        }


        return true
    }

    }
