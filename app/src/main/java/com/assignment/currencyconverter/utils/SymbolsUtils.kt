package com.assignment.currencyconverter.utils

fun getCurrencySymbols(): ArrayList<String>{
    val symbolList = arrayListOf<String>()
    symbolList.add("USD")
    symbolList.add("NGN")
    symbolList.add("AED")
    symbolList.add("AFN")
    symbolList.add("AUD")
    symbolList.add("BTC")
    symbolList.add("CAD")
    symbolList.add("EUR")

    return symbolList
}