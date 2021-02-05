package com.halim_18102195.praktikum14.`interface`

import com.halim_18102195.praktikum14.model.Login
import com.halim_18102195.praktikum14.model.Quote

interface MainView {
    fun showMessage(messsage : String)
    fun resultQuote(data: ArrayList<Quote>)
    fun resultLogin(data: Login)
}
