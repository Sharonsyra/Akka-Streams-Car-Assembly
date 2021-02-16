package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.Flow

class QualityAssurance {
  val inspect: Flow[UnfinishedCar, Car, NotUsed] =

    Flow[UnfinishedCar].collect {
      case unfinishedCar: UnfinishedCar
        if unfinishedCar.color.nonEmpty && unfinishedCar.engine.nonEmpty && unfinishedCar.wheels.length.equals(4) =>
        Car(SerialNumber(), unfinishedCar.color.get, unfinishedCar.engine.get, unfinishedCar.wheels, unfinishedCar.upgrade)
    }
}
