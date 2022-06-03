package id.krisna.viuit.extension

import android.util.Patterns
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

fun String.isEmailValid(): Boolean {
    return Patterns.EMAIL_ADDRESS.toRegex().matches(this)
}

fun getMessageError(stringError: String?): String {
    val errorObject = JSONObject(stringError!!)
    val serverMessage = errorObject.getString("message")
    var result = serverMessage
    result = result.replace("\"{", "{")
    result = result.replace("}\"", "}")
    result = result.replace("\\", "")

//    val errorMessage: List<Message> = Gson().fromJson(result, object : TypeToken<List<Message>>() {}.type)
//    return errorMessage.first().messages!!.first().messageError
    return ""
}

fun dateResponseString(data: String): String {
    val finalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    val responseFormat = "yyyy-MM-dd HH:mm:ss"
    val simpleDateFormat = SimpleDateFormat(responseFormat, Locale.ENGLISH)
    val date = simpleDateFormat.parse(data)

    return finalFormat.format(date)
}

fun getMonthString(data: String): String {
    val finalFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)

    val responseFormat = "yyyy-MM-dd HH:mm:ss"
    val simpleDateFormat = SimpleDateFormat(responseFormat, Locale.ENGLISH)
    val date = simpleDateFormat.parse(data)

    return finalFormat.format(date)
}