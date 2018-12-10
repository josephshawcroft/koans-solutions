package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(other: MyDate): Int {
        if (this.year > other.year) return 1
        else if (this.year < other.year) return -1
        else if (this.month > other.month) return 1
        else if (this.month < other.month) return -1
        else if (this.dayOfMonth > other.dayOfMonth) return 1
        else if (this.dayOfMonth < other.dayOfMonth) return -1
        else return 0
    }
}

operator fun DateRange.contains(other: MyDate) : Boolean {
    return other >= this.start && other <= this.endInclusive
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
