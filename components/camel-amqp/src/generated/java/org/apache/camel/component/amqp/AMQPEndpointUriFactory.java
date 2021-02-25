/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.amqp;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
public class AMQPEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":destinationType:destinationName";

    private static final Set<String> PROPERTY_NAMES;
    private static final Set<String> SECRET_PROPERTY_NAMES;
    static {
        Set<String> props = new HashSet<>(97);
        props.add("includeSentJMSMessageID");
        props.add("asyncConsumer");
        props.add("mapJmsMessage");
        props.add("synchronous");
        props.add("eagerLoadingOfProperties");
        props.add("password");
        props.add("replyToMaxConcurrentConsumers");
        props.add("deliveryMode");
        props.add("transferException");
        props.add("asyncStartListener");
        props.add("eagerPoisonBody");
        props.add("artemisStreamingEnabled");
        props.add("maxConcurrentConsumers");
        props.add("taskExecutor");
        props.add("priority");
        props.add("acknowledgementModeName");
        props.add("exposeListenerSession");
        props.add("receiveTimeout");
        props.add("replyTo");
        props.add("replyToOverride");
        props.add("errorHandlerLoggingLevel");
        props.add("errorHandler");
        props.add("allowReplyManagerQuickStop");
        props.add("replyToOnTimeoutMaxConcurrentConsumers");
        props.add("messageConverter");
        props.add("maxMessagesPerTask");
        props.add("jmsKeyFormatStrategy");
        props.add("streamMessageTypeEnabled");
        props.add("headerFilterStrategy");
        props.add("destinationName");
        props.add("allowAdditionalHeaders");
        props.add("clientId");
        props.add("recoveryInterval");
        props.add("replyToCacheLevelName");
        props.add("messageIdEnabled");
        props.add("allowSerializedHeaders");
        props.add("preserveMessageQos");
        props.add("connectionFactory");
        props.add("testConnectionOnStartup");
        props.add("subscriptionName");
        props.add("useMessageIDAsCorrelationID");
        props.add("cacheLevelName");
        props.add("idleTaskExecutionLimit");
        props.add("messageListenerContainerFactory");
        props.add("requestTimeoutCheckerInterval");
        props.add("includeAllJMSXProperties");
        props.add("cacheLevel");
        props.add("errorHandlerLogStackTrace");
        props.add("transactedInOut");
        props.add("timeToLive");
        props.add("exceptionListener");
        props.add("destinationType");
        props.add("waitForProvisionCorrelationToBeUpdatedThreadSleepingTime");
        props.add("transactionManager");
        props.add("alwaysCopyMessage");
        props.add("artemisConsumerPriority");
        props.add("replyToConcurrentConsumers");
        props.add("replyToDestinationSelectorName");
        props.add("disableTimeToLive");
        props.add("deliveryPersistent");
        props.add("concurrentConsumers");
        props.add("acceptMessagesWhileStopping");
        props.add("consumerType");
        props.add("lazyStartProducer");
        props.add("subscriptionDurable");
        props.add("destinationResolver");
        props.add("exceptionHandler");
        props.add("idleConsumerLimit");
        props.add("explicitQosEnabled");
        props.add("transacted");
        props.add("transactionName");
        props.add("correlationProperty");
        props.add("autoStartup");
        props.add("messageTimestampEnabled");
        props.add("waitForProvisionCorrelationToBeUpdatedCounter");
        props.add("lazyCreateTransactionManager");
        props.add("messageCreatedStrategy");
        props.add("asyncStopListener");
        props.add("transferExchange");
        props.add("selector");
        props.add("requestTimeout");
        props.add("allowNullBody");
        props.add("replyToDeliveryPersistent");
        props.add("deliveryDelay");
        props.add("disableReplyTo");
        props.add("formatDateHeadersToIso8601");
        props.add("exchangePattern");
        props.add("pubSubNoLocal");
        props.add("forceSendOriginalMessage");
        props.add("subscriptionShared");
        props.add("replyToType");
        props.add("transactionTimeout");
        props.add("durableSubscriptionName");
        props.add("replyToSameDestinationAllowed");
        props.add("jmsMessageType");
        props.add("defaultTaskExecutorType");
        props.add("username");
        PROPERTY_NAMES = Collections.unmodifiableSet(props);
        Set<String> secretProps = new HashSet<>(2);
        secretProps.add("password");
        secretProps.add("username");
        SECRET_PROPERTY_NAMES = Collections.unmodifiableSet(secretProps);
    }

    @Override
    public boolean isEnabled(String scheme) {
        return "amqp".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> properties, boolean encode) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(properties);

        uri = buildPathParameter(syntax, uri, "destinationType", "queue", false, copy);
        uri = buildPathParameter(syntax, uri, "destinationName", null, true, copy);
        uri = buildQueryParameters(uri, copy, encode);
        return uri;
    }

    @Override
    public Set<String> propertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Set<String> secretPropertyNames() {
        return SECRET_PROPERTY_NAMES;
    }

    @Override
    public boolean isLenientProperties() {
        return false;
    }
}
