package com.example.config

import org.slf4j.LoggerFactory
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler
import org.springframework.boot.logging.LogLevel
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.AsyncConfigurer
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor
import java.lang.reflect.Method
import java.util.concurrent.Executor


@Configuration
@EnableAsync
class AsyncConfig : AsyncConfigurer {
    override fun getAsyncExecutor(): Executor {
        val executor = ThreadPoolTaskExecutor()
        executor.corePoolSize = 10
        executor.maxPoolSize = 10
        executor.queueCapacity = 10000
        executor.setWaitForTasksToCompleteOnShutdown(true)
        executor.setAwaitTerminationSeconds(10)
        executor.initialize()
        return executor
    }

//    override fun getAsyncUncaughtExceptionHandler(): AsyncUncaughtExceptionHandler {
//        return AsyncExceptionHandler()
//    }
}

//class AsyncExceptionHandler : AsyncUncaughtExceptionHandler {
//    private val log = LoggerFactory.getLogger(javaClass)
//
//    override fun handleUncaughtException(e: Throwable, method: Method, vararg params: Any?) {
//        if (e is Exception) {
//            when (e.errorType.logLevel) {
//                LogLevel.ERROR -> log.error("CoreException : {}", e.message, e)
//                LogLevel.WARN -> log.warn("CoreException : {}", e.message, e)
//                else -> log.info("CoreException : {}", e.message, e)
//            }
//        } else {
//            log.error("Exception : {}", e.message, e)
//        }
//    }
//}