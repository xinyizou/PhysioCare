package com.example.hackthenorth2019_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chronic.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.HashMap

class ChronicActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    var muscledataset: Queue<Any> = ArrayDeque<Any>(10)
    var degreedataset: Queue<Any> = ArrayDeque<Any>(10)
    var ohmdataset: Queue<Any> = ArrayDeque<Any>(10)

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronic)
        database = FirebaseDatabase.getInstance().reference
        readFB()

    }

    fun readFB() {

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Subset1")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataset = dataSnapshot.getValue(object : GenericTypeIndicator<HashMap<String, Any>?>(){})

                Log.d(TAG, "Value is: $dataset")

                parseData(dataset)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
        // [END read_message]
    }

    fun parseData(dataset : HashMap<String, Any>?) {

        var muscle = dataset?.getValue("Muscle")
        tensionvalue.text = muscle.toString().subSequence(0, 5)
        muscledataset.add(muscle)
        Log.d(TAG, "musclesaet is: $muscledataset")

        var degree = dataset?.getValue("Degree")
        posturedegrees.text = degree.toString()
        degreedataset.add(degree)
        Log.d(TAG, "musclesaet is: $degreedataset")

        var resistance = dataset?.getValue("Resistance")
        postureohm.text = resistance.toString().format("%.2f")
        ohmdataset.add(resistance)
        Log.d(TAG, "musclesaet is: $muscledataset")
//        var message = dataset?.getValue("Message")
//        var pressure = dataset?.getValue("Pressure")
    }
}