package ii_collections

fun example1(list: List<Int>) {

    // If a lambda has exactly one parameter, that parameter can be accessed as 'it'
    val positiveNumbers = list.filter { it > 0 }

    val squares = list.map { it * it }
}

fun Shop.getCitiesCustomersAreFrom(): Set<City> {
    // Return the set of cities the customers are from
    val listOfCustomers = this.getSetOfCustomers()
    val listOfCities: MutableList<City> = mutableListOf()
    listOfCustomers.forEach { customer: Customer -> listOfCities.add(customer.city)}
    return listOfCities.toSet()
}

fun Shop.getCustomersFrom(city: City): List<Customer> {
    return this.getSetOfCustomers().filter { customer: Customer -> customer.city == city }
}


