package com.barath.gateway.app.filter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StreamUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PostResponseFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 999;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run()  {

        try {
            if(logger.isDebugEnabled()) {
                RequestContext context = RequestContext.getCurrentContext();
                InputStream stream = context.getResponseDataStream();
                String body = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));
                logger.debug("response body {}",body);
                context.setResponseBody(body);
            }

        } catch (IOException e) {
          logger.error("exception in post filter {}", e.getCause());
           ReflectionUtils.rethrowRuntimeException(e);
        }

        return null;
    }
}
