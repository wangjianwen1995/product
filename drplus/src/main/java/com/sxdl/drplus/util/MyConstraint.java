package com.sxdl.drplus.util;

import com.sxdl.drplus.annotation.ValidKey;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class MyConstraint implements ConstraintValidator<ValidKey, String> {



   Logger logger =  LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);



   public void initialize(ValidKey constraint) {

//      logger.info("   " );
   }

   /**
    *实现验证逻辑， 注册码生成5分钟后 失效(重要操作)
    *@param  obj 需要验证的对象
    *@param context 约束验证器的上下文
    */
   public boolean isValid(String obj, ConstraintValidatorContext context)  {
      try {
         if(StringUtils.isEmpty(obj))
            return false;
         if(Encryption.getKeySup().equals(obj))
            return true;
         String str = Encryption.EncryptionOrDecrypt(obj,2 );
         if(!Encryption.containKey(str))
            return false;
         Date date1  =  DataUtil.getDateTime(str);
         if((int)ChronoUnit.MINUTES.between(Instant.ofEpochMilli(date1.getTime()), Instant.ofEpochMilli(new Date().getTime()))>5)
            return false;
      }catch (Exception e){
         logger.error("验证异常:"+e);
      }
      return true;
   }





}
