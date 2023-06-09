package com.mhp.coding.challenges.dependency.inquiry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import com.mhp.coding.challenges.dependency.*;



@Component
public class InquiryService {

    @Autowired
    private ApplicationEventPublisher publisher;



    private static final Logger LOG = LoggerFactory.getLogger(InquiryService.class);

    public void create(final Inquiry inquiry) {

        LOG.info("User sent inquiry: {}", inquiry);
        publisher.publishEvent(inquiry);
    }

}
