package com.github.jsonldjava.core;

import com.github.jsonldjava.utils.JsonUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LocalBaseTest {
    @Test
    public void testMixedLocalRemoteBaseRemoteContextFirst() throws Exception {

        final Reader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/custom/base-0001-in.jsonld"),
                Charset.forName("UTF-8")));
        final Object context = JsonUtils.fromReader(reader);
        assertNotNull(context);

        final JsonLdOptions options = new JsonLdOptions();
        final Object expanded = JsonLdProcessor.expand(context, options);
        // System.out.println(JsonUtils.toPrettyString(expanded));

        final Reader outReader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/custom/base-0001-out.jsonld"),
                Charset.forName("UTF-8")));
        final Object output = JsonUtils.fromReader(outReader);
        assertNotNull(output);
        assertEquals(expanded, output);
    }

    @Test
    public void testMixedLocalRemoteBaseLocalContextFirst() throws Exception {

        final Reader reader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/custom/base-0002-in.jsonld"),
                Charset.forName("UTF-8")));
        final Object context = JsonUtils.fromReader(reader);
        assertNotNull(context);

        final JsonLdOptions options = new JsonLdOptions();
        final Object expanded = JsonLdProcessor.expand(context, options);
         System.out.println(JsonUtils.toPrettyString(expanded));

        final Reader outReader = new BufferedReader(new InputStreamReader(
                this.getClass().getResourceAsStream("/custom/base-0002-out.jsonld"),
                Charset.forName("UTF-8")));
        final Object output = JsonUtils.fromReader(outReader);
        assertNotNull(output);
        assertEquals(expanded, output);
    }

}
