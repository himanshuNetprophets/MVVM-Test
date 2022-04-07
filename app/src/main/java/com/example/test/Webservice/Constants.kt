package com.example.test.Webservice

object Constants {
    const val Auth_key = "admin@1234"
    const val BASE_URL = "http://soccer.zobofy.com/api/"
    const val API_CONNECTION_TIMEOUT: Long = 60
    const val API_READ_TIMEOUT: Long = 60
    const val SUCCESS_RESULT = 0
    const val FAILURE_RESULT = 1
    var TWITTER_API_KEY = "DtQmEIDCqJ8cD686vsjM8J4g8"
    var TWITTER_API_SECRET = "SEPiGs0L3cFAh5UWZkKkTRrQ1JTmuVgRzusb09Nb4VDtuUbOCZ"

    interface UserType {
        companion object {
            const val IS_USER_AS_PLAYER = "Player"
            const val IS_USER_AS_COACH = "Coach"
        }
    }

    interface Key {
        companion object {
            const val isForgetpassword = "isForgetpassword"
            const val BUNDLE = "bundle"
            const val DeviceID = "deviceId"
            const val FCM_TOKEN = "fcmToken"
            const val ApiToken = "apitoken"
            const val USERID = "userid"
            const val NAME = "fullname"
            const val EMAIL = "email"
            const val DOB = "dob"
            const val MOBILE = "mobile"
            const val Type = "type"
            const val USERIMAGE = "displayImage"
            const val SESSION_ID = "sessionid"
            const val IS_ALREADY_LOGGED_IN = "isAlreadyLoggedIn"
            const val IS_SELECT_LANGUAGE = "isSelectLanguage"
            const val IS_FIRST_TIME_LAUNCH = "isfirstlaunch"
            const val IS_FIRST_TIME = "isfirst"
            const val apiKey = "AIzaSyBsKXUHqa5DcNk9_usVfjjFSPgwxqTiai4"
            const val IS_CAMERA = "camera"
            const val IS_GALLERY = "gallery"
            const val IS_OTP_REQUIRED = "isOtpRequired"
            const val IS_OTP_VERIFIED = "isOtpVerified"
            const val ID = "id"
            const val IMAGE = "image"
            const val LightCoachHome = "lightCoachHome"
            const val LightUserHome = "lightUserHome"
            const val LightPlayerList = "lightPlayerList"
            const val LightSessionList = "lightSessionList"
            const val LightPayment = "lightPayment"
            const val LightPaymentList = "lightPaymentList"
            const val LightPlayer = "lightPlayer"
            const val LightUserList = "lightUserList"
            const val LightPlayerProfile = "lightPlayerProfile"
            const val LightBuildSession = "lightBuildSession"
            const val LightUserSession = "lightUserSession"
            const val LightAllTrainingCoach = "lightAllTrainingCoach"
            const val LightAllTrainingCoachList = "lightAllTrainingCoachList"
            const val LightCoachProfile = "lightCoachProfile"
            const val LightMessage = "lightMessage"
            const val LightCoachList = "lightCoachList"
            const val LightBookingList = "lightBookingList"
            const val LightPendingReport = "lightPendingReport"
            const val LightCompleteReport = "lightCompleteReport"
            const val WelcomeCoach = "WelcomeCoach"
            const val WelcomePlayer = "WelcomePlayer"
        }
    }
}