package com.lightbend.akkassembly

import akka.stream.Materializer
import akka.stream.scaladsl.{Keep, Sink}

import scala.concurrent.Future

class Factory(
  bodyShop: BodyShop, paintShop: PaintShop, engineShop: EngineShop,
  wheelShop: WheelShop, qualityAssurance: QualityAssurance)(implicit mat: Materializer) {

  def orderCars(quantity: Int): Future[Seq[Car]] = {
    bodyShop.cars
      .viaMat(paintShop.paint)(Keep.right)
      .viaMat(engineShop.installEngine)(Keep.right)
      .viaMat(wheelShop.installWheels)(Keep.right)
      .viaMat(qualityAssurance.inspect)(Keep.right)
      .grouped(quantity)
      .runReduce(_.concat(_))
  }
}
