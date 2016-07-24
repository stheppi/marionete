package com.marionette.training.chapter10

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object MonadFutureExample {
  val loadItem: Order => Future[Item] = {
    order => ItemService.loadItem(order)
  }

  val purchaseItem: Item => Future[PurchaseResult] = {
    item => PurchasingService.purchaseItem(item)
  }

  val logPurchase: PurchaseResult => Future[LogResult] = {
    purchaseResult => PurchasingService.logPurchase(purchaseResult)
  }

  val result = OrderService.loadOrder("customerUsername")
    .flatMap(loadItem)
    .flatMap(purchaseItem)
    .flatMap(logPurchase)

  val result1 =
    for {
      loadedOrder <- OrderService.loadOrder("customerUsername")
      loadedItem <- loadItem(loadedOrder)
      purchaseResult <- purchaseItem(loadedItem)
      logResult <- logPurchase(purchaseResult)
    } yield logResult
}


trait Order

trait Item

trait PurchaseResult

trait LogResult

object OrderService {
  def loadOrder(username: String): Future[Order] = Future {
    new Order {}
  }
}

object ItemService {
  def loadItem(order: Order): Future[Item] = Future {
    new Item {}
  }
}

object PurchasingService {
  def purchaseItem(item: Item): Future[PurchaseResult] = Future {
    new PurchaseResult {}
  }

  def logPurchase(purchaseResult: PurchaseResult): Future[LogResult] = Future {
    new LogResult {}
  }
}
