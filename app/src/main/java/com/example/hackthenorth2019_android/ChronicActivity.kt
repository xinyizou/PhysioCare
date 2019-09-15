package com.example.hackthenorth2019_android

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.core.app.NotificationCompat
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_chronic.*
import kotlin.collections.HashMap

class ChronicActivity : AppCompatActivity() {

    private val ACTION_UPDATE_NOTIFICATION = "com.android.example.notifyme.ACTION_UPDATE_NOTIFICATION"

    private val NOTIFICATION_ID = 1

    private val PRIMARY_CHANNEL_ID = "primary_notification_channel"
    private var mNotifyManager: NotificationManager? = null

    private lateinit var database: DatabaseReference
    var muscledataset0: Float = 0f
    var degreedataset0: Float = 0f
    var muscledataset1: Float = 0f
    var degreedataset1: Float = 0f
    var muscledataset2: Float = 0f
    var degreedataset2: Float = 0f
    var muscledataset3: Float = 0f
    var degreedataset3: Float = 0f
    var muscledataset4: Float = 0f
    var degreedataset4: Float = 0f
    var muscledataset5: Float = 0f
    var degreedataset5: Float = 0f
    var muscledataset6: Float = 0f
    var degreedataset6: Float = 0f
    var muscledataset7: Float = 0f
    var degreedataset7: Float = 0f
    var muscledataset8: Float = 0f
    var degreedataset8: Float = 0f
    var muscledataset9: Float = 0f
    var degreedataset9: Float = 0f

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronic)

        createNotificationChannel()

        database = FirebaseDatabase.getInstance().reference
        readFB()
    }

    fun readFB() {

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("Subset1")
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val dataset = dataSnapshot.getValue(object : GenericTypeIndicator<HashMap<String, Any>?>(){})

                parseData(dataset)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
            }
        })
        // [END read_message]
    }

    fun parseData(dataset : HashMap<String, Any>?) {

        var muscle = dataset?.getValue("Muscle").toString().toFloat()
//        tensionvalue.text = muscle.toString().subSequence(0, 5)
        muscledataset0 = muscledataset1
        muscledataset1 = muscledataset2
        muscledataset2 = muscledataset3
        muscledataset3 = muscledataset4
        muscledataset4 = muscledataset5
        muscledataset5 = muscledataset6
        muscledataset6 = muscledataset7
        muscledataset7 = muscledataset8
        muscledataset8 = muscledataset9
        muscledataset9 = muscle

        var avgmuscle = (muscledataset0 + muscledataset1 + muscledataset2 + muscledataset3 + muscledataset4 + muscledataset5 + muscledataset6 + muscledataset7 + muscledataset8 + muscledataset9)/10

        tensiontext.text = "Muscle tension is " + muscle + " volts"
        if (muscle > 4.0) {
            tensiontext.setTextColor(Color.RED)
        }

        else if (muscle < 4.0) {
            tensiontext.setTextColor(Color.BLACK)
        }


        var data9 = (muscledataset9/5f*300f).toInt()
        val params9 = bar9.getLayoutParams() as LinearLayout.LayoutParams
        params9.height = data9
        bar9.setLayoutParams(params9)
        Log.d(TAG, "$data9")

        var data8 = (muscledataset8/5f*300f).toInt()
        val params8 = bar8.getLayoutParams() as LinearLayout.LayoutParams
        params8.height = data8
        bar8.setLayoutParams(params8)

        var data7 = (muscledataset7/5f*300f).toInt()
        val params7 = bar7.getLayoutParams() as LinearLayout.LayoutParams
        params7.height = data7
        bar7.setLayoutParams(params7)

        var data6 = (muscledataset6/5f*300f).toInt()
        val params6 = bar6.getLayoutParams() as LinearLayout.LayoutParams
        params6.height = data6
        bar6.setLayoutParams(params6)


        var data5 = (muscledataset5/5f*300f).toInt()
        val params5 = bar5.getLayoutParams() as LinearLayout.LayoutParams
        params5.height = data5
        bar5.setLayoutParams(params5)

        var data4 = (muscledataset4/5f*300f).toInt()
        val params4 = bar4.getLayoutParams() as LinearLayout.LayoutParams
        params4.height = data4
        bar4.setLayoutParams(params4)

        var data3 = (muscledataset3/5f*300f).toInt()
        val params3 = bar3.getLayoutParams() as LinearLayout.LayoutParams
        params3.height = data3
        bar3.setLayoutParams(params3)

        var data2 = (muscledataset2/5f*300f).toInt()
        val params2 = bar2.getLayoutParams() as LinearLayout.LayoutParams
        params2.height = data2
        bar2.setLayoutParams(params2)

        var data1 = (muscledataset1/5f*300f).toInt()
        val params1 = bar1.getLayoutParams() as LinearLayout.LayoutParams
        params1.height = data1
        bar1.setLayoutParams(params1)

        var data0 = (muscledataset0/5f*300f).toInt()
        val params0 = bar0.getLayoutParams() as LinearLayout.LayoutParams
        params0.height = data0
        bar0.setLayoutParams(params0)


        var degree = dataset?.getValue("Degree").toString().toFloat()
//        tensionvalue.text = degree.toString().subSequence(0, 5)
        degreedataset0 = degreedataset1
        degreedataset1 = degreedataset2
        degreedataset2 = degreedataset3
        degreedataset3 = degreedataset4
        degreedataset4 = degreedataset5
        degreedataset5 = degreedataset6
        degreedataset6 = degreedataset7
        degreedataset7 = degreedataset8
        degreedataset8 = degreedataset9
        degreedataset9 = degree

        var avgdegree = (degreedataset0 + degreedataset1 + degreedataset2 + degreedataset3 + degreedataset4 + degreedataset5 + degreedataset6 + degreedataset7 + degreedataset8 + degreedataset9)/10

        posturetext.text = "Posture degree is " + degree

        if (degree > 30.0) {
            posturetext.setTextColor(Color.RED)
        }

        else if (degree < 30.0) {
            posturetext.setTextColor(Color.BLACK)
        }

        var ddata9 = (degreedataset9/360f*300f).toInt()
        val dparams9 = pbar9.getLayoutParams() as LinearLayout.LayoutParams
        dparams9.height = ddata9
        pbar9.setLayoutParams(dparams9)
        Log.d(TAG, "$ddata9")

        var ddata8 = (degreedataset8/360f*300f).toInt()
        val dparams8 = pbar8.getLayoutParams() as LinearLayout.LayoutParams
        dparams8.height = ddata8
        pbar8.setLayoutParams(dparams8)

        var ddata7 = (degreedataset7/360f*300f).toInt()
        val dparams7 = pbar7.getLayoutParams() as LinearLayout.LayoutParams
        dparams7.height = ddata7
        pbar7.setLayoutParams(dparams7)

        var ddata6 = (degreedataset6/360f*300f).toInt()
        val dparams6 = pbar6.getLayoutParams() as LinearLayout.LayoutParams
        dparams6.height = ddata6
        pbar6.setLayoutParams(dparams6)

        var ddata5 = (degreedataset5/360f*300f).toInt()
        val dparams5 = pbar5.getLayoutParams() as LinearLayout.LayoutParams
        dparams5.height = ddata5
        pbar5.setLayoutParams(dparams5)

        var ddata4 = (degreedataset4/360f*300f).toInt()
        val dparams4 = pbar4.getLayoutParams() as LinearLayout.LayoutParams
        dparams4.height = ddata4
        pbar4.setLayoutParams(dparams4)

        var ddata3 = (degreedataset3/360f*300f).toInt()
        val dparams3 = pbar3.getLayoutParams() as LinearLayout.LayoutParams
        dparams3.height = ddata3
        pbar3.setLayoutParams(dparams3)

        var ddata2 = (degreedataset2/360f*300f).toInt()
        val dparams2 = pbar2.getLayoutParams() as LinearLayout.LayoutParams
        dparams2.height = ddata2
        pbar2.setLayoutParams(dparams2)

        var ddata1 = (degreedataset1/360f*300f).toInt()
        val dparams1 = pbar1.getLayoutParams() as LinearLayout.LayoutParams
        dparams1.height = ddata1
        pbar1.setLayoutParams(dparams1)

        var ddata0 = (degreedataset0/360f*300f).toInt()
        val dparams0 = pbar0.getLayoutParams() as LinearLayout.LayoutParams
        dparams0.height = ddata0
        pbar0.setLayoutParams(dparams0)

        //var danger = false;
        if (avgmuscle > 4.0 && avgdegree > 30.0) {
            //danger = true;
            sendNotification("Bad posture strains muscles and tendons, please refer to our guide for proper posture.")
        }

        else if (avgmuscle > 4.0) {
            sendNotification("Your muscles are extremely tense, likely due to prolonged sitting. We recommend that you stretch as soon as possible.")
        }
    }

    fun createNotificationChannel() {

        // Create a notification manager object.
        val mNotifyManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        // Notification channels are only available in OREO and higher.
        // So, add a check on SDK version.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            // Create the NotificationChannel with all the parameters.
            val notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID, "Mascot Notif",
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Mascot desc"

            mNotifyManager.createNotificationChannel(notificationChannel)
        }
    }
    fun sendNotification(msg: String) {

        // Sets up the pending intent to update the notification.
        // Corresponds to a press of the Update Me! button.
        val updateIntent = Intent(ACTION_UPDATE_NOTIFICATION)
        val updatePendingIntent = PendingIntent.getBroadcast(
            this,
            NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT
        )

        // Build the notification with all of the parameters using helper
        // method.
        val notifyBuilder = getNotificationBuilder(msg)

        // Deliver the notification.
        mNotifyManager?.notify(NOTIFICATION_ID, notifyBuilder.build())

    }

    private fun getNotificationBuilder(msg: String): NotificationCompat.Builder {

        // Set up the pending intent that is delivered when the notification
        // is clicked.
        val notificationIntent = Intent(this, MainActivity::class.java)
        val notificationPendingIntent = PendingIntent.getActivity(
            this, NOTIFICATION_ID, notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Build the notification with all of the parameters.
        return NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
            .setContentTitle("title")
            .setContentText(msg)
            .setAutoCancel(true).setContentIntent(notificationPendingIntent)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDefaults(NotificationCompat.DEFAULT_ALL)
    }


}