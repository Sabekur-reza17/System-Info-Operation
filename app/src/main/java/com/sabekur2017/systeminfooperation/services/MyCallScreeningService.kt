package com.sabekur2017.systeminfooperation.services

import android.os.Build
import android.telecom.Call
import android.telecom.CallScreeningService
import androidx.annotation.RequiresApi
import com.sabekur2017.systeminfooperation.FORBIDDEN_PHONE_CALL_NUMBER
import com.sabekur2017.systeminfooperation.extensions.parseCountryCode
import com.sabekur2017.systeminfooperation.extensions.removeTelPrefix

@RequiresApi(Build.VERSION_CODES.N)
class MyCallScreeningService  : CallScreeningService(){
    override fun onScreenCall(p0: Call.Details) {

    }
    private fun handlePhoneCall(
        response: CallResponse.Builder,
        phoneNumber: String
    ): CallResponse.Builder {
        if (phoneNumber == FORBIDDEN_PHONE_CALL_NUMBER) {
            response.apply {
                setRejectCall(true)
                setDisallowCall(true)
                setSkipCallLog(false)
                //
                //displayToast(String.format("Rejected call from %s", phoneNumber))
            }
        } else {
           // displayToast(String.format("Incoming call from %s", phoneNumber))
        }
        return response
    }

    private fun getPhoneNumber(callDetails: Call.Details): String {
        return callDetails.handle.toString().removeTelPrefix().parseCountryCode()
    }


}