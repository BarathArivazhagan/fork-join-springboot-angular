package com.barath.gateway.app.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.post.SendErrorFilter;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.lang.invoke.MethodHandles;

@Component
public class CustomErrorFilter extends SendErrorFilter {

    private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Value("${error.path:/error}")
    private String errorPath;


    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            ExceptionHolder exception = findZuulException(ctx.getThrowable());
            HttpServletRequest request = ctx.getRequest();

            request.setAttribute("javax.servlet.error.status_code", exception.getStatusCode());

            logger.warn("Error during filtering", exception.getThrowable());
            request.setAttribute("javax.servlet.error.exception", exception.getThrowable());

            if (StringUtils.hasText(exception.getErrorCause())) {
                request.setAttribute("javax.servlet.error.message", exception.getErrorCause());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher(
                    this.errorPath);
            if (dispatcher != null) {
                ctx.set(SEND_ERROR_FILTER_RAN, true);
                if (!ctx.getResponse().isCommitted()) {
                    ctx.setResponseStatusCode(exception.getStatusCode());
                    dispatcher.forward(request, ctx.getResponse());
                }
            }
        }
        catch (Exception ex) {

            ReflectionUtils.rethrowRuntimeException(ex);
        }
        return null;
    }


    protected ExceptionHolder findZuulException(Throwable throwable) {
        if (throwable.getCause() instanceof ZuulRuntimeException) {
            // this was a failure initiated by one of the local filters
            if(throwable.getCause().getCause() instanceof ZuulException) {
                return new ZuulExceptionHolder((ZuulException) throwable.getCause().getCause());
            }
        }

        if (throwable.getCause() instanceof ZuulException) {
            // wrapped zuul exception
            return  new ZuulExceptionHolder((ZuulException) throwable.getCause());
        }

        if (throwable instanceof ZuulException) {
            // exception thrown by zuul lifecycle
            return new ZuulExceptionHolder((ZuulException) throwable);
        }

        // fallback
        return new DefaultExceptionHolder(throwable);
    }



}
