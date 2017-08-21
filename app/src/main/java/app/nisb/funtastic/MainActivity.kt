package app.nisb.funtastic

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.zxing.integration.android.IntentIntegrator;
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import org.json.JSONException
import android.content.Intent
import android.content.Context
import android.util.Log
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import com.android.volley.*
import com.android.volley.Response.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley





var code = arrayListOf<String>("a9b7ba70783b617e9998dc4dd82eb3c5",
    "b8c37e33defde51cf91e1e03e51657da",
    "fba9d88164f3e2d9109ee770223212a0",
    "aa68c75c4a77c87f97fb686b2f068676",
    "fed33392d3a48aa149a87a38b875ba4a",
    "2387337ba1e0b0249ba90f55b2ba2521",
    "5f268dfb0fbef44de0f668a022707b86")
var curr = 0
var cur1= 0



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)

        var teamno = sharedpreferences.getString("teamno","1").toInt()

        teamno--

        var group = teamno%3


            q1.visibility = View.GONE
            q2.visibility = View.GONE
            q3.visibility = View.GONE
            q4.visibility = View.GONE
            q5.visibility = View.GONE
            q6.visibility = View.GONE
            q7.visibility = View.GONE




            curr = sharedpreferences.getString("current", "0").toInt()

            val test = curr

            if (test >= 1) {
                q1.visibility = View.VISIBLE
            }

            if (test >= 2) {
                q2.visibility = View.VISIBLE
            }

            if (test >= 3) {
                q3.visibility = View.VISIBLE
            }

            if (test >= 4) {
                q4.visibility = View.VISIBLE
            }

            if (test >= 5) {
                q5.visibility = View.VISIBLE
            }

            if (test >= 6) {
                q6.visibility = View.VISIBLE
            }

            if (test >= 7) {
                q7.visibility = View.VISIBLE
                longToast("Congratulations!!")
            }

        toast((group+1).toString())

        if (group==0) {

            code = arrayListOf<String>("a9b7ba70783b617e9998dc4dd82eb3c5",
                    "b8c37e33defde51cf91e1e03e51657da",
                    "fba9d88164f3e2d9109ee770223212a0",
                    "aa68c75c4a77c87f97fb686b2f068676",
                    "fed33392d3a48aa149a87a38b875ba4a",
                    "2387337ba1e0b0249ba90f55b2ba2521",
                    "5f268dfb0fbef44de0f668a022707b86")

                q0.text = "1) Start from Notice Board!"
                q1.text = "2) Keeping food cold is important you see,\n This is the place where the meal may be."
                q2.text = "3) I am the source of knowledge, found in every knowledge. Even though I vanished,\n but present in your college."
                q3.text = "4) When light goes, E=PZΦn/A come to rescue."
                q4.text = "5) Some like me hot, some like me cold,\n some like me mild but some like me bold."
                q5.text = "6) My birthday is (celebrated as) your day.\n You drink water because of me. Find me in college."
                q6.text = "7) The wheel is come full circle,\n the end of the journey is the beginning of our run."
                q7.text = "Congratulations!!\n You have Completed the Treasure Hunt!!"
            }

        if (group==1) {

            code = arrayListOf<String>("a9b7ba70783b617e9998dc4dd82eb3c5",
                    "d0fb963ff976f9c37fc81fe03c21ea7b",
                    "4ba29b9f9e5732ed33761840f4ba6c53",
                    "2387337ba1e0b0249ba90f55b2ba2521",
                    "b8b4b727d6f5d1b61fff7be687f7970f",
                    "d47268e9db2e9aa3827bba3afb7ff94a",
                    "5f268dfb0fbef44de0f668a022707b86")

            q0.text = "1) Start from Notice Board!"
            q1.text = "2) Its a place of DJ where you go to\n Dance and play, wanna go out take a U-Turn."
            q2.text = "3) I love my girls, you are so sweet,\n This comfy place is where princesses sleep."
            q3.text = "4) My birthday is (celebrated as) your day.\n You drink water because of me. Find me in college."
            q4.text = "5) To solve the hunt , you must get into the room wired with net, crambed with tech and full of code with the clue hidden in this building."
            q5.text = "6) KA 09 ___________ \nI'm the third son in the family.Me, my twin, an elder brother who is twice my age and sister a year younger are standing in an order of birth. sum of our age is 19. Find the blank."
            q6.text = "7) The wheel is come full circle, the end of the journey is the beginning of our run."
            q7.text = "Congratulations!!\n You have Completed the Treasure Hunt!!"
        }

        if (group==2) {

            code = arrayListOf<String>("a9b7ba70783b617e9998dc4dd82eb3c5",
                    "908c9a564a86426585b29f5335b619bc",
                    "2387337ba1e0b0249ba90f55b2ba2521",
                    "a4380923dd651c195b1631af7c829187",
                    "20479c788fb27378c2c99eadcf207e7f",
                    "3a61ed715ee66c48bacf237fa7bb5289",
                    "5f268dfb0fbef44de0f668a022707b86")

            q0.text = "1) Start from Notice Board!"
            q1.text = "2) You pass through me everyday with all the respect, Reminds your identity when he is there for inspect."
            q2.text = "3) My birthday is (celebrated as) your day. You drink water because of me. Find me in college."
            q3.text = "4) Caution is needed going this way, A tarmac place of bay bay bay. Now is the time to leave the car, If you leave here you'll not go far."
            q4.text = "5) I have a pouch but i cant catch fish. I see shots fired and all your colour full sneakers. Find me you seeker."
            q5.text = "6) You gulp it down or sip it slow, this is the place where you forget to frown."
            q6.text = "7) The wheel is come full circle, the end of the journey is the beginning of our run."
            q7.text = "Congratulations!!\n You have Completed the Treasure Hunt!!"
        }



            var qrScan: IntentIntegrator = IntentIntegrator(this)

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

                        if (curr<6){
                        curr+=1
                        }

                        if (cur1<7)
                            cur1+=1

                        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
                        val editor = sharedpreferences.edit()
                        editor.putString("current", curr.toString())
                        editor.commit()

                        var teamno = sharedpreferences.getString("teamno","1").toInt()
                        val queue:RequestQueue = Volley.newRequestQueue(this)
                        val url:String = "http://funtastic.ml/827ccb0eea8a706c4c34a16891f84e7b/"+teamno+"/"+ cur1


                        // Request a string response from the provided URL.
                        val stringRequest = StringRequest(Request.Method.GET, url,
                                Listener<String>{ response ->
                                    // Display the first 500 characters of the response string.
                                    Log.d("volley: ",response.toString())
                                }, ErrorListener {
                            Log.d("volley:","That didn't work!")
                        })

                        // Add the request to the RequestQueue.
                        queue.add(stringRequest)


                        if (num==code[0])
                            q1.visibility = View.VISIBLE

                        if (num==code[1])
                            q2.visibility = View.VISIBLE

                        if (num==code[2])
                            q3.visibility = View.VISIBLE

                        if (num==code[3])
                            q4.visibility = View.VISIBLE

                        if (num==code[4])
                            q5.visibility = View.VISIBLE

                        if (num==code[5])
                            q6.visibility = View.VISIBLE

                        if (num==code[6]) {
                            q7.visibility = View.VISIBLE
                            longToast("Congratulations!!")
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
