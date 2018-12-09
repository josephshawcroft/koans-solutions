package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    val customersWhoOrderedProduct = mutableListOf<Customer>()
    val customers = this.customers

    customers.forEach { customer -> if(customer.orderedProducts.contains(product)) customersWhoOrderedProduct.add(customer) }
    return customersWhoOrderedProduct.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    val orders = this.orders
    val deliveredOrders = orders.partition { it.isDelivered }.first //returns delivered orders
    val deliveredProducts = mutableListOf<Product>()
    deliveredOrders.forEach { order -> order.products.forEach{product -> deliveredProducts.add(product)} }

    return deliveredProducts.maxBy { product -> product.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    val customers = this.customers
    val orders = mutableListOf<Order>()
    customers.forEach { customer -> orders.addAll(customer.orders) }

    val products = mutableListOf<Product>()
    orders.forEach { order -> products.addAll(order.products) }
    return products.count { it.name == product.name }
}
