package com.demo.demoui24

import android.app.DatePickerDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.demo.demoui24.databinding.ActivityMainBinding
import org.json.JSONObject
import java.util.*

class MainActivity : AppCompatActivity() {

    private var jsonDataForm1: JSONObject? = null
    private var jsonDataForm2: JSONObject? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.layout2.etDate.setOnClickListener {
            showDatePickerDialog()
        }

        binding.layout2.btnSave.setOnClickListener {
            if (checkAllFields()) {
                jsonDataForm1 = createJsonForm1()
            }
        }

        binding.layout2.btnNext.setOnClickListener {
            if (jsonDataForm1 != null) {
                binding.layout2.root.visibility = View.GONE
                binding.layout1.root.visibility = View.VISIBLE
            }
            else {
                Toast.makeText(this, "Please Complete And Save the form 1", Toast.LENGTH_LONG).show()
            }
        }
        binding.layout1.btnSave.setOnClickListener {
            if (checkForm2Fields()) {
                jsonDataForm2 = createJsonForm2()
            }
        }

        binding.layout1.btnNext.setOnClickListener {
            if (jsonDataForm2!=null) {
                var intent = Intent(this, ResultActivity::class.java).also {
                    it.putExtra("data", jsonDataForm1.toString())
                    it.putExtra("data2", jsonDataForm2.toString())
                    startActivity(it)
                }
            }
            else {
                Toast.makeText(this, "Please Complete the form 2", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun createJsonForm1(): JSONObject {
        val name = binding.layout2.etName.text
        val address = binding.layout2.etAddress.text
        val mobile = binding.layout2.etMobile.text
        val desc = binding.layout2.etDescription.text
        val location = binding.layout2.etLocation.text
        val test = binding.layout2.etTest.text
        val date = binding.layout2.etDate.text

        val rootObject= JSONObject()
        rootObject.put("name", name)
        rootObject.put("address", address)
        rootObject.put("mobile", mobile)
        rootObject.put("description", desc)
        rootObject.put("location", location)
        rootObject.put("test", test)
        rootObject.put("date", date)

        Toast.makeText(this, "Details Saved", Toast.LENGTH_LONG).show()

        return rootObject
    }

    private fun createJsonForm2(): JSONObject {
        val c1r1 = binding.layout1.c1r1.text
        val c2r1 = binding.layout1.c2r1.text
        val c3r1 = binding.layout1.c3r1.text
        val c1r2 = binding.layout1.c1r2.text
        val c2r2 = binding.layout1.c2r2.text
        val c3r2 = binding.layout1.c3r2.text
        val c1r3 = binding.layout1.c1r3.text
        val c2r3 = binding.layout1.c2r3.text
        val c3r3 = binding.layout1.c3r3.text
        val c1r4 = binding.layout1.c1r4.text
        val c2r4 = binding.layout1.c2r4.text
        val c3r4 = binding.layout1.c3r4.text
        val c1r5 = binding.layout1.c1r5.text
        val c2r5 = binding.layout1.c2r5.text
        val c3r5 = binding.layout1.c3r5.text

        val rootObject= JSONObject()
        rootObject.put("c1r1", c1r1)
        rootObject.put("c2r1", c2r1)
        rootObject.put("c3r1", c3r1)
        rootObject.put("c1r2", c1r2)
        rootObject.put("c2r2", c2r2)
        rootObject.put("c3r2", c3r2)
        rootObject.put("c1r3", c1r3)
        rootObject.put("c2r3", c2r3)
        rootObject.put("c3r3", c3r3)
        rootObject.put("c1r4", c1r4)
        rootObject.put("c2r4", c2r4)
        rootObject.put("c3r4", c3r4)
        rootObject.put("c1r5", c1r5)
        rootObject.put("c2r5", c2r5)
        rootObject.put("c3r5", c3r5)

        Toast.makeText(this, "Details Saved", Toast.LENGTH_LONG).show()

        return rootObject
    }

    private fun showDatePickerDialog() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                binding.layout2.etDate.setText(dat)
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun checkAllFields(): Boolean {

        if (binding.layout2.etName.length() == 0) {
            binding.layout2.etName.setError("Name is required")
            return false
        }
        if (binding.layout2.etAddress.length() == 0) {
            binding.layout2.etAddress.setError("Address is required")
            return false
        }
        if (binding.layout2.etDate.length()==0) {
            binding.layout2.etDate.error = "This field is required"
            return false
        }
        if (binding.layout2.etMobile.length() < 10){
            binding.layout2.etMobile.setError("Mobile is required")
            return false
        }
        if (binding.layout2.etLocation.length() == 0) {
            binding.layout2.etLocation.setError("Location is required")
            return false
        }
        if (binding.layout2.etDescription.length() == 0) {
            binding.layout2.etDescription.setError("Description is required")
            return false
        }
        if (binding.layout2.etTest.length() == 0){
            binding.layout2.etTest.setError("Test is required")
            return false
        }
        return true
    }

    private fun checkForm2Fields(): Boolean {

        val mainView = binding.layout1

        if (
            mainView.c1r1.length() == 0 ||
            mainView.c2r1.length() == 0 ||
            mainView.c3r1.length() == 0 ||
            mainView.c1r2.length() == 0 ||
            mainView.c2r2.length() == 0 ||
            mainView.c3r2.length() == 0 ||
            mainView.c1r3.length() == 0 ||
            mainView.c2r3.length() == 0 ||
            mainView.c3r3.length() == 0 ||
            mainView.c1r4.length() == 0 ||
            mainView.c2r4.length() == 0 ||
            mainView.c3r4.length() == 0 ||
            mainView.c1r5.length() == 0 ||
            mainView.c2r5.length() == 0 ||
            mainView.c3r5.length() == 0
        )
        {
            return false
        }
        else {
            Toast.makeText(this, "Please Complete the form", Toast.LENGTH_LONG).show()
        }
        return true
    }
}