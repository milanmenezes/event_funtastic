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





var code = arrayListOf<String>("38b3eff8baf56627478ec76a704e9b52",
    "ec8956637a99787bd197eacd77acce5e",
    "6974ce5ac660610b44d9b9fed0ff9548",
    "c9e1074f5b3f9fc8ea15d152add07294",
    "65b9eea6e1cc6bb9f0cd2a47751a186f",
    "f0935e4cd5920aa6c7c996a5ee53a70f",
    "a97da629b098b75c294dffdc3e463904",
        "a3c65c2974270fd093ee8a9bf8ae7d0b",
        "2723d092b63885e0d7c260cc007e8b9d",
        "5f93f983524def3dca464469d2cf9f3e")
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
            q8.visibility = View.GONE
            q9.visibility = View.GONE
            q10.visibility = View.GONE




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
        }

        if (test >= 8) {
            q8.visibility = View.VISIBLE
        }

        if (test >= 9) {
            q9.visibility = View.VISIBLE
        }

            if (test >= 10) {
                q10.visibility = View.VISIBLE
                longToast("Congratulations!!")
            }

        toast((group+1).toString())

        if (group==0) {

            code = arrayListOf<String>("38b3eff8baf56627478ec76a704e9b52",
                    "ec8956637a99787bd197eacd77acce5e",
                    "6974ce5ac660610b44d9b9fed0ff9548",
                    "c9e1074f5b3f9fc8ea15d152add07294",
                    "65b9eea6e1cc6bb9f0cd2a47751a186f",
                    "f0935e4cd5920aa6c7c996a5ee53a70f",
                    "a97da629b098b75c294dffdc3e463904",
                    "a3c65c2974270fd093ee8a9bf8ae7d0b",
                    "2723d092b63885e0d7c260cc007e8b9d",
                    "5f93f983524def3dca464469d2cf9f3e")

                q0.text = "1) Start from Notice Board!"
                q1.text = "2) Gourmet in an instant. Every moment has its flavor"
                q2.text = "3) A place of all love, with balls from above, \nthe way you must get, is split with a net."
                q3.text = "4) I have no doors or windows, but still stand \nhere with my twin to keep you free from  Hunger"
                q4.text = "5) Gotta keep things green and fresh. \nWhen I’m working, I’ll make your seats wet"
                q5.text = "6) I come to the rescue when you are in trouble every month, \nI have things more than worth, I provide you with all your needs \nbut you gotta walk through a subterrain in return of all  my deeds."
                q6.text = "7) Beside the place of fun and game, I stand big with a greater fame, \nNot many of you have stepped inside it, \nas it takes a test of your technical wit."
                q7.text = "8) Find the shoe to continue the clue."
                q8.text = "9) KA09 is my family name, Try finding my name  110101111000"
                q9.text = "10) Three boys stand in a row, on the face of a door uphold,\n First two being the young twins, the third one is definitely elder and bold. \n Add them up and get a 7 nod, let me tell you all these three brothers are odd."
                q10.text = "Congratulations!!\n You have Completed the Treasure Hunt!!"
            }

        if (group==1) {

            code = arrayListOf<String>("38b3eff8baf56627478ec76a704e9b52",
                    "854d6fae5ee42911677c739ee1734486",
                    "e2c0be24560d78c5e599c2a9c9d0bbd2",
                    "274ad4786c3abca69fa097b85867d9a4",
                    "eae27d77ca20db309e056e3d2dcd7d69",
                    "7eabe3a1649ffa2b3ff8c02ebfd5659f",
                    "69adc1e107f7f7d035d7baf04342e1ca",
                    "091d584fced301b442654dd8c23b3fc9",
                    "b1d10e7bafa4421218a51b1e1f1b0ba2",
                    "5f93f983524def3dca464469d2cf9f3e")

            q0.text = "1) Start from Notice Board!"
            q1.text = "2) I have buttons but I’m not a shirt, I have doors but I’m not a house\nI go up and down but I’m not an umbrella,\nI need at least two stories but I’m not a book of fairytales, I’m found in tall buildings but I’m not a penthouse"
            q2.text = "3) It’s been a long day, I’m about to burst, rush to me to quench your thirst"
            q3.text = "4) You use me and yet I don’t complain, a seeking green puppet under the blue sky who holds your mess"
            q4.text = "5) There's a place your teachers meet,  a portal place where people greet,  also keep lost and found,  find this area with a fine toothed comb"
            q5.text = "6) An elevated place with substance and a story where many masquerades with their hidden talents carve a path to their glory"
            q6.text = "7) I have a net but do not catch, you go up and down but I stand still watching the match."
            q7.text = "8) I’m a landmark,  I’m a mystery who keeps all your secrets safe. Saving you from the sunburn, wanna go somewhere? Take a n U-turn."
            q8.text = "9) Known for shatarupa, the one praised by the wise, she resides in our college in the form of ___"
            q9.text = "10) Three boys stand in a row, on the face of a door uphold, First two being the young twins, the third one is definitely elder and bold.  Add them up and get a 7 nod, let me tell you all these three brothers are odd."
            q10.text = "Congratulations!!\n You have Completed the Treasure Hunt!!"
        }

        if (group==2) {

            code = arrayListOf<String>("38b3eff8baf56627478ec76a704e9b52",
                    "577bcc914f9e55d5e4e4f82f9f00e7d4",
                    "11b9842e0a271ff252c1903e7132cd68",
                    "37bc2f75bf1bcfe8450a1a41c200364c",
                    "496e05e1aea0a9c4655800e8a7b9ea28",
                    "b2eb7349035754953b57a32e2841bda5",
                    "8e98d81f8217304975ccb23337bb5761",
                    "a8c88a0055f636e4a163a5e3d16adab7",
                    "eddea82ad2755b24c4e168c5fc2ebd40",
                    "5f93f983524def3dca464469d2cf9f3e")

            q0.text = "1) Start from Notice Board!"
            q1.text = "2) I'm full of water, but don't take a sip. I'm for feathered friends who want a dip."
            q2.text = "3) Seek not any higher, I hide behind tyre, Now is the time to leave the car\n" +
                    "If you leave from here you’ll go far"
            q3.text = "4) I’m a 7 lettered word, the first 3 letters make you drink from me and the other 4 is a phase of life. The clue is easy to crack, when you are hungry and all dark"
            q4.text = "5) I’m the biggest, I’m the gloriest. I treasure all the Musical nights and dance fights."
            q5.text = "6) Oh how you boys wish to take a look inside, but here I sit in my small room pushing you all aside."
            q6.text = "7) An open air place for your athletic skills to show, where we all sweat but never frown, look beneath you, isn't the colour just too brown?"
            q7.text = "8) Dare you come near me, I can burn you blight. I’m the supreme power who keeps your room bright."
            q8.text = "9) You pass through me, I welcome you all. Don’t be late, or else you have to climb the wall."
            q9.text = "10) Three boys stand in a row, on the face of a door uphold,\n First two being the young twins, the third one is definitely elder and bold. \n Add them up and get a 7 nod, let me tell you all these three brothers are odd."
            q10.text = "Congratulations!!\n You have Completed the Treasure Hunt!!"
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

                        if (curr<9){
                        curr+=1
                        }

                        if (cur1<10)
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

                        if (num==code[6])
                            q7.visibility = View.VISIBLE

                        if (num==code[7])
                            q8.visibility = View.VISIBLE

                        if (num==code[8])
                            q9.visibility = View.VISIBLE

                        if (num==code[9]) {
                            q10.visibility = View.VISIBLE
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
