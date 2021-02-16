resolvers in ThisBuild += "lightbend-commercial-mvn" at
  "https://repo.lightbend.com/pass/lqOyvqPXaJbZPlWnnh831bfKwsGJUpNwQS5YSyFgYxaPTWYg/commercial-releases"
resolvers in ThisBuild += Resolver.url("lightbend-commercial-ivy",
  url("https://repo.lightbend.com/pass/lqOyvqPXaJbZPlWnnh831bfKwsGJUpNwQS5YSyFgYxaPTWYg/commercial-releases"))(Resolver.ivyStylePatterns)
