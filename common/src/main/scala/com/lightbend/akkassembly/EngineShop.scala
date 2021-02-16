package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.{Flow, Source}

class EngineShop(shipmentSize: Int) {
  val shipments: Source[Shipment, NotUsed] = Source.fromIterator{
    () => Iterator.fill(shipmentSize)(Shipment(Seq.fill(shipmentSize)(Engine(SerialNumber()))))
  }

  val engines: Source[Engine, NotUsed] =
    shipments.flatMapConcat(shipment => Source(shipment.engines))

  val installEngine: Flow[UnfinishedCar, UnfinishedCar, NotUsed] =
    Flow[UnfinishedCar].zipWith(engines) {
      (unfinishedCar, engine) => unfinishedCar.installEngine(engine)
    }
}
