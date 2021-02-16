package com.lightbend.akkassembly

import akka.NotUsed
import akka.stream.scaladsl.Source

class EngineShop(shipmentSize: Int) {
  val shipments: Source[Shipment, NotUsed] = Source.fromIterator{
    () => Iterator.fill(shipmentSize)(Shipment(Seq.fill(shipmentSize)(Engine(SerialNumber()))))
  }
}
