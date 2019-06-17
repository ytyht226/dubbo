package org.apache.dubbo.demo.provider;

import org.apache.dubbo.demo.DemoOneService;
import org.apache.dubbo.rpc.RpcContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yanghuitao on 2019/6/17.
 */
@Service
public class DemoOneServiceImpl implements DemoOneService {
    private static final Logger logger = LoggerFactory.getLogger(DemoOneServiceImpl.class);
    @Override
    public String demoOne1(String name) {
        logger.info("[demoOne1]Hello " + name + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "[demoOne1]Hello " + name + ", response from provider: " + RpcContext.getContext().getLocalAddress();
    }
}