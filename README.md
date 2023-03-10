
## This repo is to reproduce an issue reported https://github.com/apollographql/apollo-kotlin/issues/4748

### In order to run
* Change the URL and TOKEN in the DemoApplication.java
* ./gradlew build
* ./gradlew bootRun


### Exception stactrace
```
Exception in thread "restartedMain" java.lang.reflect.InvocationTargetException
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:78)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:567)
        at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:49)
Caused by: java.lang.NoSuchMethodError: 'void kotlin.jvm.internal.FunctionReferenceImpl.<init>(int, java.lang.Class, java.lang.String, java.lang.String, int)'
        at kotlinx.coroutines.flow.internal.SafeCollectorKt$emitFun$1.<init>(SafeCollector.kt)
        at kotlinx.coroutines.flow.internal.SafeCollectorKt$emitFun$1.<clinit>(SafeCollector.kt)
        at kotlinx.coroutines.flow.internal.SafeCollectorKt.<clinit>(SafeCollector.kt:15)
        at kotlinx.coroutines.flow.internal.SafeCollector.emit(SafeCollector.kt:87)
        at kotlinx.coroutines.flow.internal.SafeCollector.emit(SafeCollector.kt:66)
        at com.apollographql.apollo3.network.http.HttpNetworkTransport$execute$1.invokeSuspend(HttpNetworkTransport.kt:83)
        at com.apollographql.apollo3.network.http.HttpNetworkTransport$execute$1.invoke(HttpNetworkTransport.kt)
        at com.apollographql.apollo3.network.http.HttpNetworkTransport$execute$1.invoke(HttpNetworkTransport.kt)
        at kotlinx.coroutines.flow.SafeFlow.collectSafely(Builders.kt:61)
        at kotlinx.coroutines.flow.AbstractFlow.collect(Flow.kt:230)
        at kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl.flowCollect(ChannelFlow.kt:195)
        at kotlinx.coroutines.flow.internal.ChannelFlowOperator.collectTo$suspendImpl(ChannelFlow.kt:157)
        at kotlinx.coroutines.flow.internal.ChannelFlowOperator.collectTo(ChannelFlow.kt)
        at kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1.invokeSuspend(ChannelFlow.kt:60)
        at kotlin.coroutines.jvm.internal.BaseContinuationImpl.resumeWith(ContinuationImpl.kt:33)
        at kotlinx.coroutines.DispatchedTask.run(DispatchedTask.kt:106)
        at kotlinx.coroutines.internal.LimitedDispatcher.run(LimitedDispatcher.kt:42)
        at kotlinx.coroutines.scheduling.TaskImpl.run(Tasks.kt:95)
        at kotlinx.coroutines.scheduling.CoroutineScheduler.runSafely(CoroutineScheduler.kt:570)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.executeTask(CoroutineScheduler.kt:750)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.runWorker(CoroutineScheduler.kt:677)
        at kotlinx.coroutines.scheduling.CoroutineScheduler$Worker.run(CoroutineScheduler.kt:664)
```