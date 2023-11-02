package eu.tutorials.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var tvInput: TextView? = null
    var lastNumeric: Boolean = false
    var firstNumeric: Boolean = true
    var btnOne: Button? = null
    var btnTwo: Button? = null
    var btnThree: Button? = null
    var btnFour: Button? = null
    var btnFive: Button? = null
    var btnSix: Button? = null
    var btnSeven: Button? = null
    var btnEight: Button? = null
    var btnNine: Button? = null
    var btnZero: Button? = null
    var lastDot: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvInput = findViewById(R.id.tvInput)
        btnOne = findViewById(R.id.btnOne)
        btnTwo = findViewById(R.id.btnTwo)
        btnThree = findViewById(R.id.btnThree)
        btnFour = findViewById(R.id.btnFour)
        btnFive = findViewById(R.id.btnFive)
        btnSix = findViewById(R.id.btnSix)
        btnSeven = findViewById(R.id.btnSeven)
        btnEight = findViewById(R.id.btnEight)
        btnNine = findViewById(R.id.btnNine)
        btnZero = findViewById(R.id.btnZero)

    btnOne?.setOnClickListener {
        tvInput?.append("1")
        btnOne?.setBackgroundColor(Color.BLACK)
       onDigitTwo()
        onDigitThree()
    }

        btnTwo?.setOnClickListener { tvInput?.append("2")
            btnTwo?.setBackgroundColor(Color.DKGRAY)
        }
        btnThree?.setOnClickListener {  tvInput?.append("3")
            btnThree?.setBackgroundColor(Color.BLUE) }
        btnFour?.setOnClickListener { tvInput?.append("4")
            btnFour?.setBackgroundColor(Color.RED)
        onDigitFive()
            onDigitSix()

        }
        btnFive?.setOnClickListener { tvInput?.append("5")
            btnFive?.setBackgroundColor(Color.MAGENTA) }
        btnSix?.setOnClickListener {  tvInput?.append("6")
            btnSix?.setBackgroundColor(Color.YELLOW) }
        btnSeven?.setOnClickListener {   tvInput?.append("7")
            btnSeven?.setBackgroundColor(Color.CYAN)
        onDigitEight()
            onDigitNine()
        }
        btnEight?.setOnClickListener { tvInput?.append("8")
            btnEight?.setBackgroundColor(Color.DKGRAY) }
        btnNine?.setOnClickListener { tvInput?.append("9")
            btnNine?.setBackgroundColor(getColor(R.color.af_Blue)) }
        btnZero?.setOnClickListener {
            //onDigitZero()
            tvInput?.append("0")
            btnZero?.setBackgroundColor(Color.GREEN)
            if(Integer.parseInt(tvInput?.text.toString())>0 ) {
                tvInput?.append("0")
            }
            else
            {
                tvInput?.text="0"
            }
        }





    }



        fun onDigitTwo() {
            tvInput?.append("2")
            btnTwo?.setBackgroundColor(Color.DKGRAY)
        }

        fun onDigitThree() {
            tvInput?.append("3")
            btnThree?.setBackgroundColor(Color.BLUE)
        }

        fun onDigitFour() {
            tvInput?.append("4")
            btnFour?.setBackgroundColor(Color.BLACK)

            onDigitFive()
            onDigitSix()
        }

        fun onDigitFive() {
            tvInput?.append("5")
            btnFive?.setBackgroundColor(Color.MAGENTA)
        }

        fun onDigitSix() {
            tvInput?.append("6")
            btnSix?.setBackgroundColor(Color.YELLOW)
        }

        fun onDigitSeven() {
            tvInput?.append("7")
            btnSeven?.setBackgroundColor(Color.CYAN)

            onDigitEight()
            onDigitNine()
        }

        fun onDigitEight() {
            tvInput?.append("8")
            btnEight?.setBackgroundColor(Color.DKGRAY)
        }

        fun onDigitNine() {
            tvInput?.append("9")
            btnNine?.setBackgroundColor(Color.GRAY)
        }

        fun onDigitZero() {
            //tvInput?.append("0")
            btnZero?.setBackgroundColor(Color.BLACK)

            if(Integer.parseInt(tvInput?.text.toString())>0 ) {
                tvInput?.append("0")
            }
            else
            {
                tvInput?.text="0"
            }

        }


        fun onDigit(view: View) {
            if ((view as Button).text == "0" && tvInput?.text == "0") {

            } else if (tvInput?.text == "0") {
                tvInput?.text = (view as Button).text
            } else {
                tvInput?.append((view as Button).text)
                lastNumeric = true
                firstNumeric = false
                lastDot = false
            }

            fun onDigit(view: View) {
                if ((view as Button).text == "0" && tvInput?.text == "0") {

                }
            }




            if ((view as Button).text == "1") {

            } else if ((view as Button).text == "2") {

            } else if ((view as Button).text == "3") {

            } else if ((view as Button).text == "4") {

            } else if ((view as Button).text == "5") {

            } else if ((view as Button).text == "6") {

            } else if ((view as Button).text == "7") {

            } else if ((view as Button).text == "8") {

            } else if ((view as Button).text == "9") {

            } else if ((view as Button).text == "0") {
                tvInput?.append("9")
            }


        }

        fun onClear(view: View) {
            tvInput?.text = ""

            btnOne?.setBackgroundColor(getColor(R.color.grey))
            btnTwo?.setBackgroundColor(getColor(R.color.grey))
            btnThree?.setBackgroundColor(getColor(R.color.grey))
            btnFour?.setBackgroundColor(getColor(R.color.grey))
            btnFive?.setBackgroundColor(getColor(R.color.grey))
            btnSix?.setBackgroundColor(getColor(R.color.grey))
            btnSeven?.setBackgroundColor(getColor(R.color.grey))
            btnEight?.setBackgroundColor(getColor(R.color.grey))
            btnNine?.setBackgroundColor(getColor(R.color.grey))
            btnZero?.setBackgroundColor(getColor(R.color.grey))

        }

        fun onDecimalPoint(view: View) {
            if (lastNumeric && !lastDot) {
                tvInput?.append(".")
                lastNumeric = false
                lastDot = true
                firstNumeric = true


            }
        }


        fun onOperator(view: View) {

            tvInput?.text?.let {
                if (lastNumeric && !isOperatorAdded(it.toString())) {
                    tvInput?.append((view as Button).text)
                    lastNumeric = false
                    lastDot = false
                    firstNumeric = true

                }
            }

        }

        fun onEqual(view: View) {
            if (lastNumeric) {
                var tvValue = tvInput?.text.toString()
                var prefix = ""

                try {

                    if (tvValue.startsWith("-")) {
                        prefix = "-"
                        tvValue = tvValue.substring(1)
                    }
                    if (tvValue.contains("-")) {
                        val splitValue = tvValue.split("-")
                        var one = splitValue[0] //99
                        var two = splitValue[1] //1

                        if (prefix.isNotEmpty()) {

                            one = prefix + one
                        }

                        tvInput?.text =
                            removeZeroAfterDot((one.toDouble() - two.toDouble()).toString())

                    } else if (tvValue.contains("+")) {
                        val splitValue = tvValue.split("+")
                        var one = splitValue[0] //99
                        var two = splitValue[1] //1

                        if (prefix.isNotEmpty()) {

                            one = prefix + one
                        }

                        tvInput?.text =
                            removeZeroAfterDot((one.toDouble() + two.toDouble()).toString())

                    } else if (tvValue.contains("*")) {
                        val splitValue = tvValue.split("*")
                        var one = splitValue[0] //99
                        var two = splitValue[1] //1

                        if (prefix.isNotEmpty()) {

                            one = prefix + one
                        }

                        tvInput?.text =
                            removeZeroAfterDot((one.toDouble() * two.toDouble()).toString())

                    } else if (tvValue.contains("/")) {
                        val splitValue = tvValue.split("/")
                        var one = splitValue[0] //99
                        var two = splitValue[1] //1

                        if (prefix.isNotEmpty()) {

                            one = prefix + one
                        }

                        tvInput?.text =
                            removeZeroAfterDot((one.toDouble() / two.toDouble()).toString())

                    }


                } catch (e: ArithmeticException) {
                    e.printStackTrace()
                }
            }
        }

        private fun removeZeroAfterDot(result: String): String {
            var value = result
            if (result.contains(".0"))
                value = result.substring(0, result.length - 2)

            return value
        }


        private fun isOperatorAdded(value: String): Boolean {
            return if (value.startsWith("-")) {
                false
            } else {
                value.contains("/")
                        || value.contains("*")
                        || value.contains("+")
                        || value.contains("-")
            }
        }


    }
