package itstep.learning.ioc;

import com.google.inject.Inject;
import itstep.learning.hash.HashService;

import javax.inject.Named;
import java.util.logging.Logger;

public class IocDemo {

    private final HashService digestHashService;
    private final HashService signatureHashService;
    private final String appName;


    @Inject private Logger logger;

    @Inject
    public IocDemo(
            @Named("digest") HashService digestHashService,
            @Named("signature") HashService signatureHashService,
            @Named("appName") String appName)
    {
        System.out.println("IocDemo constructor work");
        this.digestHashService = digestHashService;
        this.signatureHashService = signatureHashService;
        this.appName = appName;
    }

    public void run()
    {
        System.out.println(appName);
        System.out.println(digestHashService.digest("12345"));
        System.out.println(signatureHashService.digest("12345"));

        logger.info("Logger working " + appName);
    }









}
