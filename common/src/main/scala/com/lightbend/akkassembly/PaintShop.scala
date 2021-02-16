package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.{Flow, Source}

class PaintShop(colorSet:  Set[Color]) {
  val colors: Source[Color, NotUsed] = Source.cycle{
    () => Iterator.from(colorSet)
  }

  val paint: Flow[UnfinishedCar, UnfinishedCar, NotUsed] =
    Flow[UnfinishedCar].zipWith(colors) {
      (unFinishedCar, color) => unFinishedCar.paint(color)
    }
}
