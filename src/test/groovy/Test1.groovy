import static net.grinder.script.Grinder.grinder
import static org.junit.Assert.*
import static org.hamcrest.Matchers.*
import net.grinder.plugin.http.HTTPRequest
import net.grinder.script.GTest
import net.grinder.script.Grinder
import net.grinder.scriptengine.groovy.junit.GrinderRunner
import net.grinder.scriptengine.groovy.junit.annotation.BeforeThread
import net.grinder.scriptengine.groovy.junit.annotation.BeforeProcess

import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith

import HTTPClient.HTTPResponse

import lib.PerfTestUtil

/**
 * A simple example using the HTTP plugin that shows the retrieval of a
 * single page via HTTP.
 *
 * This script is auto generated by ngrinder.
 *
 * @author ${userName}
 */
@RunWith(GrinderRunner)
class Test1 {
    public static GTest test;
    public static HTTPRequest request;

    // This method is executed once per a process.
    @BeforeProcess
    public static void beforeClass() {
        println('BeforeProcess');
        test = new GTest(1, "${PerfTestUtil.name}");
        request = new HTTPRequest();
        test.record(request);
        grinder.logger.info("before process.");
    }

    // This method is executed once per a thread.
    @BeforeThread
    public void beforeThread() {
        grinder.statistics.delayReports = true;
        grinder.logger.info("before thread.");
    }

    // This method is continuously executed until you stop the test
    @Test
    public void test() {
        HTTPResponse result = request.GET("${PerfTestUtil.url}");
        if (result.statusCode == 301 || result.statusCode == 302) {
            grinder.logger.warn("Warning. The response may not be correct. The response code was {}.", result.statusCode);
        } else {
            assertThat(result.statusCode, is(200));
        }
    }
}