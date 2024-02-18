package com.recipe.api.utils.base

/**
 * This is an extension function that is used to check if the string is a valid email or not using regex pattern matching.
 * @return Boolean
 */
fun String.isValidEmail(): Boolean {
    val emailRegex = "^[A-Za-z0-9](.*)(@)(.+)(\\.)(.+)"
    return this.matches(emailRegex.toRegex())
}

/**
 * This is an extension function that is used to check if the string is a valid phone number or not using regex pattern matching.
 * @return Boolean
 */
fun String.isValidPhoneNumber(): Boolean {
//    val phoneRegex = "^+[0-9]{10,12}$"
    val phoneRegex = "^\\+[0-9]{10,12}$"
    return this.matches(phoneRegex.toRegex())
}

/**
 * This is an extension function that is used to check if the string is a valid password or not using regex pattern matching.
 * @return Boolean
 */
fun String.isValidPassword(): Boolean {
    val passwordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
    return this.matches(passwordRegex.toRegex())
}