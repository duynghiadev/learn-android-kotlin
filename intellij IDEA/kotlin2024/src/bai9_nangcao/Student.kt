package bai9_nangcao

data class Student(
    val name: String,
    val email: String,
    val score1: Double,
    val score2: Double,
    val score3: Double
) {
    fun averageScore(): Double = (score1 + score2 + score3) / 3
    fun result(): String = if (averageScore() >= 5.0) "Đậu" else "Rớt"
}
