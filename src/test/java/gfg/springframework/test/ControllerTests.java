package gfg.springframework.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Tag("controllers")
public interface ControllerTests {

    @BeforeAll
    default void beforeAll(){
        System.out.println("beforeAll-Initialization can be done here");
    }
}
