import bean.BioBean;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Index;

import java.io.IOException;

/**
 * @author dhy
 * @create 2020-07-11 11:04 上午
 */

public class ESWrite {
    public static void main(String[] args) throws IOException {
        //创建ES客户端连接池
        JestClientFactory jestClientFactory = new JestClientFactory();
        //创建Es客户端连接地址
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder("http：//hadoop102：9200").build();
        //设置Es连接地址
        jestClientFactory.setHttpClientConfig(httpClientConfig);
        //
        JestClient jestClient = jestClientFactory.getObject();

        BioBean bioBean = new BioBean("crispr_single", "gene_edit");
        Index index = new Index.Builder(bioBean).index("biotechnology").type("_doc").id("20").build();

        jestClient.execute(index);

        jestClient.close();

    }
}
