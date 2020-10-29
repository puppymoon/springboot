package com.moontea.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// logTest() 括號內的兩個點,代表不論傳入什麼參數都做切
	@Pointcut("execution(* com.moontea.controller.LogTestController.logTest(..))")
	public void log() {

	}

	// 最上面已經定義好切點,這邊可以重寫一次，或是直接指定定義好的切點
//	@Before("execution(* com.moontea.controller.LogTestController.logTest(..))")
	@Before("log()")
	public void doBefore() {
		logger.info("=================在切點前在切點前在切點前");
	}

//	@After("execution(* com.moontea.controller.LogTestController.logTest(..))")
	@After("log()")
	public void doAfter() {
		logger.info("=================在切點後在切點後在切點後");
	}

	@AfterReturning(returning = "object", pointcut="log()")
	public void doAfterReturning(Object object) {
		logger.info("=======doAfterReturning {}", object);
	}
	
}

