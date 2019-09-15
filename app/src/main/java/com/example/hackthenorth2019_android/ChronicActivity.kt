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
//        tensionvalue.text = muscle.toString().subSequence(0, 5)
        muscledataset.add(muscle)

        var itr = muscledataset.iterator()
        var index = 0

        // hasNext() returns true if the queue has more elements
        while (itr.hasNext()) {
            // next() returns the next element in the iteration
            if (index == 0) {
                bar0.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 1) {
                bar1.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 2) {
                bar2.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 3) {
                bar3.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 4) {
                bar4.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 5) {
                bar5.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 6) {
                bar6.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 7) {
                bar7.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 8) {
                bar8.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 9) {
                bar9.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }

            index++

        }
        Log.d(TAG, "musclesaet is: $muscledataset")

        var degree = dataset?.getValue("Degree")
//        posturedegrees.text = degree.toString()
        degreedataset.add(degree)
        itr = degreedataset.iterator()
        index = 0

        // hasNext() returns true if the queue has more elements
        while (itr.hasNext()) {
            // next() returns the next element in the iteration
            if (index == 0) {
                pbar0.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 1) {
                pbar1.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 2) {
                pbar2.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 3) {
                pbar3.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 4) {
                pbar4.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 5) {
                pbar5.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 6) {
                pbar6.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 7) {
                pbar7.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 8) {
                pbar8.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }
            if (index == 9) {
                pbar9.layoutParams.height = itr.next().toString().toInt() / 5 * 300
            }

            index++

        }
        Log.d(TAG, "musclesaet is: $degreedataset")

    }
}