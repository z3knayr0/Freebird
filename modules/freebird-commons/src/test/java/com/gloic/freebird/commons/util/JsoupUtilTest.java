package com.gloic.freebird.commons.util;

import com.gloic.freebird.commons.SpringTestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author gloic
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringTestConfiguration.class)
public class JsoupUtilTest {

    @Test
    public void shouldAccessToUrl() {
        Collection<String> urls = new HashSet<>(Arrays.asList(
                "http://dls.firone-land.com/Doctor.Strange.2016.FRENCH.720p.BluRay.x264.AC3-VENUE/",
                "http://dls.firone-land.com/Mass%20Effect%20DLC%20Pinnacle%20Station%20+%20Turbulences%20%C3%A0%20900%20000%20Pieds/"
        ));

        urls.forEach(url -> {
            Assert.notNull(JsoupUtil.getDocument(url), "A document should be retrieve for url:" + url);
        });
    }
}
