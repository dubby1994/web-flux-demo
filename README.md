# web-flux-demo

>启动的时候失败了？

```
org.springframework.boot.web.server.WebServerException: Unable to start Netty
        at org.springframework.boot.web.embedded.netty.NettyWebServer.start(NettyWebServer.java:74) ~[spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.startReactiveWebServer(ReactiveWebServerApplicationContext.java:139) ~[spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.finishRefresh(ReactiveWebServerApplicationContext.java:72) ~[spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:552) ~[spring-context-5.0.0.RC3.jar:5.0.0.RC3]
        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:49) ~[spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) [spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:386) [spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:327) [spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1245) [spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1233) [spring-boot-2.0.0.M3.jar:2.0.0.M3]
        at <mypackage>.<myclass>.main(MyApplication.kt:10) [main/:na]
Caused by: reactor.core.Exceptions$ReactiveException: java.util.concurrent.TimeoutException: HttpServer couldn't be started within 3000ms
        at reactor.core.Exceptions.propagate(Exceptions.java:240) ~[reactor-core-3.1.0.M3.jar:3.1.0.M3]
        at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:87) ~[reactor-core-3.1.0.M3.jar:3.1.0.M3]
        at reactor.core.publisher.Mono.block(Mono.java:1280) ~[reactor-core-3.1.0.M3.jar:3.1.0.M3]
        at reactor.ipc.netty.tcp.BlockingNettyContext.<init>(BlockingNettyContext.java:55) ~[reactor-netty-0.7.0.M1.jar:0.7.0.M1]
        at reactor.ipc.netty.tcp.BlockingNettyContext.<init>(BlockingNettyContext.java:45) ~[reactor-netty-0.7.0.M1.jar:0.7.0.M1]
        at reactor.ipc.netty.NettyConnector.start(NettyConnector.java:53) ~[reactor-netty-0.7.0.M1.jar:0.7.0.M1]
        at org.springframework.boot.web.embedded.netty.NettyWebServer.start(NettyWebServer.java:64) ~[spring-boot-2.0.0.M3.jar:2.0.0.M3]
        ... 10 common frames omitted
        Suppressed: java.lang.Exception: #block terminated with an error
                at reactor.core.publisher.BlockingSingleSubscriber.blockingGet(BlockingSingleSubscriber.java:88) ~[reactor-core-3.1.0.M3.jar:3.1.0.M3]
                ... 15 common frames omitted
Caused by: java.util.concurrent.TimeoutException: HttpServer couldn't be started within 3000ms
        at reactor.ipc.netty.tcp.BlockingNettyContext.<init>(BlockingNettyContext.java:53) ~[reactor-netty-0.7.0.M1.jar:0.7.0.M1]
        ... 13 common frames omitted
```

很正常，这是因为`java.net.InetAddress.getLocalHost()`超时了，解决方法很简单，修改你的`hosts`文件，加上这两个，一定要记得加上你的主机名，在这里就是`mbpro.local`：

```
127.0.0.1   localhost mbpro.local
::1         localhost mbpro.local
```

ok，至此就可以了！
