package com.assignment.shoppingcheckout

/**
  * Created by nikhilb on 07/05/17.
  */
object CheckoutSystem {

  private val itemsCostMapping: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  def totalCost(items : List[String]): Double = {
    items.flatMap(itemCost).sum
  }

  def getItemCost(item: String) : Double = itemsCostMapping.getOrElse(item toLowerCase,0.00)

  def itemCost(item: String) : Option[Double] = itemsCostMapping.get(item)
}