package com.example.test.Webservice

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AuthBeanModel {
    @SerializedName("status")
    @Expose
    var status: Boolean? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("data")
    @Expose
    var data: Data? = null

    inner class Data {
        @SerializedName("user_id")
        @Expose
        var userId: String? = null

        @SerializedName("roll")
        @Expose
        var roll: String? = null

        @SerializedName("profile_image")
        @Expose
        var profileImage: String? = null

        @SerializedName("full_name")
        @Expose
        var fullName: String? = null

        @SerializedName("mobile")
        @Expose
        var mobile: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("dob")
        @Expose
        var dob: String? = null

        @SerializedName("age")
        @Expose
        var age: String? = null

        @SerializedName("position")
        @Expose
        var position: String? = null

        @SerializedName("level")
        @Expose
        var level: String? = null

        @SerializedName("country")
        @Expose
        var country: String? = null

        @SerializedName("state")
        @Expose
        var state: String? = null

        @SerializedName("city")
        @Expose
        var city: String? = null

        @SerializedName("add_date")
        @Expose
        var addDate: String? = null
    }
}