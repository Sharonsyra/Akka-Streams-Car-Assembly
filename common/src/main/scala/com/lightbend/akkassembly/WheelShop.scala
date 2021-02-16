package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.{Flow, Source}

class WheelShop {
  val wheels: Source[Wheel, NotUsed] = Source.repeat(
    Wheel()
  )

  val installWheels: Flow[UnfinishedCar, UnfinishedCar, NotUsed] =
    Flow[UnfinishedCar].zipWith(wheels.grouped(4)) {
      (unfinishedCar, wheels) => unfinishedCar.installWheels(wheels)
    }
}
