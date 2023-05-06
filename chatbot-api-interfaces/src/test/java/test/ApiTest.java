package test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @author 小傅哥，微信：fustack
 * @description 单元测试
 * @github https://github.com/fuzhengwei
 * @Copyright 公众号：bugstack虫洞栈 | 博客：https://bugstack.cn - 沉淀、分享、成长，让自己和他人都能有所收获！
 */
public class ApiTest {

    @Test
    public void query_unanswered_questions() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48884544412888/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=9A2ED3A4-BCC3-3ECB-7A4B-502F41F4B213_1897E5C84B1EB7E6; sensorsdata2015jssdkcross={\"distinct_id\":\"218281118552881\",\"first_id\":\"1837f76218746c-0f93a1535de6db8-78565470-1327104-1837f762188d79\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgzN2Y3NjIxODc0NmMtMGY5M2ExNTM1ZGU2ZGI4LTc4NTY1NDcwLTEzMjcxMDQtMTgzN2Y3NjIxODhkNzkiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTgyODExMTg1NTI4ODEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"218281118552881\"},\"$device_id\":\"1837f76218746c-0f93a1535de6db8-78565470-1327104-1837f762188d79\"}; abtest_env=product; zsxqsessionid=440f426496d9ba554bc839916068953b");
        get.addHeader("Content-Type","application/json;charset=utf8");


        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/412515558485258/answer");
        post.addHeader("cookie", "zsxq_access_token=9A2ED3A4-BCC3-3ECB-7A4B-502F41F4B213_1897E5C84B1EB7E6; sensorsdata2015jssdkcross={\"distinct_id\":\"218281118552881\",\"first_id\":\"1837f76218746c-0f93a1535de6db8-78565470-1327104-1837f762188d79\",\"props\":{\"$latest_traffic_source_type\":\"直接流量\",\"$latest_search_keyword\":\"未取到值_直接打开\",\"$latest_referrer\":\"\"},\"identities\":\"eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTgzN2Y3NjIxODc0NmMtMGY5M2ExNTM1ZGU2ZGI4LTc4NTY1NDcwLTEzMjcxMDQtMTgzN2Y3NjIxODhkNzkiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTgyODExMTg1NTI4ODEifQ==\",\"history_login_id\":{\"name\":\"$identity_login_id\",\"value\":\"218281118552881\"},\"$device_id\":\"1837f76218746c-0f93a1535de6db8-78565470-1327104-1837f762188d79\"}; abtest_env=product; zsxqsessionid=440f426496d9ba554bc839916068953b");
        post.addHeader("Content-Type", "application/json;charset=utf8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"不告诉你！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } else {
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

}
