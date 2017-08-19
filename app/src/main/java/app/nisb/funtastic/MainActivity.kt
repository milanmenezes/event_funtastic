package app.nisb.funtastic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import org.json.JSONException
import org.json.JSONObject
import android.content.Intent
import android.R.id.edit
import android.app.PendingIntent.getActivity
import android.content.Context
import android.content.SharedPreferences
import android.content.Context.MODE_PRIVATE
import android.R.id.edit
import android.content.SharedPreferences.Editor



val codes: IntArray = intArrayOf(10, 20, 30, 40, 50, 60, 70)
var curr = 0



class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        q1.visibility = View.GONE
        q2.visibility = View.GONE
        q3.visibility = View.GONE
        q4.visibility = View.GONE
        q5.visibility = View.GONE
        q6.visibility = View.GONE
        q7.visibility = View.GONE


        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
//        val editor = sharedpreferences.edit()
//        editor.putString("current", curr.toString())
//        editor.commit()

        curr = sharedpreferences.getString("current","0").toInt()

        val test = curr

        if (test>=1){
            q1.visibility = View.VISIBLE
        }

        if(test>=2){
            q2.visibility = View.VISIBLE
        }

        if(test>=3){
            q3.visibility = View.VISIBLE
        }

        if(test>=4){
            q4.visibility = View.VISIBLE
        }

        if(test>=5){
            q5.visibility = View.VISIBLE
        }

        if(test>=6){
            q6.visibility = View.VISIBLE
        }

        if(test>=7){
            q7.visibility = View.VISIBLE
        }


        q1.text = "First question text"
        q2.text = "Second question text"
        q3.text = "Third question text"
        q4.text = "Forth question text"
        q5.text = "Fifth question text"
        q6.text = "Sixth question text"
        q7.text = "Seventh question text"


        var qrScan : IntentIntegrator = IntentIntegrator(this)

        qrbtn.setOnClickListener({
            qrScan.initiateScan()
        })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        if (result != null) {
            //if qrcode has nothing in it
            if (result.contents == null) {
                Toast.makeText(applicationContext, "Result Not Found", Toast.LENGTH_LONG).show()
            } else {
                //if qr contains data
                try {
                    //converting the data to json
                    val num = (result.contents).toInt()

                    if (num==codes[curr]){
                        curr+=1

                        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
                        val editor = sharedpreferences.edit()
                        editor.putString("current", curr.toString())
                        editor.commit()


                        if (num==10)
                            q1.visibility = View.VISIBLE

                        if (num==20)
                            q2.visibility = View.VISIBLE

                        if (num==30)
                            q3.visibility = View.VISIBLE

                        if (num==40)
                            q4.visibility = View.VISIBLE

                        if (num==50)
                            q5.visibility = View.VISIBLE

                        if (num==60)
                            q6.visibility = View.VISIBLE

                        if (num==70)
                            q7.visibility = View.VISIBLE

                    }
                    else{
                        Toast.makeText(applicationContext,"Wrong Wrong Wrong !!",Toast.LENGTH_LONG).show()
                    }

                    println(num.toString() + " code")

                } catch (e: JSONException) {
                    e.printStackTrace()

                    Toast.makeText(this, result.contents, Toast.LENGTH_LONG).show()
                }

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
