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
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast



//val codes: IntArray = intArrayOf(10, 20, 30, 40, 50, 60, 70)
val code = arrayListOf<String>("a9b7ba70783b617e9998dc4dd82eb3c5","b8c37e33defde51cf91e1e03e51657da","fba9d88164f3e2d9109ee770223212a0","aa68c75c4a77c87f97fb686b2f068676","fed33392d3a48aa149a87a38b875ba4a","2387337ba1e0b0249ba90f55b2ba2521","9246444d94f081e3549803b928260f56")
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
            longToast("Congradulations!!")
        }


        q0.text = "1) Start from the Notice Board!"
        q1.text = "2) You pass through me everyday with all the respect,\n Remainds your identity when he is there for inspect"
        q2.text = "3) I love my girls, you are so sweet,\n This comfy place is where princesses sleep"
        q3.text = "4) My birthday is (celebrated as)your day.\n You drink water because of me. Find me in college"
        q4.text = "5) To solve the hunt , you must get into the room wired with net, crambed with tech and full of code with the clue hidden in this building"
        q5.text = "6) KA 09 ___________ \nIm the third son in the family.Me, my twin, an elder brother who is twice my age and sister a year younger are standing in an order of birth. sum of our age is 19. find the blank."
        q6.text = "7) Seventh question text"
        q7.text = "Congradulations!!\n You have Completed the Treasure Hunt!!"


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
                toast("Result Not Found")
            } else {
                //if qr contains data
                try {

//                    val num = (result.contents).toInt()
                    val num = (result.contents).toString()

                    if (num==code[curr]){
                        curr+=1

                        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
                        val editor = sharedpreferences.edit()
                        editor.putString("current", curr.toString())
                        editor.commit()


                        if (num=="a9b7ba70783b617e9998dc4dd82eb3c5")
                            q1.visibility = View.VISIBLE

                        if (num=="b8c37e33defde51cf91e1e03e51657da")
                            q2.visibility = View.VISIBLE

                        if (num=="fba9d88164f3e2d9109ee770223212a0")
                            q3.visibility = View.VISIBLE

                        if (num=="aa68c75c4a77c87f97fb686b2f068676")
                            q4.visibility = View.VISIBLE

                        if (num=="fed33392d3a48aa149a87a38b875ba4a")
                            q5.visibility = View.VISIBLE

                        if (num=="2387337ba1e0b0249ba90f55b2ba2521")
                            q6.visibility = View.VISIBLE

                        if (num=="9246444d94f081e3549803b928260f56") {
                            q7.visibility = View.VISIBLE
                            longToast("Congradulations!!")
                        }

                    }
                    else{
                        toast("Wrong Location!")
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
