package app.nisb.funtastic

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast


class login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
        var state = sharedpreferences.getString("state","start")
        if (state=="next") {
            startActivity(intentFor<MainActivity>())
        }


        submit.setOnClickListener {
            if (teamno.text.toString().trim()!="" && teamno.text.toString().toInt() > 0) {
                val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
                val editor = sharedpreferences.edit()
                editor.putString("state", "next")
                editor.putString("teamno", teamno.text.toString())
                editor.commit()
                startActivity(intentFor<MainActivity>())
            }

            else {
                toast("Enter valid Team Number")
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val sharedpreferences = getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE)
        var state = sharedpreferences.getString("state","start")
        if (state=="next")
            this.finish()




    }
}
