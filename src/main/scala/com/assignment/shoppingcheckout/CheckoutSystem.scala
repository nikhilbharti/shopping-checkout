package com.assignment.shoppingcheckout

/**
  * Created by nikhilb on 07/05/17.
  */
object CheckoutSystem {

  private val itemsCostMapping: Map[String, Double] = Map(("apple", 0.60), ("orange", 0.25))

  def totalCost(items : List[String]): Double = {
    items.flatMap(itemCost).sum
  }

  def totalCostWithOffers(items : List[String]) : Double = {
    val noOfApples: Int = items.count(p => p.equalsIgnoreCase("apple"))
    val noOfOranges: Int = items.count(p => p.equalsIgnoreCase("orange"))
    ShoppingOffers.applyOffer("apple",noOfApples) + ShoppingOffers.applyOffer("orange",noOfOranges)
  }

  def getItemCost(item: String) : Double = itemsCostMapping.getOrElse(item toLowerCase,0.00)

  def itemCost(item: String) : Option[Double] = itemsCostMapping.get(item)
}