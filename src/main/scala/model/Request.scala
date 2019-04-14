package model
import java.time.LocalDate

class Request (val customer : Customer.Value, val checkInDate : LocalDate, val checkOutDate : LocalDate) {
  def apply(customer: Customer.Value, checkInDate: LocalDate, checkOutDate: LocalDate): Request = new Request(customer, checkInDate, checkOutDate)
}
