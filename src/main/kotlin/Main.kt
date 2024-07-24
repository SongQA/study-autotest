import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var number: Int

    // 1부터 9까지의 숫자 입력받기
    while (true) {
        try {
            println("1부터 9까지의 숫자를 입력하세요:")
            val input = scanner.nextLine()
            number = input.toInt()

            if (number in 1..9) {
                break
            } else {
                println("1부터 9까지의 숫자를 입력해 주세요.")
            }
        } catch (e: NumberFormatException) {
            println("유효한 숫자를 입력해 주세요.")
        }
    }
    // 테스트

    // 구구단 출력
    println("$number 단:")
    for (i in 1..9) {
        println("$number * $i = ${number * i}")
    }
}
