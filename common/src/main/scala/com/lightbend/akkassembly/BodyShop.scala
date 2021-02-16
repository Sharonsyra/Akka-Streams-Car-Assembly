package com.lightbend.akkassembly

import akka.actor.Cancellable
import akka.stream.scaladsl.Source

import scala.concurrent.duration.{DurationInt, FiniteDuration}

class BodyShop(buildTime: FiniteDuration) {

  val cars: Source[UnfinishedCar, Cancellable] = Source.tick(
    initialDelay = 1.second,
    interval = buildTime,
    tick = UnfinishedCar()
  )
}
