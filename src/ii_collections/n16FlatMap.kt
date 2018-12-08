package ii_collections

fun example() {

    val result = listOf("abc", "12").flatMap { it.toList() }

    result == listOf('a', 'b', 'c', '1', '2')
}

val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered
    val orders = this.orders
    val setOfProducts : MutableSet<Product> = mutableSetOf()
    orders.forEach { order: Order -> setOfProducts.addAll(order.products)}
    return setOfProducts
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    val customers = this.getSetOfCustomers()
    val setOfProducts : MutableSet<Product> = mutableSetOf()
    customers.forEach{customer -> setOfProducts.addAll(customer.orderedProducts)}
    return setOfProducts
}
