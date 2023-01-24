package com.example.ecrypt_decrypt_stanley

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import java.io.File
import kotlin.random.Random
import kotlin.text.Regex
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    fun encrypt(text: String,emojiList:MutableList<String>):String{
        if(text.isEmpty()) return ""
        var encryptedStr = ""
        val random = Random
        var randomInt = random.nextInt(0, emojiList.size-1)
        var check = false
        var nowLetter : Int
        var nextLetter : Int
        randomInt = 77
        encryptedStr += emojiList[randomInt]
        for(i in 0 until text.length){
            if(check){
                check=false
                continue
            }
            nowLetter = 126-text[i].toInt()
            if(nowLetter >= 5 && nowLetter<=29 && i<text.length-1){
                nextLetter = 126-text[i+1].toInt()
                if(nextLetter>=5 && nextLetter<=29) {
                    randomInt+=nowLetter*25+nextLetter
                    check=true
                }
            }
            if(!check){
                randomInt+=nowLetter
            }
            if(randomInt>816){
                randomInt%=816
            }
            encryptedStr += emojiList[randomInt]
        }
        return encryptedStr
    }

    fun binarySearch(list: MutableList<String>, c: Char): Int {
        var left = 0
        var right = list.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            val midChar = list[mid][0]
            when {
                c == midChar -> return mid
                c < midChar -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return -1
    }
    fun decrypt(text: String,emojiList:MutableList<String>):String{

        return emojiList.size.toString()
    }
    fun quickSort(list: MutableList<String>, left: Int, right: Int) {
        if (left < right) {
            val pivotIndex = partition(list, left, right)
            quickSort(list, left, pivotIndex)
            quickSort(list, pivotIndex + 1, right)
        }
    }
    private fun partition(list: MutableList<String>, left: Int, right: Int): Int {
        val pivot = list[(left + right) / 2]
        var i = left - 1
        var j = right + 1
        while (true) {
            do {
                i++
            } while (list[i] < pivot)
            do {
                j--
            } while (list[j] > pivot)
            if (i >= j) {
                return j
            }
            val temp = list[i]
            list[i] = list[j]
            list[j] = temp
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_encrypt = findViewById<Button>(R.id.btn_encrypt)
        val btn_decrypt = findViewById<Button>(R.id.btn_decrypt)
        val input_words = findViewById<TextInputEditText>(R.id.input_words)
        val input_emojis = findViewById<TextInputEditText>(R.id.input_emoji)
        val textview_emojis = findViewById<TextInputLayout>(R.id.text_Layout_emojis)
        val textview_words = findViewById<TextInputLayout>(R.id.text_layout_words)

        val emojiList = mutableListOf("😁","😂","😃","😄","😅","😆","😉","😊","😋","😌","😍","😏","😒","😓","😔","😖","😘","😚","😜","😝","😞","😠","😡","😢","😣","😤","😥","😨","😩","😪","😫","😭","😰","😱","😲","😳","😵","😷","😸","😹","😺","😻","😼","😽","😾","😿","🙀","🙅","🙆","🙇","🙈","🙉","🙊","🙋","🙌","🙍","🙎","🙏","😀","😇","😈","😎","😐","😑","😕","😗","😙","😛","😦","😧","😬","😮","😯","😴","😶","🚀","🚃","🚄","🚅","🚇","🚉","🚌","🚏","🚑","🚒","🚓","🚕","🚗","🚙","🚚","🚢","🚤","🚥","🚧","🚨","🚩","🚪","🚫","🚬","🚭","🚲","🚶","🚹","🚺","🚻","🚼","🚽","🚾","🛀","🚁","🚂","🚆","🚈","🚊","🚍","🚎","🚐","🚔","🚖","🚘","🚛","🚜","🚝","🚞","🚟","🚠","🚡","🚣","🚦","🚮","🚯","🚰","🚱","🚳","🚴","🚵","🚷","🚸","🚿","🛁","🛂","🛃","🛄","🛅","🅰" ,"🅱" ,"🅾" ,"🅿" ,"🆎","🆑","🆒","🆓","🆔","🆕","🆖","🆗","🆘","🆙","🆚","🈁","🈂","🈚","🈯","🈲","🈳","🈴","🈵","🈶","🈷","🈸","🈹","🈺","🉐","🉑","8⃣","9⃣","7⃣","6⃣","1⃣","0⃣","2⃣","3⃣","5⃣","4⃣","#⃣","🀄","🃏","🌀","🌁","🌂","🌃","🌄","🌅","🌆","🌇","🌈","🌉","🌊","🌋","🌌","🌏","🌑","🌓","🌔","🌕","🌙","🌛","🌟","🌠","🌰","🌱","🌴","🌵","🌷","🌸","🌹","🌺","🌻","🌼","🌽","🌾","🌿","🍀","🍁","🍂","🍃","🍄","🍅","🍆","🍇","🍈","🍉","🍊","🍌","🍍","🍎","🍏","🍑","🍓","🍔","🍕","🍖","🍗","🍘","🍙","🍚","🍛","🍜","🍝","🍞","🍟","🍠","🍡","🍢","🍣","🍤","🍥","🍦","🍧","🍨","🍩","🍪","🍫","🍬","🍭","🍮","🍯","🍰","🍱","🍲","🍳","🍴","🍵","🍶","🍷","🍸","🍹","🍺","🍻","🎀","🎁","🎂","🎃","🎄","🎅","🎆","🎇","🎈","🎉","🎊","🎋","🎌","🎍","🎎","🎏","🎐","🎑","🎒","🎓","🎠","🎡","🎢","🎣","🎤","🎥","🎦","🎧","🎨","🎩","🎪","🎫","🎬","🎭","🎮","🎯","🎰","🎱","🎲","🎳","🎴","🎵","🎶","🎷","🎸","🎹","🎺","🎻","🎼","🎽","🎾","🎿","🏀","🏁","🏂","🏃","🏄","🏆","🏈","🏊","🏠","🏡","🏢","🏣","🏥","🏦","🏧","🏨","🏩","🏪","🏫","🏬","🏭","🏮","🏯","🏰","🐌","🐍","🐎","🐑","🐒","🐔","🐗","🐘","🐙","🐚","🐛","🐜","🐝","🐞","🐟","🐠","🐡","🐢","🐣","🐤","🐥","🐦","🐧","🐨","🐩","🐫","🐬","🐭","🐮","🐯","🐰","🐱","🐲","🐳","🐴","🐵","🐶","🐷","🐸","🐹","🐺","🐻","🐼","🐽","🐾","👀","👂","👃","👄","👅","👆","👇","👈","👊","👋","👌","👍","👎","👏","👐","👑","👒","👓","👔","👕","👖","👗","👘","👙","👚","👛","👜","👝","👞","👟","👠","👡","👢","👣","👤","👦","👧","👨","👩","👪","👫","👮","👯","👰","👱","👲","👳","👴","👵","👶","👷","👸","👹","👺","👻","👼","👽","👾","👿","💀","💁","💂","💃","💄","💅","💆","💇","💈","💉","💊","💋","💌","💍","💎","💏","💐","💑","💒","💓","💔","💕","💖","💗","💘","💙","💚","💛","💜","💝","💞","💟","💠","💡","💢","💣","💤","💥","💦","💧","💨","💩","💪","💫","💬","💮","💯","💰","💱","💲","💳","💴","💵","💸","💹","💺","💻","💼","💽","💾","💿","📀","📁","📂","📃","📄","📅","📆","📇","📈","📉","📊","📋","📌","📍","📎","📏","📐","📑","📒","📓","📔","📕","📖","📗","📘","📙","📚","📛","📜","📝","📞","📟","📠","📡","📢","📣","📤","📥","📦","📧","📨","📩","📪","📫","📮","📰","📱","📲","📳","📴","📶","📷","📹","📺","📻","📼","🔃","🔊","🔌","🔍","🔎","🔏","🔐","🔑","🔒","🔓","🔔","🔖","🔗","🔘","🔙","🔚","🔛","🔜","🔝","🔞","🔟","🔠","🔡","🔢","🔣","🔤","🔥","🔦","🔧","🔨","🔩","🔪","🔫","🔮","🔯","🔰","🔱","🔲","🔳","🔴","🔵","🔶","🔷","🔸","🔹","🔺","🔻","🔼","🔽","🕐","🕑","🕒","🕓","🕔","🕕","🕖","🕗","🕘","🕙","🕚","🕛","🗻","🗼","🗽","🗾","🗿","🌍","🌎","🌐","🌒","🌖","🌗","🌘","🌚","🌜","🌝","🌞","🌲","🌳","🍋","🍐","🍼","🏇","🏉","🏤","🐀","🐁","🐂","🐃","🐄","🐅","🐆","🐇","🐈","🐉","🐊","🐋","🐏","🐐","🐓","🐕","🐖","🐪","👥","👬","👭","💭","💶","💷","📬","📭","📯","📵","🔀","🔁","🔂","🔄","🔅","🔆","🔇","🔉","🔕","🔬","🔭","🕜","🕝","🕞","🕟","🕠","🕡","🕢","🕣","🕤","🕥","🕦","🕧")
        quickSort(emojiList,0,711)

        btn_encrypt.setOnClickListener {
            val text = input_words.text.toString()
            val returnText = encrypt(text,emojiList)
            input_emojis.setText(returnText)
        }

        btn_decrypt.setOnClickListener {
            val emojis = input_emojis.text.toString()
            val returnEmoji = decrypt(emojis,emojiList)
            input_words.setText(returnEmoji)
        }
    }
}