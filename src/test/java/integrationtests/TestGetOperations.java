package integrationtests;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

import testconfig.E2eJunitRunner;


@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class TestGetOperations {

    @Test
    @JsonTestCase("integration_tests/negative/negative_get_person_by_invalid_id.json")
    public void test_getParkRunnerWithValidAndInvalidid(){
    	
    }

}
