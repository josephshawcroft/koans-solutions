package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order count is the highest among all customers
    val customers = this.customers
    val customer = customers.maxBy {customer -> customer.orders.count()}
    return customer
}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
    val products = this.orderedProducts
    return products.maxBy { it -> it.price }
}
