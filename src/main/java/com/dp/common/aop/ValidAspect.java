package com.dp.common.aop;

import java.lang.reflect.Method;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.internal.engine.path.PathImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

@Component
@Aspect
public class ValidAspect{

    private static final Logger logger = LoggerFactory.getLogger(ValidAspect.class);

    @Pointcut("execution(public * com.dp.web.*.*(..))")
    public void controllerBefore(){};

    ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

    @Before("controllerBefore()")
    public void before(JoinPoint point) throws Exception {
        //  获得切入目标对象
        Object target = point.getThis();
        // 获得切入方法参数
        Object [] args = point.getArgs(); 
        // 获得切入的方法
        Method method = ((MethodSignature)point.getSignature()).getMethod(); 
        
        //获取参数中用于接受error的对象result
        BindingResult result = null;
        for (Object object : args) {
			if(object instanceof BindingResult){
				result = (BindingResult) object;
			}
		}
        if(args.length>0 && result!=null){
        	logger.info("开始校验参数.............");
        	// 执行校验，获得校验结果
        	Set<ConstraintViolation<Object>> validResult = validMethodParams(target, method, args);
        	
        	if(!validResult.isEmpty()){
        		String [] parameterNames = parameterNameDiscoverer.getParameterNames(method); // 获得方法的参数名称
        		for (ConstraintViolation<Object> constraintViolation : validResult) {
        			PathImpl pathImpl = (PathImpl) constraintViolation.getPropertyPath();  // 获得校验的参数路径信息
        			int paramIndex = pathImpl.getLeafNode().getParameterIndex(); // 获得校验的参数位置
        			String paramName = parameterNames[paramIndex];  // 获得校验的参数名称
        			ObjectError error = new ObjectError(paramName, constraintViolation.getMessage());
        			result.addError(error);//添加错误
        		}
        	}
        	logger.info("校验完毕.............");
        }
    }

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final ExecutableValidator validator = factory.getValidator().forExecutables();

    private <T> Set<ConstraintViolation<T>> validMethodParams(T obj, Method method, Object [] params){
        return validator.validateParameters(obj, method, params);
    }
}