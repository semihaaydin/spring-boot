package com.saydin.api;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/log")
public class LogApi {

    Logger logger=LoggerFactory.getLogger(LogApi.class);
    //asenkron bir logger factory oluşturur.

        @GetMapping
        public String getDetails() {
            logger.info("get details methodu basladi");
            return internalLogDetail();
        }

        private String internalLogDetail() {
            try {
                logger.debug("get details methodu basladi");
                Thread.sleep(1000);
                return "API Mesaj";
            } catch (InterruptedException e) {
                logger.error("sdcsdcsdcdscsdc");
            }
            return "";
        }
}
