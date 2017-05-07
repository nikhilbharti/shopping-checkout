package com.assignment.shoppingcheckout

/**
  * Created by nikhilb on 07/05/17.
  */
import org.scalatest._
import com.assignment.shoppingcheckout.Utility._

class CheckoutSystemTest extends WordSpecLike with Matchers with OptionValues  {
  "cost of an APPLE in shop should be 0.60" in {
    CheckoutSystem.getItemCost(Apple) shouldBe 0.60
  }

  "cost of an ORANGE in shop should be 0.25" in {
    CheckoutSystem.getItemCost(Orange) shouldBe 0.25
  }
  "cost of an BANANA in shop should be 0.0" in {
    CheckoutSystem.getItemCost(Banana) shouldBe 0.0
  }
  "cost of an ANYTHING ELSE in shop should be 0.0" in {
    CheckoutSystem.getItemCost(Other) shouldBe 0.0
  }

  "CheckoutSystem" should {
    "calculate totalCost of (APPLE, APPLE, ORANGE, APPLE) as £2.05" in {
      CheckoutSystem.totalCost(List(Apple, Apple, Orange, Apple)) shouldBe 2.05
    }
    "calculate totalCost of (APPLE, APPLE, ORANGE, APPLE, BANANA) as £2.05" in {
      CheckoutSystem.totalCost(List(Apple, Apple, Orange, Apple,Banana)) shouldBe 2.05
    }
    "calculate totalCost of (APPLE, APPLE, ORANGE, APPLE, BANANA,ANYTHINGELSE) as £2.05" in {
      CheckoutSystem.totalCost(List(Apple, Apple, Orange, Apple,Banana,Other)) shouldBe 2.05
    }
    "calculate totalCost of (APPLE, ORANGE, ORANGE, ORANGE) as £2.05" in {
      CheckoutSystem.totalCost(List(Apple, Orange, Orange, Orange,Banana,Other)) shouldBe 1.35
    }
  }
}


