package bai9_nangcao

object Validator {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()

    // Kiểm tra email hợp lệ
    fun isValidEmail(email: String?): Boolean {
        return email != null && email.matches(emailRegex)
    }

    // Kiểm tra điểm hợp lệ
    fun isValidScore(score: Double): Boolean {
        return score in 0.0..10.0
    }
}
