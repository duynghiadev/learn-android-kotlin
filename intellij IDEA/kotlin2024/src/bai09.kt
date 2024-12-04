fun main() {
    // Biểu thức chính quy kiểm tra định dạng điểm hợp lệ (chỉ chứa số và có thể có một dấu chấm thập phân)
    val scoreRegex = "^[0-9]?(\\.[0-9]{1,2})?\$".toRegex()

    println("Nhập điểm môn toán:")
    val score1 = readLine()?.trim()
    println("Nhập điểm môn Văn:")
    val score2 = readLine()?.trim()
    println("Nhập điểm môn Anh:")
    val score3 = readLine()?.trim()

    // Kiểm tra định dạng của điểm nhập vào
    if (isValidScore(score1) && isValidScore(score2) && isValidScore(score3)) {
        // Chuyển đổi điểm từ String sang Double và tính điểm trung bình
        val score1Double = score1?.toDoubleOrNull() ?: 0.0
        val score2Double = score2?.toDoubleOrNull() ?: 0.0
        val score3Double = score3?.toDoubleOrNull() ?: 0.0

        // Kiểm tra các điểm có hợp lệ không
        if (score1Double !in 0.0..10.0 || score2Double !in 0.0..10.0 || score3Double !in 0.0..10.0) {
            println("Điểm phải trong khoảng từ 0 đến 10.")
        } else {
            // Tính điểm trung bình
            val averageScore = (score1Double + score2Double + score3Double) / 3
            println("Điểm trung bình: $averageScore")

            // Kiểm tra kết quả đậu hay không
            if (averageScore >= 5.0) {
                println("Chúc mừng! Bạn đã đậu đại học.")
            } else {
                println("Rất tiếc! Bạn chưa đậu đại học.")
            }
        }
    } else {
        println("Vui lòng nhập điểm hợp lệ (chỉ chứa số và có thể có một dấu chấm thập phân).")
    }
}

// Hàm kiểm tra xem điểm có hợp lệ không
fun isValidScore(score: String?): Boolean {
    return score != null && score.matches("^[0-9]?(\\.[0-9]{1,2})?\$".toRegex())
}
