package extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ContainerExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.springframework.context.ConfigurableApplicationContext;

import info.novatec.webtester.factsheet.Application;


public class EmbeddedApplication implements BeforeAllCallback, AfterAllCallback {

    private static final Namespace NAMESPACE = Namespace.create("webtester-factsheet");

    @Override
    public void beforeAll(ContainerExtensionContext context) throws Exception {
        ConfigurableApplicationContext application = Application.start();
        context.getStore(NAMESPACE).put("application", application);
    }

    @Override
    public void afterAll(ContainerExtensionContext context) throws Exception {
        context.getStore(NAMESPACE).get("application", ConfigurableApplicationContext.class).stop();
    }

}
