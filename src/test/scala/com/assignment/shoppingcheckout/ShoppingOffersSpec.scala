package com.assignment.shoppingcheckout

import org.scalatest.{Matchers, WordSpecLike}

/**
  * Created by nikhilb on 07/05/17.
  */
class ShoppingOffersSpec extends WordSpecLike with Matchers {

  "on Buy one get one offer total cost of 2 apple should be 0.60" in {
    ShoppingOffers.buyOneGetOneOffer(2,0.60) shouldBe 0.60
  }

  "on Buy one get one offer total cost of 3 apple should be 1.20" in {
    ShoppingOffers.threeForTwoOffer(3,0.60) shouldBe 1.20
  }

  "on Three For Two offer total cost of 3 oranges should be 0.50" in {
    ShoppingOffers.threeForTwoOffer(3,0.25) shouldBe 0.50
  }
  "on Three For Two offer total cost of 4 oranges should be 0.75" in {
    ShoppingOffers.threeForTwoOffer(4,0.25) shouldBe 0.75
  }

}
