package kuidd.bot.commiton.manager;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Deys on 15.06.2015.
 */
@Service
public class TelegramManager {

    private final Logger log = LoggerFactory.getLogger(TelegramManager.class);

    @Value("${telegram.bot.username}")
    private String telegramBotUsername;

    @Value("${telegram.bot.token}")
    private String telegramBotToken;

    @Value("${telegram.bot.chat.id}")
    private String telegramBotChatId;

    @Value("${proxy.enable:false}")
    private Boolean proxyEnable;

    @Value("${proxy.url}")
    private String proxyUrl;

    @Value("${proxy.port}")
    private Integer proxyPort;

    @Value("${proxy.domain}")
    private String proxyDomain;

    @Value("${proxy.user}")
    private String proxyUser;

    @Value("${proxy.password}")
    private String proxyPassword;

    private String telegramApiUrl = "https://api.telegram.org/bot";

    public boolean sendMessage(String message)
    {
        boolean result = true;

        String url = telegramApiUrl + telegramBotToken + "/sendMessage";
        try {
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
            map.add("text", message);
            map.add("chat_id", telegramBotChatId);

            RestTemplate rest = createRestTemplate();
            rest.postForObject(url, map, String.class);
        } catch (Exception e) {
            log.error(e.getMessage());

            result = false;
        }
        return result;
    }

    public String getUpdates()
    {
        String result = "";

        String url = telegramApiUrl + telegramBotToken + "/getUpdates";
        try {
            MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

            RestTemplate rest = createRestTemplate();
            result = rest.postForObject(url, map, String.class);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }

    private RestTemplate createRestTemplate() throws Exception {
        if (!proxyEnable) {
            return new RestTemplate();
        } else {
            CredentialsProvider credsProvider = new BasicCredentialsProvider();
            credsProvider.setCredentials(
                    new AuthScope(proxyUrl, proxyPort),
                    new NTCredentials(proxyUser, proxyPassword, null, proxyDomain));

            HttpHost myProxy = new HttpHost(proxyUrl, proxyPort);
            HttpClientBuilder clientBuilder = HttpClientBuilder.create();
            clientBuilder.setProxy(myProxy).setDefaultCredentialsProvider(credsProvider).disableCookieManagement();

            CloseableHttpClient httpClient = clientBuilder.build();
            HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
            factory.setHttpClient(httpClient);

            return new RestTemplate(factory);
        }
    }
}
