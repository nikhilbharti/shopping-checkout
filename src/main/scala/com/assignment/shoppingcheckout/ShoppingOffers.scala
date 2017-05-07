package com.assignment.shoppingcheckout

/**
  * Created by nikhilb on 07/05/17.
  */
object ShoppingOffers {

  def buyOneGetOneOffer(noOfItems: Int, oneItemPrice: Double): Double = ((noOfItems / 2) + (noOfItems % 2)) * oneItemPrice

  def threeForTwoOffer(noOfItems: Int, oneItemPrice: Double): Double = (2 * (noOfItems / 3) + (noOfItems % 3)) * oneItemPrice

  def applyOffer(item: String, noOfItems:Int) :Double = {
    val price: Double = CheckoutSystem.getItemCost(item)
    item toLowerCase match {
      case "apple" =>  buyOneGetOneOffer(noOfItems, price)
      case "orange" =>  threeForTwoOffer(noOfItems, price)
      case _ => noOfItems * price
    }
  }
}

