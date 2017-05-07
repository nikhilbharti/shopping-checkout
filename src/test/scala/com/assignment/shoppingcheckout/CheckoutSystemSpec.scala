package com.assignment.shoppingcheckout

/**
  * Created by nikhilb on 07/05/17.
  */
import org.scalatest._
import com.assignment.shoppingcheckout.Utility._

class CheckoutSystemSpec extends WordSpecLike with Matchers  {
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
    "calculate totalCost of 2 Apple on 'buy one, get one free' offer on Apples as £0.60" in {
      CheckoutSystem.totalCostWithOffers(List(Apple, Apple)) shouldBe 0.60
    }

    "calculate totalCost of 3 Apple on 'buy one, get one free' offer on Apples as £1.20" in {
      CheckoutSystem.totalCostWithOffers(List(Apple, Apple,Apple)) shouldBe 1.20
    }

    "calculate totalCost of 4 Apple on 'buy one, get one free' offer on Apples as £1.20" in {
      CheckoutSystem.totalCostWithOffers(List(Apple, Apple,Apple,Apple)) shouldBe 1.20
    }

    "calculate totalCost of 3 Orange on 'three for two' offer on Oranges as £0.50" in {
      CheckoutSystem.totalCostWithOffers(List(Orange, Orange,Orange)) shouldBe 0.50
    }

    "calculate totalCost of 4 Orange on 'three for two' offer on Oranges as £0.75" in {
      CheckoutSystem.totalCostWithOffers(List(Orange, Orange,Orange,Orange)) shouldBe 0.75
    }

    "calculate totalCost of 2 Apple and 3 Orange on 'buy one, get one free' on Apple And 'three for two' offer on Oranges as £1.10" in {
      CheckoutSystem.totalCostWithOffers(List(Apple,Apple,Orange, Orange,Orange)) shouldBe 1.10
    }

    "calculate totalCost of 3 Apple and 4 Orange on 'buy one, get one free' on Apple And 'three for two' offer on Oranges as £1.95" in {
      CheckoutSystem.totalCostWithOffers(List(Apple,Apple,Apple,Orange, Orange,Orange,Orange)) shouldBe 1.95
    }

  }
}


