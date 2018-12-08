package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
    val customers = getSetOfCustomers()
    val undeliveredCustomers = mutableListOf<Customer>()
    customers.forEach { it -> if(it.areMoreOrdersUndelivered()) undeliveredCustomers.add(it)}
    return undeliveredCustomers.toSet()
}

fun Customer.areMoreOrdersUndelivered() : Boolean {
    val orders = this.orders
    val (negative, positive) = orders.partition { it.isDelivered < !it.isDelivered}
    return negative.count() > positive.count()
}